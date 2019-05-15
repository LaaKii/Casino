<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../Stylesheets/basic.css">
<link rel="stylesheet" href="../Stylesheets/mainmenu.css">
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js?ver=1.3.2'></script>
<script type='text/javascript' src='../javascript/jquery.mousewheel.js'></script>
<script>
$(document).ready(function() {
	$('.content').mousewheel(function(e, delta) {
	this.scrollLeft -= (delta * 2);
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
	<h1 class="basicHeader">Pepnis-Casino</h1>
	<div class="choiceWrapper"><span id="choice">test</span></div>
	<div class="content">
		<a onmouseover="showTitle('Roulette')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="../Ressources/roulette4.png"></a>
		<a onmouseover="showTitle('Blackjack')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="../Ressources/blackjack.png"></a>
		<a onmouseover="showTitle(' ')" onmouseout="hideTitle()" href=#><img height="250" width="250" src=""></a>
		<a onmouseover="showTitle('Profil')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="../Ressources/profile.png"></a>
		<a onmouseover="showTitle('Einstellungen')" onmouseout="hideTitle()" href=#><img height="250" width="250" src="../Ressources/config2.png"></a>
	</div>

</body>
</html>