package br.com.fgp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fgp.model.Usuario;

public class UsuarioDao {
	
	private Connection conexao;
	
	public UsuarioDao(Connection conexao) {
		super();
		this.conexao = conexao;
	}

	public List<Usuario> buscarUsuarios(String login){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		if(getConexao() != null){
			try {
				PreparedStatement prepare = getConexao().prepareStatement("SELECT * from Usuario");
				prepare.setString(1, login);
				ResultSet resultSet = prepare.executeQuery();
				while(resultSet.next()){
					usuarios.add(montaUsuario(resultSet));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return usuarios;
	}
	
	public Usuario buscarUsuarioPorLogin(String login){
		if(getConexao() != null){
			try {
				PreparedStatement prepare = getConexao().prepareStatement("SELECT * from Usuario WHERE login = ?");
				prepare.setString(1, login);
				ResultSet resultSet = prepare.executeQuery();
				return montaUsuario(resultSet);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Boolean isLogado(String login, String senha){
		Usuario usuario = buscarUsuarioPorLogin(login);
		if(usuario != null && senha != null && senha.equals( usuario.getSenha() ) ){
			return true;
		}
		return false;
	}

	private Usuario montaUsuario(ResultSet resultSet) throws SQLException {
		Long rowId = resultSet.getLong("codigo");
		String nome = resultSet.getString("nome");
		String endereco = resultSet.getString("endereco");
		String cidade = resultSet.getString("cidade");
		String email = resultSet.getString("email");
		String fone = resultSet.getString("fone");
		String login = resultSet.getString("login");
		String senha = resultSet.getString("senha");
		
		Usuario usuario = new Usuario();
		usuario.setCodigo(rowId);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setLogin(login);
		usuario.setFone(fone);
		usuario.setCidade(cidade);
		usuario.setEndereco(endereco);
		usuario.setEmail(email);
		
		return usuario;
	}

	public Connection getConexao() {
		try {
			if(!conexao.isClosed()){
				return conexao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	
}
