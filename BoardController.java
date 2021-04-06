package org.zerock.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	private final String MODULE = "board";
	
	//@Setter-lombok사용, @Autowired-spring 사용
	//대신 사용 가능한 어노테이션 : @Autowired - spring,@inject - java
	//DI 적용시 BoardService 타입 : 1. BoardService interface 2.BoardServiceImpl class
	@Setter(onMethod_ = @Autowired )
	private BoardService service;
	
	//실행할 메소드 - list
	//맵핑 -get방식/ list.do
	@GetMapping("/list.do")
	public String list() throws Exception {
		
		log.info("list() - board List");
		
		service.list();
		
		return MODULE +  "/list";
	}
	
	
	//실행할 메소드 -writeForm
	//맵핑 -get방식/ write.do
	@GetMapping("/write.do")
	public String writeForm() {
		
		log.info("writeForm() - board Write Form");
		return MODULE + "/write";
	}
	
	//실행할 메소드 -write 처리
	//맵핑 -post방식/ write.do
	@PostMapping("/write.do")
	public String write() {
		
		log.info("write() - board Write");
		return "redirect:list.do";
	}
	
	//실행할 메소드 -view
	//맵핑 -get방식/ view.do
	@GetMapping("/view.do")
	public String view() {
		
		log.info("view() - board View");
		return MODULE + "/view";
		}
		
	//실행할 메소드 -updateForm
	//맵핑 -get방식/ update.do
	@GetMapping("/update.do")
	public String updateForm() {
		
		log.info("updateForm() - board Update Form");
		return MODULE + "/update";
		}
		
	//실행할 메소드 -update 처리
	//맵핑 -post방식/ update.do
	@PostMapping("/update.do")
	public String update() {
		
		log.info("write() - board Update");
		return "redirect:view.do";
		}
		
	//실행할 메소드 -delete
	//맵핑 -get방식/ delete.do
	@GetMapping("/delete.do")
	public String deleteForm() {
		
		log.info("delete() - board Delete Form");
		return "redirect:list.do";
		}
	
}
