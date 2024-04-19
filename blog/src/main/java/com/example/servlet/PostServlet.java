package com.example.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.example.model.Post;
import com.google.gson.Gson;

@WebServlet
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create an ArrayList to hold the posts
		ArrayList<Post> posts = new ArrayList<>();

		// Add some dummy posts (for demonstration purposes)
		posts.add(new Post("Title 1", "Content 1"));
		posts.add(new Post("Title 2", "Content 2"));

		// Convert posts to JSON format using Gson
		String json = new Gson().toJson(posts);

		// Set content type and encoding for the response
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Write JSON response to the HttpServletResponse object
		response.getWriter().write(json);
	}
}
