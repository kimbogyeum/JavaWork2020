<%@page import="java.util.Enumeration"%>
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
<%

	
	

	String sessionName,sessionValue;
	Enumeration enumeration=session.getAttributeNames();
	//Enumeration은 다꺼낼때 쓰는거다. 
	int i=0;
	while(enumeration.hasMoreElements()){
		sessionName=enumeration.nextElement().toString();
		sessionValue=session.getAttribute(sessionName).toString();
		out.println((i+1)+" ] "+sessionName+" : "+sessionValue+"<br>");
		i++;
	}
	if(i==0){
		out.println("세션이 없습니다. <br>");
	}

%>

<hr>

<form action="sessionCreate.jsp" method="get">
<input type="submit" value="세션생성">
</form>

<br>

<form action="sessionDelete.jsp" method="get">
<input type="submit" value="세션삭제">
</form>

<br>

<% 
	String sessionId=session.getId();
	int sessionInterval=session.getMaxInactiveInterval();
	
	out.println("세션 ID: "+ sessionId+"<br>");
	out.println("세션 유효시간: "+sessionInterval+"<br>");

%>
<%
	out.println("-----session.invalidate()");
	//세션무효화 invalidate
	//세션의 모든 attribute를 무효화.
	session.invalidate();

	
	sessionId = session.getId();
	sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션 ID: " + sessionId + "<br>");
	out.println("세션 유효시간: " + sessionInterval + "<br>");	
	// '새로고침 하면서'  어떻게 바뀌는지 보자
	
	if(request.isRequestedSessionIdValid()){
    	out.println("유효한 세션 있습니다...");    	
    }else{
    	out.println("유효한 세션이 없습니다...");
    }


%>


</body>
</html>