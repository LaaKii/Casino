<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackjack</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script>

	var playerCards = 0, dealerCards = 0;
	var secondDealerCardImage = "";
	
	
	
	
	$(document).ready(function() {
		$("#startButton").click(function(){
			var bet = document.getElementById("betInput").value;
			document.getElementById("startGameBox").style.visibility = "hidden";
			document.getElementById("userInput").style.visibility = "visible";
			document.getElementById("placedBet").style.visibility = "visible";
			document.getElementById("placedBetValue").innerHTML = bet + "$";
			$.get("/Casino/BlackJackServlet?game=go", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					
					if(temp[0].indexOf("dealercard") != -1){
						getDealerCard(temp[1]);
					}
					
					else if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
				}
			});
		});
	});
	

	$(document).ready(function() {
		$("#hitButton").click(function(){
			$.get("/Casino/BlackJackServlet?game=hit", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				alert(responseText);
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
				}
			});
		});
	});
	
	$(document).ready(function(){
		$("#stayButton").click(function(){
			turnDealerCard();
			$.get("/Casino/BlackJackServlet?game=stay", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				alert(responseText);
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					if(temp[0].indexOf("dealercard") != -1){
						getDealerCard(temp[1]);
					}
				}
			});
		});	
	})
	
	$(document).ready(function() {
		$("#doubleButton").click(function(){
			$.get("/Casino/BlackJackServlet?game=double", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				alert(responseText);
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
				}
			});
			turnDealerCard();
		});
	});
	
	function getPlayerCard(image){
		var card = document.createElement("img");
		card.src = "../Ressources/cardImages/KartenDeckImages/allcards/card_back.png";
		card.style.height = "150px";
		card.style.width = "100px";
		card.style.top = "300px";
		card.style.right = "20px";
		card.style.position = "absolute";
		document.getElementById("table").appendChild(card);
		moveTo(card, 450 - (playerCards * 20), 500 - (playerCards++ * 20), image);

	}
	
	function getDealerCard(image){
		var card = document.createElement("img");
		if(dealerCards == 1){
			secondDealerCardImage = image;
			image = "card_back";
			card.id = "secondDealerCard";
		}
		card.src = "../Ressources/cardImages/KartenDeckImages/allcards/card_back.png";
		card.style.height = "150px";
		card.style.width = "100px";
		card.style.top = "300px";
		card.style.right = "20px";
		card.style.position = "absolute";
		document.getElementById("table").appendChild(card);
		moveTo(card, 450 - (dealerCards++ * 30), 50, image);	
		
	}
	
	function turnDealerCard(){
		if(dealerCards == 2){
			document.getElementById("secondDealerCard").src = "../Ressources/cardImages/KartenDeckImages/allcards/" + secondDealerCardImage + ".png";
		}
	}
	
	function moveTo(elem, targetX, targetY, image){
		var posX = parseInt(elem.style.right);	
		var posY = parseInt(elem.style.top);
		var stepX = (targetX - posX) / 50;
		var stepY = (targetY - posY) / 50;
		
		
		var id = setInterval(frame, 1);
		
		
		
		function frame() {
			
			if(stepX > 0 && stepY > 0){
			    if (posX >= targetX || posY >= targetY) {
					clearInterval(id);
					elem.src = "../Ressources/cardImages/KartenDeckImages/allcards/" + image + ".png";
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX > 0 && stepY < 0){
			    if (posX >= targetX || posY <= targetY) {
					clearInterval(id);
					elem.src = "../Ressources/cardImages/KartenDeckImages/allcards/" + image + ".png";
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX < 0 && stepY < 0){
			    if (posX <= targetX || posY <= targetY) {
					clearInterval(id);
					elem.src = "../Ressources/cardImages/KartenDeckImages/allcards/" + image + ".png";
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX < 0 && stepY > 0){
			    if (posX <= targetX || posY >= targetY) {
					clearInterval(id);
					elem.src = "../Ressources/cardImages/KartenDeckImages/allcards/" + image + ".png";
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			    
			    
		    elem.style.top = posY + 'px';
		    elem.style.right = posX + 'px';
		  }
	}
</script>
<style>
.animation {
	animation-duration: 5s;
	animation-name: move;
}

@
keyframe move {from { top:300px;
	right: 20px;
}

to {
	
}

}
#table {
	margin-top: 50px;
	height: 700px;
	width: 1000px;
	background-color: green;
	position: absolute;
	margin-left: auto;
	margin-right: auto;
	left: 0px;
	right: 0px;
	border: 8px solid rgb(77, 51, 0);
	border-radius: 30px;
}

#cardDeck {
	position: absolute;
	right: 20px;
	top: 300px;
}

#userInput {
	position: absolute;
	bottom: 40px;
	left: 40px;
	text-align: center;
	visibility: hidden;
}

#playerCards {
	height: 180px;
	width: 130px;
	border: 4px solid grey;
	position: absolute;
	top: 482px;
	right: 432px;
	border-radius: 30px;
}

#dealerCards {
	height: 180px;
	width: 130px;
	border: 4px solid grey;
	position: absolute;
	top: 32px;
	right: 432px;
	border-radius: 30px;
}

#header {
	margin-top: 100px;
	opacity: 0.4;
}

#startGameBox {
	position: absolute;
	top: 500px;
	right: 20px;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	border-radius: 30px;
	text-align: center;
	font-size: 30px;
}

#betInput {
	border-style: none;
	font-size: 30px;
	width: 80px;
	margin-left: 10px;
	padding: 10px 20px;
	border-radius: 30px;
}

#startButton {
	margin-top: 30px;
}

#balance {
	position: absolute;
	top: 20px;
	left: 20px;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.9);
	border-radius: 30px;
	font-size: 40px;
}

#placedBet {
	position: absolute;
	bottom: 30px;
	right: 80px;
	visibility: hidden;
	font-size: 30px;
}

.playButton {
	margin: 10px 0px;
	width: 200px;
}
</style>
</head>
<body class="basicBody">
	<div id="table">
		<img id="header" src="../Ressources/blackjack_header.png"> <img
			id="cardDeck"
			src="../Ressources/cardImages/KartenDeckImages/card.png"
			height="150px" width="100px">
		<div id="playerCards"></div>
		<div id="dealerCards"></div>
		<div id="balance">5000$</div>
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
			<button id="stayButton" class="basicButton playButton"">Stay</button>
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