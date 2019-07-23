package de.casino.com.database.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.GameBean;
import de.casino.com.database.UserBean;
import de.casino.com.database.UserLoginBean;
import de.casino.com.services.GameService;
import de.casino.com.services.KontoService;
import de.casino.com.services.LoginService;
import de.casino.com.services.TransactionService;
import de.casino.com.services.UserService;

@WebServlet("/UserServlet")
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = -1088763422670853130L;
	
	private LoginService loginService = new LoginService();
	private UserService userService = new UserService();
	private TransactionService transactionService = new TransactionService();
	private GameService gameService = new GameService();
	private KontoService kontoService = new KontoService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserBean userBean = (UserBean) request.getAttribute("userBean");
		if (userBean == null) {
			userBean = new UserBean();
			request.setAttribute("userBean", userBean);
		}
		userBean.setUsername(request.getParameter("username"));
		userBean.setPassword(request.getParameter("password"));

		RequestDispatcher dispatcher;
		if (loginService.isUserLoginCorrect(userBean)) {
			UserLoginBean userLoginBean = new UserLoginBean();
			userLoginBean.setIdUser(userService.getUserByUsername(userBean.getUsername()).getIdUser());
			userLoginBean.setLoginDate(LocalDate.now());
			loginService.updateUserLogin(userLoginBean);
			userBean.setIdUser(userLoginBean.getIdUser());
			if(transactionService.checkFirstLoginOnThatDay(userBean)) {
				transactionService.createTransaction(gameService.getGameByName("DAILY LOGIN"), kontoService.getKontoByUser(userBean), 1000);
				System.out.println("Daily Login Bonus granted");
			}else {
				System.out.println("Already received daily login bonus");
			}
			dispatcher = request.getRequestDispatcher("Mainmenu/mainmenu.jsp");
		}
		else {
			//TODO where to go
			String loginError = "Benutzername oder Passwort falsch!";
			request.setAttribute("loginError", loginError);
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		request.getSession().setAttribute("userBean", userBean);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
