package br.edu.fgp.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* 
 * 
Criando Function para chamar com o callable statement
CREATE OR REPLACE FUNCTION incrementa( i INT) RETURNS INT AS $$
BEGIN
	RETURN i+1;
END;
$$ LANGUAGE plpgsql;


SELECT incrementa(2)
 * 
 * 
 * */
public class ConnectionFactory {
	
	private static Connection conexao; 

	public static Connection getConection() throws SQLException, ClassNotFoundException{
		if(conexao!= null && conexao.isClosed()){
			conexao = null;
		}
		if(conexao == null){
			conexao = connectaSqlite();
			conexao.setAutoCommit(false);
			return conexao;
		}
		return conexao;
	}
/*	
		//Exemplo usando try finnaly
		 * sem o class for name
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		try(Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco","postgres","postgres")){
			conexao.setAutoCommit(false);
			//Codigo aqui
		}//Fecha a conexão depois no finnally automatico
	*/
	
	private static Connection connectaPostgresql() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema","postgres","postgres");
	}
	
	private static Connection connectaSqlite() throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection("jdbc:sqlite:/opt/sqlite/sistema.db");
	}
}
