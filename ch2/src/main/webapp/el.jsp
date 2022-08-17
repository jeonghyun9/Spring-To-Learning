<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.fastcampus.ch2.*" %>
<%
	Person person = new Person();
	request.setAttribute("person", person);
	request.setAttribute("name", "남궁성");   
	request.setAttribute("list", new java.util.ArrayList());	
%>
<html>  
<head>   
	<title>EL</title>   
</head>  
<body>   
person.getCar().getColor()=<%=person.getCar().getColor()%> <br>
<!-- person.getCar().getColor()=red -->
person.getCar().getColor()=${person.getCar().getColor()} <br>
<!-- person.getCar().getColor()=red -->
person.getCar().getColor()=${person.car.color} <br>
<!-- person.car.color=red -->    
name=<%=request.getAttribute("name")%> <br> 
<!-- name=유정현 -->  
name=${requestScope.name} <br>
<!-- name=유정현 -->
name=${name} <br>
<!-- name=유정현 -->
id=<%=request.getParameter("id")%> <br>
<!-- id=null -->
<!--id=${pageContext.request.getParameter("id")} --><br>
<!-- id= -->	<!-- EL은 null을 출력하지 않음 -->
id=${param.id} <br>
<!-- id= -->	<!-- EL은 null을 출력하지 않음 -->
"1"+1 = ${"1"+1.5} <br>
<!-- "1"+1 = 2 -->	<!-- EL에서는 문자열"1" 과 숫자가 연산되면 숫자가 됨 -->
"1"+="1" = ${"1"+="1"} <br>
<!-- "1"+="1" = 11 -->
"2">1 = ${"2">1} <br>   
<!-- "2">1 = true -->
null = ${null}<br>
<!-- null = -->		<!-- EL은 null을 출력하지 않음 -->
null+1 = ${null+1} <br>
<!-- null+1 = 1 -->		<!-- 단, 계산할때는 0으로 나온다. -->
null+null = ${null+null} <br>
<!-- null+null = 0 -->	<!-- 단, 계산할때는 0으로 나온다. -->
"" + null = ${""+null} <br>  
<!-- "" + null = 0 --> 	<!-- 단, 계산할때는 0으로 나온다. -->
""-1 = ${""-1} <br> 
<!-- ""-1 = -1 -->
empty null=${empty null} <br>
<!-- empty null=true -->
empty list=${empty list} <br>
<!-- empty list=true -->
null==0 = ${null==0} <br>
<!-- null==0 = false -->
null eq 0 = ${null eq 0} <br>
<!-- null eq 0 = false -->
name == "유정현"=${name=="유정현"} <br>
<!-- name == "유정현"=true -->
name != "유정현"=${name!="유정현"} <br>
<!-- name == "유정현"=false -->
name eq "유정현"=${name eq "유정현"} <br> <!-- equal -->
<!-- name == "유정현"=true -->  
name ne "유정현"=${name ne "유정현"} <br> <!-- not equal -->
<!-- name == "유정현"=false -->  
name.equals("유정현")=${name.equals("유정현")} <br> 
<!-- name == "유정현"=true -->  
</body>
</html>
