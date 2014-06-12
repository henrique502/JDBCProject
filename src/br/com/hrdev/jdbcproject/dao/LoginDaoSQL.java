package br.com.hrdev.jdbcproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.hrdev.jdbcproject.exceptions.LoginException;
import br.com.hrdev.jdbcproject.models.Cliente;
import br.com.hrdev.jdbcproject.models.Funcionario;
import br.com.hrdev.jdbcproject.models.Usuario;
import br.com.hrdev.jdbcproject.utils.Config;

public class LoginDaoSQL extends Dao implements LoginDao {
	
	@Override
	public Usuario tryLogin(int type, String username, String password) throws LoginException {
		Usuario usuario = null;
		
		try {
			String sql = "SELECT id, nome, username, tipo FROM usuarios WHERE (tipo = ? AND username = ? AND senha = ?) LIMIT 1";
			
			if(Config.DEBUG)
				System.out.println("Query: " + sql);
			
			start(sql);
			
			statement.setInt(1, type);
			statement.setString(2, username);
			statement.setString(3, password);

			ResultSet rs = statement.executeQuery();
			
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
			end();
		}
		
		if(usuario == null)
			throw new LoginException(0);
			
		return usuario;
	}

	@Override
	public Cliente getClienteByUser(Usuario usuario) throws LoginException {
		try {
			String sql = "SELECT clientes.saldo FROM clientes INNER JOIN usuarios ON usuarios.id = clientes.usuario WHERE (usuarios.id = ?) LIMIT 1";
			
			if(Config.DEBUG)
				System.out.println("Query: " + sql);
			
			start(sql);
			
			statement.setInt(1, usuario.getId());
	
			ResultSet rs = statement.executeQuery();
			
			if(!rs.next())
				throw new LoginException(0);
			
			Cliente cliente = new Cliente(usuario);
			cliente.setSaldo(rs.getDouble("saldo"));
			
			return cliente;
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			end();
		}
		
		return null;
	}
	
	@Override
	public Funcionario getFuncionarioByUser(Usuario usuario) throws LoginException {	
		try {
			String sql = "SELECT usuario FROM functionarios INNER JOIN usuarios ON usuarios.id = functionarios.usuario WHERE (usuarios.id = ?) LIMIT 1";
			
			if(Config.DEBUG)
				System.out.println("Query: " + sql);
			
			start(sql);
			
			statement.setInt(1, usuario.getId());
	
			ResultSet rs = statement.executeQuery();
			
			if(!rs.next())
				throw new LoginException(0);
			
			Funcionario functionario = new Funcionario(usuario);
			
			return functionario;
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			end();
		}
		
		return null;
	}
}
