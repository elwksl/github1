package com.spring.helper.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.helper.vo.BoardVO.KnowledgeVO;
import com.spring.helper.vo.BoardVO.UserVO;


@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSession sqlSession;
	
	// 동욱이 메소드 시작
	// 지식인 게시판 게시글 갯수 구하기
	@Override
	public int knowledgeGetArticleCnt() {
		return sqlSession.selectOne("com.spring.helper.dao.BoardDAO.knowledgeGetArticleCnt");
	}
	// 지식인 게시판 리스트 출력
	@Override
	public ArrayList<KnowledgeVO> knowledgeGetArticleList(Map<String, Object> map) {
		ArrayList<KnowledgeVO> dtos = null;
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dtos = dao.knowledgeGetArticleList(map);
		return dtos;
	}
	// 질문등록 처리
	@Override
	public int knowledgeInsertArticle(KnowledgeVO Knowledge) {
		
		return sqlSession.insert("com.spring.helper.dao.BoardDAO.knowledgeInsertArticle",Knowledge);
	}
	// 지식인 게시판 게시글 상세페이지 출력
	@Override
	public KnowledgeVO knowledgeGetArticle(int knowledgeNumber) {
		return sqlSession.selectOne("com.spring.helper.dao.BoardDAO.knowledgeGetArticle",knowledgeNumber);
	}
	// 댓글작성 처리
	@Override
	public int knowledgeCommentPro(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.spring.helper.dao.BoardDAO.knowledgeCommentPro",map);
	}
	// 동욱이 메소드 종료
	
	
	
	
}
