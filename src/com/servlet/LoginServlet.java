package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.vo.VOLogin;

/*
 Esta es una forma de definir un servlet, a traves de la inyeccion con @WebServlet.
 La anulamos y lo hacemos a traves de web.xml
 */
//@WebServlet("/loginWeb.jr") 

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
      
      
    }
   		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	//	doPost(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*El valor del usuario y de la password que se obtiene aqui viene de 
		la etiqueta name de los input que hay en login.html */
		
		String usuario = request.getParameter("user");
		
		String password = request.getParameter("pass");
	
		
		
		if(usuario.equals("root") && password.equals("toor")) {
			
			System.out.println("Username accepted");
			VOLogin vo = new VOLogin();

			vo.setNombre("Oswaldo");
			vo.setPassword(password);
			vo.setUsuario(usuario);
			vo.setEdad(21);
			
			List<VOLogin> lista = new ArrayList<VOLogin>();
			
			HttpSession session = request.getSession(true);
			/*
			 * Ahora que hay un session ya no es necesario meter los 
			 * atributos en request, lo hacemos directamente en 
			 * el session 
			 */
			
			//request.setAttribute("usuarioLogueado", vo);
			 
			session.setAttribute("listaUsuario", lista);
			session.setAttribute("usuarioLogueado", vo);
			request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			
		}else{
			System.out.println("Error en credenciales de acceso");
			response.sendRedirect("login.html");
		}
		
		
	}

}
