<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	margin:0px auto;
	width: 550px;
	border-top: 2px double blue;
	border-bottom: 2px double blue;
	border-spacing: 0px;
}

table thead th{
	background: skyblue;
}

table tfoot td{
	border-top: 2px solid black;
}	

table tbody td{
	text-align: center;
}
</style>
</head>
<body>
<h2>게시판 모두보기</h2>
<section>
	<article>
		<h2>자유게시판</h2>
		<table summary="게시판리스트">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		<thead>
		
		<!-- 페이징처리 -->
		<tfoot>
			<tr>
			<td colspan="3" align="center">
				${requestScope.pageStr}
			</td>
			<td align="center">
			<a href="bbsWriteForm.do">글쓰기</a>
			</td>
			</tr>
		</tfoot>
		<!--  -->
			<tbody>
		<c:set var="bbsList" value="${requestScope.list}"></c:set>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4">등록된 게시글이 없습니다.</td>
			</tr>
		</c:if>	
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.idx}</td>
				<td><a href="bbsContent.do?idx=${dto.idx}">${dto.subject}</a></td>
				<td>${dto.writer }</td>
				<td>${dto.readnum }</td>
			</tr>		
		</c:forEach>
		</tbody>
		</table>
	</article>
</section>
</body>
</html>