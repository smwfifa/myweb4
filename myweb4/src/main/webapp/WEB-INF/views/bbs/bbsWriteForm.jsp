<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2>자유게시판 글쓰기</h2>
	<form name="bbsWrite" action="bbsWrite.do">
	<table>
	<tr>
		<th>작성자</th>
		<td><input type="text" name="writer"></td>
		<th>비밀번호</th>
		<td><input type="password" name="pwd"></td>
	</tr>
	<tr>
	<th>제목</th>
	<td colspan="3">
	<input type="text" name="subject">
	</td>
	</tr>
	
	<tr>
	<td colspan="4">
	<textarea rows="10" cols="45" name="content"></textarea>
	</td>
	</tr>
	
	<tr>
		<td colspan="4" align="center">
		<input type="submit" value="작성하기">
		<input type="reset" value="다시작성">
		</td>
	</tr>
	
	</table>
	</form>	
	</article>
</section>
</body>
</html>