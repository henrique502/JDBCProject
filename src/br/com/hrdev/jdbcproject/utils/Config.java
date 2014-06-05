package br.com.hrdev.jdbcproject.utils;

import java.util.Properties;

/**
 * @author Henrique Rieger Schmidt
 */
public class Config {
	
	private static Properties prop = null;
	
	/**
	 * @param key
	 * @return Texto
	 */
	public static String key(String key){
		return prop.getProperty(key);
	}
	
	public Config(Properties properties){
		prop = properties;
	}
}