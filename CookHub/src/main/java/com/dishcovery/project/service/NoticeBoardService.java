package com.dishcovery.project.service;

import java.util.List;

import com.dishcovery.project.domain.NoticeBoardVO;

public interface NoticeBoardService {

    // ��� ���������� ��ȸ�ϴ� �޼���
    List<NoticeBoardVO> getAllNoticeBoards();

    // Ư�� ���������� ��ȸ�ϴ� �޼���
    NoticeBoardVO getNoticeBoardById(int noticeBoardId);

    // ���������� ����ϴ� �޼���
    void addNoticeBoard(NoticeBoardVO noticeBoard);

    // ���������� �����ϴ� �޼���
    void updateNoticeBoard(NoticeBoardVO noticeBoard);

    // ���������� �����ϴ� �޼���
    void deleteNoticeBoard(int noticeBoardId);
}