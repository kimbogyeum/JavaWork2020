<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>login 페이지</title>
</head>
<body>
<%!
	int i=0;
%>

<%
	Cookie[] cookies=request.getCookies(); //Cookie[]배열
	String cookieName="userid"; //로그인 성공하면 발급되는 쿠키 이름. 
	
	if(cookies!=null){
		for(i=0;i<cookies.length;i++){
			if(cookieName.equals(cookies[i].getName())){ //<--
				break;
			}
		}//end for
	}//end if
%>

<!-- 이렇게 각각 나눠주는 이유는 out.println쓰기 귀찮아서. Html로 쓰면 편하잖아 -->
	<% if(cookies ==null || i==cookies.length){ %>
		<h2>로그인 상태가 아니야.</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
	<% }else{ %>
		<h2>로그인 상태야.</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그아웃"><br>
		</form>
	<% } %>

</body>
</html>