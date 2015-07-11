package br.edu.fgp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.fgp.sql.ConnectionFactory;

public class MinhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conexao;
       
    public MinhaServlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	try {
			conexao = ConnectionFactory.getConection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Error("Zoeira no Banco");
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		Statement statement = null;
		StringBuilder resultado = new StringBuilder();
		try {
			statement = conexao.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM CLIENTE");
			while (result.next()) {
				resultado.append("{")
				.append("Id:").append(result.getString("id"))
				.append(", ")
				.append("Nome:").append(result.getString("nome"))
				.append("},");
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.getWriter()
		.append("<html>")
			.append("<head>")
			.append("</head>")
			.append("<body>")
				.append(resultado.toString())
			.append("</body>")
		.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		try{
			conexao.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		super.destroy();
	}
}
