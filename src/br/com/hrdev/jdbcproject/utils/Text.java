package br.com.hrdev.jdbcproject.utils;

import java.util.Properties;

/**
 * @author Henrique Rieger Schmidt
 */
public class Text {
	
	private static Properties prop = null;
	
	/**
	 * @param key 
	 * @param labels
	 * @return Texto
	 */
	public static String key(String key,Object... labels){
		return String.format(key(key),labels);
	}
	
	/**
	 * @param key
	 * @return Texto
	 */
	public static String key(String key){
		return prop.getProperty(key);
	}
	
	public Text(Properties properties){
		prop = properties;
	}
}
