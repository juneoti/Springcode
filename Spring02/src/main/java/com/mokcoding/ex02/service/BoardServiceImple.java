package com.mokcoding.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.persistence.BoardMapper;
import com.mokcoding.ex02.util.Pagination;

import lombok.extern.log4j.Log4j;

@Service //@Component : Spring이 관리하는 객체
@Log4j
public class BoardServiceImple implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int createBoard(BoardVO boardVO) {
		log.info("createBoard()");
		int result = boardMapper.insert(boardVO);
		return result;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		log.info("getAllBoard()");
		return boardMapper.selectList();
	}

	@Override
	public BoardVO getBoardById(int boardId) {
		log.info("getBoardById()");
		return boardMapper.selectOne(boardId);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		log.info("updateBoard()");
		return boardMapper.update(boardVO);
	}

	@Override
	public int deleteBoard(int boardId) {
		log.info("deleteBoard");
		return boardMapper.delete(boardId);
	}

	@Override
	public List<BoardVO> getPagingBoards(Pagination pagination) {
		log.info("getPagingBoards()");
		return boardMapper.selectListByPagination(pagination);
	}

	@Override
	public int getTotalCount() {
		log.info("getTotalCount()");
		return boardMapper.selectTotalCount();
	}

}
