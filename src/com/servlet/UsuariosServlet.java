package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.vo.VOLogin;

/**
 * Servlet implementation class UsuariosServlet
 */
@WebServlet("/usuarios/adminUsuarios.servlet") //Esto es la ruta de nuestro jsp!!!
public class UsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UsuariosServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost de User servlet");
		String accion = request.getParameter("accion");
		System.out.println("Accion: " + accion);
		List<VOLogin> lista = (List<VOLogin>) request.getSession().getAttribute("listaUsuario");
		VOLogin vo = new VOLogin();
		
		vo.setUsuario(request.getParameter("usuario"));
		vo.setNombre(request.getParameter("nombre"));
		vo.setEdad(Integer.parseInt(request.getParameter("edad"))); //Esto es un casteo a integer
		System.out.println("Aqui");
		if(accion.equals("guardar")) {
			
			lista.add(vo);
			
			} else if(accion.equals("actualizar")) {
				
				for(VOLogin obj : lista) {
					
					if(obj.getUsuario().equals(vo.getUsuario())) {
						
						obj.setNombre(vo.getNombre());
						obj.setNombre(vo.getUsuario());
						obj.setEdad(vo.getEdad());
						obj.setPassword(vo.getPassword());
					}
				}
			
			} else if (accion.equals("borrar")) {
			
				for(VOLogin obj : lista) {
					
					if(obj.getUsuario().equals(vo.getUsuario())) {
						
						lista.remove(obj);
					}
					
				}
			
			}
		
		response.sendRedirect("Usuarios.jsp");
		
	}

}
