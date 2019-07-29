var slot;
	var counter0, counter1, counter2;
	var maxCounts0, maxCounts1, maxCounts2;
	var interval0, interval1, interval2;
	
	window.onload = function(){
		loadKontostand();
		slot = document.getElementsByClassName("slots");
		for(var i = 0; i < slot.length; i++){
		
		switch(getRandomNum() % 5){
		case 0:	slot[i].src = "../Ressources/slotmachine/cherry.png";
				break;
		case 1:	slot[i].src = "../Ressources/slotmachine/lemon.png";
				break;
		case 2:	slot[i].src = "../Ressources/slotmachine/grape.png";
				break;
		case 3:	slot[i].src = "../Ressources/slotmachine/bell.png";
				break;
		case 4:	slot[i].src = "../Ressources/slotmachine/seven.png";
				break;
		default:break;
	}
	}
		function loadKontostand(){
			$.get("/Casino/KontoServlet", function(responseText) { 
				$("#balance").text(responseText + "$"); 
			});
		}
		
		function updateKonto(amount){
			$.get("/Casino/TransactionServlet?amount="+ amount, function(responseText) { 
				$("#balance").text(responseText + "$"); 
			});
			loadKontostand();
		}
		
		
		
		var imageNames = ["cherry", "lemon", "grape", "bell", "seven"];
		var winRates = ["20", "50", "100", "1000", "10000"];
		for(var i = 0; i < 5; i++){
			var tr = document.createElement("tr");
			
			var td = document.createElement("td");
			for(var j = 0; j < 3; j++){
				var img = document.createElement("img");
				img.src = "../Ressources/slotmachine/" + imageNames[i] + ".png";
				img.setAttribute("class", "smallImg");
				td.appendChild(img);
			}
			tr.appendChild(td);
			
			var td = document.createElement("td");
			td.innerHTML = "=";
			tr.appendChild(td);
			
			var td = document.createElement("td");
			td.innerHTML = "Einsatz x " + winRates[i];
			tr.appendChild(td);
			document.getElementById("table2").appendChild(tr);
		}
		
		
	}
	
	function startSlot(num) {
		
		if(num == 0){
			counter0 = 0;
			maxCounts0 = 40 + getRandomNum();
			interval0 = setInterval(spinSlot0, 30);
		}
		else if(num == 1){
			counter1 = 0;
			maxCounts1 = 40 + getRandomNum();
			interval1 = setInterval(spinSlot1, 30);
		}
		else{
			counter2 = 0;
			maxCounts2 = 40 + getRandomNum();
			interval2 = setInterval(spinSlot2, 30); 
		}
	}
	
	function getRandomNum(){
		var img0 = 35, img1 = 65, img2 = 85, img3 = 95, img4 = 100;
		var num = Math.floor(Math.random() * 100) + 1;
		if(num < img0){
			return 0;
		}
		else if(num < img1){
			return 1;
		}
		else if(num < img2){
			return 2;
		}
		else if(num < img3){
			return 3;
		}
		else{
			return 4;
		}
		
	}
	
	function start(){
		var startButton = document.getElementById("startButton");
		startButton.classList.add("disabledButton");
		startButton.disabled = true;
		startSlot(0);
	}
	
	function spinSlot0() {
		switch(counter0 % 5){
			case 0:	slot[0].src = "../Ressources/slotmachine/cherry.png";
					break;
			case 1:	slot[0].src = "../Ressources/slotmachine/lemon.png";
					break;
			case 2:	slot[0].src = "../Ressources/slotmachine/grape.png";
					break;
			case 3:	slot[0].src = "../Ressources/slotmachine/bell.png";
					break;
			case 4:	slot[0].src = "../Ressources/slotmachine/seven.png";
					break;
			default:break;
		}
		counter0++;
		if(counter0 == 10){
			startSlot(1);
		}
		if(counter0 > maxCounts0){
			clearInterval(interval0);
		}
	}
	
	function spinSlot1() {
		switch(counter1 % 5){
		case 0:	slot[1].src = "../Ressources/slotmachine/cherry.png";
				break;
		case 1:	slot[1].src = "../Ressources/slotmachine/lemon.png";
				break;
		case 2:	slot[1].src = "../Ressources/slotmachine/grape.png";
				break;
		case 3:	slot[1].src = "../Ressources/slotmachine/bell.png";
				break;
		case 4:	slot[1].src = "../Ressources/slotmachine/seven.png";
				break;
		default:break;
	}
		counter1++;
		if(counter1 == 10){
			startSlot(2);
		}
		if(counter1 > maxCounts1){
			clearInterval(interval1);
		}
	}
	
	function spinSlot2() {
		switch(counter2 % 5){
		case 0:	slot[2].src = "../Ressources/slotmachine/cherry.png";
				break;
		case 1:	slot[2].src = "../Ressources/slotmachine/lemon.png";
				break;
		case 2:	slot[2].src = "../Ressources/slotmachine/grape.png";
				break;
		case 3:	slot[2].src = "../Ressources/slotmachine/bell.png";
				break;
		case 4:	slot[2].src = "../Ressources/slotmachine/seven.png";
				break;
		default:break;
	}
		counter2++;
		if(counter2 > maxCounts2){
		
			clearInterval(interval2);
			getResult();
		}
	}
	
	function getResult(){
		if(maxCounts0 == maxCounts1 && maxCounts0 == maxCounts2){
			var profit;
			var bet = document.getElementById("betInput").value;
			switch(maxCounts0 % 5){
			case 0:	profit = bet * 20;
					break;
			case 1:	profit = bet * 50;
					break;
			case 2:	profit = bet * 100;
					break;
			case 3:	profit = bet * 1000;
					break;
			case 4:	profit = bet * 10000;
					break;
			default:break;
				}
			document.getElementById("result").innerHTML = profit + "$ gewonnen!";
			updateKonto(profit);
		}
		else{
			var bet = document.getElementById("betInput").value;
			updateKonto("-" + profit);
			document.getElementById("result").innerHTML = "verloren" ;
		}
		
		var startButton = document.getElementById("startButton");
		startButton.classList.remove("disabledButton");
		startButton.disabled = false;
	}