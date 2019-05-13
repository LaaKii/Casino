package de.casino.com.login;

import javax.servlet.http.HttpServlet;

public class User extends HttpServlet{

	private String username;
	private String mail;
	private int money;
	
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
