package de.casino.com.database;

import java.time.LocalDate;

public class UserLoginBean {
	
	private int idLoginBean;
	private int idUser;
	private LocalDate loginDate;
	
	
	public int getIdLoginBean() {
		return idLoginBean;
	}
	public void setIdLoginBean(int idLoginBean) {
		this.idLoginBean = idLoginBean;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public LocalDate getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(LocalDate loginDate) {
		this.loginDate = loginDate;
	}
	
	

}
