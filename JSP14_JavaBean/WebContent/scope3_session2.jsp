<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>
 
<h3>session2<b>cnt의 getCount 호출</b></h3><br>

<jsp:getProperty property="count" name="cnt"/><br>

<a href="scope3_session1.jsp">session 1로..</a>