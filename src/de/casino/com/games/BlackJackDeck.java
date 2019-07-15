package de.casino.com.games;


import java.util.ArrayList;
import javax.swing.ImageIcon;


public class BlackJackDeck {
	
	static final int MAX = 52;	
	int index = 0;

	private ArrayList<BlackJackCards> deck = new ArrayList<BlackJackCards>();


	public BlackJackDeck() {
		index = 0;	
		for(BlackJackCards.FaceValue faceValue : BlackJackCards.FaceValue.values())
			for(BlackJackCards.Suit suit: BlackJackCards.Suit.values()) {
				deck.add(new BlackJackCards(suit, faceValue, new ImageIcon("WebContent/Ressources/cardImages/KartenDeckImages/allcards/"+faceValue+"_of_"+suit+".png").getImage()));	
				index++;
			}		
	}
	

	public BlackJackCards dealCard() {
		index = (int)(Math.random()*deck.size()); 
		return deck.get(index);		
	}
			
}