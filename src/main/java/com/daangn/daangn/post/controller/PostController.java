package com.daangn.daangn.post.controller;

import com.daangn.daangn.post.dto.PostUpdateRequestDto;
import com.daangn.daangn.post.entity.Post;
import com.daangn.daangn.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody Post requestDto) {
        return postService.save(requestDto).getId();
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

}
