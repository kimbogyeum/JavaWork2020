<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>Insert title here</title>
</head>
<body>
<%! int age; %>
<%
	String str=request.getParameter("age");
	age=Integer.parseInt(str);
%>

당신은 <%= age %>세 입니다.<br>
성인이시군요....사이트를 이용하실 수 있습니다. <br>

<a href="input_age.html">처음으로</a>
</body>
</html>