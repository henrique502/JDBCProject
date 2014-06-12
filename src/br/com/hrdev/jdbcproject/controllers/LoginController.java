package br.com.hrdev.jdbcproject.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import br.com.hrdev.jdbcproject.Application;
import br.com.hrdev.jdbcproject.dao.LoginDao;
import br.com.hrdev.jdbcproject.dao.LoginDaoSQL;
import br.com.hrdev.jdbcproject.exceptions.LoginException;
import br.com.hrdev.jdbcproject.models.Cliente;
import br.com.hrdev.jdbcproject.models.Funcionario;
import br.com.hrdev.jdbcproject.models.Usuario;
import br.com.hrdev.jdbcproject.utils.Config;
import br.com.hrdev.jdbcproject.utils.Session;
import br.com.hrdev.jdbcproject.views.ClienteDashboardView;
import br.com.hrdev.jdbcproject.views.FuncionarioDashboardView;
import br.com.hrdev.jdbcproject.views.LoginView;

public class LoginController extends Controller {
	
	private LoginView view;
	
	public LoginController(LoginView view){
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		checkCredentials();
	}
	
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_ENTER){
			checkCredentials();
		}
	}
	
	private void checkCredentials(){
		view.setEnabled(false);
		LoginDao dao = new LoginDaoSQL();
		
		try {
			int type = view.getType();
			String username = view.getUsername();
			String password = view.getPassword();
			
			if(username == null || username.trim().length() < 3)
				throw new LoginException(1);
			
			if(password == null || password.trim().length() < 6 || password.trim().length() > 16)
				throw new LoginException(2);
			
			Usuario usuario = dao.tryLogin(type, username, password);
			
			
			
			if(Config.DEBUG)
				System.out.println("Login success: " + usuario + " (id: " + usuario.getId() + ")");
			
			switch(usuario.getTipo()){
				case Usuario.CLIENTE : loadDashboardCliente(view.getApplication(), dao.getClienteByUser(usuario)); break;
				case Usuario.FUNCIONARIO : loadDashboardFunctionario(view.getApplication(), dao.getFuncionarioByUser(usuario)); break;
				default: throw new LoginException(0);
			}
			
		} catch(LoginException ex){
			view.loginError(ex.getCode());
		}
		
		view.setEnabled(true);
	}

	private void loadDashboardFunctionario(Application application, Funcionario funcionario) {
		application.setSession(new Session(funcionario));
		application.addPanel(new FuncionarioDashboardView(application), "dashboard");

		application.swap("dashboard");
		application.clear(view);
	}

	private void loadDashboardCliente(Application application, Cliente cliente) {
		application.setSession(new Session(cliente));
		application.addPanel(new ClienteDashboardView(application), "dashboard");

		application.swap("dashboard");
		application.clear(view);
	}
}