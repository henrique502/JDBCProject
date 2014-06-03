package br.com.hrdev.JDBCProject.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import br.com.hrdev.JDBCProject.utils.Config;

public class DatabaseFactory {
	
	private DatabaseFactory(){}
	
	public static Connection getInstance(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbc = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s", Config.key("host"), Config.key("port"), Config.key("database"), Config.key("user"), Config.key("password"));
			
			return DriverManager.getConnection(jdbc);
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection connect){
		try {
			if(connect != null)
				connect.close();
		} catch(Exception e){}
	}
}