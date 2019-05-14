<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="request" />

<html>
	<head>
		<title>login</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="Stylesheets/Header.css">
		
		<style>			
			form.content {
				margin-top:200px;
			}
			
			table.content {
				background-color:rgba(255,255,255,0.8);
				border-radius:30px;
				padding:15px;
				margin:auto;
				font-size:30px;
				font-family:Verdana;
				text-align:right;
			}
			
			tr {
				height:70px;
			}
			
			input.content {
				font-size:25px;
				padding:10px 20px;
				border-style:none;
				margin-left:10px;
				border-radius:30px;
			}
			
			#forgetpw {
				text-align:center;
				font-size:20px;
				padding-top:10px;
			}
			
			a{text-decoration:none}
			
			button {
				border:solid 2px grey;
				padding:10px 20px;
				border-radius:30px;
				font-size:25px;
				margin-top:20px;
				cursor:pointer;
			}
			
			button:hover {
				background-color:grey;
				color:white;
			}
		
		</style>
	</head>
	<body>
		<h1 class="header">PEPNIS-CASINO</h1>
		<form method="get" action="UserServlet">
			<table class="content">
				<tr>
					<th>Benutzername:</th>
					<td><input name="username" type="text" value="${userBean.username}"></td>
				</tr>
				<tr>
					<th style="text-align:right">Passwort:</th>
					<td><input name="password" type="text" value="${userBean.password}"></td>
				</tr>
				<tr>
					<td style="text-align:left"><button name="signup">Registrieren</button></td>
					<td><button name="signin" type="submit">Anmelden</button></td>
				</tr>
				<tr>
					<th colspan="2" id="forgetpw"><a href=#>Passwort vergessen?</a></th>
				</tr>
			</table>
		</form>
	</body>
</html>