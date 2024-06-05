package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDao;
import com.DB.DBConnect;
import com.Entities.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(DBConnect.getConnection());
		User user =dao.getLogin(email, password);
		if(user!=null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("Home.jsp");
		}else {
			
			HttpSession session = request.getSession();
			session.setAttribute("err-msg", "Invalid email id & password");
			response.sendRedirect("Login.jsp");
		}
	}

}
