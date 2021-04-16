<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board write</title>
<!-- bootstrap 라이브러리 등록 / CDN 방식 : sitemesh decoreator.jsp에서 한꺼번에 해결  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () {
	$(".cancelBtn").click(function () {
		history.back();	
	});
});
</script>
<style type="text/css">
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
<h2>Board write</h2>
  <form action="write.do" method="post">
  <input name="perPageNum" type="hidden" value="${param.perPageNum }">
    <div class="form-group">
      <label for="title">제목 </label>
      <!-- required : 필수입력, placeholder :입력 초기 안내 ,pattern : 정규표현식으로 유효성 검사, title : 패턴이 맞지 않을 때 메세지-->
      <input name="title" type="text" class="form-control" id="title" pattern=".{4,100}" maxlength="100" required="required" 
      placeholder="4자 이상 100자 미만 입력" title="4자 이상 100자 미만 입력">
    </div>
    <div class="form-group">
  <label for="content">내용 </label>
  <textarea name="content" rows="5" id="content" class="form-control" placeholder="4자 이상 2000자 미만 입력"></textarea>
</div>
    <div class="form-group">
      <label for="writer">작성자 </label>
      <input name="writer" type="text" class="form-control" id="writer" required="required" pattern="[A-Za-z가-힣][0-9-Za-z가-힣]{1,19}">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호 </label>
      <input name="pw" type="text" class="form-control" id="pw" pattern="[^가-힣ㄱ-ㅎ]{4,20}"required="required" title="4자 이상 20자 미만 입력,한글은 입력 할 수 없습니다.">
    </div>
    <button class="btn wBtn">등록</button>
    <button type="reset" class="btn wBtn">새로입력</button>
    <button type="button" class="cancelBtn btn wBtn">취소</button>
  </form>
</div>
</body>
</html>