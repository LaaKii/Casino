<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<title>registration</title>
		<meta charset="utf-8">
		
		<style>
			body {
				background-image:url("../Ressources/casino.jpg");
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
				margin-top:60px;
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
			
			input {
				font-size:25px;
				padding:10px 20px;
				border-style:none;
				margin-left:10px;
				border-radius:30px;
			}
			
			tr {
				height:90px;
			}
			
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
			
			#agb {
				font-size:20px;
				border:solid 2px black;
				border-radius:30px;
				padding:10px 15px;
			}
			#tablehead {
				text-align:center;
				font-size:40px;
				font-weight:bold;
				height:70px;
			}
			

		
		</style>
	</head>
	<body>
		<h1 class="header">PEPNIS-CASINO</h1>
		
		<form class="content">
			<table class="content">
				<tr id="tablehead">
					<td colspan="2" >Registration</td>
				</tr>
				<tr>
					<td>Benutzername:</td>
					<td><input type="text"></td>
				</tr>
				<tr>
					<td>E-Mail:</td>
					<td><input type="email"></td>
				</tr>
				<tr>
					<td>Passwort:</td>
					<td><input type="password"></input></td>
				</tr>
				<tr>
					<td>Passwort wiederholen:</td>
					<td><input type="password"></input></td>
				</tr>
				<tr>
					<td></td>
					<td><span id="agb">Ich akzeptiere die AGB.<input type="checkbox"></input></span></td>
				</tr>
				<tr>
					<td style="text-align:left"><button>Zur�ck zum Login</button></td>
					<td><button>Absenden</button></td>
				</tr>
			</table>
		</form>
	</body>
</html>