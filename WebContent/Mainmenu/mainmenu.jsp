<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/mainmenu.css">
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<link rel="stylesheet" href="../Stylesheets/basic.css">
<link rel="stylesheet" href="../Stylesheets/mainmenu.css">
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js?ver=1.3.2'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/jquery.mousewheel.js'></script>
<script>
$(document).ready(function() {
	$('.content').mousewheel(function(e, delta) {
	this.scrollLeft -= (delta * 30);
	e.preventDefault();
	});
	});
</script>
<title>Hauptmenü</title>
<script>
$(function() {

	   $("body").mousewheel(function(event, delta) {

	      this.scrollLeft -= (delta * 30);
	    
	      event.preventDefault();

	   });

	})
	var name;
	function showTitle(name) {
		document.getElementById("choice").style.visibility = "visible";
		document.getElementById("choice").innerHTML = name;
	}
	
	function hideTitle(){
		document.getElementById("choice").style.visibility = "hidden";
	}
	
	
</script>
</head>
<body class="basicBody">
	<!--  <h1 class="basicHeader">Username ${userBean.username}</h1>-->
	<h1 class="basicHeader">Recursino</h1>
	<div class="choiceWrapper"><span id="choice">test</span></div>
	<div class="content">
		<a onmouseover="showTitle('Roulette')" onmouseout="hideTitle()" href="./games/roulette.jsp"><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/roulette4.png"></a>
		<a onmouseover="showTitle('Blackjack')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/blackjack.png"></a>
		<a onmouseover="showTitle('Slot Maschine')" onmouseout="hideTitle()" href=#><img height="150" width="250" style="padding:50px 0px" src="${pageContext.request.contextPath}/Ressources/slotmachine.jpg"></a>
		<a onmouseover="showTitle('Profil')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/profile.png"></a>
		<a onmouseover="showTitle('Einstellungen')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/config2.png"></a>
	</div>

</body>
</html>