package com.spring.helper.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BoardService {
	
	// 동욱이 메소드 시작(지식인 게시판 관련)
	// 지식인게시판 리스트 출력
	public void knowledgeBoardList(HttpServletRequest req,Model model);
	// 질문등록 처리
	public void knowledgeInsertArticle(HttpServletRequest req,Model model);
	// 지식인게시판 글 상세페이지 출력
	public void knowledgeDetailForm(HttpServletRequest req,Model model);
	// 답변등록 처리
	public void knowledgeCommentPro(HttpServletRequest req,Model model);
	// 동욱이 메소드 종료
}
