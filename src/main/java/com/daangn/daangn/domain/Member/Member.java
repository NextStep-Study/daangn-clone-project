package com.daangn.daangn.domain.Member;

/*
id [자신이 설정하는 닉네임 개념]

최대 4-8글자까지 설정, 올바르지 않은 입력 형식에 밑에 배너로 알림

영어, 숫자 조합 -> 정규식

email [구글 계정 로그인 API 사용시 로그인 요소(미정) or 회원 가입 시 입력 정보]

최대 32글자 까지 설정->올바르지 않은 입력 형식에 밑에 배너로 알림

XXX@XXX.XXXX로 입력 -> 정규식

password [회원 가입 시 설정, 로그인 시 권한 부여 여부를 결정하는 요소 (Id, Password)]

최대 8-12글자까지 설정, 올바르지 않은 입력 형식에 배너로 알림

영어(대소문자), 숫자, 특수 문자 조합-> 정규식
 */

import com.daangn.daangn.domain.product.Product;
import com.daangn.daangn.domain.review.Review;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "member_id")
	private Long id;

	private String name;

	private String email;

	private String pwd;

	private int reg_num;

	private int reg_date;

	private Address address;


	@OneToMany(mappedBy = "member")
	List<Product> allUploadedProducts = new ArrayList<>();

	@OneToMany(mappedBy = "writer")
	List<Review> sentReviews = new ArrayList<>();

//	@OneToMany(mappedBy = "target")
//	List<Review> receivedReviews = new ArrayList<>();

}