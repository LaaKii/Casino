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
	
<script>
	function formCheck(){
		
		var username = document.getElementById('usernameInput');
		var firstname = document.getElementById('firstnameInput');
		var lastname = document.getElementById('lastnameInput');
		var email = document.getElementById('emailInput');
		var password1 = document.getElementById('passwordInput');
		var password2 = document.getElementById('passwordRepeatedInput');
		var agb = document.getElementById("agbCheck");
		var isOk = true;
		
		username.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("usernameError").style.visibility = "collapse";
		firstname.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("firstnameError").style.visibility = "collapse";
		lastname.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("lastnameError").style.visibility = "collapse";
		email.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("emailError").style.visibility = "collapse";
		password1.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("password1Error").style.visibility = "collapse";
		password2.style.borderColor = "rgba(255, 255, 255, 0.8)";
		document.getElementById("password2Error").style.visibility = "collapse";
		
		
		if(username.value == ""){
			username.style.borderColor = "red";
			document.getElementById("usernameError").style.visibility = "visible";
			document.getElementById("usernameErrorMessage").innerHTML = "Benutzername ungültig"
			isOk = false;
		}
		
		if(firstname.value == ""){
			firstname.style.borderColor = "red";
			document.getElementById("firstnameError").style.visibility = "visible";
			document.getElementById("firstnameErrorMessage").innerHTML = "Vorname ungültig"
			isOk = false;
		}
		
		if(lastname.value == ""){
			lastname.style.borderColor = "red";
			document.getElementById("lastnameError").style.visibility = "visible";
			document.getElementById("lastnameErrorMessage").innerHTML = "Nachname ungültig"
			isOk = false;
		}
		
		if(email.value == ""){
			email.style.borderColor = "red";
			document.getElementById("emailError").style.visibility = "visible";
			document.getElementById("emailErrorMessage").innerHTML = "E-Mail ungültig"
			isOk = false;
		}
		
		if(password1.value != password2.value){
			password1.style.borderColor = "red";
			password2.style.borderColor = "red";
			document.getElementById("password2Error").style.visibility = "visible";
			document.getElementById("password2ErrorMessage").innerHTML = "Passwörter nicht identisch"
			isOk = false;
		}
		
		if(password1.value == ""){
			password1.style.borderColor = "red";
			document.getElementById("password1Error").style.visibility = "visible";
			document.getElementById("password1ErrorMessage").innerHTML = "Passwort ungültig"
			isOk = false;
		}
		
		if(password2.value == ""){
			password2.style.borderColor = "red";
			document.getElementById("password2Error").style.visibility = "visible";
			document.getElementById("password2ErrorMessage").innerHTML = "Passwort ungültig"
			isOk = false;
		}
		
		if(agb.value == false){
			document.getElementById("agbErrorMessage").innerHTML = "Bitte AGBs akzeptieren"
			alert("test");
		}
		
		
		return isOk;
	}
</script>
		
	
	

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
				<td><input id="usernameInput" class="textInput" name="username" type="text"
					value="${userBean.username}"></td>
			</tr>
			<tr id="usernameError" class="errorMessages">
				<td></td><td><span id="usernameErrorMessage" style="padding-left:20px"></span></td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td><input id="firstnameInput" class="textInput" name="firstname" type="text"
					value="${userBean.firstname}"></td>
			</tr>
			<tr id="firstnameError" class="errorMessages">
				<td></td><td><span id="firstnameErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td><input id="lastnameInput"class="textInput" name="lastname" type="text"
					value="${userBean.lastname}"></td>
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
				<td><input id="passwordInput" class="textInput" name="password" type="password"
					value="${userBean.password}"></td>
			</tr>
			<tr id="password1Error" class="errorMessages">
				<td></td><td><span id="password1ErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td>Passwort wiederholen:</td>
				<td><input id="passwordRepeatedInput" class="textInput" name="passwordRepeated"
					type="password" value="${userBean.passwordRepeated}"></td>
			</tr>
			<tr id="password2Error" class="errorMessages">
				<td></td><td><span id="password2ErrorMessage" style="padding-left:20px">Benutzername ungültig</span></td>
			</tr>
			<tr>
				<td id="agbErrorMessage" class="errorMessages"></td>
				<td><span id="agbCheck" class="agb">Ich akzeptiere die AGB.<input
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