package com.daangn.daangn.post.entity;

import com.daangn.daangn.member.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    // 작성자와의 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    // 생성자
    public Post(String title, String content, Category category, Member author) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }
}
