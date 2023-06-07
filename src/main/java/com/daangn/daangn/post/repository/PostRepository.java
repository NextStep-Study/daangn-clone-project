package com.daangn.daangn.post.repository;


import com.daangn.daangn.post.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
