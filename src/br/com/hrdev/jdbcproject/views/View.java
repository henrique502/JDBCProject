package br.com.hrdev.jdbcproject.views;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import br.com.hrdev.jdbcproject.Application;

public abstract class View extends JPanel {

	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	
	protected Application app;
	
	public View(Application app){
		super();
		
		this.app = app;
		this.menu = new JMenuBar();
		setupMenu(this.menu);
		
		addComponentListener(new Updater());
	}
	
	/**
	 * Configura barra de menu quando view esta visivel
	 * @param JMenuBar menu
	 */
	protected void setupMenu(JMenuBar menu){}
	
	/**
	 * Acionada quando a view esta visivel
	 */
	protected void notifyVisible(){}
	
	/**
	 * Acionada quando a view deixa ser visivel
	 */
	protected void notifyHidden(){}
	
	private class Updater extends ComponentAdapter {
		 @Override
		 public void componentShown(ComponentEvent e){
			 app.setJMenuBar(menu);
			 notifyVisible();
	     }

	     @Override
	     public void componentHidden(ComponentEvent e){
	    	 notifyHidden();
	     }
	}
}