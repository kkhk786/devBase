<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
//가입폼 확인
function formCheck() {
	var id = document.getElementById('id');
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var name = document.getElementById('name');
	
	if (id.value.length < 3 || id.value.length > 10) {
		alert("ID는 3~10자로 입력하세요.");
		id.focus();
		id.select();
		return false;
	}
	if (pw.value.length < 3 || pw.value.length > 10) {
		alert("비밀번호는 3~10자로 입력하세요.");
		pw.focus();
		pw.select();
		return false;
	}
	if (pw.value != pw2.value) {
		alert("비밀번호를 정확하게 입력하세요.");
		pw.focus();
		pw.select();
		return false;
	}
	if (name.value == '') {
		alert("이름을 입력하세요.");
		name.focus();
		name.select();
		return false;
	}
	return true;
}

function idCheckOpen() {
	window.open("goIdCheckForm.action","newwin","top=200,left=400,width=400,height=300,resizable=no");
}

function zipcodeOpen() {
	window.open("goZipcodeForm.action","newwin","top=200,left=400,width=500,height=500,resizable=no,scrollbars=yes");
}
</script>

</head>
<body>
<h1>[ 회원 가입 ]</h1>
        
<form id="insertMember" name="joinform" onsubmit="return formCheck();" action="insertMember.action" method="post">

ID :
<input type="text" name="member.id" value="" readonly="readonly" id="id" onclick="javascript:idCheckOpen()"/>
<input type="button" value="ID중복확인" onclick="javascript:idCheckOpen()"><br>
비밀번호 :
<input type="password" name="member.password" id="password"/><br>
비밀번호 확인 :
<input type="password" name="" id="password2"/><br>
이름 :
<input type="text" name="member.name" value="" id="name"/><br>
우편번호 :
<input type="text" name="member.zipcode" value="" readonly="readonly" id="zipcode" onClick="javascript:zipcodeOpen()"/>
<input type="button" value="우편번호검색" onClick="javascript:zipcodeOpen()"><br>
주소 :
<input type="text" name="member.address1" value="" readonly="readonly" id="address1" onClick="javascript:zipcodeOpen()"/><br>
상세주소 :
<input type="text" name="member.address2" value="" id="insertMember_member_address2"/><br>
전화번호 :
<input type="text" name="member.phone" value="" id="insertMember_member_phone"/><br>
E-mail :
<input type="text" name="member.email" value="" id="insertMember_member_email"/><br>

<input type="submit" id="insertMember_0" value="가입"/>

<input type="reset" value="다시 쓰기"/>


</form>

</body>
</html>