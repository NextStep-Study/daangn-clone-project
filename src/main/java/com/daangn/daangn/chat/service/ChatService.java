package com.daangn.daangn.chat.service;


import com.daangn.daangn.chat.dto.SendMessageDto;
import com.daangn.daangn.chat.entity.Chat;
import com.daangn.daangn.chat.entity.ChatRoom;
import com.daangn.daangn.chat.repository.ChatRepository;
import com.daangn.daangn.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor

public class ChatService {
    private final ChatRoomRepository chatRoomRepository;

    private final ChatRepository chatRepository;

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = chatRoomRepository.findAll();
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public Optional<ChatRoom> findById(long roomId) {
        return chatRoomRepository.findById(roomId);
    }

    //채팅방 생성
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = ChatRoom.builder().roomName(name).
                build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    public void saveMessage(SendMessageDto messageInfo) {

        Chat chat = Chat.builder()
                .room(ChatRoom.builder().id(Long.valueOf(messageInfo.getRoomId())).build())
                .message(messageInfo.getMessage())
                .sender(messageInfo.getSender()).build();

        log.info("chat {}", chat);
        chatRepository.save(chat);
    }
}
