package com.daangn.chat;


import com.daangn.daangn.domain.chat.Chat;
import com.daangn.daangn.repository.chat.ChatRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ChatRepositoryTest {


    @Autowired
    ChatRepository chatRepository;
    @Test
    @Transactional
    @Rollback(false)
    public void test() throws Exception {
        //give
        Chat chat = new Chat();
        chat.setMessage("Hi");

        //when
        Long savedId = chatRepository.save(chat).getId();
        Optional<Chat> findChat = chatRepository.findById(savedId);

        //then
        Assertions.assertThat(findChat).isEqualTo(chat);

    }
}
