package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.vo.BoardVO;

public interface BoardMapper {

	//1.list
	public List<BoardVO> list()throws Exception;
	
	//1-1.전체 데이터 갯수 가져오기
	public Long getTotalRow()throws Exception;
	
	//2.view
	public BoardVO view()throws Exception;
	//2-1.조회수 1증가
	public int increase()throws Exception;
	
	//3.write
	public int write()throws Exception;
	
	//4.update
	public int update()throws Exception;
	
	//5.delete
	public int delete()throws Exception;
}
