<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
 
<h3>page2<b>cnt의 getCount 호출</b><br></h3>

<jsp:getProperty property="count" name="cnt"/><br>

<a href="scope1_page1.jsp">page 1로..</a>