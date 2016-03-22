<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>매장 게임 상품 등록 페이지</h2>
<form name="gameAdd" action="gameAdd.do" method="post">

<!-- 
	

 -->
게임1: 타이틀-<input type="text" name="gameitem[0].title">/
	수량-<input type="text" name="gameitem[0].number">
	비고-<input type="text" name="gameitem[0].bigo"><br>
게임2: 타이틀-<input type="text" name="gameitem[1].title">/
	수량-<input type="text" name="gameitem[1].number">
	비고-<input type="text" name="gameitem[1].bigo"><br>
게임3: 타이틀-<input type="text" name="gameitem[2].title">/
	수량-<input type="text" name="gameitem[2].number">
	비고-<input type="text" name="gameitem[2].bigo"><br>
지점정보<br>
지점명: <input type="text" name="centerinfo.centername"><br>
지점주소: <input type="text" name="centerinfo.address"><br>
<input type="submit" value="상품등록">
</form>
</body>
</html>