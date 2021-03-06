package de.casino.com.games.blackjack;

import java.util.ArrayList;

public class BlackJackPlayer extends BlackJackGui{
	
	private ArrayList<BlackJackCards> hand = new ArrayList<BlackJackCards>();
	public int valueOfHand;
	public int aceFound = 0;
	
	public BlackJackPlayer() {
		 valueOfHand = 0;
	}
	
	
	public void addCard(BlackJackCards card) {
		getHand().add(card);
		if (card.getFaceValue() == BlackJackCards.FaceValue.ace) {
			valueOfHand += 11;
			aceFound++;

			if (aceFound > 0 && valueOfHand > 21) {
				valueOfHand -= 10;
				aceFound--;
			}

		} else {
			valueOfHand += card.getFaceValue().getIntValue();
			if (aceFound > 0 && valueOfHand > 21) {
				valueOfHand -= 10;
				aceFound--;
			}
		}
System.out.println(aceFound);
	}

	public ArrayList<BlackJackCards> getHand() {
		return hand;
	}


	public int getValueOfHand () {
		return valueOfHand;
	}
	

	public void setHand(ArrayList<BlackJackCards> hand) {
		this.hand = hand;
	}


	public void setValueOfHand (int valueOfHand) {
		this.valueOfHand = valueOfHand;
	}
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i < this.hand.size(); i++) {
			sb.append(hand.get(i).getFaceValue().toString() + "of" + hand.get(i).getSuit().toString() + " ");
		}
		return sb.toString();
	}


	public int getAceFound() {
		return aceFound;
	}


	public void setAceFound(int aceFound) {
		this.aceFound = aceFound;
	}
	
	
	
	
}