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

<% if(session.getAttribute("userid")!=0){ %>
	<h2>로그인상태</h2>
	<form action="logout.jsp">
		<input type="submit" value="로그아웃"><br>
	</form>

<% }else {%>
	<h2>로그아웃상태</h2>
	<form action="login.jsp">
		id: <input type="text" name="userid"><br>
		pw: <input type="password" name="pw"><br>
		<input type="submit" value="로그인"><br>
	</form>
<% } %>




</body>
</html>