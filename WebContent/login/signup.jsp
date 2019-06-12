<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<!DOCTYPE html>

<html>
<head>
<title>registration</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/signup.css">

<%if(userBean.isSubmitted() == true){%>
	<style>
	#usernameInput{border-color:red}
		<%if(userBean.checkUsername() == false){%>
		
		#usernameInput{border-color:red}
		
		<%}
		
		if(userBean.checkFirstname() == false){%>
		
		#firstnameInput{border-color:red}
		
		<%}
		
		if(userBean.checkLastname() == false){%>
		
		#lastnameInput{border-color:red}
		
		<%}
		
		if(userBean.checkEmail() == false){%>
		
		#emailInput{border-color:red}
		
		<%}
		
		if(userBean.checkPassword() == false){%>
		
		#passwordInput{border-color:red}
		#passwordRepeatedInput{border-color:red}
		
		<%}
		
		if(userBean.isAgbAccepted() == false){%>
		
		.agb{border-color:red}
			
		<%}%>
		
	</style><%}%>
		
	
	

</head>
<body class="basicBody">
	<h1 class="basicHeader">Recursino</h1>
	<form class="content" method="get" action="${pageContext.request.contextPath}/RegistrationServlet">
		<table class="content">
			<tr id="tablehead">
				<td colspan="2">Registration</td>
			</tr>
			<tr>
				<td>Benutzername:</td>
				<td><input id="usernameInput" class="textInput" name="username" type="text"
					value="${userBean.username}"></td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td><input id="firstnameInput" class="textInput" name="firstname" type="text"
					value="${userBean.firstname}"></td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td><input id="lastnameInput"class="textInput" name="lastname" type="text"
					value="${userBean.lastname}"></td>
			</tr>
			<tr>
				<td>E-Mail:</td>
				<td><input id="emailInput" class="textInput" name="email" type="text"
					value="${userBean.email}"></td>
			</tr>
			<tr>
				<td>Passwort:</td>
				<td><input id="passwordInput" class="textInput" name="password" type="password"
					value="${userBean.password}"></td>
			</tr>
			<tr>
				<td>Passwort wiederholen:</td>
				<td><input id="passwordRepeatedInput" class="textInput" name="passwordRepeated"
					type="password" value="${userBean.passwordRepeated}"></td>
			</tr>
			<tr>
				<td></td>
				<td><span class="agb">Ich akzeptiere die AGB.<input
						name="agb" type="checkbox"></input></span></td>
			</tr>
			<tr>
				<td style="text-align: left"><a class="basicButton"
					href="${pageContext.request.contextPath}/index.jsp">Zurück zum Login</a></td>
				<td><button class="basicButton" name="signin" type="submit">Absenden</button></td>
			</tr>
		</table>
	</form>
	<footer>
		<span class="basicFooter">
			<a href="${pageContext.request.contextPath}/others/impressum.jsp">Impressum</a>
			<a href="${pageContext.request.contextPath}/others/faq.jsp">FAQ</a>
		</span>
	</footer>
</body>
</html>