<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.james.jsp.CircleCalc"%>
<<jsp:useBean id="getArea1" class="com.james.jsp.CircleCalc" scope="request"></jsp:useBean>
<<jsp:useBean id="getArea2" class="com.james.jsp.CircleCalc" scope="application"/>
<<jsp:useBean id="getArea3" class="com.james.jsp.CircleCalc" scope="session"/>
<<jsp:useBean id="getArea4" class="com.james.jsp.CircleCalc" scope="page"/>
<html>
<head>
<title>JavaBean在JSP中的应用</title>
</head>
<body>

	<%
		getArea1.setR(1.3);
		getArea1.setUnit("米");
		out.println(getArea1.getArea());
		out.println("scope='request'"+"<br/>");
		getArea2.setR(3.4);
		getArea2.setUnit("厘米");
		out.println(getArea2.getArea());
		out.println("scope='application'"+"<br/>");
		getArea3.setR(0.9);
		getArea3.setUnit("米");
		out.println(getArea3.getArea());
		out.println("scope='session'"+"<br/>");
		getArea4.setR(9);
		getArea4.setUnit("米");
		out.println(getArea4.getArea());
		out.println("scope='page'"+"<br/>");
	%>
</body>
</html>