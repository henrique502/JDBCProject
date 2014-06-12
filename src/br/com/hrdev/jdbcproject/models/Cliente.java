package br.com.hrdev.jdbcproject.models;

public class Cliente extends Usuario {

	private double saldo;
	
	public Cliente(){
		super();
	}
	
	public Cliente(Usuario usuario){
		super();
		id = usuario.id;
		nome = usuario.nome;
		username = usuario.username;
		senha = usuario.senha;
		tipo = usuario.tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
