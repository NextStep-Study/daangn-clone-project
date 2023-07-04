package com.daangn.daangn.member.entity;

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

import com.daangn.daangn.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "member")
@Entity
@ToString
@NoArgsConstructor

public class Member extends BaseTimeEntity {

    private String name;
    private String birth;
    private String phone_num;


    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String pwd;

    private int reg_num;

    private int reg_date;

    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Address> adress = new ArrayList<>();

    /*
 	위에 처럼 Adress 클래스를 따로 뺄까 아니면 아래 처럼 한번에 선언할지 ,,
 	private String city;
 	private String street;
 	private String zipcode;
    */

    @Builder
    public Member(String name, String birth, String phone_num, Long id, String email, String pwd, int reg_num, int reg_date,
                  String picture, Role role) {
        this.name = name;
        this.birth = birth;
        this.phone_num = phone_num;
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.reg_num = reg_num;
        this.reg_date = reg_date;
//        this.adress=adress;
        this.picture=picture;
        this.role=role;
    }
//
//    @OneToMany(mappedBy = "seller")
//    List<Product> uploadedProducts = new ArrayList<>();

    public Member update(String name, String picture){
        this.name=name;
        this.picture=picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}