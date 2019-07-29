<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slotmachine</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
</head>
<script>

	var slot;
	var counter0, counter1, counter2;
	var maxCounts0, maxCounts1, maxCounts2;
	var interval0, interval1, interval2;
	
	window.onload = function(){
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
		}
		else{
			document.getElementById("result").innerHTML = "verloren" ;
		}
		
		var startButton = document.getElementById("startButton");
		startButton.classList.remove("disabledButton");
		startButton.disabled = false;
	}

</script>
<style>
	
	
	#slotMachine{
		position:relative;
		left:50px;
		top:50px;
		height:500px;
		width:600px;
		background-color:red;
		border-radius:30px;
	}
	
	#result {
		position:absolute;
		width:300px;
		top:50px;
		left:150px;
		text-align:center;
		background-color:gray;
		font-size:30px;
		padding:10px 0px;
		border-radius:20px;
	}
	
	#slotWrapper {
		position:absolute;
		top:150px;
		left:50px;
		background-color:white;
		padding:20px;
		border-radius:30px;
	}
	
	#startButton{
		position:absolute;
		left:400px;
		top:400px;
		font-size:30px;
	}
	
	
	#table {
		margin-top:50px;
		height:600px;
		width:1200px;
		background-color:rgba(255,255,255,0.8);
		position:absolute;
		margin-left:auto;
		margin-right:auto;
		left:0px;
		right:0px;
		border-radius:30px;
	}
	
	#bet{
		position:absolute;
		bottom:30px;
		left:50px;
		background-color:rgba(255,255,255,0.9);
		border-radius:30px;
		padding:20px;
		font-size:30px;
	}
	
	#betInput{
		border-style:none;
		font-size:30px;
		width:80px;
		padding:10px 20px;
		border-radius:30px;
	}
	
	#combos{
		position:absolute;
		height:300px;
		width:450px;
		top:150px;
		right:50px;
	}
	
	#table2 {
		font-size:25px;
	}
	
	#table2 tr {
		height:70px;
	}
	
	#table2 tr td{
		padding:0px 5px;
	}
			
	.slots{
		height:150px;
		width:150px;
		float:left;
	}
	
	.smallImg {
		width:50px;
		height:50px;
	}
	
	.disabledButton{
		 opacity: 0.6;
		 cursor: not-allowed;
	}
	
	.disabledButton:hover {
		background-color:white;
		color:black;
	}
	
	#balance {
				position: absolute;
				top: 30px;
				right: 30px;
				padding: 20px;
				background-color: rgba(255, 255, 255, 0.9);
				border-radius: 30px;
				font-size: 40px;
			}

	
</style>
<body class="basicBody">
<div id="table">
<div id="balance">500$</div>
<div id="slotMachine">
<div id="result">slotmachine</div>
<button class="basicButton" id="startButton" onclick="start()">Start</button>
<div id="bet">
	Einsatz: 
	<input id="betInput" value="100">$
	</div>
<div id="slotWrapper">
	<img class="slots" id="slot0">
	<img class="slots" id="slot1">
	<img class="slots" id="slot2">
	</div>
	</div>
	<div id="combos">
		<table id="table2">
		
		</table>
	</div>
	</div>
</html>