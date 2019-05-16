package de.casino.com.database;

import java.util.List;


public class UserBean {
	
	private String username, password, passwordRepeated, email;

	

	DbManager dbManager = new DbManager();
	
	public boolean isUserLoginCorrect() {
		System.out.println("checking " + username + " password: " + password);
		
		
		List<UserBean> allUsers = dbManager.queryDb("select * from user;");
		
		for (UserBean user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				System.out.println("user authenticated");
				return true;
			}
		}
		System.out.println("user not authenticated");
		return false;
	}
	
	public boolean registerUser() {
		return dbManager.registerUser(this);
	}
	
	public UserBean() {
		
	}

	public UserBean(String username, String password) {
		this.username=username;
		this.password=password;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}
	
	public boolean isOk() {
		if(checkUsername() && checkPassword()) {
			return true;
		}
		return false;
	}
	
	public boolean checkUsername() {
		if(username == null) {
			return false;
			
		}
		return true;
	}
	
	public boolean checkPassword() {
		if(password != passwordRepeated) {
			return false;
		}
		return true;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname=firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname=lastname;
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", email=" + email + "]";
	}

}
