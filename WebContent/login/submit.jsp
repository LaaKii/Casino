<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page  import="de.casino.com.login.User"%>
<!DOCTYPE html>
<html>
	<body>
		<%
		
			boolean loginButtonPressed = request.getParameter("login") != null;
			boolean submitButtonPressed = request.getParameter("submit") != null;
			
			if(loginButtonPressed){
					response.sendRedirect("../index.jsp");
			}
			
			else if(submitButtonPressed){	
				String username = request.getParameter("username");
				String mail = request.getParameter("mail");
				
				User user = new User();
				user.setUsername(username);
				user.setMail(mail);
				
				out.print(user.getUsername());
				out.print(user.getMail());
			}
		%>
	</body>
</html>