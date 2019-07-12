<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackjack</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<script>

	var playerCards = 0;
	
	function getPlayerCard(cardName){
		var card = document.createElement("img");
		card.src = "../Ressources/cardImages/KartenDeckImages/Herz/" + cardName + ".png";
		card.style.height = "150px";
		card.style.width = "100px";
		card.style.top = "325px";
		card.style.right = "20px";
		card.style.position = "absolute";
		var table = document.getElementById("table");
		table.appendChild(card);
		moveTo(card, 450 - (playerCards * 20), 600 - (playerCards * 20));
		playerCards++;
	}
	
	function moveTo(elem, targetX, targetY){
		var posX = parseInt(elem.style.right);	
		var posY = parseInt(elem.style.top);
		var stepX = (targetX - posX) / 100;
		var stepY = (targetY - posY) / 100;
		
		
		var id = setInterval(frame, 1);
		
		
		
		function frame() {
			
			if(stepX > 0 && stepY > 0){
			    if (posX >= targetX || posY >= targetY) {
					clearInterval(id);
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX > 0 && stepY < 0){
			    if (posX >= targetX || posY <= targetY) {
					clearInterval(id);
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX < 0 && stepY < 0){
			    if (posX <= targetX || posY <= targetY) {
					clearInterval(id);
					}
			    else {
			    	posX += stepX;
			    	posY += stepY;
			    }
			}
			
			else if(stepX < 0 && stepY > 0){
			    if (posX <= targetX || posY >= targetY) {
					clearInterval(id);
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


#table {
	height:800px;
	width:1000px;
	background-color:green;
	position:absolute;
	margin-left:auto;
	margin-right:auto;
	left:0px;
	right:0px;
	border-radius:30px;
}

#cardDeck {
	height:150px;
	width:100px;
	background-color:yellow;
	position:absolute;
	right:20px;
	top:325px;
}

#userInput {
	position:absolute;
	bottom:40px;
	left:40px;
	text-align:center;
}

#playerCards{
	height:180px;
	width:130px;
	border:4px solid grey;
	position:absolute;
	top:582px;
	right:432px;
	border-radius:30px;
}

.playButton{
	margin:10px 0px;
}



</style>
</head>
<body class="basicBody">
<div id="table">
<div></div>
<div id="cardDeck"></div>
<div id="playerCards"></div>
<div id="dealerCards"></div>
<div id="userInput">
<button class="basicButton playButton" onclick="getPlayerCard('10_of_hearts')">Hit</button><br>
<button class="basicButton playButton">Double</button><br>
<button class="basicButton playButton">Stay</button><br>
</div>
</div>
</body>
</html>