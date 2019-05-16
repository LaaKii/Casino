<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>registration</title>
<meta charset="utf-8">
<link rel="stylesheet" href="../Stylesheets/basic.css">
<link rel="stylesheet" href="../Stylesheets/signup.css">
</head>
<body class="basicBody">
	<h1 class="basicHeader">PEPNIS-CASINO</h1>
	<form class="content" method="get" action="../RegistrationServlet">
		<table class="content">
			<tr id="tablehead">
				<td colspan="2">Registration</td>
			</tr>
			<tr>
				<td>Benutzername:</td>
				<td><input class="content" name="username" type="text"
					value="${userBean.username}"></td>
			</tr>
			<tr>
				<td>Vorname:</td>
				<td><input class="content" name="firstname" type="text"
					value="${userBean.firstname}"></td>
			</tr>
			<tr>
				<td>Nachname:</td>
				<td><input class="content" name="lastname" type="text"
					value="${userBean.lastname}"></td>
			</tr>
			<tr>
				<td>E-Mail:</td>
				<td><input class="content" name="email" type="email"
					value="${userBean.email}"></td>
			</tr>
			<tr>
				<td>Passwort:</td>
				<td><input class="content" name="password" type="password"
					value="${userBean.password}"></td>
			</tr>
			<tr>
				<td>Passwort wiederholen:</td>
				<td><input class="content" name="passwordRepeated"
					type="password" value="${userBean.password}"></td>
			</tr>
			<tr>
				<td></td>
				<td><span class="agb">Ich akzeptiere die AGB.<input
						name="agb" type="checkbox"></input></span></td>
			</tr>
			<tr>
				<td style="text-align: left"><a class="basicButton"
					href="../index.jsp">Zurück zum Login</a></td>
				<td><button class="basicButton" name="signin" type="submit">Absenden</button></td>
			</tr>
		</table>
	</form>
</body>
</html>