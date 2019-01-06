<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.servlet.vo.VOLogin"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<script test="text/javascript">
		
		function guardar(){
			
			var forma = document.getElementById("formaUsuarios");
			forma.action = "adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value = "guardar";
			forma.submit();
		}
		
		
		function actualizar(){
			
			var forma = document.getElementById("formaUsuarios");
			forma.action = "adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value = "actualizar";
			forma.submit();
			
			
		}
		
		function borrar(){
			
			var forma = document.getElementById("formaUsuarios");
			forma.action = "adminUsuarios.servlet";
			var accion = document.getElementById("accion");
			accion.value = "borrar";
			forma.submit();
		}
	
	</script>

</head>
<body>
	<form action="" method = "POST" id = "formaUsuarios">
	
		<input type = "hidden" name = "accion" id = "accion">
	
		<p> Bienvenido al sistema de JSO y Servlets: <%=  
	
			((VOLogin)session.getAttribute("usuarioLogueado")).getNombre()
	
			%>
		
		</p>
	
			<table align = "center" style = "font-weight:bold; size = 27px">
			<tr>
				<td colspan = "2">Enter username and password</td>
			</tr>
			
			<tr>
				<td style = "font-weight: bold ; size : 12px; color: blue; align: right;">Usuario: </td>
				<td> <input type = "text" name = "usuario" id = "usuario"> </td>
			</tr>
			
			<tr>
				<td style = "font-weight: bold ; size : 12px; color: blue; align: right;">Password: </td>
				<td> <input type = "password" name = "edad" id = "edad"> </td>
			</tr>
			
			<tr>
				<td style = "font-weight: bold ; size : 12px; color: blue; align: right;">Nombre: </td>
				<td> <input type = "text" name = "nombre" id = "nombre"> </td>
			</tr>
			
		
			<tr>
				<td style = "font-weight: bold ; size : 12px; color: blue; align: right;">Edad: </td>
				<td> <input type = "text" name = "edad" id = "edad"> </td>
			</tr>
			<tr>
				
				<td> 	<input  type = "button" value = "Guardar" style ="font-size: 14px ; color: blue;" onclick = "guardar();">
						<input  type = "button" value = "Actualizar" style ="font-size: 14px ; color: blue;"onclick = "actualizar();">
						<input  type = "button" value = "Eliminar" style ="font-size: 14px ; color: blue;" onclick = "eliminar();">
				</td>
				
			</tr>
				
		</table>
		
		
		
		<table align = "center" style = "font-weight:bold; size = 27px">
			<tr>
				<th>Usuario</th> <th>Nombre</th> <th>Edad</th>
				
			</tr>
			
			<%
			
			List<VOLogin> lista	 = (List<VOLogin>)session.getAttribute("listaUsuario");
				
			for(VOLogin obj : lista){
			
			%>
			
				<tr>
					<td><%=obj.getUsuario() %></td>
					<td><%=obj.getNombre() %></td>
					<td><%=obj.getEdad() %></td>
				
				</tr>
					
			<%
			
			}
			
			%>	
				
				
		</table>
	
	</form>

</body>
</html>