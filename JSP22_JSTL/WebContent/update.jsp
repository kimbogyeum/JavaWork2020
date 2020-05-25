<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<c:choose>
	<c:when test="${empty list ||fn:length(list)==0}">
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>		
	</c:when>
	<c:otherwise>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>수정${list[0].subject}></title>
</head>
<script>
function chkSubmit(){
	frm=document.forms['frm'];
	var subject=frm['subject'].value.trim();
	
	if(subject==""){
		alert("제목을 반드시 입력하셔야 해요");
		frm['subject'].focus();
		return false;
	}
	return true;
}
</script>


<body>
<h2>수정${list[0].subject}</h2>
<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
<%--post로 보낼때는 form같은 형태로 보내야 하고 uid는 수정할거 아니니까! hidden 쓰기 --%>
<input type="hidden" name="uid" value="${list[0].uid}"/> 
작성자 : ${list[0].name}<br><%--작성자 이름 변경불가 --%>
제목 : 
<input type="text" name="subject" value="${list[0].subject}"/><br>
내용: <br>
<textarea name="content">${list[0].content}</textarea>
<br>
<input type="submit" value="수정"/>

</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>
	</c:otherwise>
	</c:choose>
