package com.daangn.daangn.domain.Product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product; //상품 ID
	private String src; //사진이 존재하는 위치

}
