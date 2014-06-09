package br.com.hrdev.jdbcproject;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import br.com.hrdev.jdbcproject.views.LoginView;
import br.com.hrdev.jdbcproject.views.View;
import br.com.hrdev.jdbcproject.utils.Config;
import br.com.hrdev.jdbcproject.utils.Text;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(950,600);
    
	
	public Application(){
		super();

		try {
			setupProperties();
			setupFrame();
			
			add(new LoginView(this), "login");
			swap("login");
			
			setVisible(true);
		} catch(Exception ex){
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, "Fatal Error", ex);
			System.exit(-1);
		}
	}
	
	private void setupFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(size);
		setResizable(true);
		setJMenuBar(new JMenuBar());
		setResizable(true);
		setLocationRelativeTo(null);
		setTitle(Text.key("title"));
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new FullscreenManager());
		
		getContentPane().setLayout(new CardLayout());
	}
	
	private void setupProperties() throws Exception {
		new Config(getPropertiesFile("configs"));
		new Text(getPropertiesFile("texts"));
	}

	private Properties getPropertiesFile(String file) throws Exception {
		Properties prop = null;
		InputStream input = null;
		try {
			prop = new Properties();
			input = getClass().getResourceAsStream("/assets/properties/" + file + ".properties");
			prop.load(input);
		} finally {
			input.close();
		}
		
		return prop;
	}
	
	/**
	 * Troca o layout no JFrame
	 * @param String panelName
	 */
	public void swap(String panelName){
		CardLayout card = (CardLayout) getContentPane().getLayout();
		card.show(getContentPane(), panelName);
	}
	
	/**
	 * Adiciona layout no JFrame
	 * @param View panel
	 * @param String panelName
	 */
	public void add(View panel, String panelName){
		getContentPane().add(panel, panelName);
	}
	
	public void clearAll() {
		getContentPane().removeAll();
		
	}
	
	public void clear(Component comp) {
		getContentPane().remove(comp);
	}
	
	/**
	 * FullscreenManager
	 */
	
	private class FullscreenManager implements KeyEventDispatcher {
        
		private boolean fullscreen = false;
	    private Point location;
		
		@Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_TYPED){
            	boolean keyCtrl = (e.getModifiers() & KeyEvent.VK_WINDOWS) != 0;
            	boolean keyF = (e.getKeyChar() == 'f' || e.getKeyChar() == 'F');

            	if(keyCtrl && keyF){
                	if(!fullscreen){
                		startFullscreen();
                	} else {
                		exitFullscreen();
                	}
                }
            }
            
            return false;
        }

		private void exitFullscreen() {
			setBounds(location.x, location.y, size.width, size.height);
            dispose();
			setUndecorated(false);
			setVisible(true);
			fullscreen = false;
		}

		private void startFullscreen() {
			location = getLocation();
			size = getSize();
			dispose();
			setUndecorated(true);
			setBounds(0, 0, getToolkit().getScreenSize().width, getToolkit().getScreenSize().height);
			setVisible(true);
			fullscreen = true;
		}
    }
}
