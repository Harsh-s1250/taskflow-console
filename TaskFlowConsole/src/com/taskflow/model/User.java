package com.taskflow.model;

public class User {
	private int userId;
	private String username;
	private String email;
	private String password;
	
	public User() {
		super();
	}
	public User(int userId, String username, String email, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	
	@Override
	public String toString() {
		return "User [userId= "+userId+", username= "+username+", email= "+email+"]";
	}
}
