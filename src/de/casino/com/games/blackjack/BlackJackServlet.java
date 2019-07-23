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

	private void setupNewGame(BlackJackBean blackJackBean) {
		gameOver = false;
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackCards card = deck.dealCard();
		blackJackBean.setDealer(dealer);
		blackJackBean.setPlayer(player);
		blackJackBean.setDeck(deck);
		blackJackBean.setCards(card);
		player.setHand(new ArrayList<BlackJackCards>());
		dealer.setHand(new ArrayList<BlackJackCards>());
		player.setValueOfHand(0);
		dealer.setValueOfHand(0);
		for (int i = 0; i < 2; i++) {
			card = deck.dealCard();
			player.addCard(card);
			response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			card = deck.dealCard();
			dealer.addCard(card);
			response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			System.out.println("Player: " + player.getValueOfHand());
			System.out.println("Dealer: " + dealer.getValueOfHand());
		}

		req.getSession().setAttribute("blackJackBean", blackJackBean);
//		System.out.println(player.getHand());
//		System.out.println(((BlackJackBean) req.getSession().getAttribute("blackJackBean")));
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			this.resp.setContentType("text/plain");
			this.resp.setCharacterEncoding("UTF-8");
		} else {
//			stay(blackJackBean);
		}
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void stay(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackCards card = deck.dealCard();
		if (player.getValueOfHand() <= 21) {
			while (dealer.getValueOfHand() < player.getValueOfHand() && dealer.getValueOfHand() < 17) {
				card = deck.dealCard();
				dealer.addCard(card);
				System.out.println(dealer.getHand());
				response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
				this.resp.setContentType("text/plain");
				this.resp.setCharacterEncoding("UTF-8");
			}
			try {
				this.resp.getWriter().write(response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			endGame(blackJackBean);
			req.getSession().setAttribute("BlackJackBean", null);

		}
	}

	private void goDouble(BlackJackBean blackJackBean) {

		BlackJackPlayer player = blackJackBean.getPlayer();
		if (player.getHand().size() == 2 && player.getValueOfHand() <= 17) {
			hit(blackJackBean);
			stay(blackJackBean);
		} else {
			System.out.println("Nope");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			System.out.println("Go clicked");
			setupNewGame(blackJackBean);
			break;

		case "hit":
			System.out.println("Hit clicked");
			hit(blackJackBean);
			System.out.println("Player hand: " + blackJackBean.getPlayer().getValueOfHand());
			break;

		case "stay":
			System.out.println("Dealer hand: " + blackJackBean.getDealer().getValueOfHand());
			stay(blackJackBean);
			System.out.println("Dealer hand after draw: " + blackJackBean.getDealer().getValueOfHand());
			endGame(blackJackBean);

			req.getSession().setAttribute("BlackJackBean", null);
			break;

		case "double":
			System.out.println("double clicked");
			goDouble(blackJackBean);
			break;
		}

		if (drawToMuch(blackJackBean)) {
			endGame(blackJackBean);
		}

		// TODO GANZ DICKES TODO, IRGENDWIE MUSS DAS MIT DEM SESSION SCOPE GEREGELT
		// WERDEN. SEITE NEU LADEN UND MAN HAT IMMERNOCH GLEICHE KARTEN
//		if (!endGameCalled) {
		req.getSession().setAttribute("blackJackBean", blackJackBean);
//		}else {
//			req.getSession().setAttribute("blackJackBean", null);
//		}
	}

	private boolean drawToMuch(BlackJackBean blackJackBean) {
		if (blackJackBean.getPlayer().getValueOfHand() > 21) {
			return true;
		}
		return false;
	}

	private void endGame(BlackJackBean blackJackBean) {
		response = "gameWinner=";

		BlackJackUtility utility = new BlackJackUtility();
		System.out.println("final dealer hand: " + blackJackBean.getDealer().getValueOfHand());
		System.out.println("final player hand: " + blackJackBean.getPlayer().getValueOfHand());
		response += utility.determineWinner(blackJackBean.getPlayer(), blackJackBean.getDealer()).name();
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gameOver = true;
	}

}
