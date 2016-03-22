<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일업로드 테스트</h2>
<h3>@RequestParam 방식</h3>
<!-- 파일 업로드 할떄는 Method방식을 post로 업로드를 해야된다. 
enctype="application/x-www-form-urlencoded 에서
enctype="multipart/form-data"로 변경해줘야 한다.-->
<form name="fileupload1" action="fileupload1.do" method="post" enctype="multipart/form-data">
작성자: <input type="text" name="writer"><br>
파일: <input type="file" name="upload"><br>		<!-- File선택 태그 -->
<input type="submit" value="파일올리기">
</form>

<hr>
<h3>MultipartHttpServletRequest 방식</h3>
<form name="fileupload2" action="fileupload2.do" method="post" enctype="multipart/form-data">
작성자: <input type="text" name="writer"><br>
파일: <input type="file" name="upload"><br>		<!-- File선택 태그 -->
<input type="submit" value="파일올리기">
</form>

<hr>
<h3>DTO를 이용한 방식</h3>
<form name="fileupload3" action="fileupload3.do" method="post" enctype="multipart/form-data">
작성자: <input type="text" name="writer"><br>
파일: <input type="file" name="upload"><br>		<!-- File선택 태그 -->
<input type="submit" value="파일올리기">
</form>

<hr>
<h3>파일 3개를 한번에 올리기</h3>
<form name="fileupload4" action="fileupload4.do" method="post" enctype="multipart/form-data">
작성자: <input type="text" name="writer"><br>
파일1: <input type="file" name="uploads"><br>
파일2: <input type="file" name="uploads"><br>
파일3: <input type="file" name="uploads"><br>
<input type="submit" value="파일올리기">
</form>
</body>
</html>