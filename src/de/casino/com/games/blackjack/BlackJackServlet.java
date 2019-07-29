package de.casino.com.games.blackjack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/BlackJackServlet")
public class BlackJackServlet extends HttpServlet {

	private String response = "";
	private HttpServletResponse resp;
	private HttpServletRequest req;
	private boolean gameOver = false;
	String winner;

	private void setupNewGame(BlackJackBean blackJackBean) {
		gameOver = false;
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackCards card = deck.dealCard();
		BlackJackUtility utility = new BlackJackUtility();
		blackJackBean.setDealer(dealer);
		blackJackBean.setPlayer(player);
		blackJackBean.setDeck(deck);
		blackJackBean.setCards(card);
		player.setAceFound(0);
		dealer.setAceFound(0);
		player.setHand(new ArrayList<BlackJackCards>());
		dealer.setHand(new ArrayList<BlackJackCards>());
		player.setValueOfHand(0);
		dealer.setValueOfHand(0);
		for (int i = 0; i < 2; i++) {
			card = deck.dealCard();
			player.addCard(card);
			response += "playerCardValue=" + player.getValueOfHand() + ";";
			response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			card = deck.dealCard();
			dealer.addCard(card);
			response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			System.out.println("Player: " + player.getValueOfHand());
			System.out.println("Dealer: " + dealer.getValueOfHand());
		}
		response += "dealerCardValueHidden="+ dealer.getHand().get(0).getFaceValue().getIntValue() + ";";
		req.getSession().setAttribute("blackJackBean", blackJackBean);
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		if(utility.checkBlackJack(player)) {
			response += "BlackJack=;";
			stay(blackJackBean);
		}
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void hit(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackCards card = deck.dealCard();
		if (player.getValueOfHand() < 21 && !gameOver) {
			player.addCard(card);
			System.out.println("Player: " + player.getValueOfHand());
			response += "playerCardValue=" + player.getValueOfHand() + ";";
			response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			this.resp.setContentType("text/plain");
			this.resp.setCharacterEncoding("UTF-8");
		} else {
//			stay(blackJackBean);
		}
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void stay(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackCards card = deck.dealCard();
		response += "dealerCardValue=" + dealer.getValueOfHand() + ";";
		if (player.getValueOfHand() <= 21) {
			while (dealer.getValueOfHand() <= player.getValueOfHand() && dealer.getValueOfHand() < 17) {
				card = deck.dealCard();
				dealer.addCard(card);
				System.out.println("Dealer: " + dealer.getValueOfHand());
				response += "dealerCardValue=" + dealer.getValueOfHand() + ";";
				response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
				this.resp.setContentType("text/plain");
				this.resp.setCharacterEncoding("UTF-8");
			}
			}
			try {
				this.resp.getWriter().write(response);
			} catch (IOException e) {
				e.printStackTrace();
			}
			endGame(blackJackBean);
			req.getSession().setAttribute("BlackJackBean", null);

		
	}

	private void goDouble(BlackJackBean blackJackBean) {
		BlackJackPlayer player = blackJackBean.getPlayer();
		if (player.getHand().size() == 2 && player.getValueOfHand() <= 17) {
			hit(blackJackBean);
			stay(blackJackBean);
		}else {
			response += "ScoreTooHigh;";	
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.resp = resp;
		this.req = req;

		BlackJackBean blackJackBean = ((BlackJackBean) req.getSession().getAttribute("blackJackBean"));
		if (blackJackBean == null) {
			blackJackBean = new BlackJackBean();
			req.setAttribute("blackJackBean", blackJackBean);
		}

		String request = "";
		request = req.getParameter("game");
		switch (request) {
		case "go":
			setupNewGame(blackJackBean);
			break;

		case "hit":
			hit(blackJackBean);
			break;

		case "stay":
			stay(blackJackBean);
			endGame(blackJackBean);

			req.getSession().setAttribute("BlackJackBean", null);
			break;

		case "double":
			goDouble(blackJackBean);
			break;
		}

		if (drawToMuch(blackJackBean)) {
			endGame(blackJackBean);
		}

		req.getSession().setAttribute("blackJackBean", blackJackBean);

	}

	private boolean drawToMuch(BlackJackBean blackJackBean) {
		if (blackJackBean.getPlayer().getValueOfHand() > 21) {
			return true;
		}
		return false;
	}

	private void endGame(BlackJackBean blackJackBean) {
		response = "";
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackUtility utility = new BlackJackUtility();
		System.out.println("final dealer hand: " + blackJackBean.getDealer().getValueOfHand());
		System.out.println("final player hand: " + blackJackBean.getPlayer().getValueOfHand());
		String winner = utility.determineWinner(blackJackBean.getPlayer(), blackJackBean.getDealer()).name();
//		response += winner+";";
		System.out.println(winner);
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		if(winner.equals("PLAYER")) {
			response += "PlayerWins=;";
			System.out.println(response);
		}else if (winner == "DEALER") {
			response += "DealerWins=;";
		}else {
			response += "Tiegame=;";
		}
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.setAceFound(0);
		dealer.setAceFound(0);
		gameOver = true;
	}

}
