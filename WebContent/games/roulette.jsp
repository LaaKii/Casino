<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<jsp:useBean id="transactionBean"
	class="de.casino.com.database.TransactionBean"
	scope="request" />

<html>
	<head>
		<title>login</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/index.css">		
		<script src="https://code.jquery.com/jquery-1.10.2.js"
		type="text/javascript"></script>
		<script src="javascript/ajaxx.js" type="text/javascript"></script>
		<script>
		
		var black = [2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35];
		
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
			data.innerHTML = "2to1"
			data.style.width = "80px";
			data.id = "2to1row" + i;
			data.setAttribute("class", "click");
			document.getElementById("row" + i).appendChild(data);
		}
		
		var elem = document.getElementsByClassName("click");;
		for(var i = 0; i < elem.length; i++){
			elem[i].addEventListener("click", clickEvent);
			
		}
		
		}
		
		var chosenNums = [];
		function clickEvent(){
			
			
			
			var bet = document.getElementById("betInput").value;
			var profit = document.getElementById("profitValue");
			var winFactor = 1;
			var id = this.id;
			
			if(id.indexOf("num") != -1){
				var elem = document.getElementsByClassName("click");
				for(var i = 0; i < elem.length; i++){
					elem[i].style.fontWeight = "normal";
					elem[i].style.color = "white";
				}
				chosenNums.push(id.innerHTML);
				winFactor = 36 / chosenNums.length;
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
				chosenNums = [];
			
			switch(id){
			case "black":	winFactor = 2;
							break;
			case "red":		winFactor = 2;
							break;
			case "even":	winFactor = 2;
							break;
			case "odd":		winFactor = 2;
							break;
			case "1-18":	winFactor = 2;
							break;
			case "19-36":	winFactor = 2;
							break;
			case "1-12":	winFactor = 3;
							break;
			case "13-24":	winFactor = 3;
							break;
			case "25-36":	winFactor = 3;
							break;
			case "2to1row2":	winFactor = 3;
						break;
			case "2to1row3":	winFactor = 3;
						break;
			case "2to1row4":	winFactor = 3;
						break;
			}
			}
			this.style.color = "yellow";
			this.style.fontWeight = "bold";
			profitValue.innerHTML = Math.round(bet * winFactor) + "$";
			
			
			//alert(this);
		}

		function start(){
			var style =  document.createElement("style");
			var rotate = ".rotate{animation: rotation 2s 1 linear;animation-fill-mode:both;}";
			style.innerHTML = rotate;
			document.getElementsByTagName("head")[0].appendChild(style);
			
			document.getElementById("wheel").setAttribute("class", "rotate");
			
			
			/*for(var i = 0; i < 101; i++){
				if(i < 100){
					setTimeout(function(){
						setSpeed(2 + (0.1 * i));
					}, 2000 + (50*i));
				}
				else{
					setTimeout(function(){
						setSpeed(20);
					}, 2000 + (50*i));
				}
			}*/

		}
		
		function move(){
			setSpeed(++v);
		}
		</script>
		
		
		
		
		<style>
		
			#bet{
				position:absolute;
				bottom:30px;
				right:400px;
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
				margin-top:10px;
			}
			
			#profit{
				position:absolute;
				bottom:30px;
				right:30px;
				background-color:rgba(255,255,255,0.9);
				border-radius:30px;
				padding:20px;
				font-size:30px;
				text-align:center;
			}
			
			#profitValue{
				//background-color:white;
				//border-radius:30px;
			}
		
			#wheel{
				position:absolute;		
				top:50px;
				left:50px;
			}
			

			#table {
				margin-top:50px;
				height:700px;
				width:1200px;
				background-color:green;
				position:absolute;
				margin-left:auto;
				margin-right:auto;
				left:0px;
				right:0px;
				border:8px solid rgb(77, 51, 0);
				border-radius:30px;
			}
			
			td{
				border:3px solid white;
				
			}
			
			#numTable{
				 border-collapse: collapse;
				 Color:white;
				 text-align:center;
				 font-size:25px;
				 position:absolute;
				 top:50px;
				 right:50px;
			}
			
			.num{
				
				width:50px;
				padding:0px;
			}
			
			#numTable tr td:hover{
				color:yellow;
				cursor:pointer;
			}
			
			#startButton{
				position:absolute;
				bottom:50px;
				left:50px;
			}
			
			
			@keyframes rotation {
				from{
					transform:rotate(0deg);
				}
				to{
					transform:rotate(3590deg);
				}
			}
			
		</style>
	</head>
	
	<body class="basicBody">
	<div id="table">
	<div id="bet">
	Einsatz:<br>
	<input id="betInput" value="100">$
	</div>
	
	<div id="profit">
	Gewinn:<br>
	<span id="profitValue">-</span>
	</div>
	<table id="numTable">
		<tr id="row1">
		<td id="1-12" class="click" colspan="4">1-12</td>
		<td id="13-24" class="click" colspan="4">13-24</td>
		<td id="25-36" class="click" colspan="4">25-36</td>
		</tr>
		<tr id="row2"></tr>
		<tr id="row3"></tr>
		<tr id="row4"></tr>
		<tr id="row5">
		<td id="1-18" class="click" colspan="2">1-18</td>
		<td id="even" class="click" colspan="2">Even</td>
		<td id="red" class="click" colspan="2">red</td>
		<td id="black" class="click" colspan="2">black</td>
		<td id="odd" class="click" colspan="2">odd</td>
		<td id="19-36" class="click" colspan="2">19-36</td>
		</tr>
	</table>
		<img id="wheel" height="250" width="250" src="${pageContext.request.contextPath}/Ressources/roulette.png">
		<button class="basicButton" id="startButton" onclick="start()">Spiel starten</button>
	</div>
		
		
	</body>
</html>