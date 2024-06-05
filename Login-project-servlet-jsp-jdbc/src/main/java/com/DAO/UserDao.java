package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Entities.User;

public class UserDao {
	private Connection conn;

	

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegister(User user) {
		
		boolean f = false;
		try {
			String qu = "INSERT INTO user(name,email,password) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			f= true;
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User getLogin(String email, String password) {
		User user = null;
		try {
			
			String qu ="SELECT * FROM user WHERE email=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(qu);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
}
