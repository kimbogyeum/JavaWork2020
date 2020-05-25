<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
    
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" >
<title>JSTL Core3</title>
</head>

<style>
table, th, tr{
	border: 1px solid black;
	border-collapse: collapse;
}
</style>


<body>

<h2>if</h2>
<!-- 스크립트릿만 사용하는 경우 1 -->
	<% if(1 + 2 ==3){ %>
		1 + 2 = 3<br>
	<%} %>
<!-- 스크립트릿만 사용하는 경우 2 -->
	<%
		if(1+2==3){
			out.println("1 + 2 = 3<br>");
		}
	%>

<!-- JSTL 사용 -->
	<c:if test="${1 + 2 ==3 }"> <%--EL 식 사용 --%>
		1 + 2 = 3: EL 식 사용가능  <br>
	</c:if>
	
	<c:if test="true">
		true <br>
	</c:if>
	
	<c:if test="<%= 1 + 2 == 3 %>"><%--표현식 사용 --%>
		1 + 2 = 3: JSP 식 사용가능  <br>
	</c:if>
	
	<c:if test="${1 + 2 !=3 }">
		1 + 2 != 3 <br>
	</c:if>
	
<hr>

<%--JSTL 에선 c:else는 따로 없다. 대신 choose,when 을 조합하여 사용 --%>
<h2>choose, when, otherwise</h2>

		<%--스크립트릿만 사용하는 경우 1 --%>
			<%
				switch(10%2){
				case 0:
			%>		
				짝수입니다. <br>
			<%
					break;
				case 1:
			%>	
					
				홀수입니다  <br>
			<%
					break;
				default:
			%>	
				이도 저도 아닙니다. <br>		
					
			<%	}	%>

		<%--JSTL 사용하는 경우 --%>
		<c:choose>
			<c:when test="${10%2==0 }">
				짝수입니다 <br>
			</c:when>	
			<c:when test="${10%2==1 }">
				홀수입니다.<br>
			</c:when>
			<c:otherwise>
				이도저도 아닙니다.<br>
			</c:otherwise>
		
		</c:choose>

	
<hr>
<h2>forEach</h2>

		<!-- 스크립트릿만 사용하는 경우 -->
		<%
			for(int i=0;i<=30;i+=3){
		%>
				<span><%=i %></span>
		<%
			}
		%>
		
		
<br>		
		<!-- JSTL을 사용하는 경우 -->
		<c:forEach var="i" begin="0" end="30" step="3">
			<span>${i }</span>
		</c:forEach>
<br><br>	
		<!-- 구구단 3단 출력하기 -->
		<c:forEach var="i" begin="1" end="9">
			<li>3*${i}=${i *3}</li><br>
		
		</c:forEach>

		<br><br>
		<c:set var="intArray" value="<%=new int[]{1,2,3,4,5} %>"/>
			<c:forEach var="element" items="${intArray }">
				${element },
			</c:forEach>
			<br>
			
			
			<!-- intArray 배열 인덱스 2~4번째 값 출력 -->
			<c:forEach var="element" items="${intArray }" begin="2" end="4">
				${element },
			</c:forEach>
			<br>
			
			
			
			<!-- intArray 배열 인덱스 2~4번째 loop 정보가 status 변수에 담김. -->
			<c:forEach var="element" items="${intArray }" begin="2" end="4" varStatus="status">
				${status.count }:intArray [${status.index }] = ${element }<br>
			</c:forEach>
			<br>
			
			
			<!--복수개의 배열/ collection도 다를 수 있다.
				하나의 forEach 구문으로 두개의 배열 뽑기 varState 사용해서.-->
				
			<%
				List<String> myList=new ArrayList<String>();
				myList.add("월");
				myList.add("화");
				myList.add("수");
				
			%>
			
			<c:set var="arr1" value='<%=new String[]{"SUN","MON","TUE"}%>'/>
			<c:set var="arr2" value='<%=new String[]{"월","화","수"}%>'/>
			<ul>
				<c:forEach var="element" items="${arr1 }" varStatus="status">
					<li>${status.index }: ${element } - ${arr2[status.index] }</li>
				</c:forEach>
			</ul>
			
<hr>	

<%
	HashMap<String, Object> hMap=new HashMap<String, Object>();
	hMap.put("name", "김보겸");
	hMap.put("age", "26");
	hMap.put("today", new Date());
%>		
	<c:set var="map1" value="<%=hMap %>"/>
	<table>
		<tr><th>key</th><th>value</th></tr>
		<c:forEach var="item" items="${map1 }">
			<tr>
			<td>${item.key }</td>
			<td>${item.value }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>