package br.com.hrdev.jdbcproject.utils;

import br.com.hrdev.jdbcproject.models.Cliente;
import br.com.hrdev.jdbcproject.models.Funcionario;


public class Session {
	
	private Cliente cliente;
	private Funcionario funcionario;
	
	public Session(Cliente cliente){
		this.cliente = cliente;
	}
	
	public Session(Funcionario funcionario){
		this.funcionario = funcionario;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public Funcionario getFuncionario(){
		return funcionario;
	}

}
