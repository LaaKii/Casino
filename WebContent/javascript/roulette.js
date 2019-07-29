var black = [2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35];
		var red = [1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36];
		var wheelNums = [0,26,3,35,12,28,7,29,18,22,9,31,14,20,1,33,16,24,5,10,23,8,30,11,36,13,34,6,27,17,25,2,21,4,19,15,32,0];
		var lastAngle = 323;
		
		window.onload = function(){
			
		for(var i = 2; i < 5;i++){
			for(var j = 1; j < 13;j++){
				var data = document.createElement("td");
				var num = (3 * j) - (i - 2);
				if(black.indexOf(num) != -1){
					data.style.backgroundColor = "black";
				}
				
				else{
					data.style.backgroundColor = "red";
				}
				data.innerHTML = num;
				data.setAttribute("class", "num");
				data.id = "num" + num;
				document.getElementById("row" + i).appendChild(data);
				data.addEventListener("click", clickEvent);
			}
			var data = document.createElement("td");
			data.innerHTML = "2to1";
			data.style.width = "80px";
			data.id = "2to1row" + i;
			data.setAttribute("class", "click");
			document.getElementById("row" + i).appendChild(data);
		}
		
		var elem = document.getElementsByClassName("click");;
		for(var i = 0; i < elem.length; i++){
			elem[i].addEventListener("click", clickEvent);
			
		}
		var startButton = document.getElementById("startButton");
		startButton.classList.add("disabledButton");
		startButton.disabled = true;
		}
		
		
		$(document).ready(function() {
			loadKontostand();
		});
		
		function loadKontostand(){
			alert("in update konto");
			$.get("/Casino/KontoServlet", function(responseText) { 
				$("#balance").text(responseText + "$"); 
			});
		}
		
		var chosenNums = [];
		var check = false;
		var bet = 100;
		var profit = document.getElementById("profitValue");
		var winFactor = 0;
		var amount = 0;
		
		function updateKonto(){
			// var amount = Math.round(bet * winFactor);
			alert("in update konto");
			$.get("/Casino/TransactionServlet?amount="+amount, function(responseText) { 
				$("#balance").text(responseText + "$"); 
			});
			loadKontostand();
		}
		
		
		function clickEvent(){
			
			bet = document.getElementById("betInput").value;
			var id = this.id;
			
			if(check)chosenNums = [];
			check = false;
			
			if(id.indexOf("num") != -1){
				var elem = document.getElementsByClassName("click");
				for(var i = 0; i < elem.length; i++){
					elem[i].style.fontWeight = "normal";
					elem[i].style.color = "white";
				}
				var num = Number(this.innerHTML);
				if(chosenNums.indexOf(num) != -1){
					chosenNums.splice(chosenNums.indexOf(num), 1);
					if(chosenNums.length != 0){
					winFactor = 36 / chosenNums.length;
					}
					else{
						winFactor = 0;
					}
					this.style.color = "white";
					this.style.fontWeight = "normal";
				}
				else{
					chosenNums.push(num);
					winFactor = 36 / chosenNums.length;
					this.style.color = "yellow";
					this.style.fontWeight = "bold";
				}
				
				
			}
			else{
				var elem = document.getElementsByClassName("num");
				for(var i = 0; i < elem.length; i++){
					elem[i].style.fontWeight = "normal";
					elem[i].style.color = "white";
				}
				var elem = document.getElementsByClassName("click");
				for(var i = 0; i < elem.length; i++){
					elem[i].style.fontWeight = "normal";
					elem[i].style.color = "white";
				}
				check = true;
				chosenNums = [];
			switch(id){
			case "black":	winFactor = 2;
							chosenNums = black;
							break;
			case "red":		winFactor = 2;
							chosenNums = red;
							break;
			case "even":	winFactor = 2;
							for(var i = 1; i < 37; i++){
								if(i % 2 == 0){
									chosenNums.push(i);
								}
							}
							break;
			case "odd":		winFactor = 2;
							for(var i = 1; i < 37; i++){
								if(i % 2 != 0){
									chosenNums.push(i);
								}
							}
							break;
			case "1-18":	winFactor = 2;
							for(var i = 1; i < 19; i++){
								chosenNums.push(i);
							}
							break;
			case "19-36":	winFactor = 2;
							for(var i = 19; i < 37; i++){
								chosenNums.push(i);
							}
							break;
			case "1-12":	winFactor = 3;
							for(var i = 1; i < 13; i++){
								chosenNums.push(i);
							}
							break;
			case "13-24":	winFactor = 3;
							for(var i = 13; i < 25; i++){
								chosenNums.push(i);
							}
							break;
			case "25-36":	winFactor = 3;
							for(var i = 25; i < 37; i++){
								chosenNums.push(i);
							}
							break;
			case "2to1row2":	winFactor = 3;
								for(var i = 1; i < 13; i++){
									chosenNums.push(i*3);
								}
								break;
			case "2to1row3":	winFactor = 3;
								for(var i = 1; i < 13; i++){
									chosenNums.push(i*3-1);
								}
								break;
			case "2to1row4":	winFactor = 3;
								for(var i = 1; i < 13; i++){
									chosenNums.push(i*3-2);
								}
								break;
			}
			this.style.color = "yellow";
			this.style.fontWeight = "bold";
			
			}
			var startButton = document.getElementById("startButton");
			if(chosenNums.length > 0){
				
				startButton.classList.remove("disabledButton");
				startButton.disabled = false;
			}
			else{
				startButton.classList.add("disabledButton");
				startButton.disabled = true;
			}
			
			profitValue.innerHTML = "Gewinn: " + Math.round(bet * winFactor) + "$";
			//document.getElementById("startButton").disabled = "false";
			
			//alert(this);
		}

		function start(){
			var result = document.getElementById("result");
			result.style.backgroundColor = "transparent";
			result.innerHTML = "";
			var wheel = document.getElementById("wheel");
			var angle = Math.floor(Math.random() * 360);
			var style =  document.createElement("style");
			style.id="animationStyle";
			var rotate = ".rotate{animation: rotation 5s 1 linear;animation-fill-mode:both;animation-timing-function: ease-out;}";
			var keyframe = "@keyframes rotation {from{transform:rotate(/startAngle/deg);}to{transform:rotate(/angle/deg);}}" + rotate;
			style.innerHTML = keyframe.replace("/angle/", 1800 + angle + 323).replace("/startAngle/", lastAngle);
			lastAngle = 323 + angle;
			document.getElementsByTagName("head")[0].appendChild(style);	
			wheel.addEventListener("animationend", wheelStop);
			wheel.setAttribute("class", "rotate");

		}
		
		function wheelStop(){
			document.getElementById("animationStyle").remove();
			var wheel = document.getElementById("wheel");
			wheel.style.transform = "rotate(" + lastAngle + "deg)";
			
			var temp = 360/37.0;
			var num = wheelNums[Math.round((lastAngle - 323) / temp)];
			var result = document.getElementById("result");
			result.innerHTML = num;
			if(black.indexOf(num) != -1){
				result.style.backgroundColor = "black";
			}
			else if(red.indexOf(num != -1)){
				result.style.backgroundColor = "red";
			}
			else{
				result.style.backgroundColor = "green";
			}
			if(chosenNums.indexOf(num) != -1){
				//this
				amount = Math.round(bet * winFactor) - bet;
				updateKonto();
			}
			else{
				//this
				amount = 0-bet;
				updateKonto();
			}
		}
		
		function refreshProfit(){
			bet = document.getElementById("betInput").value;
			profitValue.innerHTML = "Gewinn: " + Math.round(bet * winFactor) + "$";
		}
		
		/*$(document).ready(function(){
			function getBalance(){
				$.get("/Casino/TransactionServlet?game=stay", function(responseText) { 

				});
			});	
		})*/