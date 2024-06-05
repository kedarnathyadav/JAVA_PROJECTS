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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao dao = new UserDao(DBConnect.getConnection());
		boolean f = dao.userRegister(user);
		
		if(f) {
			HttpSession session = request.getSession();
			session.setAttribute("reg-msg", "Registration Successfull!! "+name);
			response.sendRedirect("Register.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("err-msg", "Registration Failed!! "+name);
			response.sendRedirect("Register.jsp");
		}
	}

}
