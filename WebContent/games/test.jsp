<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="kontoBean"
	class="de.casino.com.database.KontoBean"
	scope="session" />
	
	<jsp:useBean id="userBean"
	class="de.casino.com.database.UserBean"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Kontostand von ${userBean.username} : ${kontoBean.money}</h1>
</body>
</html>