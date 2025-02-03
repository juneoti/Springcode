package com.mokcoding.ex02.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex02.config.RootConfig;
import com.mokcoding.ex02.config.WebConfig;
import com.mokcoding.ex02.domain.BoardVO;
import com.mokcoding.ex02.util.Pagination;

import lombok.extern.log4j.Log4j;
import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {RootConfig.class}) // 설정 파일 연결
@Log4j
public class BoardMapperTest {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
//		testBoardInsert();
//		testBoardList();
//		testBoardSelectOne();
//		testBoardUpdate();
//		testBoardDelete();
		testBoardPagination();
	}


	private void testBoardInsert() {
		BoardVO boardVO = new BoardVO(0, "test title", "test content", "guest", null);
		int result = boardMapper.insert(boardVO);
		log.info(result + "행 삽입");
	}
	
	private void testBoardList() {
		for(BoardVO boardVO : boardMapper.selectList()) {
			log.info(boardVO);
		}
	}
	
	private void testBoardSelectOne() {
        int boardId = 1;
        BoardVO boardVO = boardMapper.selectOne(boardId);
        
        if (boardVO == null) {
            log.warn("게시글 ID = " + boardId + " 에 해당하는 데이터가 없습니다.");
        } else {
            log.info("조회된 게시글: " + boardVO);
        }
    }

    private void testBoardUpdate() {
        BoardVO boardVO = new BoardVO(1, "Updated Title", "Updated Content", "test", null);
        int result = boardMapper.update(boardVO);
        
        if (result == 0) {
        	log.warn("게시글 ID = " + boardVO.getBoardId() + " 에 해당하는 데이터가 없습니다.");
        } else {
        	log.info(result + "행 수정");
        }
    }

    private void testBoardDelete() {
        int boardId = 1;
        int result = boardMapper.delete(boardId);
        
        if (result == 0) {
            log.warn("게시글 ID = " + boardId + " 에 해당하는 데이터가 이미 없습니다.");
        } else {
            log.info(result + "행 삭제되었습니다.");
        }
    }

    private void testBoardPagination() {
    	Pagination pagination = new Pagination(2, 3);
    	List<BoardVO> list = boardMapper.selectListByPagination(pagination);
    	for(BoardVO boardVO : list) {
    		log.info(boardVO);
    	}
    }
    
} // end BoardMapperTest
