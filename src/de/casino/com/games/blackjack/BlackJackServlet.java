package de.casino.com.games.blackjack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.games.blackjack.BlackJackUtility.Winner;

@WebServlet("/BlackJackServlet")
public class BlackJackServlet extends HttpServlet {

	private String response = "";
	private HttpServletResponse resp;
	private HttpServletRequest req;
	private boolean endGameCalled=false;
	
	private void setupNewGame(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackCards card = deck.dealCard();
		for (int i = 0; i < 2; i++) {
			card = deck.dealCard();
			player.addCard(card);
			response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
			card = deck.dealCard();
			dealer.addCard(card);
			response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		}
		blackJackBean.setDealer(dealer);
		blackJackBean.setPlayer(player);
		blackJackBean.setDeck(deck);
		blackJackBean.setCards(card);
		req.getSession().setAttribute("blackJackBean", blackJackBean);
		System.out.println("Setup new game:");
		System.out.println(((BlackJackBean)req.getSession().getAttribute("blackJackBean")));
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
		player.addCard(card);
		response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void stay(BlackJackBean blackJackBean) {
		response="";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackCards card;
		card = deck.dealCard();
		dealer.addCard(card);
		response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void goDouble(BlackJackBean blackJackBean) {
		hit(blackJackBean);
		endGame(blackJackBean);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.resp=resp;
		this.req=req;
		
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
			System.out.println("Dealer hand: "+ blackJackBean.getDealer().getValueOfHand());
			while (blackJackBean.getDealer().getValueOfHand()<17) {
				stay(blackJackBean);	
				System.out.println("Dealer hand after draw: "+ blackJackBean.getDealer().getValueOfHand());
			}
			endGame(blackJackBean);
			
			
			req.getSession().setAttribute("BlackJackBean", null);
			break;
			
		case "double":
			System.out.println("double clicked");
			goDouble(blackJackBean);
		}
		
		if (drawToMuch(blackJackBean)) {
			endGame(blackJackBean);
		}
			
		//TODO GANZ DICKES TODO, IRGENDWIE MUSS DAS MIT DEM SESSION SCOPE GEREGELT WERDEN. SEITE NEU LADEN UND MAN HAT IMMERNOCH GLEICHE KARTEN
		if (!endGameCalled) {
			req.getSession().setAttribute("blackJackBean", blackJackBean);	
		}else {
			req.getSession().setAttribute("blackJackBean", null);
		}
	}
	
	private boolean drawToMuch(BlackJackBean blackJackBean) {
		if (blackJackBean.getPlayer().getValueOfHand()>21) {
			return true;
		}
		return false;
	}
	
	private void endGame(BlackJackBean blackJackBean) {
		response="gameWinner=";
		
		BlackJackUtility utility = new BlackJackUtility();
		System.out.println("final dealer hand: " + blackJackBean.getDealer().getValueOfHand());
		System.out.println("final player hand: " + blackJackBean.getPlayer().getValueOfHand());
		response+=utility.determineWinner(blackJackBean.getPlayer(), blackJackBean.getDealer()).name();
		this.resp.setContentType("text/plain");
		this.resp.setCharacterEncoding("UTF-8");
		try {
			this.resp.getWriter().write(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endGameCalled=true;
	}
	
}
