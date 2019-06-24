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
<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/signup.js'></script>
	<c:if test="${signupError != null}">
		<style>
			#usernameError{visibility:visible}
			#usernameInput{border-color:red;}
		</style>
	</c:if>
</head>
<body class="basicBody">
	<h1 class="basicHeader">Rekursino</h1>
	
	<form class="content" method="get" action="${pageContext.request.contextPath}/RegistrationServlet" onsubmit="return formCheck()" >
		<table class="content">
			<tr id="tablehead">
				<td colspan="2">Registration</td>
			</tr>
			<tr>
				<td>Benutzername:</td>
				<td><input 
				title="Der Benutzername darf nicht mit einer Zahl beginnen, keine Leerzeichen enthalten und muss mindestens 3 Zeichen enthalten" 
				id="usernameInput" class="textInput" name="username" type="text" value="${userBean.username}"></td>
			</tr>
			<tr id="usernameError" class="errorMessages">
				<td></td><td><span id="usernameErrorMessage" style="padding-left:20px"><c:out value="${signupError}"></c:out></span></td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td><input title="Der Vorname darf keine Zahlen und Leerzeichen enthalten" 
				id="firstnameInput" class="textInput" name="firstname" type="text" value="${userBean.firstname}"></td>
			</tr>
			<tr id="firstnameError" class="errorMessages">
				<td></td><td><span id="firstnameErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td><input title="Der Vorname darf keine Zahlen und Leerzeichen enthalten"
				id="lastnameInput"class="textInput" name="lastname" type="text" value="${userBean.lastname}"></td>
			</tr>
			<tr id="lastnameError" class="errorMessages">
				<td></td><td><span id="lastnameErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>E-Mail:</td>
				<td><input id="emailInput" class="textInput" name="email" type="email"
					value="${userBean.email}"></td>
			</tr>
			<tr id="emailError" class="errorMessages">
				<td></td><td><span id="emailErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>Passwort:</td>
				<td><input title="Das Passwort darf keine Leerzeichen und muss mindestens 3 Zeichen enthalten"
				id="passwordInput" class="textInput" name="password" type="password" value="${userBean.password}"></td>
			</tr>
			<tr id="password1Error" class="errorMessages">
				<td></td><td><span id="password1ErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>Passwort wiederholen:</td>
				<td><input title="Das Passwort darf keine Leerzeichen und muss mindestens 3 Zeichen enthalten"
				id="passwordRepeatedInput" class="textInput" name="passwordRepeated" type="password" value="${userBean.passwordRepeated}"></td>
			</tr>
			<tr id="password2Error" class="errorMessages">
				<td></td><td><span id="password2ErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td id="agbErrorMessage">Bitte AGBs Akzeptieren</td>
				<td><span  class="agb">Ich akzeptiere die AGB.<input id="agbCheck" name="agb" type="checkbox"></input></span></td>
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