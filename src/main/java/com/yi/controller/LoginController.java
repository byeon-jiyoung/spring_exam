package com.yi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.LoginDTO;
import com.yi.domain.MemberVO;
import com.yi.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public void joinGet() {
		logger.info("-------------- join GET --------------");
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String joinPost(MemberVO vo) throws Exception {
		logger.info("-------------- join POST --------------");
		logger.info(vo.toString());
		
		service.insertMember(vo);
		
//		return "redirect:/board/list";
		return "redirect:/";
	}
	
	/*@RequestMapping(value="join", method=RequestMethod.POST)
	public String joinPut(String userid) throws Exception {
		logger.info("-------------- join PUT --------------" + userid);
		
		MemberVO member = service.selectMemberById(userid);
		String duplication = "";
		
		if(member != null) {
			duplication = "yes";
			logger.info("exist");
		}else {
			duplication = "no";
			logger.info("notexist");
		}
		
		return duplication;
	}*/
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGet() {
		logger.info("-------------- login GET --------------");
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void loginPost(MemberVO vo, Model model) throws Exception {
		logger.info("-------------- login POST --------------");
		
		MemberVO dbMember = service.selectMemberByIdAndPw(vo.getUserid(), vo.getUserpw()); //DB에서 받아오는 정보
		
		if(dbMember == null) {
			logger.info("login POST ...... login fail, not member");
			return;
		}
		
		LoginDTO dto = new LoginDTO();
		dto.setUserid(dbMember.getUserid());
		dto.setUsername(dbMember.getUsername());
		
		model.addAttribute("loginDTO", dto);
	}
}
