package br.com.hrdev.jdbcproject.models;

public class Funcionario extends Usuario {
	
	public Funcionario(){
		super();
	}
	
	public Funcionario(Usuario usuario){
		super();
		id = usuario.id;
		nome = usuario.nome;
		username = usuario.username;
		senha = usuario.senha;
		tipo = usuario.tipo;
	}
}
