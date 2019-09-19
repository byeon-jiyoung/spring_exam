package com.yi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.service.BoardService;
import com.yi.util.UploadFileUtils;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public void registerGET() {
		logger.info("-------- registerGET ---------");
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String registerPOST(BoardVO vo, List<MultipartFile> imgFiles) throws Exception {
																//boardVO변수이름이랑 동일해서 스프링이 어디에 넣어야 될지 몰라서 매개변수 에러난다. 그래서 이름을 다르게 해줘야됨
		logger.info("-------- registerPOST ---------");
		logger.info(vo.toString());
		
		ArrayList<String> list = new ArrayList<>();
		for(MultipartFile file : imgFiles) {
			logger.info("file name : " + file.getOriginalFilename());
			logger.info("file size : " + file.getSize());
			
			if(file.getSize() <= 0) {
				continue;
			}
			
			String savedName = UploadFileUtils.upladFile(uploadPath, file.getOriginalFilename(), file.getBytes()); //파일 업로드하고, 썸네일 파일까지 다 만들어줌
			list.add(savedName);
		}
		vo.setFiles(list);
		
		service.insertBoard(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("-------- listPage ---------");
		
		/*List<BoardVO> list = service.listboard(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listboardCount(cri));
		model.addAttribute("pageMaker", pageMaker);*/
	}
}
