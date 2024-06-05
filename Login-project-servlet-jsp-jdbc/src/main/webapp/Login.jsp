<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="All-Header-links.jsp" %>
</head>
<body style="background-image: linear-gradient(to right top, #b4cd5a, #c1c647, #cebd34, #dcb422, #eba912); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<%@ include file="Navbar.jsp" %>
	<%
	Connection con = DBConnect.getConnection();
	out.println(con);
	
	%>
	<div class="container">
		<div class="row mt-3">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center c-head text-white">
						<i class="fa-solid fa-user"></i>
						<h5>Login Page</h5>
					</div>
					<%
						String logoutMSG = (String)session.getAttribute("logout-msg");
					if(logoutMSG!=null)
					{%>
					
					<div class="alert alert-success" role="alert"><%=logoutMSG %></div>
					
					<%	
					session.removeAttribute("logout-msg");
					}
					%>
					
					
					<%
						String errorMSG = (String)session.getAttribute("err-msg");
					if(errorMSG!=null)
					{%>
					
					<div class="alert alert-success" role="alert"><%=errorMSG %></div>
					
					<%	
					session.removeAttribute("err-msg");
					}
					%>
					
					
					<div class="card-body">
						<form action="LoginServlet" method="post">

							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Email address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="email">

							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Enter
									Password</label> <input type="password" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>

							<div class="d-grid gap-2">
								<button class="btn btn-primary rounded-pill" type="submit">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>

