<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메모작성 성공!</h2>
<h3>db에 저장된 내용들..</h3>
<h4>번호: ${cmd.idx}</h4>
<h4>제목: ${cmd.title}</h4>
<h4>내용: ${cmd.content}</h4>
<!-- EL에서 넣을땐 앞에 소문자로 입력 -->
</body>
</html>