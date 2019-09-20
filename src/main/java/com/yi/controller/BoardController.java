package com.yi.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		
		for(MultipartFile file : imgFiles) {
			logger.info("file name : " + file.getOriginalFilename());
			logger.info("file size : " + file.getSize());
			
			if(file.getSize() <= 0) {
				continue;
			}
			
			String savedName = UploadFileUtils.upladFile(uploadPath, file.getOriginalFilename(), file.getBytes()); //파일 업로드하고, 썸네일 파일까지 다 만들어줌
			vo.setFile(savedName);
			vo.setOriginfile(file.getOriginalFilename());
			service.insertBoard(vo);
		}
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		logger.info("-------- listPage ---------");
		
		List<BoardVO> list = service.listboard(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listBoardCount(cri));
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST) //delete를 post로 바꿈
	public @ResponseBody List<BoardVO> deletePage(int bno, Criteria cri, RedirectAttributes rattr) throws Exception {
		logger.info("-------- delete --------- & bno: "+ bno);
		
		BoardVO vo = service.readBoard(bno); //delete전에 적어줘야 읽을 수 있다.
		service.deleteBoard(bno);
		
		//파일도 지워지도록 처리. 지울 파일 목록
		UploadFileUtils.deleteFile(uploadPath, vo.getFile());
		
		List<BoardVO> list = service.listboard(cri);
		
		rattr.addAttribute("page",cri.getPage());
		
		return list;
	}
	
	@RequestMapping(value="/displayFile", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<byte[]> displayFile(String filename) { //외부에 저장되어 있는 파일을 불러오기 위해 byte배열로 데이터를 주고받아야 한다.
		logger.info("------------- displayFile, filename : " + filename);
		
		String formatName = filename.substring(filename.lastIndexOf(".")+1); //확장자만 뽑아냄
		MediaType mType = null;
		ResponseEntity<byte[]> entity = null;
		
		if(formatName.equalsIgnoreCase("jpg")) {
			mType = MediaType.IMAGE_JPEG;
		}else if(formatName.equalsIgnoreCase("gif")) {
			mType = MediaType.IMAGE_GIF;
		}else if(formatName.equalsIgnoreCase("png")) {
			mType = MediaType.IMAGE_PNG;
		}
		
		InputStream in = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + "/" + filename);
			headers.setContentType(mType);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if(in != null) {
				try {
					in.close(); //파일을 열었으면 반드시 닫아줘야 한다!!!!★★★★★ 이거 안닫아주면 계속 inputstream으로 파일 당겨서 close가 잘 안됨
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return entity;
	}
}
