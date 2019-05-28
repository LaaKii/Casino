<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<html>
	<head>
		<title>login</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/index.css">		
	</head>
	
	<body class="basicBody">
		<h1 class="basicHeader">Username: ${userBean.username}</h1>
		<form class="content" method="post" action="${pageContext.request.contextPath}/UserServlet">
			<table class="content">
				<tr>
					<th>Amount:</th>
					<td><input class="content" name="username" type="text" value="${userBean.username}"></td>
				</tr>
				<tr>
					<th style="text-align:right">Passwort:</th>
					<td><input class="content" name="password" type="password" value="${userBean.password}"></td>
				</tr>
				<tr>
					<td style="text-align:left"><a href="${pageContext.request.contextPath}/login/signup.jsp" class="basicButton">Registrieren</a></td>
					<td><button class="basicButton" name="signin" type="submit">Anmelden</button></td>
				</tr>
				<tr>
					<th colspan="2" id="forgetpw"><a href=#>Passwort vergessen?</a></th>
				</tr>
			</table>
		</form>
		<div class="basicFooter">
			<a class="footer" href="${pageContext.request.contextPath}/others/impressum.jsp">Impressum</a>
			<a class="footer" href="${pageContext.request.contextPath}/others/faq.jsp">FAQ</a>
		</div>
	</body>
</html>