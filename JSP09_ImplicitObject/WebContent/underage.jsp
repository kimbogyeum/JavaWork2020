<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>미성년자 페이지</title>
</head>
<body>
<%! int age; %>
<%
	String str=request.getParameter("age");
	age=Integer.parseInt(str);
%>
당신은 <%= age %>세 입니다.<br>
사이트를 이용하실 수 없습니다...<br>

<%=(19-age) %>년 뒤에 다시오거라.<br>
<a href="input_age.html"></a>

</body>
</html>