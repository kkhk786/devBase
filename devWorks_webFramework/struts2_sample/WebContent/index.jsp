<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>게시판</title>
</head>
<body>
<h1>[ strutstest3 ]</h1>
<ul>
<s:if test="id == null">
	<li><a href="/strutstest3/member/goMemberJoinForm.action">회원 가입</a>
	<li><a href="/strutstest3/member/goLoginForm.action">로그인</a>
	<br><br>
	<li><a href="/strutstest3/board/boardList.action">게시판</a>
</s:if>
<s:else>
	<li><a href="/strutstest3/member/updateMemberForm.action?id=${id}">회원정보수정</a>
	<li><a href="/strutstest3/member/logout.action">로그아웃</a>
	<br><br>
	<li><a href="/strutstest3/board/boardList.action">게시판</a>
</s:else>
</ul>
</body>
</html>