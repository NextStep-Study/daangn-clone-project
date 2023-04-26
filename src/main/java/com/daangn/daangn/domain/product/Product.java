package com.daangn.daangn.domain.product;

import com.daangn.daangn.domain.Member.Member;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id; //물품 ID

	private String title; //물품 제목

	private String content; //물품 설명

	private Integer price; //물품 가격

	@OneToMany(mappedBy = "product")
	private List<Photo> photoList; //물품 사진

	private LocalDateTime createdAt; //올린 날짜

	private LocalDateTime updatedAt; //끌올 날짜

	@Enumerated(EnumType.STRING)
	private ProductStatus status; //판매 상태

	private Integer targetId; //상대방 ID

	@Enumerated(EnumType.STRING)
	private Category category; //카테고리 ID

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member; //작성자

	//==연관관계 메소드==//
	public void addPhoto(Photo photo) {
		photoList.add(photo);
		photo.setProduct(this);
	}

}
