package de.casino.com.games;

public class RouletteField {

	private int number;
	private RouletteColor rouletteColor;
	
	public RouletteField(int number, RouletteColor rouletteColor) {
		this.number=number;
		this.rouletteColor=rouletteColor;
	}
	
	public RouletteField() {
		
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public RouletteColor getRouletteColor() {
		return rouletteColor;
	}
	public void setRouletteColor(RouletteColor rouletteColor) {
		this.rouletteColor = rouletteColor;
	}
	
	@Override
	public String toString() {
		return "RouletteField [number=" + number + ", rouletteColor=" + rouletteColor + "]";
	}
	
	
	
}
