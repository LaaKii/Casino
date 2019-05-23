package de.casino.com.database;

public class GameBean {
	
	private int idGame;
	private String gameName;
	public int getIdGame() {
		return idGame;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public GameBean(int idGame, String gameName) {
		super();
		this.idGame = idGame;
		this.gameName = gameName;
	}
	
	public GameBean(String gameName){
		this.gameName = gameName;
	}
	

}
