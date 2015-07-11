package br.edu.fgp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class ImagemController extends HttpServlet {
    
	private static final long serialVersionUID = -5683337195887422033L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imagem = request.getParameter("imagem");
		ServletContext servletContext = getServletContext();
		String path = servletContext.getRealPath("/WEB-INF/"+imagem);
		try{
			FileInputStream fileOutputStream = new FileInputStream(path);
			response.setContentType("image/jpg");
			try(OutputStream os = response.getOutputStream()){
				IOUtils.copy(fileOutputStream, os);
				os.flush();
			}
		}catch(IOException e){
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter()
			.append("<html>")
			.append("<head>")
				.append("<title>")
					.append("404")
				.append("</title>")
			.append("</head>")
			.append("<body>")
			.append("<h1>404 Não encontrado</h1>")
			.append("</body>")
			.append("</html>");
		}
	}
	
}
