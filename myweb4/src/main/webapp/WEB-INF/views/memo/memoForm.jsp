<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>간단 메모 쓰기</h2>
<form name="memoWrite" action="memoWrite.do" method="post">
순번: <input type="text" name="idx"><br>
제목: <input type="text" name="title"><br>
내용<br>
<textarea rows="6" cols="35" name="content"></textarea><br>
<input type="submit" value="메모작성">
<input type="reset" value="다시작성">
</form>
</body>
</html>