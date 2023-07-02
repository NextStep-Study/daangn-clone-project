package com.daangn.daangn.post.repository;

import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.post.entity.Like;
import com.daangn.daangn.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByMemberAndPost(Member member, Post post);
}
