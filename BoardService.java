package org.zerock.board.service;

import java.util.List;

import org.zerock.board.vo.BoardVO;

public interface BoardService {

	//1.list
	public List<BoardVO> list()throws Exception;
	
	//2.view
	public BoardVO view(Long no)throws Exception;
	
	//3.write
	public int write(BoardVO vo)throws Exception;
	
	//4.update
	public int update(BoardVO vo)throws Exception;
	
	//5.delete
	public int delete(Long no)throws Exception;

	
}
