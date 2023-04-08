package com.daangn.daangn.domain.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Photo {

	@Id
	@GeneratedValue
	@Column(name = "photo_id")
	private Long id; //사진 ID
	private Long productId; //상품 ID
	private String src; //사진이 존재하는 위치

}
