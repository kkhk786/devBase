<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
function formCheck() {
	var id = document.getElementById('id');
	var password = document.getElementById('password');
	
	if (id.value == '' || password.value == '') {
		alert('ID와 비밀번호를 입력하세요.');
		return false;
	}
	return true;
}
</script>

</head>
<body>
<h2>[ 로그인 ]</h2>

<form id="login" name="loginForm" action="/strutstest3/member/login.action" method="post" onSubmit="return formCheck();">
ID : <input type="text" name="id" value="" id="id"/><br>
Password : <input type="password" name="password" id="password"/>
<input type="submit" id="login_0" value="Login"/>


</form>

</body>
</html>