package com.daangn.daangn.post.service;

import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.member.repository.MemberRepository;
import com.daangn.daangn.post.entity.Like;
import com.daangn.daangn.post.entity.Post;
import com.daangn.daangn.post.repository.LikeRepository;
import com.daangn.daangn.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, MemberRepository memberRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    public Like toggleLike(Long memberId, Long postId) {
        Optional<Member> member = memberRepository.findById(memberId);
        Optional<Post> post = postRepository.findById(postId);
        if (member.isPresent() && post.isPresent()) {
            Like existingLike = likeRepository.findByMemberAndPost(member.get(), post.get());
            if (existingLike != null) {
                likeRepository.delete(existingLike);
                return null;
            } else {
                Like newLike = new Like(member.get(), post.get());
                return likeRepository.save(newLike);
            }
        }
        return null;
    }
}
