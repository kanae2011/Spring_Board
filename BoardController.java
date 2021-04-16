package org.zerock.board.controller;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;

import com.webjjang.util.PageObject;

import lombok.extern.log4j.Log4j;

//자동생성 - @Controller,@Service,@Repository,@Component,@RestController,@RestControllerAdvice ->Component-scan 설정 : servlet-context.xml,root-context.xml
@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final String MODULE = "board";
	
	//자동DI
	@Autowired
	@Qualifier("bsi")
	private BoardService service;
	
	//1.게시판 목록 -검색 /list.do - get
	@GetMapping("/list.do")
	//@ModelAttribute-전달 받은 변수의 값을 model에 담아서 JSP까지 보내줌. 변수 이름으로 사용
	public String list(Model model,@ModelAttribute PageObject pageObject) throws Exception {
		log.info("BoardController_list().pageObject : " + pageObject + "......");
		model.addAttribute("list",service.list(pageObject));
		return MODULE + "/list";
	}
	
	//2.게시판 글보기 /view.do - get
	@GetMapping("/view.do")
	//Model객체- 처리된 데이터를 JSP에 전달
	//no,inc-숫자 타입 : 원래는 String으로 데이터 전달, 없으면 null 
	public String view(Model model,@ModelAttribute PageObject pageObject,Long no,int inc) throws Exception {
		log.info("BoardController_view().pageObject : " + pageObject + "......");
		model.addAttribute("vo", service.view(no, inc));
		return  MODULE + "/view";
	}
	
	@GetMapping("/write.do")
	//3-1.게시판 작성 폼  /write.do - get
	public String writeForm() {
		return MODULE + "/write";
	}
	
	@PostMapping("/write.do")
	//3-2.게시판 작성 /write.do - post
	public String write(BoardVO vo,int perPageNum, RedirectAttributes rttr) throws Exception {
		log.info("write.vo()" + vo);
		service.write(vo);
		rttr.addFlashAttribute("msg","글 작성 성공");
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
	
	@GetMapping("/update.do")
	//4-1.게시판 글수정 폼 /update.do - get
	public String updateForm(Model model,Long no) throws Exception {
		log.info("updateForm().no : " + no);
		//JSP에 수정할 데이터를 보내야 함. 데이터가 DB에 있음
		model.addAttribute("vo",service.view(no, 0));
		return MODULE + "/update";
	}
	
	@PostMapping("/update.do")
	//4-2.게시판 글수정 /update.do - post
	public String update(BoardVO vo,RedirectAttributes rttr,PageObject pageObject) throws Exception {
		log.info("update().vo" + vo);
		
		int result = service.update(vo);
		if(result == 0)throw new Exception("Board update Fasle -정보 확인 요망");
		log.info("update().result" + result);
		rttr.addFlashAttribute("msg", "글 수정 성공");
		return "redirect:view.do?no=" + vo.getNo() + "&inc=0" 
			+ "&page=" + pageObject.getPage() 
			+ "&perPageNum=" + pageObject.getPerPageNum()
			+ "&key=" + pageObject.getKey()
			//URL로 요청되는 경우 서버의 한글이 적용되므로 UTF-8로 Encode시킴
			+ "&word=" + URLEncoder.encode(pageObject.getWord(),"utf-8") 
			;
	}
	
	@PostMapping("/delete.do")
	//5.게시판 글삭제
	public String delete(BoardVO vo,int perPageNum,RedirectAttributes rttr) throws Exception {
		log.info("delete().vo:"  + vo);
		
		int result = service.delete(vo);
		//result가 0이면 비밀번호가 틀림
		if(result == 0)throw new Exception("Board delete false - 정보확인 요망");
		rttr.addFlashAttribute("msg", "글 삭제 성공");
		return "redirect:list.do?perPageNum=" + perPageNum;
	}
}
