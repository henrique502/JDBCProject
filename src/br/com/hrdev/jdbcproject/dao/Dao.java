package br.com.hrdev.jdbcproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hrdev.jdbcproject.factory.DatabaseFactory;

public abstract class Dao {
	
	 private Connection conexao = null;
	 protected PreparedStatement statement = null;
	 
	 protected void start(String sql) throws SQLException{
		 conexao = DatabaseFactory.getInstance();
		 statement = conexao.prepareStatement(sql);
	 }
	 
	 protected void end(){
		 DatabaseFactory.close(statement);
		 DatabaseFactory.close(conexao);
	 }
	 
}
