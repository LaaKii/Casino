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
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js?ver=1.3.2'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/javascript/mainmenu.js'></script>
<title>Hauptmenü</title>
</head>
<body class="basicBody">
	<!--  <h1 class="basicHeader">Username ${userBean.username}</h1>-->
	<h1 class="basicHeader">Recursino</h1>
	<div class="choiceWrapper"><span id="choice">test</span></div>
	<div class="content">
		<a onmouseover="showTitle('Blackjack')" onmouseout="hideTitle()" href="${pageContext.request.contextPath}/games/blackjack.jsp"><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/blackjack.png"></a>
		<a onmouseover="showTitle('Roulette')" onmouseout="hideTitle()" href="${pageContext.request.contextPath}/games/roulette.jsp"><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/roulette2.png"></a>
		<a onmouseover="showTitle('Slotmachine')" onmouseout="hideTitle()" href="${pageContext.request.contextPath}/games/slotmachine.jsp"><img height="150" width="250" style="padding:50px 0px" src="${pageContext.request.contextPath}/Ressources/slotmachine.jpg"></a>
		<a onmouseover="showTitle('Profil')" onmouseout="hideTitle()" href="${pageContext.request.contextPath}/games/profile.jsp"><img height="250" width="250" src="${pageContext.request.contextPath}/Ressources/profile.png"></a>
	</div>
<footer>
		<span class="basicFooter">
			<a href="${pageContext.request.contextPath}/others/impressum.jsp">Impressum</a>
			<a href="${pageContext.request.contextPath}/others/faq.jsp">FAQ</a>
		</span>
		</footer>
</body>
</html>