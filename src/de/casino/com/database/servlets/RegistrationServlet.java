package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.KontoDao;
import de.casino.com.dao.UserDao;
import de.casino.com.database.KontoBean;
import de.casino.com.database.UserBean;
import de.casino.com.services.LoginService;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 3698751230122561475L;
	
	private DatabaseDao<UserBean> userDao = new UserDao();
	private DatabaseDao<KontoBean> kontoDao = new KontoDao();
	private LoginService loginService = new LoginService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserBean userBean = (UserBean) request.getAttribute("userBean");
		if (userBean == null) {
			userBean = new UserBean();
			request.setAttribute("userBean", userBean);
		}

			userBean.setUsername(request.getParameter("username"));
			userBean.setFirstname(request.getParameter("firstname"));
			userBean.setLastname(request.getParameter("lastname"));
			userBean.setPassword(request.getParameter("password"));
			userBean.setPasswordRepeated(request.getParameter("passwordRepeated"));
			userBean.setEmail(request.getParameter("email"));
			
			RequestDispatcher dispatcher;
			if(loginService.checkUserSpecifications(userBean))
			{	
				userDao.createNewItem(userBean);
				//Objekt wieder aus db holen wegen generierter ID
				UserBean userFromDb = userDao.getSingleItemByValue("username", userBean);
				kontoDao.createNewItem(new KontoBean(userFromDb.getIdUser(), 0));
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			
			else {
				String signupError = "Benutzername bereits vergeben";
				request.setAttribute("errorMessage", signupError);
				dispatcher = request.getRequestDispatcher("login/signup.jsp");
			}
			dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
