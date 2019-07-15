package de.casino.com.games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlackJackGui {

	static final int DEALER_LIMIT = 17;

	private JFrame frame;
	private BlackJackDeck deck;
	private DrawFrame drawPanel;
	private BlackJackPlayer player;
	private BlackJackPlayer dealer;
	private String message = "";
	private BlackJackUtility help;
	private boolean gameOn;
	private String count = "";

	public static void main(String[] args) {
		BlackJackGui gui = new BlackJackGui();
		gui.init();
	}

	public void init() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawPanel = new DrawFrame();
		drawPanel.setBounds(0, 0, 600, 500);
		drawPanel.setLayout(null);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(drawPanel);
		frame.setSize(600, 500);
		frame.setVisible(true);
		JButton newGameButton = new JButton("NEW GAME");
		newGameButton.setBounds(100, 415, 100, 35);
		drawPanel.add(newGameButton);
		JButton hitButton = new JButton("HIT");
		hitButton.setBounds(220, 415, 100, 35);
		drawPanel.add(hitButton);
		JButton doubleButton = new JButton("DOUBLE");
		doubleButton.setBounds(340, 415, 100, 35);
		drawPanel.add(doubleButton);
		JButton standButton = new JButton("STAND");
		standButton.setBounds(460, 415, 100, 35);
		drawPanel.add(standButton);
		newGameButton.addActionListener(new NewGameListener());
		hitButton.addActionListener(new HitListener());
		doubleButton.addActionListener(new DoubleListener());
		standButton.addActionListener(new standListener());
	}

	private void setupNewGame() {
		deck = new BlackJackDeck();
		player = new BlackJackPlayer();
		dealer = new BlackJackPlayer();
		help = new BlackJackUtility();
		message = "";
		count = "";
		gameOn = true;
	}

	class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (!gameOn) {
				setupNewGame();
				for (int i = 0; i < 2; i++) {
					dealer.addCard(deck.dealCard());
					player.addCard(deck.dealCard());
				}
				if (help.checkBlackJack(player)) {
					if (help.determineWinner(player, dealer) == BlackJackUtility.Winner.TIE) {
						message = "Blackjack ! Tie !";
						gameOn = false;
					} else {
						message = "Blackjack ! You win !";
						gameOn = false;
					}
				}
				drawPanel.setDealerHand(dealer.getHand());
				drawPanel.setPlayerHand(player.getHand());
				drawPanel.setMessage(message);
				drawPanel.setGameOn(gameOn);
				frame.repaint();
			}
		}
	}

	class HitListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (gameOn) {
				player.addCard(deck.dealCard());
				if (help.checkBust(player)) {
					message = "Busted ! You lose !";
					gameOn = false;
				}
				drawPanel.setPlayerHand(player.getHand());
				drawPanel.setMessage(message);
				drawPanel.setGameOn(gameOn);
				frame.repaint();
			}
		}
	}

	class DoubleListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			BlackJackUtility.Winner winner;
			if (gameOn) {
				if (player.getHand().size() == 2 && player.getValueOfHand() <= 17) {
					player.addCard(deck.dealCard());
					if (help.checkBust(player)) {
						message = "Busted ! You lose !";
						gameOn = false;

					} else {
						while (dealer.getValueOfHand() < DEALER_LIMIT) {
							dealer.addCard(deck.dealCard());
						}
						winner = help.determineWinner(player, dealer);
						switch (winner) {
						case PLAYER:
							message = "You win !";
							gameOn = false;
							break;
						case DEALER:
							message = "You lose !";
							gameOn = false;
							break;
						case TIE:
							message = "Tie !";
							gameOn = false;
							break;
						default:
							break;
						}
					}
				} else {
					message = "Double nicht mehr möglich";
				}
				drawPanel.setPlayerHand(player.getHand());
				drawPanel.setMessage(message);
				drawPanel.setGameOn(gameOn);
				frame.repaint();
			}
		}
	}

	class standListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			BlackJackUtility.Winner winner;
			if (gameOn) {
				gameOn = false;
				while (dealer.getValueOfHand() < DEALER_LIMIT) {
					dealer.addCard(deck.dealCard());
				}
				if (help.checkBust(dealer)) {
					message = "You win !";
					drawPanel.setMessage(message);
					drawPanel.setGameOn(gameOn);
					frame.repaint();
				} else {
					winner = help.determineWinner(player, dealer);
					switch (winner) {
					case PLAYER:
						message = "You win !";
						break;
					case DEALER:
						message = "You lose !";
						break;
					case TIE:
						message = "Tie !";
						break;
					default:
						break;
					}
					drawPanel.setMessage(message);
					drawPanel.setGameOn(gameOn);
					frame.repaint();
				}
			}
		}
	}

}

@SuppressWarnings("serial")
class DrawFrame extends JPanel {

	private ArrayList<BlackJackCards> playerHand;
	private ArrayList<BlackJackCards> dealerHand;
	String count = "";
	String message = "";
	boolean gameOn;

	public void setPlayerHand(ArrayList<BlackJackCards> playerHand) {
		this.playerHand = playerHand;
	}

	public void setDealerHand(ArrayList<BlackJackCards> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}

	public void paintComponent(Graphics g) {
		g.setColor(new Color(0.0f, 0.5f, 0.0f));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(1.0f, 1.0f, 1.0f));
		g.fillRect(460, 360, 100, 35);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(new Color(1.0f, 0.0f, 0.0f));
		g.drawString(message, 240, 265);
		g.setColor(new Color(0.0f, 0.0f, 0.0f));
		if (playerHand != null) {
			for (int i = 0; i < playerHand.size(); i++) {
				Image image = playerHand.get(i).getImage();
				g.drawImage(image, (120 + i * 25), (285), this);
			}
		}
		if (dealerHand != null) {
			for (int i = 0; i < dealerHand.size(); i++) {
				Image image = null;
				if (gameOn) {
					if (i == 0) {
						image = dealerHand.get(i).getImage();
//						image = new ImageIcon("WebContent/Ressources/cardImages/KartenDeckImages/allcards/card_back.png").getImage();
					} else {
						image = dealerHand.get(i).getImage();
					}
				} else {
					image = dealerHand.get(i).getImage();
				}
				g.drawImage(image, (120 + i * 25), (50), this);
			}
		}
	}

}