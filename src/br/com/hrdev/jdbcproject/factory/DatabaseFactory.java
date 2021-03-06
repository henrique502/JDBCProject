package br.com.hrdev.jdbcproject.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.hrdev.jdbcproject.utils.Config;

public class DatabaseFactory {
	
	private DatabaseFactory(){}
	
	public static Connection getInstance(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			String jdbc = String.format("jdbc:mysql://%s:%s/%s", Config.key("host"), Config.key("port"), Config.key("database"));
			
			if(Config.DEBUG)
				System.out.println("Connect url: " + jdbc);
			
			connection = DriverManager.getConnection(jdbc, Config.key("user"), Config.key("password"));
			if(connection == null)
				throw new SQLException("Database fail to connect");
			
			if(Config.DEBUG)
				System.out.println("Connect success");
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, "Database Error", ex);
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, "Database Error", ex);
		}
		
		return connection;
	}
	
	public static void close(Connection connect){
		if(Config.DEBUG)
			System.out.println("Connection closed");
		
		try {
			if(connect != null)
				connect.close();
		} catch(Exception e){}
	}

	public static void close(PreparedStatement preparedStatement) {
		if(Config.DEBUG)
			System.out.println("PreparedStatement closed");
		
		try {
			if(preparedStatement != null)
				preparedStatement.close();
		} catch(Exception e){}
	}
}