package com.daangn.daangn.member.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;


@Getter
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long id;
    private String city;
    private String si;
    private String code;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    protected Address() {
    }

    @Builder
    public Address(Long id, String city, String si, String code, Member member) {
        this.id = id;
        this.city = city;
        this.si = si;
        this.code = code;
        this.member = member;
    }
}
