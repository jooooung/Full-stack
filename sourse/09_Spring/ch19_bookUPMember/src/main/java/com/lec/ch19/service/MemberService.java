package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	public int idConfirm(String mid);
	public int joinMember(Member member, HttpSession httpSession);	// 회원가입 후 mid 저장 용도 session
	public String loginCheck(String mid, String mpw, HttpSession httpSession); // 로그인 완료 시 session에 정보 넣기
	public Member getDetailMember(String mid);
	public int modifyMember(Member member, HttpSession httpSession);  // 수정 정보 session에 추가
}
