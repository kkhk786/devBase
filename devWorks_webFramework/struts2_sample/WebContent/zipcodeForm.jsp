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
		alert('검색어를 입력하세요.');
		return false;
	}
	return true;
}

//ID 사용
function selectZipcode(zipcode, address) {
	opener.joinform.zipcode.value = zipcode;
	opener.joinform.address1.value = address;
	this.close();
}
</script>

</head>
<body>
<h2>[ 우편번호 검색 ]</h2>

<form id="zipcode" name="zipcodeform" action="/strutstest3/member/zipcode.action" method="post" onSubmit="return formCheck();">

주소 : <input type="text" name="searchText" value="" id="zipcode_searchText"/>
	 <input type="submit" id="zipcode_0" value="검색"/>

</form>

<s:if test="zipcodeList.size() != 0">
	<s:iterator value="zipcodeList" status="stat">
		<table>
			<tr>
				<s:a href="javascript:selectZipcode('%{zipcodeList[#stat.index].zipcode}', '%{zipcodeList[#stat.index].area1} %{zipcodeList[#stat.index].area2}');">
				<td><s:property value="%{zipcodeList[#stat.index].zipcode}"/></td>
				<td><s:property value="%{zipcodeList[#stat.index].area1}"/></td>
				<td><s:property value="%{zipcodeList[#stat.index].area2}"/></td>
				<td><s:property value="%{zipcodeList[#stat.index].area3}"/></td>
				<td><s:property value="%{zipcodeList[#stat.index].area4}"/></td></s:a>
			</tr>
			
		</table>
	</s:iterator>
</s:if>

</body>
</html>