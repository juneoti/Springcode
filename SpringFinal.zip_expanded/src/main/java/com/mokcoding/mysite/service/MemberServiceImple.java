package com.mokcoding.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mokcoding.mysite.domain.Member;
import com.mokcoding.mysite.domain.MemberDTO;
import com.mokcoding.mysite.persistence.MemberMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;

	@Transactional(value = "transactionManager")
	@Override
	public int createMember(MemberDTO memberDTO) {
		log.info("createMember()");
		int insertMemberResult = memberMapper.insertMember(toEntity(memberDTO));
		log.info(insertMemberResult + "행 회원 정보 등록");
	
		int insertRoleResult = memberMapper.insertMemberRole(memberDTO.getMemberId());
		log.info(insertRoleResult + "행 권한 정보 등록");
		return 1;
	}

	@Override
	public int checkMemberId(String memberId) {
		log.info("checkMemberId()");
		
		return memberMapper.selectExistingMemberId(memberId);
	}
	
	@Override
	public MemberDTO getMemberById(String memberId) {
		log.info("getMemberById()");
		return toDTO(memberMapper.selectMemberByMemberId(memberId));
	}


	@Override
	public int updateMember(MemberDTO memberDTO) {
		log.info("updateMember()");
		return memberMapper.updateMember(toEntity(memberDTO));
	}

	@Transactional(value = "transactionManager")
	@Override
	public int deleteMember(String memberId) {
		log.info("deleteMember()");
		int deleteMemberResult = memberMapper.deleteMember(memberId);
		log.info(deleteMemberResult + "행 회원 정보 삭제");
		int deleteRoleResult = memberMapper.deleteMemberRole(memberId);
		log.info(deleteRoleResult + "행 권한 정보 삭제");
		return 1;
	}
	
	
    public MemberDTO toDTO(Member member) {
    	MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberId(member.getMemberId());
        memberDTO.setMemberPw(member.getMemberPw());
        memberDTO.setMemberName(member.getMemberName());
        memberDTO.setRegDate(member.getRegDate());
        memberDTO.setEnabled(member.getEnabled());
        return memberDTO;
    }

    public Member toEntity(MemberDTO memberDTO) {
        Member entity = new Member();
        entity.setMemberId(memberDTO.getMemberId());
        entity.setMemberPw(memberDTO.getMemberPw());
        entity.setMemberName(memberDTO.getMemberName());
        entity.setRegDate(memberDTO.getRegDate());
        entity.setEnabled(memberDTO.getEnabled());
        return entity;
    }



}
