package com.daangn.daangn.web.chat;

import com.daangn.daangn.domain.Member.Member;
import com.daangn.daangn.domain.chat.Chat;
import com.daangn.daangn.domain.chat.ChatRepository;
import com.daangn.daangn.domain.chat.ChatRoomRepository;
import com.daangn.daangn.domain.chat.types.ChatType;
import com.daangn.daangn.service.chat.ChatService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatController {

    private final SimpMessageSendingOperations template;

    @Autowired
    ChatRepository chatRepository;
    @Autowired
    ChatRoomRepository chatRoomRepository;

    @Autowired
    Member member;

    // MessageMapping 을 통해 webSocket 로 들어오는 메시지를 발신 처리한다.
    // 이때 클라이언트에서는 /pub/chat/message 로 요청하게 되고 이것을 controller 가 받아서 처리한다.
    // 처리가 완료되면 /sub/chat/room/roomId 로 메시지가 전송된다.
    @MessageMapping("/chat/enterUser")
    public void enterUser(@Payload Chat chat, SimpMessageHeaderAccessor headerAccessor) {
        // 채팅방 유저+1
        // 채팅방에 유저 추가 및 UserUUID 반환
        // 반환 결과를 socket session 에 userUUID 로 저장
    }

    // 해당 유저
    @MessageMapping("/chat/sendMessage")
    public void sendMessage(@Payload Chat chat) {
        log.info("CHAT {}", chat);
        chat.builder().content(chat.getContent()).build();
        template.convertAndSend("/sub/chat/room/" + chat.getRoom(), chat);
    }

    // 유저 퇴장
    public void webSocketDisconnectListener() {
    }

    // 채팅에 참여한 유저 리스트 반환
    @GetMapping("/chat/userlist")
    @ResponseBody
    public ArrayList<String> userList(String roomId) {
        return null;
    }

    // 채팅에 참여한 유저 닉네임 중복 확인
    @GetMapping("/chat/duplicateName")
    @ResponseBody
    public String isDuplicateName(@RequestParam("roomId") String roomId, @RequestParam("username") String username) {
        return null;
    }
}

