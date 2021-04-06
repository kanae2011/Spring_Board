package org.zerock.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.board.vo.BoardVO;
import lombok.extern.log4j.Log4j;


//자동생성하게 하는 annotation
//@Controller,@Sevice,@Repository,@Comtonent,@RestController,@Advice
///WEB-INF/spring/root-context./xml 설정이 되어 있어야함.component-scan
@Repository
@Log4j

public class BoardDAOImpl implements BoardDAO{

	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		log.info("list() - BoardList 데이터 가져오기 ");
		return null;
	}

	@Override
	public Long getTotalRow() throws Exception {
		// TODO Auto-generated method stub
		log.info("getTotalRow() - getTotalRow 전체 데이터 갯수 가져오기 ");
		return null;
	}

	@Override
	public BoardVO view() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int increase() throws Exception {
		// TODO Auto-generated method stub
		return 0;
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
