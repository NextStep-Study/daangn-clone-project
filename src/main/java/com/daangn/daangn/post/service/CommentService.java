package com.daangn.daangn.post.service;

import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.member.repository.MemberRepository;
import com.daangn.daangn.post.entity.Comment;
import com.daangn.daangn.post.entity.Post;
import com.daangn.daangn.post.repository.CommentRepository;
import com.daangn.daangn.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository MemberRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, MemberRepository MemberRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.MemberRepository = MemberRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

        public Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment, Long memberId, Long postId) {
        Optional<Member> user = MemberRepository.findById(memberId);
        Optional<Post> post = postRepository.findById(postId);
        if (user.isPresent() && post.isPresent()) {
            comment.setMember(user.get());
            comment.setPost(post.get());
            return commentRepository.save(comment);
        }
        return null;
    }

    public Comment updateComment(Long id, Comment comment) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            Comment updatedComment = existingComment.get();
            updatedComment.setContent(comment.getContent());
            return commentRepository.save(updatedComment);
        }
        return null;
    }

    public boolean deleteComment(Long id) {
        Optional<Comment> existingComment = commentRepository.findById(id);
        if (existingComment.isPresent()) {
            commentRepository.delete(existingComment.get());
            return true;
        }
        return false;
    }
}
