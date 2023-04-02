package com.daangn.daangn.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String userName;

    private String title;

    private String content;

}
