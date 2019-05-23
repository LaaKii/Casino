package de.casino.com.database;

public class KontoBean {

	private int idKonto, idUser;
	private double money;
	
	@Override
	public String toString() {
		return "KontoBean [idKonto=" + idKonto + ", idUser=" + idUser + ", money=" + money + "]";
	}

	public KontoBean(int idKonto, int idUser, double money) {
		this.idKonto = idKonto;
		this.idUser = idUser;
		this.money = money;
	}
	
	public KontoBean(int idUser, double money) {
		this.idUser = idUser;
		this.money=money;
	}
	
	public int getIdKonto() {
		return idKonto;
	}
	public void setIdKonto(int idKonto) {
		this.idKonto = idKonto;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
	
}
