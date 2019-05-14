package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.UserBean;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet{
	
	private static final long serialVersionUID = -1088763422670853130L;

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
		if (userBean.isUserLoginCorrect())
			dispatcher = request.getRequestDispatcher("Mainmenu/mainmenau.jsp");
		else {
			//TODO where to go
			dispatcher = request.getRequestDispatcher("Form.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
