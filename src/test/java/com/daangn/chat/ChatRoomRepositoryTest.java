package com.daangn.chat;

import com.daangn.daangn.domain.chat.Chat;
import com.daangn.daangn.domain.chat.ChatRoom;
import com.daangn.daangn.repository.chat.ChatRoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class ChatRoomRepositoryTest {

    @Autowired
    ChatRoomRepository chatRoomRepository;
    @Test
    @Transactional
    @Rollback(false)
    public void test() throws Exception {
        //given
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setPr_title("신발");

        //when
        Long savedId = chatRoomRepository.save(chatRoom).getId();

        Optional<ChatRoom> findChatRoom = chatRoomRepository.findById(savedId);

        //then
        Assertions.assertThat(findChatRoom).isEqualTo(chatRoom);

    }
}
