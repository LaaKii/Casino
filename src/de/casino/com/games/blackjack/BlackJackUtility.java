package de.casino.com.games.blackjack;

public class BlackJackUtility {

	static final int BLACK_JACK = 21;

	public enum Winner {
		PLAYER, DEALER, TIE
	}

	public Winner determineWinner(BlackJackPlayer player, BlackJackPlayer dealer) {
		int PlayerHand = (int) player.getValueOfHand();
		int DealerHand = (int) dealer.getValueOfHand();
		
		if(DealerHand <= 21) {
		if (PlayerHand == DealerHand) {
			return Winner.TIE;
		} else if (PlayerHand > DealerHand && PlayerHand <= 21) {
			return Winner.PLAYER;
		} else {
			return Winner.DEALER;
		}
		}else {
			return Winner.PLAYER;
		}

	}

	public boolean checkBlackJack(BlackJackPlayer player) {
		if (player.getValueOfHand() == BLACK_JACK){
			return true;
		} else {
			return false;
		}
	}

	public boolean checkBust(BlackJackPlayer player) {
		if (player.getValueOfHand() > BLACK_JACK){
			return true;
		} else {
			return false;
		}
	}

	public boolean aceFound(BlackJackPlayer player) {
		boolean aceFound = false;
		if (player.getHand().size() > 0) {
			for (BlackJackCards index : player.getHand()) {
				if (index.getFaceValue() == BlackJackCards.FaceValue.ace) {
					aceFound = true;
				}
			}
		}
		return aceFound;
	}

	public void checkAce(BlackJackPlayer player) {
		int valueOfHand = player.valueOfHand;
		while (player.getValueOfHand() > BLACK_JACK && aceFound(player) == true) {
			valueOfHand -= 10;

		}
	}

}