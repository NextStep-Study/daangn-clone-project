package com.danggun.chat.web.chat;

import com.danggun.chat.domain.chat.Chat;
import com.danggun.chat.domain.chat.types.ChatType;
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

    @MessageMapping("/chat/message")
    public void enter(Chat chat) {
        log.debug("here");
      if (chat.getType().equals(ChatType.ENTER)) {
            chat.builder().content(chat.getContent()+"님이 입장하였습니다");
        }
        sendingOperations.convertAndSend("/topic/chat/room/"+chat.getRoom(),chat);
    }
}

