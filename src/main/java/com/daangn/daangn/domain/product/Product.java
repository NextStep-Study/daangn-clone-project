package com.daangn.daangn.domain.product;

import com.daangn.daangn.domain.Member.Member;
import com.daangn.daangn.domain.review.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id; //물품 ID

    private String title; //물품 제목

    private String content; //물품 설명

    private Integer price; //물품 가격

    @OneToMany(mappedBy = "product")
    private List<Photo> photoList; //물품 사진

    private LocalDateTime refreshedAt; //끌올 날짜
    
    private Long refreshedCnt; //끌올 횟수

    @Enumerated(EnumType.STRING)
    private ProductStatus status; //판매 상태

    @Enumerated(EnumType.STRING)
    private Category category; //카테고리 ID

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member seller; //작성자

    @OneToOne(fetch = FetchType.LAZY)
    private Member buyer; //상대방 ID

    @OneToOne(mappedBy = "product")
    private Review review;

    //==연관관계 메소드==//
    public void addPhoto(Photo photo) {
        photoList.add(photo);
        photo.setProduct(this);
    }

}
