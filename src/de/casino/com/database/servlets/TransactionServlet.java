package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.GameBean;
import de.casino.com.database.KontoBean;
import de.casino.com.database.TransactionBean;
import de.casino.com.database.UserBean;
import de.casino.com.services.GameService;
import de.casino.com.services.KontoService;
import de.casino.com.services.TransactionService;
import de.casino.com.services.UserService;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private TransactionService transactionService = new TransactionService();
	private KontoService kontoService = new KontoService();
	private UserService userService = new UserService();
	private GameService gameService = new GameService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TransactionBean transactionBean = (TransactionBean) req.getAttribute("transactionBean");
		KontoBean kontoBeanSess = (KontoBean) req.getSession().getAttribute("kontoBean");
		
		if(transactionBean == null) {
			transactionBean = new TransactionBean();
			req.setAttribute("transactionBean", transactionBean);
		}
		
		
		transactionBean.setTransactionAmount(Integer.parseInt(req.getParameter("amount")));
		
		
		UserBean userBean = (UserBean) req.getSession().getAttribute("userBean");
		userBean = userService.getUserByUsername(userBean.getUsername());
		
		
		System.out.println("Current UserBean: " + userBean); 
		System.out.println("Transactionamount: " + transactionBean.getTransactionAmount());
		KontoBean kontoBean = kontoService.getKontoByUser(userBean);
		GameBean gameBean = gameService.getGameByName(new GameBean("Roulette"));
		
		transactionService.createTransaction(gameBean, kontoBean, transactionBean.getTransactionAmount());
		kontoService.updateKontoMoney(kontoBean);
		
		kontoBeanSess.setMoney(kontoBeanSess.getMoney()+transactionBean.getTransactionAmount());
		req.getSession().setAttribute("kontoBean", kontoBeanSess);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
