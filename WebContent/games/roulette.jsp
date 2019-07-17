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
		function go(){
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
				data.addEventListener("mouseover", mouseoverEvent)
				document.getElementById("row" + i).appendChild(data);
			}
			var data = document.createElement("td");
			data.innerHTML = "2to1"
				document.getElementById("row" + i).appendChild(data);
		}
		}
		
		function mouseOver(){
			
		}

		function setSpeed(speed){
			var style =  document.createElement("style");
			var keyframes = ".rotate{animation: rotation duration infinite linear;animation-fill-mode:both;}";
			
			style.innerHTML = keyframes.replace("duration", speed + "s");
			document.getElementsByTagName("head")[0].appendChild(style);
			
		}
		var v = 2;
		function start(){
			setSpeed(v);
			document.getElementById("wheel").setAttribute("class", "rotate");
			setInterval(move, 1000);
			
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
			

			#table {
				margin-top:50px;
				height:700px;
				width:1000px;
				background-color:green;
				position:absolute;
				margin-left:auto;
				margin-right:auto;
				left:0px;
				right:0px;
				border:8px solid rgb(77, 51, 0);
				border-radius:30px;
			}
			
			#numTable, tr, td{
				border:3px solid white;
			}
			
			#numTable{
				 border-collapse: collapse;
				 Color:white;
				 text-align:center;
				 border:3px solid white;
				 border-radius:30px;
			}
			
			.num{
				
				width:50px;
				padding:0px;
			}
			
			
			@keyframes rotation {
				from{
					transform:rotate(0deg);
				}
				to{
					transform:rotate(359deg);
				}
			}
			
		</style>
	</head>
	
	<body class="basicBody">
	<div id="table">
	<table id="numTable">
		<tr id="row1">
		<td colspan="4">1-12</td>
		<td colspan="4">13-24</td>
		<td colspan="4">25-36</td>
		</tr>
		<tr id="row2"></tr>
		<tr id="row3"></tr>
		<tr id="row4"></tr>
		<tr id="row5">
		<td colspan="2">1-18</td>
		<td colspan="2">Even</td>
		<td colspan="2">red</td>
		<td colspan="2">black</td>
		<td colspan="2">odd</td>
		<td colspan="2">19-36</td>
		</tr>
	</table>
		<img id="wheel" height="250" width="250" src="${pageContext.request.contextPath}/Ressources/roulette4.png">
		<button onclick="go()">click me</button>
	</div>
		
		
	</body>
</html>