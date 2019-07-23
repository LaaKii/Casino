package de.casino.com.database;

import java.sql.Date;
import java.time.LocalDate;

public class UserLoginBean {
	
	private int idLoginBean;
	private int idUser;
	private LocalDate loginDate;
	
	public UserLoginBean(int idUser) {
		this.idUser = idUser;
	}
	
	public UserLoginBean() {
	}
	
	public UserLoginBean(int idLoginBean, int idUser, Date loginDate) {
		this.idLoginBean = idLoginBean;
		this.idUser = idUser;
		this.loginDate = loginDate.toLocalDate();
	}
	
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

	@Override
	public String toString() {
		return "UserLoginBean [idLoginBean=" + idLoginBean + ", idUser=" + idUser + ", loginDate=" + loginDate + "]";
	}
	
	
	

}
