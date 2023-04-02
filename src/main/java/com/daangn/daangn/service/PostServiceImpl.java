package com.daangn.daangn.service;

import com.daangn.daangn.domain.Post;
import com.daangn.daangn.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postServiceImpl")
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post save(Post post) throws Exception {
        return postRepository.save(post);
    }

    @Override
    public List<Post> findAll() throws Exception {
        return postRepository.findAll();
    }
}
