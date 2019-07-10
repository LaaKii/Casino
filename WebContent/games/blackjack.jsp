<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blackjack</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<script>

	function click2(){
		move("slot1");
		setTimeout(function(){ move("slot2"); }, 3000);
		setTimeout(function(){ move("slot3"); }, 6000);
	}
	
	function move(slot){
		var pos = 0;
		var counter = 0;
		var animation = newElement();
		var animationContainer = document.getElementById(slot);
		animationContainer.appendChild(animation);
		var id = setInterval(frame, 5);
		
		function newElement(){
			var elem = document.createElement("div");
			elem.style.height = "100px";
			elem.style.width = "100px";
			elem.style.background = getRandomColor();
			elem.style.position = "absolute";
			return elem;
		}
		
		function getRandomColor() {
			  var letters = '0123456789ABCDEF';
			  var color = '#';
			  for (var i = 0; i < 6; i++) {
			    color += letters[Math.floor(Math.random() * 16)];
			  }
			  return color;
			}
		
		function frame(){
			if(pos == 300){
				clearInterval(id);
			}
			else{
				pos += 5;
				animation.style.top = pos + "px";
				if(pos == 100){
					move(slot);
				}
			}
		}
	}
</script>
<style>
.slots {
	height:400px;
	width:100px;
	background-color:white;
	position:relative;
	float:left;
}

#animation {
	height:100px;
	width:100px;
	background-color:red;
	position:absolute;
}
</style>
</head>
<body class="basicBody">
<button onclick="click2()">click me</button>
<div class="slots" id="slot1"></div>
<div class="slots" id="slot2"></div>
<div class="slots" id="slot3"></div>
</body>
</html>