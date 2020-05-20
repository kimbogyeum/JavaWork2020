<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="request"/>
 
<h3>request2<b>cnt의 getCount 호출</b></h3><br>

<jsp:getProperty property="count" name="cnt"/><br>

<a href="scope2_request1.jsp">request 1로..</a>