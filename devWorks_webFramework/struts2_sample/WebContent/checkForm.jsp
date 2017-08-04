<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript">
//검색어 입력 여부 확인
function formCheck() {
	var searchText = document.getElementById('searchText');
	if (searchText.value == '') {
		alert('검색할 ID를 입력하세요.');
		searchText.focus();
		return false;
	}
	return true;
}

//ID 사용
function selectId(id) {
	opener.joinform.id.value = id;
	this.close();
}
</script>
</head>
<body>
<h2>[ ID 중복 확인 ]</h2>

<form id="idCheck" name="idform" action="idCheck.action" method="post" onSubmit="return formCheck();">

ID : <input type="text" name="searchText" value="${searchText}" id="searchText"/>
	<input type="submit" id="idCheck_0" value="검색"/>

</form>

<s:if test="idCheck != null">
	<s:if test="idCheck">
		사용 가능한 아이디 입니다.<br>
		<input type="button" value="ID 사용하기" onClick="selectId('${searchText}')">
	</s:if>
	<s:else>
		이미 사용중인 아이디입니다.
	</s:else>
</s:if>
</body>
</html>





