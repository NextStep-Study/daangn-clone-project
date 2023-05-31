package com.daangn.daangn.chat.controller;

import com.daangn.daangn.chat.dto.SendMessageDto;
import com.daangn.daangn.chat.entity.Chat;
import com.daangn.daangn.chat.entity.ChatType;
import com.daangn.daangn.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations sendingOperations;

    private final ChatService chatService;

    @MessageMapping("/chat/message")
    public void enter(SendMessageDto messageInfo) {
        log.info("messageInfo : {}",messageInfo.toString());
        if (messageInfo.getType().equals(ChatType.ENTER)) {
            messageInfo.setMessage(messageInfo.getSender() + "님이 입장하였습니다.");
        }
        chatService.saveMessage(messageInfo);
        sendingOperations.convertAndSend("/topic/chat/room/"+messageInfo.getRoomId(),messageInfo);
    }
}

