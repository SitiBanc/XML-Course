<%@ page language="java" contentType="text/html;charset=Big5" %>
<html>
<head>
<title>Greetings</title>
</head>

<body>
<% String s =    new String(request.getParameter("data").getBytes("ISO-8859-1"), "Big5");%>

<h1>Hello <%=s%>~~~</h1>

<%   
       out.println("<h1>�ոլ� out ����</h1>");
       //  �i�H�[�W 
	   System.out.println("Standard Output");
%>
</body>
</html>
