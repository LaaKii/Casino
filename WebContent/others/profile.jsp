<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Stylesheets/basic.css">
<script src="${pageContext.request.contextPath}/javascript/ajaxx.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/javascript/jquery.js" type="text/javascript"></script>
<title>Profil</title>
<script>
$(document).ready(function() {
	loadKontostand();
});
function loadKontostand(){
	$.get("/Casino/KontoServlet", function(responseText) { 
		$("#balance").text(responseText + "$"); 
	});
}
</script>
<style>
	div{
		margin-top:50px;
		padding: 20px;
		background-color: rgba(255, 255, 255, 0.8);
		border-radius: 30px;
	}
</style>
</head>
<body class="basicBody">
<h1 class="basicHeader">Rekursino</h1>
<div>
	<c:out value="${userBean.username}"></c:out>
	<br>
	Guthaben: <span id="balance"></span>
</div>
<footer>
		<span class="basicFooter"> <a
			href="${pageContext.request.contextPath}/Mainmenu/mainmenu.jsp">Zurück</a>
		</span>
	</footer>
</body>
</html>