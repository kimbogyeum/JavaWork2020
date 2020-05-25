<%@page import="com.sun.org.apache.bcel.internal.generic.NEW"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.WriteDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>EL request</title>
</head>
<body>
<%
	request.setAttribute("myage", 30);
	request.setAttribute("mydto", new WriteDTO(100,"제목","내용","작성자",3));
	pageContext.setAttribute("myage", "흥~!");
%>

${myage }<br>
${requestScope.myage }<br>
<%--scope 가 request-page-session-application의 우선순위로 인해 흥~!이 먼저 나옴 --%>

<%--toString() 값 --%>
${mydto}<br>
${mydto.uid }<br>
<%--원래 쓰던 방법--%>
<%= ((WriteDTO)request.getAttribute("mydto")).getUid() %><br>
${mydto.subject }<br>
${mydto.content }<br>

</body>
</html>