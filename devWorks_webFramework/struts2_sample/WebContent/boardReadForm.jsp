<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>글읽기</title>
<link rel="stylesheet" href="../css/boardStyle.css" />
	
<script type="text/javascript">
//글삭제시 확인 스크립트
function deleteCheck(boardnum, currentPage){
	if(confirm("정말 삭제하시겠습니까?")){
		document.location.href = '/strutstest3/board/boardDelete.action?boardnum=' + boardnum + '&currentPage=' + currentPage;
	}
}

//리플 쓰기 폼 체크
function formCheck() {
	var retext = document.getElementById('retext');
	if (retext.value.length < 1) {
		alert('리플 내용을 입력하세요.');
		retext.focus();
		retext.select();
		return false;
	}
	return true;			
}

//리플 수정
function replyEditForm(replynum, boardnum, retext) {
	var div = document.getElementById("div"+replynum);
	
	var str = '<form name="editForm' + replynum + '" action="/strutstest3/board/replyEdit.action" method="post">';
	str += '<input type="hidden" name="reply.replynum" value="'+replynum+'">';
	str += '<input type="hidden" name="reply.boardnum" value="'+boardnum+'">';
	str += '&nbsp;';
	str += '<input type="text" name="reply.retext" value="' + retext + '" size="80">';
	str += '&nbsp;';
	str += '<a href="javascript:replyEdit(document.editForm' + replynum + ')">[저장]</a>';
	str += '&nbsp;';
	str += '<a href="javascript:replyEditCancle(document.getElementById(\'div' + replynum + '\'))">[취소]</a>';
	str += '</form>';
	div.innerHTML = str;
}

//리플 수정 취소
function replyEditCancle(div) {
	div.innerHTML = '';
}

//리플 수정 정보 저장
function replyEdit(form) {
	if (confirm('수정된 내용을 저장하시겠습니까?')) {
		form.submit();
	}
}

//리플 삭제
function replyDelete(replynum, boardnum) {
	if (confirm('리플을 삭제하시겠습니까?')) {
		location.href='/strutstest3/board/replyDelete.action?replynum=' + replynum + '&boardnum=' + boardnum;
	}
}
</script>

</head>
<body>
<center>

<h2>[ 게시판 글읽기 ]</h2>

<table border="0" cellspacing="3" cellpadding="3" align="center" width="700">
	<tr>
		<th style="width:100px;">작성자 </th>
		<td style="width:600px;">${board.id }</td>
	</tr>
	<tr>
		<th>작성일 </th>
		<td>${board.inputdate }</td>
	</tr>
	<tr>
		<th>조회수 </th>
		<td>${board.viewcount }</td>
	</tr>
	<tr>
		<th>제목 </th>
		<td>${board.title }</td>
	</tr>
	<tr>
		<th>내용 </th> 
		<td><pre>${board.content }</pre></td>
	</tr>
	<tr>
		<th>파일첨부 </th>
			<td>
				<s:iterator value="filelist" status="stat">
					<s:a href="fileDownload.action?boardnum=%{board.boardnum}&file.savedfile=%{filelist[#stat.index].savedfile}"><s:property value="%{filelist[#stat.index].originalfile}"/></s:a>
					<br>
				</s:iterator>
			</td> 
	</tr>
</table>

<!-- 본인 글인 경우에만 보이기 -->
<s:if test="session.id == board.id">
	<a href="javascript:deleteCheck('${board.boardnum}', '${currentPage }')">삭제</a>
	<a href="<s:url value="/board/goBoardEditForm.action?boardnum="/>${board.boardnum}">수정</a>
</s:if>

<!-- 목록보기-->
<a href="/strutstest3/board/boardList.action?currentPage=${currentPage }">목록보기</a>

<br><br>

<!-- 리플 작성 폼 시작 -->
<form id="replyWrite" name="replyform" action="replyWrite.action" method="post" onSubmit="return formCheck();">
	<input type="hidden" name="reply.boardnum" value="${board.boardnum }" id="replyWrite_reply_boardnum"/>
	<input type="text" name="reply.retext" value="" id="retext" style="width:500px;"/>
	<input type="submit" id="replyWrite_0" value="확인"/>

</form>

<!-- /리플 작성 폼 끝 -->

<!-- 리플 목록 출력 시작 -->
<table border=0 cellspacing=5 cellpadding=5>
<s:iterator value="replylist">
	<tr>
		<th class="reply">
			<b><s:property value="id" /></b>
		</th>
		<td class="reply" style="width:400px;">
			<s:property value="retext" />
		</td>
		<td class="reply">
			<s:if test="session.id == id">
				[<a href="javascript:replyEditForm('${replynum}', '${boardnum}', '${reply.retext}')">수정</a>]
			</s:if> 
		</td>
		<td class="reply">
			<s:if test="session.id == id">
				[<a href="javascript:replyDelete('${replynum}', '${boardnum }')">삭제</a>]
			</s:if> 
		</td>
	</tr>	
	<tr>
	<td  class="reply" colspan="4"><div id="div${replynum}"></div></td>
	</tr>
		 
</s:iterator>
</table>
<!-- /리플 목록 출력 끝 -->

<br><br><br>
</center>

</body>
</html>