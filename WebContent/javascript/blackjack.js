	var playerCards = 0, dealerCards = 0;
	var secondDealerCardImage = "";
	var amount = 0;
	var bet;
	

	
	function loadKontostand(){
		$.get("/Casino/KontoServlet", function(responseText) { 
			$("#balance").text(responseText + "$"); 
		});
	}
	
	$(document).ready(function() {
		loadKontostand();
	});
	
	function updateKonto(){
		$.get("/Casino/TransactionServlet?amount="+amount, function(responseText) { 
			$("#balance").text(responseText + "$"); 
		});
		loadKontostand();
	}
	
	$(document).ready(function() {
		$("#startButton").click(function(){
			loadKontostand();
			bet = document.getElementById("betInput").value;
			amount = -1*bet;
			updateKonto();
			loadKontostand();
			document.getElementById("startGameBox").style.visibility = "hidden";
			document.getElementById("userInput").style.visibility = "visible";
			document.getElementById("placedBet").style.visibility = "visible";
			document.getElementById("placedBetValue").innerHTML = bet + "$";
			$.get("/Casino/BlackJackServlet?game=go", function(responseText) {
				console.log(responseText);
				var arrayOfStrings = responseText.split(";");
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					
					if(temp[0].indexOf("dealercard") != -1){
						getDealerCard(temp[1]);
					}
					
					else if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
					
					else if(temp[0].indexOf("playerCardValue") != -1){
						document.getElementById("playerHandValue").innerHTML = temp[1];
					}
					else if(temp[0].indexOf("dealerCardValueHidden") != -1){
						document.getElementById("dealerHandValue").innerHTML = temp[1];
					}
					else if(temp[0].indexOf("BlackJack") != -1){
						turnDealerCard();
						document.getElementById("startGameBox").style.visibility = "visible";
						document.getElementById("placedBet").style.visibility = "hidden";
					}
					
				}
			});
		});
	});
	

	$(document).ready(function() {
		$("#hitButton").click(function(){
			$.get("/Casino/BlackJackServlet?game=hit", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
					else if(temp[0].indexOf("playerCardValue") != -1){
						document.getElementById("playerHandValue").innerHTML = temp[1];
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
				console.log(responseText);
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					if(temp[0].indexOf("dealercard") != -1){
						getDealerCard(temp[1]);
					}

					else if(temp[0].indexOf("dealerCardValue") != -1){
						document.getElementById("dealerHandValue").innerHTML = temp[1];
					}
					else if(temp[0].indexOf("PlayerWins") != -1){
						amount = bet*2;
						updateKonto();
						loadKontostand();
					}
					else if(temp[0].indexOf("TieGame") != -1){
						amount = bet;
						updateKonto();
						loadKontostand();
					}
				}
				document.getElementById("startGameBox").style.visibility = "visible";
				document.getElementById("placedBet").style.visibility = "hidden";
				
			});
		});	
	})
	
	$(document).ready(function() {
		$("#doubleButton").click(function(){
			loadKontostand();
			bet = document.getElementById("betInput").value;
			amount = -1*bet;
			updateKonto();
			loadKontostand();
			$.get("/Casino/BlackJackServlet?game=double", function(responseText) { 
				var arrayOfStrings = responseText.split(";");
				for(i in arrayOfStrings){
					var temp = arrayOfStrings[i].split("=");
					
					if(temp[0].indexOf("dealercard") != -1){
						getDealerCard(temp[1]);
					}
					
					else if(temp[0].indexOf("playercard") != -1){
						getPlayerCard(temp[1]);
					}
					else if(temp[0].indexOf("playerCardValue") != -1){
						document.getElementById("playerHandValue").innerHTML = temp[1];
					}
					else if(temp[0].indexOf("dealerCardValue") != -1){
						document.getElementById("dealerHandValue").innerHTML = temp[1];
					}
					else if(temp[0].indexOf("PlayerWins") != -1){
						amount = bet*4;
						updateKonto();
						loadKontostand();
					}
					else if(temp[0].indexOf("TieGame") != -1){
						amount = bet;
						updateKonto();
						loadKontostand();
					}
					
				}
			});
			
			turnDealerCard();
			document.getElementById("startGameBox").style.visibility = "visible";
			document.getElementById("placedBet").style.visibility = "hidden";
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
		
		function removeCards(){
			var images = document.getElementById("table").getElementsByTagName("img");
			for(var i = 0; i < images.length; i++){
				images[i].remove();
			}
		}
	}