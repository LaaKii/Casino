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
		$(document).ready(function() {
			$.get("/Casino/KontoServlet", function(responseText) { 
				$("#kontostand").text(responseText); 
			});
		});
		
		function spin(){
			var wheel = document.getElementById("wheel");
		}
		</script>
		
		<style>
			.rotate {
  animation: rotation 2s infinite linear;
}

@keyframes rotation {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(359deg);
  }
} 
		</style>
	</head>
	
	<body class="basicBody">
		<img id="wheel" class="rotate" height="250" width="250" src="${pageContext.request.contextPath}/Ressources/roulette4.png">
		<button oncliuck="spin()">click me</button>
	</body>
</html>