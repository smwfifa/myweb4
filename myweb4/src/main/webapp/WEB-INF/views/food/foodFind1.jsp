<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>foodFind1.jsp</h2>
<p>
인기상품:
	<c:forEach var="temp" items="${str }">
	${temp}&nbsp;
	</c:forEach>
</p>
<form name="f" action="foodFind2.do">
<select name="category">
	<c:forEach var="temp" items="${cate }">
	<option value="${temp }">${temp }</option>
	</c:forEach>
</select>
<input type="text" name="fvalue">
<input type="submit" value="검색">
</form>
<h2>첫번째 가상 화면입니다.</h2>

</body>
</html>