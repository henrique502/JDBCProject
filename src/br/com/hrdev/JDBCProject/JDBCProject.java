package br.com.hrdev.JDBCProject;

import java.awt.Dimension;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import br.com.hrdev.JDBCProject.utils.Config;
import br.com.hrdev.JDBCProject.utils.Text;

public class JDBCProject extends JFrame {

	private static final long serialVersionUID = 1L;
	private Dimension size = new Dimension(950,600);
	
	public JDBCProject(){
		super();

		try {
			setupProperties();
			setupFrame();
			// TODO: 
			setVisible(true);
		} catch(Exception ex){
			JOptionPane.showMessageDialog(this, "Fatal Erro: " + ex.toString(), "Fatal Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
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
}
