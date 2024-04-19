<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.model.Post" %>
<%@ page import="com.google.gson.Gson" %>
<%
    ArrayList<Post> posts = new ArrayList<>();
    // Add logic to fetch posts from database or any other source
    // For demonstration purposes, creating dummy posts
    posts.add(new Post("Title 1", "Content 1"));
    posts.add(new Post("Title 2", "Content 2"));
	
       
 // Convert the ArrayList to JSON

    String json = new Gson().toJson(posts);
    out.println(json);
%>
