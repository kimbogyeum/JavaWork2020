<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:choose>
	<c:when test="${list==0 }">
	
		<script>
			alert('수정 실패');
			history.back();
		</script>
		
	</c:when>
	
	<c:otherwise>
		
		<script>
			alert('수정 성공');
			location.href = "view.do?uid=${uid}";//multipart request이므로 그냥 uid로 updateCommand 고치고 바꿔줘야한다.
		</script>
	</c:otherwise>

</c:choose>
