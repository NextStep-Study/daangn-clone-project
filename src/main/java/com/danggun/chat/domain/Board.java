package com.danggun.chat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {



    @Id
    @GeneratedValue
    private Long id;

    private String subjectName;

}
