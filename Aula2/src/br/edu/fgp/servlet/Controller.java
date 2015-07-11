package br.edu.fgp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
    
	private static final long serialVersionUID = -5683337195887422033L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Cookie cookieContador = null;
		Cookie cookieUsuario = null;
		String contador = null;
		String usuario = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("contador".equals(cookie.getName())){
				contador = cookie.getValue();
			}
			if("usuario".equals(cookie.getName())){
				usuario = cookie.getValue();
			}
		}
		if(usuario == null){
			String login = request.getParameter("login");
			String senha = request.getParameter("password");
			if("admin".equals(login) || "user".equals(login)){
				contador = String.valueOf( 1 );
				cookieUsuario = new Cookie("usuario", login);
				cookieContador = new Cookie("contador", contador);
				if("admin".equals(login)){
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
					request.setAttribute("msg", "Administrador Logado");
					dispatcher.forward(request,response);
				}
				else if("user".equals(login)){
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user.jsp");
					request.setAttribute("msg", "User Logado");
					dispatcher.forward(request,response);
				}
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Erro");
				dispatcher.forward(request,response);
				cookieUsuario.setMaxAge(0);
				cookieContador.setMaxAge(0);
			}
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
			contador = String.valueOf( Integer.valueOf(contador)+1 );
			cookieUsuario = new Cookie("usuario", usuario);
			cookieContador = new Cookie("contador", contador);
			request.setAttribute("msg", usuario+" Logado");
			request.setAttribute("contador", contador);
			dispatcher.forward(request,response);
		}
		if(cookieContador != null){
			response.addCookie(cookieContador);
		}
		if(cookieUsuario != null){
			response.addCookie(cookieUsuario);
		}
	}
}
