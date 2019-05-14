package de.casino.com.database;

import java.util.List;

import de.casino.com.login.User;

public class UserBean {
	
	private String username, password;

	public boolean isUserLoginCorrect() {
		System.out.println("checking " + username + " password: " + password);
		
		DbManager dbManager = new DbManager();
		List<User> allUsers = dbManager.queryDb("select * from user;");
		
		for (User user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("user authenticated");
				return true;
			}
		}
		System.out.println("user not authenticated");
		return false;
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
	
}
