import java.sql.*;


public class Pessoa {

	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String celular;

	public Pessoa() {
		setId(0);
		setNome("");
		setEmail("");
		setTelefone("");
		setCelular("");
	}

	public Pessoa(int id) {
		setId(id);
		setNome("");
		setEmail("");
		setTelefone("");
		setCelular("");
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT * FROM pessoa WHERE id = "+ getId() + ";");
		try {
			rs.next();
			setNome(rs.getString("nome"));
			setEmail(rs.getString("email"));
			setTelefone(rs.getString("telefone"));
			setCelular(rs.getString("celular"));
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void salvar() {
		Banco banco = new Banco();
		if (getId() > 0) {
			banco.sqlAtualizacao("UPDATE pessoa SET nome = '" + getNome() + "', email = '" + getEmail() + "', telefone = '" + getTelefone() + "', celular = '" + getCelular() + "'  WHERE id = " + getId() + ";");
		} else {
			banco.sqlAtualizacao("INSERT INTO pessoa (nome, email, telefone, celular) VALUES ('" + this.getNome() + "', '" + this.getEmail() + "', '" + this.getTelefone() + "', '" + this.getCelular() + "');");
		}
	}

	public void remover() {
		Banco b = new Banco();
		if (getId() > 0) {
			b.sqlAtualizacao("DELETE FROM pessoa WHERE id = " + getId() + ";");
		}
	}

	public Pessoa[] consultar() {
		int x = 0;
		ResultSet rs = null;
		Banco b = new Banco();
		rs = b.sqlConsulta("SELECT COUNT(*) AS total FROM pessoa;");
		try {
			rs.next();
			x = Integer.parseInt(rs.getString("total"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (x == 0) return null;
		Pessoa[] p = new Pessoa[x];
		rs = b.sqlConsulta("SELECT * FROM pessoa ORDER BY nome;");
		try {
			int count = 0;
			while (rs.next()) {
				Pessoa temp = new Pessoa();
				temp.setId(Integer.parseInt(rs.getString("id")));
				temp.setNome(rs.getString("nome"));
				temp.setEmail(rs.getString("email"));
				temp.setTelefone(rs.getString("telefone"));
				temp.setCelular(rs.getString("celular"));
				p[count] = temp;
				count++;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p; 
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}



}
