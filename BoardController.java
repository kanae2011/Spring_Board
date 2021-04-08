package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;
import org.zerock.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final String MODULE = "board";
	
	//@Setter-lombok사용, @Autowired-spring 사용
	//대신 사용 가능한 어노테이션 : @Autowired - spring,@inject - java
	//DI 적용시 BoardService 타입 : 1. BoardService interface 2.BoardServiceImpl class
//	@Setter(onMethod_ = @Autowired )
	@Autowired
	// BoardService 상속 받아서 타입이 같은 것이 있으면 어떤 것을 넣어 줄지 결정이 안돼서 오류 - 해결
	@Qualifier("bsi")
	private BoardService service;
	
	//실행할 메소드 - list
	//맵핑 -get방식/ list.do
	@GetMapping("/list.do")
	public String list(Model model) throws Exception {
		
		log.info("list() - board List");
		
		//model에 데이터를 담으면 model안에 있는 request에 데이터가 담김 
		model.addAttribute("list",service.list());
		
		return MODULE +  "/list";
	}
	
	//실행할 메소드 -view
	//맵핑 -get방식/ view.do
	@GetMapping("/view.do")
	public String view(Model model, Long no) throws Exception {
		
		log.info("view().no: " + no + " - board View");
		model.addAttribute("vo",service.view(no));
		return MODULE + "/view";
	}
	
	//실행할 메소드 -writeForm
	//맵핑 -get방식/ write.do
	@GetMapping("/write.do")
	public String writeForm() throws Exception{
		
		log.info("writeForm() - board Write Form");
		return MODULE + "/write";
	}
	
	//실행할 메소드 -write 처리
	//맵핑 -post방식/ write.do
	@PostMapping("/write.do")
	public String write(BoardVO vo) throws Exception{
		
		log.info("write().vo: " + vo + " - board Write");
		service.write(vo);
		return "redirect:list.do";
	}
	
		
	//실행할 메소드 -updateForm
	//맵핑 -get방식/ update.do
	@GetMapping("/update.do")
	public String updateForm(Model model,Long no) throws Exception{
		
		log.info("updateForm() - board Update Form");
		
		model.addAttribute("vo",service.view(no));
		
		return MODULE + "/update";
		}
		
	//실행할 메소드 -update 처리
	//맵핑 -post방식/ update.do
	@PostMapping("/update.do")
	public String update(BoardVO vo) throws Exception{
		
		log.info("update().vo : " + vo + " - board Update");
		service.update(vo);
		return "redirect:view.do?no=" + vo.getNo();
		}
		
	//실행할 메소드 -delete
	//맵핑 -get방식/ delete.do
	@GetMapping("/delete.do")
	public String deleteForm(Long no) throws Exception{
		
		log.info("delete().no" + no + " - board Delete Form");
		service.delete(no);
		
		return "redirect:list.do";
		}
	
}
