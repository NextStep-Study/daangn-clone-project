package com.daangn.daangn.web;

import com.daangn.daangn.service.board.BoardService;
import com.daangn.daangn.web.dto.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/boards")
    @ResponseBody
    public Long saveBoard (BoardDto boardDto) {
        return boardService.saveBoard(boardDto);
    }

    //@GetMapping("/boards/{branch}")
    //@ResponseBody
    //public BoardReturnDto getBoardByBranch (@PathVariable String branch) {
    //    return boardService.getBoardByBranch(branch);
    //}
}
