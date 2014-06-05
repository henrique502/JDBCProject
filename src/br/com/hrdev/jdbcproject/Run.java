package br.com.hrdev.jdbcproject;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Run implements Runnable {
	
	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Application();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Run());
	}
}
