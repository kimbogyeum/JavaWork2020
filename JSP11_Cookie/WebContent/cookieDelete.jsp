<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Cookie[] cookies=request.getCookies();
	String cookieName="num1";
	
	if(cookies !=null){
		for(int i=0; i<cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){
				//서버가 삭제하는게 아니라 쿠키가 있는 클라이언트에게 시켜야해
				cookies[i].setMaxAge(0); //expiry를 0으로 하고, 클라이언트에 도착하자마자 브라우저가 바로 죽인다.
				response.addCookie(cookies[i]); //response 직후 곧바로 삭제됨. 
			}
		}
	}


%>

<script>
alert("<%= cookieName%> 쿠키삭제");
location.href="cookieList.jsp";
</script>