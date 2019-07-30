<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackjack</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Stylesheets/basic.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/blackjack.css">
<script src="${pageContext.request.contextPath}/javascript/jquery.js" type="text/javascript"></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/blackjack.js'></script>
</head>
<body class="basicBody">
	<div id="table">
		<img id="header" src="../Ressources/blackjack_header.png"> <img
			id="cardDeck"
			src="../Ressources/cardImages/KartenDeckImages/card.png"
			height="150px" width="100px">
		<div id="playerCards"></div>
		<div id="playerHandValue">0</div>
		<div id="dealerHandValue">0</div>
		<div id="dealerCards"></div>
		<div id="balance"></div>
		<div id="placedBet">
			Einsatz: <span id="placedBetValue"></span>
		</div>
		<div id="startGameBox">
			<span>Einsatz:</span><input pattern="\d*" id="betInput" type="text"
				min="100" max="10000" step="100" value="100"><br>
			<button id="startButton" class="basicButton">Spiel starten</button>
		</div>
		<div id="userInput">
			<button id="hitButton" class="basicButton playButton">Hit</button>
			<br>
			<button id="doubleButton" class="basicButton playButton">Double</button>
			<br>
			<button id="stayButton" class="basicButton playButton">Stay</button>
			<br>
		</div>
	</div>
	<footer>
		<span class="basicFooter"> <a
			href="${pageContext.request.contextPath}/Mainmenu/mainmenu.jsp">Zurück</a>
		</span>
	</footer>
</body>
</html>