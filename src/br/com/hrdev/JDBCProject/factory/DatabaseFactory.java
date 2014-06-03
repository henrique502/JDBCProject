package br.com.hrdev.JDBCProject.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.hrdev.JDBCProject.utils.Config;

public class DatabaseFactory {
	
	private DatabaseFactory(){}
	
	public static Connection getInstance(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			String jdbc = String.format("jdbc:mysql://%s:%s/%s", Config.key("host"), Config.key("port"), Config.key("database"));
			connection = DriverManager.getConnection(jdbc, Config.key("user"), Config.key("password"));
			if(connection == null)
				throw new SQLException("Database fail to connect");

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, "Database Error", ex);
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, "Database Error", ex);
		}
		
		return connection;
	}
	
	public static void close(Connection connect){
		try {
			if(connect != null)
				connect.close();
		} catch(Exception e){}
	}
}