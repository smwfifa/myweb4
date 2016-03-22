<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!result}">	
		<script>
			window.alert('${userid}는 사용 가능한 아이디입니다.');
			opener.join.id.value='${userid}';
			window.close();
		</script>
	</c:when>
	<c:otherwise>
	<script>
		window.alert('이미 등록되어있는 아이디입니다.');
		location.href='idCheckForm.do';
	</script>
	
	</c:otherwise>
</c:choose>