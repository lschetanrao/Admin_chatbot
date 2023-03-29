<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="admin.*" %>
<% 
String question=request.getParameter("question");
String answer=request.getParameter("answer");
Main_admin ad=new Main_admin();
ad.setQuestion(question);
ad.setAnswer(answer);
out.print(ad.getQuestion());
out.print(answer);
//ad.call_qa();  //check this line
//ad.aaa();
//response.sendRedirect("index.html");
//out.print(ad.getAnswer());
out.flush();

%> 


</body>
</html>