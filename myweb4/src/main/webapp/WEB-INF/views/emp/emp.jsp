<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section>
	<article>
		<h2>사원 관리 프로그램 (마지막 버전 MyBatis)</h2>
		<form name="empAdd" action="empAdd.do">
			<fieldset>
			<legend>사원 등록</legend>
			<ul>
				<li>사원이름: <input type="text" name="name"></li>
				<li>E-mail: <input type="text" name="email"></li>
				<li>부서: <input type="text" name="dept"></li>
			</ul>
			<p>
				<input type="submit" value="사원등록">
			</p>
			</fieldset>
		</form>
		
		<form name="empDel" action="empDel.do">
			<fieldset>
			<legend>사원 삭제</legend>
			<ul>
				<li>사원번호: <input type="text" name="idx"></li>			
			</ul>
			<p>
				<input type="submit" value="사원삭제">
			</p>
			</fieldset>
		</form>
		
		<form name="empSearch" action="empSearch.do">
			<fieldset>
			<legend>사원 검색</legend>
			<ul>
				<li>사원 이름: <input type="text" name="name"></li>			
			</ul>
			<p>
				<input type="submit" value="사원검색">
			</p>
			</fieldset>
		</form>
		
		<form name="empUpdate" action="empUpdate.do">
			<fieldset>
			<legend>사원 검색</legend>
			<ul>
				<li>사원 번호: <input type="text" name="idx" required="required"></li>			
			</ul>
			<p>
				<input type="submit" value="사원수정">
			</p>
			</fieldset>
		</form>
	</article>
</section>
</body>
</html>