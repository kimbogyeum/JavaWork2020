<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>JSTL Core 2</title>
</head>
<body>

<h2>set, remove, out</h2>
<c:set var="name" value="보겸이"/>
이름:<c:out value="김"/><br>
이름:<c:out value="${name} "/><br>
${name }<br> <%--JSTL 변수는 EL 에서 사용가능 --%>

<c:remove var="name"/>
이름:<c:out value="${name} "/><br>


<%
	int age=10;
%>
<hr>
나이: ${age }<br> <%--Java → EL (불가) --%>
<c:set var="age" value="<%= age %>"/>
나이: ${age }<br> <%--요건가능하지 --%>

<hr>
<h2>catch</h2>
<c:catch var="error">
<!-- 이 안에서 예외 발생하면 예외 객체를 error 변수에 담는다.-->
	<%= 2 / 0 %>
</c:catch>
<br>
<c:out value="${error }"/>
<br>

<c:catch var="ex">
name parameter 값:<%= request.getParameter("name") %><br>
<% if(request.getParameter("name").equals("test")){ //예외발생 %>
	${param.name }은 test입니다.
<%} %>
</c:catch>

<c:if test="${ex !=null}">
	예외발생 <br>
	${ex }<br>
</c:if>







</body>
</html>