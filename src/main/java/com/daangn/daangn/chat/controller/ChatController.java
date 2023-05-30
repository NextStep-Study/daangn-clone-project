package com.daangn.daangn.chat.controller;


import com.daangn.daangn.chat.entity.Chat;
import com.daangn.daangn.chat.entity.ChatType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 메시지를 주고 받을때는 json 형식을 이용한다.
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/message")
    public void enter(Chat chat) {
        if (chat.getType().equals(ChatType.ENTER)) {
            chat.builder().message(chat.getMessage()+"님이 입장하였습니다");

        }

        sendingOperations.convertAndSend("/topic/chat/room/"+chat.getRoomId(),chat);
    }
}
