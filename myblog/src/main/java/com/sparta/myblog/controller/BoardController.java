package com.sparta.myblog.controller;

import com.sparta.myblog.model.Board;
import com.sparta.myblog.repository.BoardRepository;
import com.sparta.myblog.dto.BoardRequestDto;
import com.sparta.myblog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;


// 스프링에게 이 녀석이 자동응답기라는 걸 알려줘야 하는데, 빼먹음.(까먹지 말것)
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return board;
    }

    @GetMapping("api/boards")
    public List<Board> readBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }


//    @PostMapping("/api/boards/{id}")    //2번 아이디
//    public Board getOneBoard(@PathVariable Long id) {
//        boardService.readOne(id);
//        return id;
//    }

//    @GetMapping("/api/boards/{id}")
//    public Board getOneBoard(@PathVariable Long id) {
////        BoardRequestDto boardRequestDto = new BoardRequestDto();
//        return boardService.showOne(id);

    @GetMapping("/api/boards/{id}")
    public Board getOneBoard(@PathVariable Long id) {
        return boardService.readOne(id);
    }

    @DeleteMapping("api/boards/{id}")
    public Long deleteOneBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }

    @PutMapping("api/boards/{id}")
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        boardService.update(id, boardRequestDto);
        return id;
    }

}
