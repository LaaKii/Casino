package de.casino.com.games.blackjack;


import java.awt.Image;

public class BlackJackCards {
	
	public enum Suit {clubs, spades, hearts, diamonds}
	
	public enum FaceValue {
		ace(1), king(10), queen(10), jack(10), ten(10), nine(9), 
		eight(8), seven(7), six(6), five(5), four(4), three(3), two(2);
		private int intValue;
	
		FaceValue(int intValue) {
			this.intValue = intValue;
		}
		
		public int getIntValue() {
			return this.intValue;
		}
	}
	
	private Suit suit;
	private FaceValue faceValue;
	private Image image;
	
	public BlackJackCards(Suit suit, FaceValue faceValue, Image image) {
		this.suit = suit;
		this.faceValue = faceValue;
		this.image = image;
	}


	public Suit getSuit() {
		return suit;
	}


	public void setSuit(Suit suit) {
		this.suit = suit;
	}


	public FaceValue getFaceValue() {
		return faceValue;
	}


	public void setFaceValue(FaceValue faceValue) {
		this.faceValue = faceValue;
	}


	public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "BlackJackCards [suit=" + suit + ", faceValue=" + faceValue + "]";
	}
	
	
	
}