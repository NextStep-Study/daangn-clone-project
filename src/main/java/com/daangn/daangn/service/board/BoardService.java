package com.daangn.daangn.service.board;

import com.daangn.daangn.domain.board.Board;
import com.daangn.daangn.domain.board.BoardRepository;
import com.daangn.daangn.web.dto.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public Long saveBoard (BoardDto boardDto) {
        Board board = boardDto.toEntity();

        if (boardDto.getParentBoardName() == null) {
            if (boardRepository.existsByBranchAndName(boardDto.getBranch(), boardDto.getName())) {
                throw new RuntimeException("branch와 name이 같을 수 없습니다. ");
            }

            Board rootBoard = boardRepository.findByBranchAndName(boardDto.getBranch(),"ROOT")
                    .orElseGet( () ->
                            Board.builder()
                                    .name("ROOT")
                                    .code("ROOT")
                                    .branch(boardDto.getBranch())
                                    .depth(0)
                                    .build()
            );

            if (!boardRepository.existsByBranchAndName(boardDto.getBranch(), "ROOT")) {
                boardRepository.save(rootBoard);
            }
            board.setParentBoard(rootBoard);
            board.setDepth(1);
        } else {
            String parentBoardName = boardDto.getParentBoardName();
            Board parentBoard = boardRepository.findByBranchAndName(boardDto.getBranch(), parentBoardName)
                    .orElseThrow(() -> new IllegalArgumentException("부모 카테고리 없음 예외"));
            board.setDepth(parentBoard.getDepth() + 1);
            board.setParentBoard(parentBoard);
            parentBoard.getSubBoard().add(board);
        }

        return boardRepository.save(board).getId();
    }

    public Map<String, BoardDto> getBoardByBranch (String branch) {
        Board board = boardRepository.findByBranchAndCode(branch, "ROOT")
                .orElseThrow(() -> new IllegalArgumentException("찾는 대분류가 없습니다"));

        BoardDto boardDTO = new BoardDto(board);

        Map <String, BoardDto> data = new HashMap<>();
        data.put(boardDTO.getName(), boardDTO);

        return data;
    }
}
