<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>게시판 글 수정</title>

<script language="javascript">
//글쓰기폼 확인
function formCheck() {
	var title = document.getElementById('title');
	var content = document.getElementById('content');
	
	if (title.value.length < 1) {
		alert("제목을 입력하세요.");
		title.focus();
		title.select();
		return false;
	}
	if (content.value.length < 1) {
		alert("내용을 입력하세요.");
		title.focus();
		title.select();
		return false;
	}
	return true;
}
</script>	
</head>
<body>

<s:form name="writeform" action="boardEdit.action"  method="post" 
	enctype="multipart/form-data" onsubmit="return formCheck();" theme="simple">
	<s:hidden name="board.boardnum"></s:hidden>	
	
<table border=0 cellpadding=3>
<tr>
	<td colspan=2 align=center><h2>[ 글수정 ]</h2></td>
</tr>
<tr>
	<td>제목</td>
	<td>
		<s:textfield name="board.title" id="title" cssStyle="width:400px;" />
	</td>
</tr>
<tr>
	<td>내용</td> 
	<td>
		<s:textarea name="board.content" id="content" cssStyle="width:400px;height:200px;resize:none;"></s:textarea>
	</td>
</tr>
<tr>
	<td>파일첨부</td> 
		<td>
		<s:if test="filelist.size() != 0">
			<s:iterator value="filelist" status="stat">
				<s:file value="File(#stat.index+1)" name="upload" size="30" />
				<s:property value="%{filelist[#stat.index].originalfile}"/>
				<br>
			</s:iterator>
		</s:if>
		<s:else>
			<s:iterator begin="1" end="3" status="stat">
			<s:file value="File(#stat.index+1)" name="upload" size="30" /><br>
		</s:iterator>
		</s:else>
		</td>
</tr>
<tr>
	<td colspan="2" align=center>
		<s:submit value="수정" />
	</td> 
</tr>
</table>
</s:form>

</body>
</html>
