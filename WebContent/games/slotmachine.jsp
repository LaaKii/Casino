<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slotmachine</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/slotmachine.css">		

<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/slotmachine.js'></script>7
<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/jquery.js'></script>

		
</head>

<body class="basicBody">
<div id="table">
<div id="balance"></div>
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
	<footer>
	<span class="basicFooter"> <a
		href="${pageContext.request.contextPath}/Mainmenu/mainmenu.jsp">Zurück</a>
	</span>
	</footer>
	</body>
</html>