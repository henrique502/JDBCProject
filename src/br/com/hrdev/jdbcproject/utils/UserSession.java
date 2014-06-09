package br.com.hrdev.jdbcproject.utils;

import br.com.hrdev.jdbcproject.models.Usuario;

public class UserSession {
	
	private static Usuario usuario = null;
	
	public static void create(Usuario u){
		usuario = u;
	}
	
	public static void destroy(){
		usuario = null;
	}
	
	public static Usuario getUser(){
		return usuario;
	}
	
}
