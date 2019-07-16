package de.casino.com.games.blackjack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BlackJackServlet")
public class BlackJackServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//boolean startGame = (boolean) req.getAttribute("startgame");
	
		System.out.println("test");
		resp.getWriter().write("start");
		
	}
}
