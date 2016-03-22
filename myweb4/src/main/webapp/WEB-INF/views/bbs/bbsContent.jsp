<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2{
	text-align: center;
}
table{
	margin: 0px auto;
}


</style>
</head>
<body>
<section>
	<article>
	<h2>자유게시판 본문보기</h2>
	<table border="1" cellspacing="0" width="550">
	<c:forEach var="dto" items="${content }">
	<tr>
		<th>글번호</th>
		<td>${dto.idx }</td>
		<th>조회수</th>
		<td>${dto.readnum }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${dto.writer }</td>
		<th>작성일자</th>
		<td>${dto.writedate }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3">${dto.subject }</td>
	</tr>
	
	<tr height="250">
		<td colspan="4" align="left" valign="top">
		${dto.content }
		</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4" align="center">
		<a href="">답변쓰기</a> | 
		<a href="bbsList.do">목록으로</a>
		</td>
	</tr>
	</table>
	
	</article>
</section>
</body>
</html>