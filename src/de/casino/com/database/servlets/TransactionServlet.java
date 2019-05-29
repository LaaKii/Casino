package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import de.casino.com.database.GameBean;
import de.casino.com.database.KontoBean;
import de.casino.com.database.TransactionBean;
import de.casino.com.database.UserBean;
import de.casino.com.services.KontoService;
import de.casino.com.services.TransactionService;
import de.casino.com.services.UserService;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private TransactionService transactionService = new TransactionService();
	private KontoService kontoService = new KontoService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TransactionBean transactionBean = (TransactionBean) req.getAttribute("transactionBean");
		
		if(transactionBean == null) {
			transactionBean = new TransactionBean();
			req.setAttribute("transactionBean", transactionBean);
		}
		
		
		transactionBean.setTransactionAmount(Integer.parseInt(req.getParameter("amount")));
		
		
		UserBean userBean = (UserBean) req.getSession().getAttribute("userBean");
		
		
		
		System.out.println("Username from userBean: " + userBean.getUsername()); 
		System.out.println("Transactionamount: " + transactionBean.getTransactionAmount());
//		KontoBean kontoBean = kontoService.getKontoByUser(userBean);
		
		
//		transactionService.createTransaction(new GameBean("Roulette"), kontoBean, transactionBean.getTransactionAmount());
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
