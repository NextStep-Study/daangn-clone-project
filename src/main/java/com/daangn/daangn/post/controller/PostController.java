package com.daangn.daangn.post.controller;

import com.daangn.daangn.post.entity.Category;
import com.daangn.daangn.post.entity.Post;
import com.daangn.daangn.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        Optional<Post> post = postService.getPostById(id);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        if (updatedPost != null) {
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        boolean deleted = postService.deletePost(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = postService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> category = postService.getCategoryById(id);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = postService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        Category updatedCategory = postService.updateCategory(id, category);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        boolean deleted = postService.deleteCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
