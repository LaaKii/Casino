package de.casino.com.games.blackjack;

public class BlackJackBean {
	
	private BlackJackCards cards;
	private BlackJackDeck deck;
	private BlackJackPlayer player;
	private BlackJackPlayer dealer;
	private String message = "";
	private BlackJackUtility help;
	private String count = "";
	
	public BlackJackDeck getDeck() {
		return deck;
	}
	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}
	public BlackJackPlayer getPlayer() {
		return player;
	}
	public void setPlayer(BlackJackPlayer player) {
		this.player = player;
	}
	public BlackJackPlayer getDealer() {
		return dealer;
	}
	public void setDealer(BlackJackPlayer dealer) {
		this.dealer = dealer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BlackJackUtility getHelp() {
		return help;
	}
	public void setHelp(BlackJackUtility help) {
		this.help = help;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public BlackJackCards getCards() {
		return cards;
	}
	public void setCards(BlackJackCards cards) {
		this.cards = cards;
	}
	
	public BlackJackBean(){
		deck = new BlackJackDeck();
		player = new BlackJackPlayer();
		dealer = new BlackJackPlayer();
		help = new BlackJackUtility();
	}
	@Override
	public String toString() {
		return "BlackJackBean [cards=" + cards + ", player=" + player + ", dealer=" + dealer
				+ ", message=" + message + ", count=" + count + "]";
	}
	
	

}
