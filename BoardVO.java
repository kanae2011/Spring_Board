package org.zerock.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {

	//글번호,제목,내용,작성자,작성일,조회수
	
	private Long no;
	private String title,content,writer;
	private Date writeDate;
	private Long hit;
	
	//getter / setter / toString / 생성자 -> lombok이 해결해 줌 
}
