<%@page import="com.Entities.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	User user = (User)session.getAttribute("user");
	if(user==null){
		session.setAttribute("login-msg", "Please Login First");
		response.sendRedirect("Login.jsp");
	}
%>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="All-Header-links.jsp" %>
</head>
<body style="background-image: linear-gradient(to right top, #b4cd5a, #c1c647, #cebd34, #dcb422, #eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
<%@ include file="Navbar.jsp" %>
	
	<div class="container">
	<div class="row d-flex justify-content-center align-items-center">
	<div class="col-md-6">
	<div class="card">
	<%
		User user1 = (User)session.getAttribute("user");
		if(user!=null){
	%>
	<div class="card-body">
	<h1>Name: <%=user1.getName() %></h1>
	<h1>Email: <%=user1.getEmail()%> </h1>
	<div class="container text-center"><a class="btn btn-danger" href="LogoutServlet">Logout</button></a></div>
	
	<%}
	%>
	
	</div>
	</div>
	</div>
	</div>
	
	</div>
</body>
</html>