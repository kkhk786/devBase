<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>memberJoinForm.jsp</title>

<script language="javascript">
//수정폼 확인
function formCheck() {
	var pw = document.getElementById('password');
	var pw2 = document.getElementById('password2');
	var name = document.getElementById('name');
	
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

function zipcodeOpen() {
	window.open("goZipcodeForm.action","newwin","top=200,left=400,width=500,height=500,resizable=no,scrollbars=yes");
}
</script>
</head>

<body>

<h1>[ 회원 정보 수정 ]</h1>

        
<form id="updateMember" name="joinform" onsubmit="return formCheck();" action="/strutstest3/member/updateMember.action" method="post">
<input type="hidden" name="member.id" value="${member.id }">
ID : ${id}<br>
비밀번호 :
<input type="password" name="member.password" id="password"/><br>
비밀번호 확인 :
<input type="password" name="" id="password2"/><br>
이름 :
<input type="text" name="member.name" value="${member.name }" id="name"/><br>
우편번호 :
<input type="text" name="member.zipcode" value="${member.zipcode }" readonly="readonly" id="zipcode" onClick="javascript:zipcodeOpen()"/>
<input type="button" value="우편번호검색" onClick="javascript:zipcodeOpen()"><br>
주소 :
<input type="text" name="member.address1" value="${member.address1 }" readonly="readonly" id="address1" onClick="javascript:zipcodeOpen()"/><br>
상세주소 :
<input type="text" name="member.address2" value="${member.address2 }" id="updateMember_member_address2"/><br>
전화번호 :
<input type="text" name="member.phone" value="${member.phone }" id="updateMember_member_phone"/><br>
E-mail :
<input type="text" name="member.email" value="${member.email }" id="updateMember_member_email"/><br>

<input type="submit" id="updateMember_0" value="수정"/>

<input type="reset" value="다시 쓰기"/>


</form>




</body>
</html>