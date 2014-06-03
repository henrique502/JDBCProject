package br.com.hrdev.JDBCProject;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Run implements Runnable {
	
	@Override
	public void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new JDBCProject();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Run());
	}
}
