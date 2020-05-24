<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% //DAO 사용한 트랜잭션
	int cnt=(Integer)request.getAttribute("result");
	int uid = Integer.parseInt(request.getParameter("uid"));
%>


<% if(cnt == 0){ %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('수정 성공');
		location.href = "view.do?uid=<%= uid%>";
	</script>
<% } %>
















