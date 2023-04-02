package com.daangn.daangn.repository;

import com.daangn.daangn.domain.Post;
import com.daangn.daangn.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired PostRepository postRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testPost() throws Exception {
        //given
        Post post = new Post();
        post.setTitle("title 1");

        //when
        Long savedId = postRepository.save(post).getId();
        Optional<Post> findPost = postRepository.findById(savedId);

        //then
        Assertions.assertThat(findPost).isEqualTo(post);
    }
}