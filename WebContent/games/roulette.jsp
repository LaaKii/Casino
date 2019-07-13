<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<jsp:useBean id="transactionBean"
	class="de.casino.com.database.TransactionBean"
	scope="request" />

<html>
	<head>
		<title>login</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/index.css">		
	</head>
	
	<body class="basicBody">
		<!--  <h1 class="basicHeader">Username: ${userBean.username}</h1> -->
		<h1 class="basicHeader">Recursino</h1>
		<!--  show current konto -->
		<form class="content" method="get" action="${pageContext.request.contextPath}/KontoServlet">
			<button class="basicButton" name="signin" type="submit">Show Konto</button>
		</form>
		
		<form class="content" method="post" action="${pageContext.request.contextPath}/TransactionServlet">
			<table class="content">
				<tr>
					<th>Amount:</th>
					<td><input class="content" name="amount" type="number" value="${transactionBean.transactionAmount}"></td>
				</tr>
				<tr>
					<td><button class="basicButton" name="signin" type="submit">Absenden</button></td>
				</tr>
			</table>
		</form>
		<form class="content" method="post" action="${pageContext.request.contextPath}/LogoutServlet">
			<table class="content">
				<tr>
					<td><button class="basicButton" name="signin" type="submit">Logout Session</button></td>
				</tr>
			</table>
		</form>
		<div class="basicFooter">
			<a class="footer" href="${pageContext.request.contextPath}/others/impressum.jsp">Impressum</a>
			<a class="footer" href="${pageContext.request.contextPath}/others/faq.jsp">FAQ</a>
		</div>
	</body>
</html>