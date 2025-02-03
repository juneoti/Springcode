package com.dishcovery.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dishcovery.project.domain.NoticeBoardVO;
import com.dishcovery.project.persistence.NoticeBoardMapper;

	@Service
	public class NoticeBoardServiceImple implements NoticeBoardService {

	    // NoticeBoardMapper�� �ڵ����� ����
	    @Autowired
	    private NoticeBoardMapper noticeBoardMapper;

	    // ��� ���������� ��ȸ�ϴ� �޼���
	    @Override
	    public List<NoticeBoardVO> getAllNoticeBoards() {
	        // Mapper�� selectAllNoticeBoards �޼��� ȣ��
	        return noticeBoardMapper.selectAllNoticeBoards();
	    }

	    // Ư�� ���������� ��ȸ�ϴ� �޼���
	    @Override
	    public NoticeBoardVO getNoticeBoardById(int noticeBoardId) {
	        // Mapper�� selectNoticeBoardById �޼��� ȣ��
	        return noticeBoardMapper.selectNoticeBoardById(noticeBoardId);
	    }

	    // ���������� ����ϴ� �޼���
	    @Override
	    public void addNoticeBoard(NoticeBoardVO noticeBoard) {
	        // Mapper�� insertNoticeBoard �޼��� ȣ��
	        noticeBoardMapper.insertNoticeBoard(noticeBoard);
	    }

	    // ���������� �����ϴ� �޼���
	    @Override
	    public void updateNoticeBoard(NoticeBoardVO noticeBoard) {
	        // Mapper�� updateNoticeBoard �޼��� ȣ��
	        noticeBoardMapper.updateNoticeBoard(noticeBoard);
	    }

	    // ���������� �����ϴ� �޼���
	    @Override
	    public void deleteNoticeBoard(int noticeBoardId) {
	        // Mapper�� deleteNoticeBoard �޼��� ȣ��
	        noticeBoardMapper.deleteNoticeBoard(noticeBoardId);
	    }
	}