<%@page import="com.servlet.vo.VOLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<p> Bienvenido al sistema de JSO y Servlets: <%=  

		((VOLogin)session.getAttribute("usuarioLogueado")).getNombre()

		%>
	
	</p>

	<a href = "usuarios/Usuarios.jsp"> Administracion de usuarios </a>

</body>
</html>