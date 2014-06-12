package br.com.hrdev.jdbcproject.dao;

import br.com.hrdev.jdbcproject.exceptions.LoginException;
import br.com.hrdev.jdbcproject.models.Cliente;
import br.com.hrdev.jdbcproject.models.Funcionario;
import br.com.hrdev.jdbcproject.models.Usuario;

public interface LoginDao {

	public Usuario tryLogin(int type, String username, String password) throws LoginException;
	public Cliente getClienteByUser(Usuario usuario) throws LoginException;
	public Funcionario getFuncionarioByUser(Usuario usuario) throws LoginException;
	
}
