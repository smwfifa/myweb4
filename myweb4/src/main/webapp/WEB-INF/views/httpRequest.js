var XHR=null;

function getXHR(){
	if(window.ActiveXObject){
		return new ActiveXObject('Msxml2.XMLHTTP');
		
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return null;
		
	}
}

function sendRequest(url, params, callback, method){
	XHR=getXHR();
	
	var httpMethod=method?method:'GET';
	if(httpMethod!='GET'&&httpMethod!='POST'){
		httpMethod='GET';
	}
	
	var httpParams=(params==null||params=='')?null:params;
	var httpUrl=url;
	
	if(httpMethod=='GET'&&httpParams!=null){
		httpUrl=httpUrl+'?'+httpParams;
		
	}
	
	XHR.onreadystatechange=callback;
	XHR.open(httpMethod, httpUrl, true);		//true는 비동기화 방식 제시
	XHR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');		//form enctype="" 자동완성 기능으로 application/x-www 복사가능
	XHR.send(httpMethod=='POST'?httpParams:null);
}