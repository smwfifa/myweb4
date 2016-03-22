<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript">
function idcheckOpen(){
	window.open('idCheckForm.do', 'idcheck', 'width=450, height=180'	);
}

function show(){
	var userid=document.join.id.value;
	var params='userid='+userid;							
	sendRequest('idCheck.do', params, showResult, 'GET');
}

function showResult(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var msg=XHR.responseText;
			var spanTag=document.getElementById('idmsg');
			spanTag.innerHTML=msg;
			window.alert(msg);
		}
	}
}

</script>
</head>
<body>
<h2>회원가입폼</h2>
<form name="join" action="join.do" method="post">
아이디 : <input type="text" name="id">
<input type="button" value="중복검사" onclick="show()">
<span id="idmsg"></span>
<br>
이름 : <input type="text" name="name"><br>
비밀번호 : <input type="password" name="pwd"><br>
이메일 : <input type="text" name="email"><br>
주소 : <input type="text" name="addr"><br>
<input type="submit" value="가입하기">
<input type="reset" value="다시작성">
</form>
</body>
</html>