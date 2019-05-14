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
	<body class="basicBackground">
		<h1 class="basicHeader">PEPNIS-CASINO</h1>
		<form action="submit.jsp" class="content">
			<table class="content">
				<tr id="tablehead">
					<td colspan="2" >Registration</td>
				</tr>
				<tr>
					<td>Benutzername:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>E-Mail:</td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td>Passwort:</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td>Passwort wiederholen:</td>
					<td><input type="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><span id="agb">Ich akzeptiere die AGB.<input type="checkbox"></input></span></td>
				</tr>
				<tr>
					<td style="text-align:left"><a class="basicButton" href="../index.jsp">Zurück zum Login</a></td>
					<td><button class="basicButton" type="submit" name="submit">Absenden</button></td>
				</tr>
			</table>
		</form>
	</body>
</html>