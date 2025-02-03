package com.mokcoding.ex03.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mokcoding.ex03.config.RootConfig;
import com.mokcoding.ex03.domain.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 스프링 JUnit test 연결
@ContextConfiguration(classes = {RootConfig.class}) // 설정 파일 연결
@Log4j
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Test
	public void test() {
		insertReply();
	}

	private void insertReply() {
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBoardId(1);
		replyVO.setMemberId("test");
		replyVO.setReplyContent("댓글 테스트");
		int result = replyMapper.insert(replyVO);
		log.info(result);
	}



} // end ReplyMapperTest
