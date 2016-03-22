<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function loginOpen(){
	window.open('loginForm.do', 'login', 'width=450,height=250');
}
</script>
</head>
<body>
<h2>메이븐 기반의 웹프로젝트</h2>
<c:if test="${empty sessionScope.sid }">
<p>
	<a href="javascript:loginOpen()">로그인</a> | <a href="join.do">회원가입</a>
	
</p>
</c:if>
<c:if test="${!empty sessionScope.sid }">
	${sessionScope.sname }님 로그인중... | <a href="logout.do">로그아웃</a>
</c:if>
<ul>
	<li><a href="ajaxTest.do">ajaxTest</a></li>
	<li><a href="bbsList.do">게시판 BBS</a></li>
	<li><a href="empList.do">사원 목록 보기</a></li>
	<li><a href="emp.do">사원 관리 프로그램 (마지막버전 MyBatis)</a></li>
	<li><a href="fileDownList.do">파일 다운로드 페이지</a></li>
	<li><a href="fileUploadForm.do">파일업로드 테스트</a></li>
	<li><a href="hello.do">스프링 MVC 적용결과</a></li>
	<li><a href="memoWrite.do">간단 메모 작성하기</a></li>
	<li><a href="gameAdd.do">게임 상품 등록페이지</a></li>
	<li><a href="paramTest.do?idx=3&str=">파라미터 테스트</a></li>
	<li><a href="cookieView.do">쿠키,세션 확인하기</a></li>
	<li><a href="cookieMake.do">쿠키 정보 저장하기</a></li>
	<li><a href="sessionMake.do">세션 저장하기</a></li>
	<li><a href="sessionView.do">세션 값 확인하기</a></li>
	<li><a href="viewTest.do">명시적 뷰 지정</a></li>
	<li><a href="viewTest/viewTest.do">묵시적 뷰 지정</a></li>
	<li><a href="viewTest2.do">또 다른 명령어 호출하기</a></li>
	<li><a href="modelTest01.do">모델 테스트1(Map)</a></li>
	<li><a href="modelTest02.do">모델 테스트2(Model)</a></li>
	<li><a href="modelTest03.do">모델 테스트3(ModelMap)</a></li>
	<li><a href="model/modelTest.do">모델 테스트4(Return)</a></li>
	<li><a href="modelTest05.do">모델 테스트5(ModelAndView)</a></li>
	<li><a href="food/foodFind1.do">식료품 검색</a></li>
</ul>

</body>
</html>