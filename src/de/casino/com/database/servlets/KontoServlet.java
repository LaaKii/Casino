package de.casino.com.database.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.casino.com.database.KontoBean;
import de.casino.com.database.UserBean;
import de.casino.com.services.KontoService;
import de.casino.com.services.UserService;

@WebServlet("/KontoServlet")
public class KontoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6910120057516961584L;
	private KontoService kontoService = new KontoService();
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean userBean = (UserBean)req.getSession().getAttribute("userBean");

		System.out.println("USERBEAN: " + userBean.getUsername());
		
		KontoBean kontoBean = (KontoBean) req.getAttribute("kontoBean");
		if (kontoBean == null) {
			kontoBean = new KontoBean();
			req.setAttribute("kontoBean", kontoBean);
		}
		
		kontoBean.setMoney(kontoService.getKontostandOfUser(userService.getUserByUsername(userBean.getUsername())));
		req.getSession().setAttribute("kontoBean", kontoBean);
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(Double.toString(kontoBean.getMoney()));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
