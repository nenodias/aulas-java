package br.edu.fgp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {
    
	private static final long serialVersionUID = -5683337195887422033L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		Integer contador = (Integer) session.getAttribute("contador");
		Cookie cookieUsuario = null;
		String usuario = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if("usuario".equals(cookie.getName())){
					usuario = cookie.getValue();
					cookieUsuario = cookie;
				}
			}
		}
		if(usuario != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
			cookieUsuario = new Cookie("usuario", usuario);
			request.setAttribute("msg", usuario+" Logado");
			contador++;
			request.setAttribute("contador", contador);
			dispatcher.forward(request,response);
		}else{
			String login = request.getParameter("login");
			String senha = request.getParameter("password");
			if("admin".equals(login) || "user".equals(login)){
				contador = 1;
				cookieUsuario = new Cookie("usuario", login);
				if(cookieUsuario != null){
					response.addCookie(cookieUsuario);
				}
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
				if(cookieUsuario != null){
					cookieUsuario.setMaxAge(0);
				}
			}
		}
		if(contador != null){
			session.setAttribute("contador", contador);
		}
		if(cookieUsuario != null){
			response.addCookie(cookieUsuario);
		}
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
	}
}
