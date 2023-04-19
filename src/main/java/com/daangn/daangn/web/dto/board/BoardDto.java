package com.daangn.daangn.web.dto.board;

import com.daangn.daangn.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private Long boardId;
    private String branch;
    private String code;
    private String name;
    private String parentBoardName;
    private Integer depth;
    private Map<String, BoardDto> children;

    public BoardDto (Board entity) {

        this.boardId = entity.getId();
        this.branch = entity.getBranch();
        this.code = entity.getCode();
        this.name = entity.getName();
        this.depth = entity.getDepth();

        if (entity.getParentBoard() == null) {
            this.parentBoardName = "같이해요/동내생활(대분류)";
        } else {
            this.parentBoardName = entity.getParentBoard().getName();
        }

        this.children = entity.getSubBoard() == null ? null : entity.getSubBoard().stream().collect(Collectors.toMap(Board::getName, BoardDto::new));
    }

    public Board toEntity () {
        return Board.builder()
                .branch(branch)
                .code(code)
                .depth(depth)
                .name(name)
                .build();
    }

}
