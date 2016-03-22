<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 등록 목록</h2>
<ul>
	<c:forEach var="item" items="${gameAddDTO.gameitem}">
	<li>${item.title}/${item.number }/${item.bigo}</li>
	</c:forEach>
</ul>
<h4>지점명: ${gameAddDTO.centerinfo.centername }</h4>
<h4>지점주소: ${gameAddDTO.centerinfo.address }</h4>
</body>
</html>