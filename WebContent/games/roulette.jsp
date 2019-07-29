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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/roulette.css">		
		<script src="https://code.jquery.com/jquery-1.10.2.js"
		type="text/javascript"></script>
		<script src="javascript/ajaxx.js" type="text/javascript"></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/roulette.js'></script>
		
	</head>
	
	<body class="basicBody">
	<div id="table">
	<div id="balance"></div>
	<div id="result"></div>
	<div id="bet">
	Einsatz: 
	<input id="betInput" value="100" onkeyup="refreshProfit()">$
	</div>
	<img height="50" width="50" src="${pageContext.request.contextPath}/Ressources/arrow.png" id="arrow">
	<div id="profit"> 
	<span id="profitValue">Gewinn: -</span>
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
		<img id="wheel" height="400" width="400" src="${pageContext.request.contextPath}/Ressources/roulette2.png">
		<button class="basicButton" id="startButton" onclick="start()">Spiel starten</button>
	</div>
	<footer>
	<span class="basicFooter"> <a
		href="${pageContext.request.contextPath}/Mainmenu/mainmenu.jsp">Zurück</a>
	</span>
	</footer>
		
	</body>
</html>