package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.dao.BoardDAO;
import org.zerock.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//자동생성하게 하는 annotation
//@Controller,@Sevice,@Repository,@Comtonent,@RestController,@Advice
///WEB-INF/spring/root-context./xml 설정이 되어 있어야함.component-scan

@Service
@Log4j
public class BoardServiceImpl implements BoardService{
	
	
	//@Setter-lombok사용, @Autowired-spring 사용
	//대신 사용 가능한 어노테이션 : @Autowired - spring,@inject - java
	//DI 적용시 BoardService 타입 : 1. BoardService interface 2.BoardServiceImpl class
	@Setter(onMethod_ = @Autowired )
	private BoardDAO dao;

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		log.info("list()-BoardListService실행");
		dao.list();
		dao.getTotalRow();
		return null;
	}

	@Override
	public BoardVO view() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int write() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
