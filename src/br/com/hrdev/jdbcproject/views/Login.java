package br.com.hrdev.jdbcproject.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.com.hrdev.jdbcproject.Application;
import br.com.hrdev.jdbcproject.utils.Text;

public class Login extends View {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordInput;
	private JTextField usuarioInput;
	private JComboBox tipoIpunt;
	
	
	public Login(Application app){
		super(app);
		
		
		setupLayout();
	}
	
	private void setupLayout() {
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(setupLoginBox());
        add(Box.createHorizontalGlue());
	}

	private JPanel setupLoginBox() {
		JPanel box = new JPanel();
		
		TitledBorder border = new TitledBorder(box.getBorder(), Text.key("login_title"), TitledBorder.CENTER, TitledBorder.TOP);
		box.setBorder(border);
		
		/* Layout */
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {0, 0, 0};
		layout.rowHeights = new int[] {0, 0, 0, 0, 0};
		layout.columnWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
		layout.rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		box.setLayout(layout);
		
		/* Label Tipo */
		JLabel labelTipo = new JLabel(Text.key("login_label_tipo"));
		labelTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		box.add(labelTipo, constraints);
		
		/* ComboBox Tipo */
		tipoIpunt = new JComboBox();
		tipoIpunt.setModel(new DefaultComboBoxModel(new String[] {Text.key("user_cliente"), Text.key("user_funcionario")}));
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		box.add(tipoIpunt, constraints);
		
		/* Label Usuario */
		JLabel labelUsuario = new JLabel(Text.key("login_label_usuario"));
		labelUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.EAST;
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.gridx = 0;
		constraints.gridy = 1;
		box.add(labelUsuario, constraints);
		
		/* Field Usuario */
		usuarioInput = new JTextField();
		usuarioInput.setColumns(15);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		box.add(usuarioInput, constraints);
		
		/* Label Senha */
		JLabel labelPassword = new JLabel(Text.key("login_label_senha"));
		labelPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 5, 5);
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 0;
		constraints.gridy = 2;
		box.add(labelPassword, constraints);
		
		/* Field Password */
		passwordInput = new JPasswordField();
		
		constraints = new GridBagConstraints();
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 2;
		box.add(passwordInput, constraints);
		
		/* Button Logar */
		JButton button = new JButton(Text.key("login_label_logar"));
		
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = 2;
		constraints.gridx = 0;
		constraints.gridy = 3;
		box.add(button, constraints);
		
		box.setMaximumSize(new Dimension(280, 160));
		
		return box;
	}
}
