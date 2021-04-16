<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board view</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
//F5, ctrl + F5, ctrl + r 새로고침 막기
$(function(){
	   $(document).keydown(function (e) {
	        
	        if (e.which === 116) {
	            if (typeof event == "object") {
	                event.keyCode = 0;
	            }
	            return false;
	        } else if (e.which === 82 && e.ctrlKey) {
	            return false;
	        }
	   }); 
	   
	   ${(empty msg)?"":"alert('"+= msg +="');"}
	   
//모달 안에 있는 삭제 버튼 이벤트
$("#modal_deleteBtn").click(function () {
	alert("modal 삭제");
	$("#modal_form").submit();
});

});

</script>

<style type="text/css">
.title_label{
	border:1px solid #ddd;
}	
<style type="text/css">
.dataRow:hover {
   cursor: pointer;
   background: #d8f3eb;
}

h2{
   text-align: center;
   margin: 50px;
   color: white; 
    background: #bce7f6; 
}

div {
   background: none;
}

 body { 
    background-color: #ecf9f5;  
    margin: 0; */
 } 
.wBtn {
   background-color: #8bdac4; /* Green */
   border: none;
   color: white;
   padding: 8px 16px;
   text-align: center;
   text-decoration: none;
   display: inline-block;
   font-size: 12px;
   margin: 2px 1px;
   transition-duration: 0.4s;
   cursor: pointer;
}

.wBtn {
   background-color: white;
   color: black;
   border: 2px solid #8bdac4;
}
.wBtn:hover {
   background-color: #8bdac4;
   color: white;
}
.abc{
    background-color: #ecf9f5; 
}

</style>
</head>
<body>
<div class="container">
<h2>Board view</h2>
<!-- 데이터 표시하는 부분 -->
<ul class="list-group">
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">번호</div>
  	<div class="col-md-10">${vo.no }</div>
  </li>
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">제목</div>
  	<div class="col-md-10">${vo.title }</div>
  </li>
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">내용</div>
  	<div class="col-md-10">${vo.content }</div>
  </li>
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">작성자</div>
  	<div class="col-md-10">${vo.writer }</div>
  </li>
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">작성일</div>
  	<div class="col-md-10">
	  	<fmt:formatDate value="${vo.writeDate }" pattern="yyyy.MM.dd"/> 
	  	<fmt:formatDate value="${vo.writeDate }" pattern="hh:mm.ss"/> 
  	</div>
  </li>
  <li class="list-group-item list-group-item-success row">
  	<div class="col-md-2 title_label">조회수</div>
  	<div class="col-md-10">${vo.hit }</div>
  </li>

</ul>
<a href="update.do?no=${vo.no }&page=${pageObject.page}&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}" class="btn wBtn">수정</a>
<a class="btn wBtn" data-toggle="modal" data-target="#myModal" onclick="return false;">삭제</a>
<a href="list.do?page=${pageObject.page }&perPageNum=${pageObject.perPageNum}&key=${pageObject.key}&word=${pageObject.word}" class="btn wBtn">목록</a>

</div>
 <!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">글삭제용 비밀번호 입력</h4>
      </div>
      <div class="modal-body">
        <form action="delete.do" method="post" id="modal_form">
        <input type="hidden" name="no" value="${vo.no }">
        <input type="hidden" name="perPageNum" value="${pageObject.perPageNum}">
        	<div class="form-group">
        		<label>비밀번호 : </label>
        		<input name="pw" type="password" id="pw" pattern="[^가-힣ㄱ-ㅎ]{4,20}"required="required" title="4자 이상 20자 미만 입력,한글은 입력 할 수 없습니다.">
        	</div>
        
        </form>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" data-dismiss="modal" id="modal_deleteBtn">삭제</button>
        <button type="button" class="btn btn-success" data-dismiss="modal">취소</button>
      </div>
    </div>

  </div>
</div>
</body>
</html>