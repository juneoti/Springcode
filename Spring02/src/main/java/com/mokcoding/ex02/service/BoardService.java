package com.mokcoding.ex02.service;

import java.util.List;

import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.util.Pagination;

public interface BoardService {
	int createBoard(BoardVO boardVO);
	List<BoardVO> getAllBoard();
	BoardVO getBoardById(int boardId);
	int updateBoard(BoardVO boardVO);
	int deleteBoard(int boardId);
	List<BoardVO> getPagingBoards(Pagination pagination);
	int getTotalCount();
}
