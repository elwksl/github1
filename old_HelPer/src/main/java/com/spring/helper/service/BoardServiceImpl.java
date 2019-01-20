package com.spring.helper.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.helper.dao.BoardDAO;
import com.spring.helper.vo.BoardVO.KnowledgeVO;
import com.spring.helper.vo.BoardVO.UserVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDao;

	// 동욱이 메소드 시작(지식인게시판)
	// 지식인게시판 리스트 출력
	@Override
	public void knowledgeBoardList(HttpServletRequest req, Model model) {
		int pageSize = 10; 		// 한 페이지당 출력할 글 갯수
		if(req.getParameter("btn_select")!=null) {
			pageSize = Integer.parseInt(req.getParameter("btn_select"));
		}
		int pageBlock = 3; 		// 한 블럭당 페이지 갯수
		int cnt = 0;       		// 글 갯수
		int start = 0;	   		// 현재 페이지 시작 글번호
		int end = 0;	   		// 현재 페이지 마지막 글번호
		int number = 0;    		// 출력용 글번호
		String pageNum = ""; 	// 페이지 번호
		int currentPage = 0;    // 현재 페이지
		int pageCount = 0;      // 페이지 갯수
		int startPage = 0;		// 시작 페이지
		int endPage = 0;		// 마지막 페이지
		cnt = boardDao.knowledgeGetArticleCnt();
		pageNum = req.getParameter("pageNum");
		
		if(pageNum== null) {
			pageNum = "1"; // 첫페이지를 1로 주겠다.
		}
		// 글 30건 기준
		currentPage = Integer.parseInt(pageNum); // 현재 페이지
		System.out.println("currentPage : "+currentPage);
		
		// 페이지 갯수 6 = (30 / 5 ) + (0)
		pageCount = (cnt / pageSize) +(cnt % pageSize > 0 ? 1 : 0);
		
		//현재 페이지 시작 글번호
		// 1 = (1 - 1) * 5 + 1
		start = (currentPage-1) * pageSize + 1;
		
		//현재 페이지 마지막 글번호
		//5 = 1 + 5 - 1;
		end = start + pageSize -1;
		if(end > cnt) end = cnt;	
		// 출력용 글번호
		number = cnt - (currentPage -1)* pageSize;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		if(cnt>0) {
			// 게시글 목록 조회
			ArrayList<KnowledgeVO> dtos = boardDao.knowledgeGetArticleList(map);
			model.addAttribute("dtos", dtos); // 큰바구니 : 게시글 목록 cf)작은 바구니 1건
			String pageSize2 = String.valueOf(pageSize);
			model.addAttribute("btn_select", pageSize2);
		}
		
		// 6단계. request나 session에 처리 결과를 저장(jsp에 전달하기 위함)
		
		// 시작페이지 1 = (1/3) * 3 + 1
		startPage = (currentPage / pageBlock) * pageBlock + 1;
		if(currentPage % pageBlock == 0) startPage -= pageBlock;
		// 마지막 페이지 3 = 1 + 3 - 1
		endPage = startPage + pageBlock-1;
		if(endPage > pageCount) endPage = pageCount;
		req.setAttribute("cnt", cnt); // 글갯수
		req.setAttribute("number", number); // 출력용 글번호
		req.setAttribute("pageNum", pageNum); // 페이지 번호
		if(cnt >0) {
			req.setAttribute("startPage", startPage); // 시작 페이지
			req.setAttribute("endPage", endPage); // 마지막 페이지
			req.setAttribute("pageBlock", pageBlock); // 출력할 페이지 갯수
			req.setAttribute("pageCount", pageCount); // 페이지 갯수
			req.setAttribute("currentPage", currentPage); // 현재페이지
		}
		
	}
	//질문등록 처리
	@Override
	public void knowledgeInsertArticle(HttpServletRequest req, Model model) {
		
		String knowledgeSubject = req.getParameter("knowledgeSubject");
		String knowledgeContent = req.getParameter("knowledgeContent");
		String knowledgeOpenCheck = req.getParameter("knowledgeOpenCheck");
		String knowledgeCategory = req.getParameter("knowledgeCategory");
		int knowledgeReward = Integer.parseInt(req.getParameter("addReward"));
		KnowledgeVO Knowledge = new KnowledgeVO();
		Knowledge.setKnowledgeReward(knowledgeReward);
		Knowledge.setKnowledgeSubject(knowledgeSubject);
		Knowledge.setKnowledgeContent(knowledgeContent);
		Knowledge.setKnowledgeOpenCheck(knowledgeOpenCheck);
		Knowledge.setKnowledgeCategory(knowledgeCategory);
		int insertcnt = boardDao.knowledgeInsertArticle(Knowledge);
		model.addAttribute("insertcnt",insertcnt);
		
	}
	// 지식인게시판 게시글 상세페이지 출력
	@Override
	public void knowledgeDetailForm(HttpServletRequest req, Model model) {
		int knowledgeNumber = Integer.parseInt(req.getParameter("knowledgeNumber"));
		KnowledgeVO Knowledge = new KnowledgeVO();
		Knowledge = boardDao.knowledgeGetArticle(knowledgeNumber);
		model.addAttribute("dtos",Knowledge);
	}
	// 답변 등록 처리
	@Override
	public void knowledgeCommentPro(HttpServletRequest req, Model model) {
		String kCommentContent = req.getParameter("kCommentContent");
		int knowledgeNumber = Integer.parseInt(req.getParameter("knowledgeNumber"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kCommentContent", kCommentContent);
		map.put("knowledgeNumber", knowledgeNumber);
		int kCommentCnt = boardDao.knowledgeCommentPro(map);
		req.setAttribute("knowledgeNumber", knowledgeNumber);
		req.setAttribute("kCommentCnt", kCommentCnt);
	}
	// 동욱이 메소드 종료
	

	
}
