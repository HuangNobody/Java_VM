<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import = "java.lang.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "cn.chapter9.*" %>
<%
	InputStream is = new FileInputStream("c:/TestClass.class");
	byte [] b = new byte[is.available()];
	is.read(b);
	is.close();
	
	out.println("<textarea style = 'width:1000;height=800'>");
	out.println(JavaClassExecutor.execute(b));
	out.println("</textarea>")
 %>

</body>
</html>