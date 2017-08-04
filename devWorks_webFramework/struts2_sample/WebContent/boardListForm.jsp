<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시판</title>
<script language="javascript">
function pagingFormSubmit(currentPage) {
	document.pagingForm.currentPage.value = currentPage;
	document.pagingForm.submit();
}
</script>

</head>
<body>
<center>
<h2>[ 게시판 ]</h2>

전체 : <s:property value="totalRecordsCount"/>
<br>
<table>
<tr>
	<th style="width:40px">번호</td>
	<th style="width:300px">제목</td>
	<th style="width:100px">작성자</td>
	<th style="width:100px">등록일</td>
	<th style="width:60px">조회수</td>
</tr>

<!-- 반복 시작 -->
<s:iterator value="boardlist" status="stat">
	<tr align="center">
		<td><s:property value="pagenavi.totalRecordsCount -  pagenavi.startRecord - #stat.index"/></td>
		<td>
			<s:a href="boardRead.action?board.boardnum=%{boardlist[#stat.index].boardnum}&board.viewcount=%{boardlist[#stat.index].viewcount}&currentPage=%{currentPage}">
				<s:property value="boardlist[#stat.index].title"/>
			</s:a>
		</td>
		<td><s:property value="boardlist[#stat.index].id"/></td>
		<td><s:property value="boardlist[#stat.index].inputdate"/></td>
		<td><s:property value="boardlist[#stat.index].viewcount"/></td>
	</tr>
</s:iterator>
<!-- 반복 끝 -->

</table>
<br/>
<input type="button" value="글쓰기" onClick="location.href='goBoardWriteForm.action'"/>
<input type="button" value="홈화면" onClick="location.href='/strutstest3/member/login.action?session.id=${session.id}'"/>
<br/><br/>
<!-- 페이지 이동 부분 -->  
<form id="boardList_action" name="pagingForm" action="boardList.action" method="post">                    
	<a href="javascript:pagingFormSubmit(<s:property value="pagenavi.startPageGroup - 1"/>)">◁◁ </a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(<s:property value="pagenavi.currentPage - 1"/>)">◀</a> &nbsp;&nbsp;
	 
	 <s:iterator begin="pagenavi.startPageGroup" end="pagenavi.endPageGroup" var="counter">
		<s:if test="#counter == pagenavi.currentPage"><b></s:if>	
			<a href="javascript:pagingFormSubmit(<s:property value="#counter"/>)"><s:property value="#counter"/></a>&nbsp;
		<s:if test="#counter == pagenavi.currentPage"></b></s:if>
	</s:iterator>
	&nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(<s:property value="pagenavi.currentPage + 1"/>)">▶</a> &nbsp;&nbsp;
	<a href="javascript:pagingFormSubmit(<s:property value="pagenavi.endPageGroup + 1"/>)">▷▷</a>

<!-- /페이지 이동 끝 -->     

<!-- 검색폼 -->
<br><br>
	<input type="hidden" name="currentPage" value="1" id="boardList_action_currentPage"/>
	제목 : <input type="text" name="searchText"  id="boardList_action_searchText"/>
	<a href="javascript:pagingFormSubmit(1)">검색</a>
</form>
</body>
</html>