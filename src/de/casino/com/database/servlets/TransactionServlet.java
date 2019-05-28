package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.KontoBean;
import de.casino.com.database.UserBean;

@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		UserBean userBean = (UserBean) request.getAttribute("userBean");
//		if (userBean == null) {
//			userBean = new UserBean();
//		}
//
//			userBean.setEmail(request.getParameter("email"));
//			userBean.setSubmitted(true);
//			
//			if(userBean.isOk())
//			{	
//				//Objekt wieder aus db holen wegen generierter ID
//				UserBean userFromDb = userDao.getSingleItemByValue("username", userBean);
//			}
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
