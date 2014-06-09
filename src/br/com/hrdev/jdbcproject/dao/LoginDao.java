package br.com.hrdev.jdbcproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hrdev.jdbcproject.exceptions.LoginException;
import br.com.hrdev.jdbcproject.factory.DatabaseFactory;
import br.com.hrdev.jdbcproject.models.Usuario;

public class LoginDao {
	
	/**
	 * @param type
	 * @param username
	 * @param password
	 * @return Usuario
	 * @throws LoginException
	 */
	public Usuario tryLogin(int type, String username, String password) throws LoginException {
		Connection db = null;
		PreparedStatement preparedStatement = null;
		Usuario usuario = null;
		
		try {
			db = DatabaseFactory.getInstance();
			
			String sql = "SELECT id, nome, username, tipo FROM usuarios WHERE (tipo = ? AND username = ? AND senha = ?) LIMIT 1";
			
			preparedStatement = db.prepareStatement(sql);
			preparedStatement.setInt(1, type);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, password);

			ResultSet rs = preparedStatement.executeQuery();
			
			if(!rs.next())
				throw new LoginException(3);
			
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setUsername(rs.getString("username"));
			usuario.setTipo(rs.getInt("tipo"));
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DatabaseFactory.close(preparedStatement);
			DatabaseFactory.close(db);
		}
		
		if(usuario == null)
			throw new LoginException(0);
			
		return usuario;
	}
}
