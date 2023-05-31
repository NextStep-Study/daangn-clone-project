package com.daangn.daangn.member.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@ToString
public class LoginMemberDTO {
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
}
