package de.casino.com.database;

public class UserBean {
	
	private String username, firstname, lastname, password, email, passwordRepeated;
	private boolean submitted = false;
	private int idUser;
	
	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public UserBean(int userId, String username, String firstname, String lastname, String password, String email) {
		this.idUser=userId;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
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
	
	public boolean isOk() {
		if(checkUsername() && checkFirstname() && checkLastname() && checkEmail() && checkPassword()) {
			return true;
		}
		return false;
		
	}
	
	public boolean checkUsername() {
		if(username.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean checkFirstname() {
		if(firstname.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean checkLastname() {
		if(lastname.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean checkEmail() {
		if(email.equals("")) {
			return false;
		}
		return true;
	}
	
	public boolean checkPassword() {
		if(password.equals("")) {
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

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}
	
	

}