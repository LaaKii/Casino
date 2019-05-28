package de.casino.com.database;

public class TransactionBean {

	private int idTransaction, idGame, idKonto;
	private double transactionAmount;
	
	public TransactionBean(int idTransaction, int idGame, int idKonto, double transactionAmount) {
		this.idTransaction = idTransaction;
		this.idGame = idGame;
		this.idKonto = idKonto;
		this.transactionAmount = transactionAmount;
	}
	
	
	public TransactionBean(int idGame, int idKonto, double transactionAmount) {
		this.idGame = idGame;
		this.idKonto = idKonto;
		this.transactionAmount = transactionAmount;
	}
	
	public TransactionBean() {};
	
	
	public int getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}
	public int getIdGame() {
		return idGame;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	public int getIdKonto() {
		return idKonto;
	}
	public void setIdKonto(int idKonto) {
		this.idKonto = idKonto;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	@Override
	public String toString() {
		return "TransactionBean [idTransaction=" + idTransaction + ", idGame=" + idGame + ", idKonto=" + idKonto
				+ ", transactionAmount=" + transactionAmount + "]";
	}
	
	
	
}
