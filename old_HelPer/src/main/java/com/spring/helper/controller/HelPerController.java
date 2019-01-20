package com.spring.helper.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.helper.service.BoardService;

@Controller
public class HelPerController{
	
	private static final Logger logger = LoggerFactory.getLogger(HelPerController.class);
	
	@Autowired
	BoardService service;
	
	
	
	@RequestMapping("index")
	   public String index(HttpServletRequest req,Model model,Authentication authentication) throws Exception {
	      logger.info("메인화면 로딩 중....");
	      if(req.getParameter("loginPage")!=null);
	         model.addAttribute("loginPage",req.getParameter("loginPage"));
         //이름 가져오기    
         if(req.getParameter("login")!=null) { 
	         String username = authentication.getName();
	         logger.info("접속자 : " + username);
	         model.addAttribute("name",username);
	      }  
	      return "index";
	   }
	
	@RequestMapping("content")
	public String contents() {
		logger.info("content 로딩 중....");
		return "board/content/content";
	}
	
	// 동욱이 시작
	@RequestMapping("knowledge")
	public void knowledge(HttpServletResponse res) throws Exception {
		logger.info("knowledge 로딩 중....");
		res.sendRedirect("knowledgeBoardList");
	}
	// 동욱이 종료
	
	@RequestMapping("realestate")
	public String realestate() {
		logger.info("realestate 로딩 중....");
		return "board/realestate/realestate";
	}
	
	@RequestMapping("onedayclass")
	public String onedayclass() {
		logger.info("onedayclass 로딩 중....");
		return "board/onedayclass/onedayclass";
	}
	
	@RequestMapping("message")
	public String chatting() {
		logger.info("message 로딩 중....");
		return "board/message/message";
	}
	/*@Secured({"ROLE_ADMIN","ROLE_MASTER"})
	@RequestMapping("onedayclassWritePro")
	public String chatting() {
		logger.info("chatting 로딩 중....");
		return "board/chatting";
	}*/
	
}
