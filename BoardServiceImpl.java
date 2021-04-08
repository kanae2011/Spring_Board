package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.zerock.board.dao.BoardDAO;
import org.zerock.board.mapper.BoardMapper;
import org.zerock.board.vo.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//자동생성하게 하는 annotation
//@Controller,@Sevice,@Repository,@Comtonent,@RestController,@Advice
///WEB-INF/spring/root-context./xml 설정이 되어 있어야함.component-scan

@Service
@Log4j
//BoardService 상속 받아서 같은 것이 있으면 어떤 것을 넣어 줄지 결정이 안돼서 오류 발생->  @Qualifier 지정 
@Qualifier("bsi")
public class BoardServiceImpl implements BoardService{
	
	
	//@Setter-lombok사용, @Autowired-spring 사용
	//대신 사용 가능한 어노테이션 : @Autowired - spring,@inject - java
	//DI 적용시 BoardService 타입 : 1. BoardService interface 2.BoardServiceImpl class
	@Setter(onMethod_ = @Autowired )
//	private BoardDAO dao;
	private BoardMapper mapper;

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		log.info("list()-BoardListService실행");
//		dao.list();
//		dao.getTotalRow();
		return mapper.list();
	}

	@Override
	public BoardVO view(Long no) throws Exception {
		// TODO Auto-generated method stub
		log.info("view()-BoardViewService실행");
		return mapper.view(no);
	}

	@Override
	public int write(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.write(vo);
	}

	@Override
	public int update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int delete(Long no) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(no);
	}

}
