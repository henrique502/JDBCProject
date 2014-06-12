package br.com.hrdev.jdbcproject.models;

public class Usuario {

	protected int id;
	protected String nome;
	protected String username;
	protected char[] senha;
	protected int tipo;
	
	public static final int CLIENTE = 1;
	public static final int FUNCIONARIO = 2;
	
	public Usuario() {}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getSenha() {
		return senha;
	}

	public void setSenha(char[] senha) {
		this.senha = senha;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String toString(){
		return this.nome;
	}
}