package com.daangn.daangn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Photo {

	private Integer id; //사진 ID
	private Integer productId; //상품 ID
	private String src; //사진이 존재하는 위치

}
