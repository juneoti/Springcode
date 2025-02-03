package com.mokcoding.ex03.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mokcoding.ex03.domain.BoardVO;

@Mapper
public interface BoardMapper {
	// 메소드 이름은 BoardMapper.xml에서 SQL 쿼리 정의 태그의 id 값과 동일
	// 매개변수는 BoardMapper.xml에서 #{변수명}과 동일(클래스 타입은 각 멤버변수명과 매칭)
	int insert(BoardVO boardVO); // 게시글 등록
	List<BoardVO> selectList(); // 전체 게시글 조회
	BoardVO selectOne(int boardId); // 특정 게시글 조회
	int update(BoardVO boardVO); // 게시글 수정
	int delete(int boardId); // 게시글 삭제
	int updateReplyCount(@Param("boardId") int boardId, @Param("amount") int amount); // 댓글 수 변경
	// @Param : 자바 객체의 속성을 mapper에 매핑
}
