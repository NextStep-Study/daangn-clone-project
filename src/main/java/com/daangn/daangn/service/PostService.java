package com.daangn.daangn.service;

import com.daangn.daangn.domain.Post;

import java.util.List;

public interface PostService {
    public Post  save(Post post) throws Exception;
    public List<Post> findAll() throws Exception;
}
