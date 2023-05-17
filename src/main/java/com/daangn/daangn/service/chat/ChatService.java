package com.daangn.daangn.service.chat;


import com.daangn.daangn.domain.chat.ChatRoom;
import com.daangn.daangn.domain.chat.ChatRoomRepository;
import com.daangn.daangn.domain.product.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ChatService(ChatRoomRepository chatRoomRepository) {
        this.chatRoomRepository = chatRoomRepository;
    }

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
        Product product = new Product();
        product.setTitle(name);
        ChatRoom chatRoom = ChatRoom.builder().product(product).
                build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }
}
