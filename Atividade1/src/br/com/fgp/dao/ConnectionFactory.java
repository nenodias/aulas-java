package br.com.fgp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static Connection conexao; 

	public static Connection getConection() throws SQLException, ClassNotFoundException{
		if(conexao != null && conexao.isClosed()){
			conexao = null;
		}
		if(conexao == null){
			conexao = connectaSqlite();
			conexao.setAutoCommit(false);
			return conexao;
		}
		return conexao;
	}
	
	private static Connection connectaSqlite() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection("jdbc:sqlite:/opt/sqlite/sistema.db");
	}
}
