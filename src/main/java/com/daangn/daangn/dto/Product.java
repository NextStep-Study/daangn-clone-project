package com.daangn.daangn.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

	private Integer id; //물품 ID
	private String title; //물품 제목
	private String content; //물품 설명
	private Integer price; //물품 가격
	private List<Photo> photoIdList; //물품 사진
	private Date createdAt; //올린 날짜
	private Date updatedAt; //끌올 날짜
	private String status; //판매 상태
	private Integer targetId; //상대방 ID
	private Integer categoryId; //카테고리 ID
	private Integer writerId; //작성자 ID

}
