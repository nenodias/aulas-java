import java.sql.*; 

public class Banco {
	
//	private final String urlConexao ="jdbc:sqlserver://localhost;instanceName=MSSQLSERVER;databaseName=Sistema;user=sa;password=sql;";
	private final String urlConexao ="jdbc:mysql://localhost:3306/teste?user=usuario&password=123";
	
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public Banco() {
	}
	
	public void sqlAtualizacao(String sql) {
		try {
			connection = DriverManager.getConnection(urlConexao);
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet sqlConsulta(String sql) {
		try {
			connection = DriverManager.getConnection(urlConexao);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultSet;
	} 
	
}
