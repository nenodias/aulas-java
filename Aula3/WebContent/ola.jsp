<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOL</title>
</head>
<body>
<%
String saudacao = "";
String data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
if(data.startsWith("02")){
	out.println("Feliz Dia Normal");
}else{
	out.println("Feliz dia em outra dimensão");
}
%>
A data atual é <%=data %><br /> <%=request.getQueryString()%>
</body>
</html>