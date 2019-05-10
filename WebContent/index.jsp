<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<title>login</title>
		<meta charset="utf-8">
		
		<style>
			body {
				background-image:url("Ressources/casino.jpg");
			}
			
			
			h1.header {
				text-align:center;
				margin:auto;
				width:100%;
				padding:2vw 0px;
				font-size:5vw;
				font-family:Verdana;
				letter-spacing:1.8vw;
				background-color:rgba(255,255,255,0.8);
				border-radius:25px;
			}
			
			form.content {
				margin-top:10vw;
			}
			
			table.content {
				background-color:rgba(255,255,255,0.8);
				border-radius:25px;
				padding:1vw;
				margin:auto;
				font-size:1.5vw;
				font-family:Verdana;
				text-align:right;
			}
			
			input.content {
				font-size:1.2vw;
				padding:0.5vw 2vw;
				border-style:none;
				margin-left:2vw;
				border-radius:25px;
			}
			
			#forgetpw {
				text-align:center;
				font-size:20px;
				padding-top:20px;
				
			}
			
			a{text-decoration:none}
			
			button {
				border:solid 2px grey;
				padding:1vw 1vw;
				border-radius:3vw;
				font-size:2vw;
				margin-top:10px;
				cursor:pointer;
				border
			}
			
			button:hover {
				background-color:grey;
				color:white;
			}
		
		</style>
	</head>
	<body>
		<h1 class="header">PEPNIS-CASINO</h1>
		<form class="content">
			<table class="content">
				<tr>
					<th>Benutzername:</th>
					<td><input type="text" class="content"></td>
				</tr>
				<tr>
					<th>Passwort:</th>
					<td><input type="password" class="content"></td>
				</tr>
				<tr>
					<th><button>Registrieren</button></th>
					<td><button>Anmelden</button></td>
				</tr>
				<tr>
					<th colspan="2" id="forgetpw"><a href=#>Passwort vergessen?</a></th>
				</tr>
			</table>
		</form>
	</body>
</html>