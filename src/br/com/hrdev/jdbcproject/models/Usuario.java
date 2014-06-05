package br.com.hrdev.jdbcproject.models;

public class Usuario {

	private int id;
	private String nome;
	private String usuario;
	private char[] senha;
	private int tipo;
	
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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