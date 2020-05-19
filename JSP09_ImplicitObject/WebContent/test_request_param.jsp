<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>request parameter</title>
</head>
<body>
<%
	String data1, data2;
	String name, id, pw, gender, local, memo;
	String [] hobbys;

%>
<%
	request.setCharacterEncoding("utf-8");

	data1=request.getParameter("data1");
	data2=request.getParameter("data2");
	name=request.getParameter("name");
	gender=request.getParameter("gender");
	local=request.getParameter("local");
	memo=request.getParameter("memo");
	hobbys=request.getParameterValues("hobby");
	
	
%>

hidden: <%= data1 %>, <%=data2 %><br>
이름: <%= name %><br>
성: <%= gender %><br>
지역: <%= local %><br>
메모: <%= memo %><br>
취미: <%= Arrays.toString(hobbys) %><br>

</body>
</html>