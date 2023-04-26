package com.daangn.chat;

import com.daangn.daangn.domain.chat.ChatRoom;
import com.daangn.daangn.domain.chat.ChatRoomRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.daangn.daangn.domain.chat.types.ChatRoomType.CARROT;

public class ChatRoomRepositoryTest {

    @Autowired
    ChatRoomRepository chatRoomRepository;
    @Test
    @Transactional
    @Rollback(false)
    public void test() throws Exception {
        //given
        ChatRoom chatRoom = ChatRoom.builder()
                .type(CARROT)
                .build();

        //when
        Long savedId = chatRoomRepository.save(chatRoom).getId();

        Optional<ChatRoom> findChatRoom = chatRoomRepository.findById(savedId);

        //then
        Assertions.assertThat(findChatRoom).isEqualTo(chatRoom);

    }
}
