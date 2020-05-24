<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="person1" class="com.lec.beans.Person" scope="page"/>

<%--
내부적인 동작
	Person person1=new com.lec.beans.Person(); //기본생성자 호출 
	request.setAttribute("person1",person1); //좀더 정확히는 이코드도 수행 
	
 --%>
 
	<%--기본생성자 생성 후 useBean 안에서 setProperty 사용--%>
	 <jsp:useBean id="person2" class="com.lec.beans.Person" scope="page">
	 	<jsp:setProperty name="person2" property="name" value="명기범"/>
	 	<jsp:setProperty name="person2" property="age" value="26"/>
	 	<jsp:setProperty name="person2" property="id" value="99887"/>
	 	<jsp:setProperty name="person2" property="gender" value="남"/>
	 </jsp:useBean>
 
 	<%--form에서 넘어온 값을 bean 객체가 바로 받을 수 있다.
 		bean의 필드명(getter/setter 명)과 form의 name이 일치해야한다.--%>

 	<jsp:useBean id="person3" class="com.lec.beans.Person" scope="page">
	 	<jsp:setProperty name="person3" property="name"/>
	 	<jsp:setProperty name="person3" property="age"/>
	 	<jsp:setProperty name="person3" property="id"/>
	 	<jsp:setProperty name="person3" property="gender"/>
	</jsp:useBean>
 	<%-- person3.getGender(request.getParameter("gender"))--%>
 	
 	
 	<%--parameter를 일괄로 받아오기 --%>
 	<jsp:useBean id="person4" class="com.lec.beans.Person" scope="page">
 		<jsp:setProperty property="*" name="person4"/>
 	</jsp:useBean>
 	
 	
 	
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>자바빈</title>
</head>
<body>
	<jsp:setProperty property="name" name="person1" value="고길동"/>
	<jsp:setProperty property="age" name="person1" value="24"/>
	<jsp:setProperty property="id" name="person1" value="1515"/>
	<jsp:setProperty property="gender" name="person1" value="남"/>
	<%--
	내부적인 동작
		person1.setName("고길동");
	 --%>
	<h3>person1</h3>
	이름:<jsp:getProperty property="name" name="person1"/><br>
	나이:<jsp:getProperty property="age" name="person1"/><br>
	아이디:<jsp:getProperty property="id" name="person1"/><br>
	성별:<jsp:getProperty property="gender" name="person1"/><br>
	<%--
	내부적인 동작
		<%= person1.getName()%>
	 --%>
	 
	<h3>person2</h3>
	이름:<jsp:getProperty property="name" name="person2"/><br>
	나이:<jsp:getProperty property="age" name="person2"/><br>
	아이디:<jsp:getProperty property="id" name="person2"/><br>
	성별:<jsp:getProperty property="gender" name="person2"/><br>

	<h3>person3</h3>
	이름:<jsp:getProperty property="name" name="person3"/><br>
	나이:<jsp:getProperty property="age" name="person3"/><br>
	아이디:<jsp:getProperty property="id" name="person3"/><br>
	성별:<jsp:getProperty property="gender" name="person3"/><br>
	
	
	<h3>person4</h3>
	이름:<jsp:getProperty property="name" name="person4"/><br>
	나이:<jsp:getProperty property="age" name="person4"/><br>
	아이디:<jsp:getProperty property="id" name="person4"/><br>
	성별:<jsp:getProperty property="gender" name="person4"/><br>
	  
</body>
</html>