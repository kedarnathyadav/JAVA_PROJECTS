<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="All-Header-links.jsp" %>
</head>
<body style="background-image: linear-gradient(to right top, #b4cd5a, #c1c647, #cebd34, #dcb422, #eba912); background-repeat: no-repeat;background-attachment: fixed;background-size: cover;">   
	<%@ include file="Navbar.jsp" %>
	<div class="container">
		<div class="row mt-3">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center c-head text-white">
						<i class="fa-solid fa-user"></i>
						<h5>Registration Page</h5>
					</div>
					<%
					String regMsg=(String)session.getAttribute("reg-msg");
					if(regMsg!=null)
					{%>
					<div class="alert alert-success" role="alert"><%=regMsg %> Login..<a href="Login.jsp">Click here</a></div>

					<%	
					session.removeAttribute("reg-msg");

					}
					%>
					<div class="card-body">
						<form action="RegisterServlet" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Enter
									Full Name</label> <input type="text" class="form-control" id="fullname"
									aria-describedby="emailHelp" name="uname">

							</div>
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
								<button class="btn btn-primary rounded-pill" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>

