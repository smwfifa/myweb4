<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="httpRequest.js"></script>
<script type="text/javascript">
function show(){
	sendRequest('ajaxList.do', null, showResult, 'GET');
}

function showResult(){
	if(XHR.readyState==4){
		if(XHR.status==200){
			var empStr=XHR.responseText;
			var empDTOs=eval('('+empStr+')');
			var msg='검색된 사원정보수: '+empDTOs.emp.length+'명\n';
			
			
			for(var i=0;i<empDTOs.emp.length;i++){
				var emp=empDTOs.emp[i];
				msg+='사원이름: '+emp.name+'('+emp.email+')/부서='+emp.dept+'\n';
				
			}
			
			window.alert(msg);
		}
	}
	
}
</script>
</head>
<body>
<input type="button" value="사원 정보 보기" onclick="show()">
</body>
</html>