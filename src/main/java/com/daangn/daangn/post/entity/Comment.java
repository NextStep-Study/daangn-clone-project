package com.daangn.daangn.post.entity;

import com.daangn.daangn.member.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    // 작성자와의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    // 게시글과의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    // 생성자
    public Comment(String content, Member member, Post post) {
        this.content = content;
        this.member = member;
        this.post = post;
        this.createdAt = LocalDateTime.now();
    }
}
