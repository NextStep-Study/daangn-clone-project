package com.daangn.daangn.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column (nullable = false)
    private String branch;

    private String code;

    private String name;

    private Integer depth;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "parent_board_id")
    private Board parentBoard;

    @OneToMany (mappedBy = "parentBoard", cascade = CascadeType.ALL)
    private List<Board> subBoard = new ArrayList<>();

    @Builder
    public Board(String branch, String code, String name, Integer depth, Board parentBoard) {
        this.branch = branch;
        this.code = code;
        this.name = name;
        this.depth = depth;
        this.parentBoard = parentBoard;
    }

}
