package de.casino.com.games.blackjack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.KontoBean;


@WebServlet("/BlackJackServlet")
public class BlackJackServlet extends HttpServlet{
	
	private String response = "";
	
	private void setupNewGame(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackPlayer dealer = blackJackBean.getDealer();
		BlackJackCards card = deck.dealCard();
		for(int i = 0; i < 2; i++) {
		card = deck.dealCard();
		player.addCard(card);
		response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		card = deck.dealCard();
		dealer.addCard(card);
		response += "dealercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		}
	}
	
	private void hit(BlackJackBean blackJackBean) {
		response = "";
		BlackJackDeck deck = blackJackBean.getDeck();
		BlackJackPlayer player = blackJackBean.getPlayer();
		BlackJackUtility help = blackJackBean.getHelp();
		BlackJackCards card = deck.dealCard();
		player.addCard(card);
		response += "playercard=" + card.getFaceValue() + "_of_" + card.getSuit() + ";";
		if (help.checkBust(player)) {
			//message = "Busted ! You lose !";
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BlackJackBean blackJackBean = (BlackJackBean) req.getAttribute("blackJackBean");
		if (blackJackBean == null) {
			blackJackBean = new BlackJackBean();
			req.setAttribute("blackJackBean", blackJackBean);
		}

		
		String request = "";
		request = req.getParameter("game");
		String request2 = req.getParameter("action");
		System.out.println(request);
		/*switch(request) {
		
			case "go": 	setupNewGame(blackJackBean);
						break;
			
			case "hit": hit(blackJackBean);
						break;
		}*/
		
		if(request != null && request.equals("go")) {
			setupNewGame(blackJackBean);
		}
		
		else if(request2 != null && request2.equals("hit")) {
			hit(blackJackBean);
		}
		
		req.getSession().setAttribute("BlackJackBean", blackJackBean);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(response);
		
	}
}
