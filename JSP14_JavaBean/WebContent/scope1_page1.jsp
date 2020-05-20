<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
<jsp:setProperty property="count" name="cnt"/>
<%-- cnt.setCount(Integer.parseInt(request.getParameter("count")))--%>


<h3>page1<br>cnt의 getCount 호출</h3>
<jsp:getProperty property="count" name="cnt"/><br>
<%-- cnt.getCount()--%>

<a href="scope1_page2.jsp">page2로....</a>