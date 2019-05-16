package de.casino.com.database.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.UserBean;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 3698751230122561475L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserBean userBean = (UserBean) request.getAttribute("userBean");
		if (userBean == null) {
			userBean = new UserBean();
			request.setAttribute("userBean", userBean);
		}

		boolean allInputsCorrect = true;

		String username = request.getParameter("username");

		if (username == null) {
			allInputsCorrect = false;
			// Meldung zurück geben
		}

		String mail = request.getParameter("email");

		String password = request.getParameter("password");

		if (password != request.getParameter("passwordRepeated")) {
			allInputsCorrect = false;
			// Meldung zurück geben
		}

		if (request.getParameter("agb") == null) {
			allInputsCorrect = false;
			// Meldung zurück geben
		}

		if(allInputsCorrect) {
			userBean.setUsername(username);
			userBean.setPassword(password);
			userBean.setEmail(mail);

			RequestDispatcher dispatcher;
			userBean.registerUser();
			dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("index.jsp");
		}
		
		else {
			response.sendRedirect("login/signup.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
