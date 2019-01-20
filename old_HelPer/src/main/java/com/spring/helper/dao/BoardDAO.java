package com.spring.helper.dao;

import java.util.ArrayList;
import java.util.Map;

import com.spring.helper.vo.BoardVO.KnowledgeVO;
import com.spring.helper.vo.BoardVO.UserVO;


public interface BoardDAO {

	// 동욱이 메소드 시작(지식인게시판)
	// 지식인 게시판 출력 자료 갯수 구하기
	public int knowledgeGetArticleCnt();
	// 지식인 게시판 리스트 출력
	public ArrayList<KnowledgeVO> knowledgeGetArticleList(Map<String, Object> map);
	// 질문등록 처리
	public int knowledgeInsertArticle(KnowledgeVO Knowledge);
	// 지식인게시판 게시글 상세페이지 출력
	public KnowledgeVO knowledgeGetArticle(int knowledgeNumber);
	// 댓글작성 처리
	public int knowledgeCommentPro(Map<String, Object> map);
	// 동욱이 메소드 종료
}
