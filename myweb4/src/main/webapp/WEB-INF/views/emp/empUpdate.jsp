<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="dto" items="${list }">
	<form name="empUpdate_ok" action="empUpdate_ok.do">
		<ul>
			<li>사원 번호 : <input type="text" name="idx" value="${dto.idx }"></li>
			<li>사원 이름 : <input type="text" name="name" value="${dto.name }"></li>
			<li>사원 메일 : <input type="text" name="email" value="${dto.email }"></li>
			<li>사원 부서 : <input type="text" name="dept" value="${dto.dept }"></li>
		</ul>
		<input type="submit" value="수정하기">
	</form>
	</c:forEach>

</body>
</html>