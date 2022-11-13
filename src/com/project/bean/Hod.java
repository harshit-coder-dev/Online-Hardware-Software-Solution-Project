package com.project.bean;

public class Hod {

	private String username;
	private String password;
	
	public Hod() {
		// TODO Auto-generated constructor stub
	}
	public Hod(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Hod [username=" + username + ", password=" + password + "]";
	}
	
	
	
}