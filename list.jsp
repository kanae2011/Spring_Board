<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="pageObject" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board list</title>
<!-- bootstrap 라이브러리 등록 / CDN 방식 : sitemesh decoreator.jsp에서 한꺼번에 해결  -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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

<script type="text/javascript">
$(function () {
	
	${(empty msg)?"":"alert('"+= msg +="');"}
	
	 $(".dataRow").click(function(){
	      var no = $(this).find(".no").text();
	      //페이지 정보 붙이기
	      var query = ${(empty pageObject)?"''":"'&page=" += pageObject.page
	            += "&perPageNum=" += pageObject.perPageNum += "'"};
	     //검색 정보 붙이기
	     query += ${(empty pageObject.word)?"''":"'&key=" += pageObject.key
		            += "&word=" += pageObject.word += "'"};
		location = "view.do?no=" + no + "&inc=1" + query;
	});
});
</script>
</head>
<body>
	<div class="container">
	<h2 class="row">
	Board list
	</h2>
	<form>
		<input name="page" value="1" type="hidden"/>
		<input name="perPageNum" value="${pageObject.perPageNum }" type="hidden"/>
	  <div class="input-group">
	  <span class= "input-group-addon">
	  	<select name="key">
	  		<option value="t" ${(pageObject.key == "t")?"selected":"" }>제목</option>
	  		<option value="c" ${(pageObject.key == "c")?"selected":"" }>내용</option>
	  		<option value="w" ${(pageObject.key == "w")?"selected":"" }>작성자</option>
	  		<option value="tc" ${(pageObject.key == "tc")?"selected":"" }>제목/내용</option>
	  		<option value="tw" ${(pageObject.key == "tw")?"selected":"" }>제목/작성자</option>
	  		<option value="cw" ${(pageObject.key == "cw")?"selected":"" }>내용/작성자</option>
	  		<option value="tcw" ${(pageObject.key == "tcw")?"selected":"" }>전체</option>
	  	</select>
	  </span>
	    <input type="text" class="form-control" placeholder="Search" name="word" value="${pageObject.word }">
	    <div class="input-group-btn">
	      <button class="btn btn-default" type="submit">
	        <i class="glyphicon glyphicon-search"></i>
	      </button>
	    </div>
	  </div>
	</form>
		<ul class="list-group">
			<!-- 데이터가 존재하지 않는 경우  -->
			<c:if test="${empty list }">
				<li class="list-group-item list-group-item-success ">데이터가 존재하지
					않습니다.</li>
			</c:if>
			<!-- 데이터가 존재하는 경우  -->
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="vo">
					<li class="list-group-item list-group-item-success dataRow">
						<div>
							<span class="no">${vo.no }</span>. ${vo.title }
						</div> 
						${vo.writer} (<fmt:formatDate value="${vo.writeDate }" />) 
						<span class="badge">${vo.hit }</span>
					</li>
				</c:forEach>
			</c:if>
		</ul>
		<!-- a tag, js : location, 주소 입력:get 방식으로 넘김 / post방식은 지정을 꼭 해주어야 함 -->
		<a href="write.do?perPageNum=${pageObject.perPageNum }" class="btn wBtn">작성</a>
		<div>
		<pageObject:pageNav listURI="list.do" 
			pageObject="${pageObject }" query="&key=${pageObject.key }&word=${pageObject.word }" />	
		</div>
	</div>
</body>
</html>