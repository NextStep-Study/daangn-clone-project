package com.daangn.daangn.post.controller;

import com.daangn.daangn.post.entity.Like;
import com.daangn.daangn.post.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts/{postId}/likes")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<Like> toggleLike(@PathVariable("postId") Long postId, @PathVariable("memberId") Long memberId) {
        Like like = likeService.toggleLike(memberId, postId);
        if (like != null) {
            return new ResponseEntity<>(like, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
