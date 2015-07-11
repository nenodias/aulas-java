package br.com.fgp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fgp.dao.ConnectionFactory;
import br.com.fgp.dao.UsuarioDao;

public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 6934778084525880247L;
	
	private Connection conexao;
	private UsuarioDao usuarioDao;

	@Override
	public void init() throws ServletException {
		super.init();
		try {
			conexao = ConnectionFactory.getConection();
			usuarioDao = new UsuarioDao(conexao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		super.destroy();
		try{
			if(!conexao.isClosed()){
				conexao.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("logado") == null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getSession().getAttribute("logado") == null){
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			if(!usuarioDao.isLogado(login, senha)){
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				request.getSession().setAttribute("logado", usuarioDao.buscarUsuarioPorLogin(login) );
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	 
}
