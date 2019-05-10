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
				padding:20px 0px;
				font-size:90px;
				font-family:Verdana;
				letter-spacing:15px;
				background-color:rgba(255,255,255,0.8);
				border-radius:30px;
			}
			
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
		<form action="" class="content">
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