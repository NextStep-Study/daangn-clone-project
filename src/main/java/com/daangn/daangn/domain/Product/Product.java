package com.daangn.daangn.domain.Product;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

	private List<Photo> photoIdList; //물품 사진

	private LocalDateTime createdAt; //올린 날짜

	private LocalDateTime updatedAt; //끌올 날짜


	@Enumerated(EnumType.STRING)
	private ProductStatus status; //판매 상태

	private Integer targetId; //상대방 ID

	@Enumerated(EnumType.STRING)
	private Category category; //카테고리 ID

	private Integer writerId; //작성자 ID


}
