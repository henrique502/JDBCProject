package br.com.hrdev.jdbcproject.views;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.hrdev.jdbcproject.Application;
import br.com.hrdev.jdbcproject.dao.DashboardClienteDao;
import br.com.hrdev.jdbcproject.dao.DashboardClienteDaoSQL;

public class ClienteDashboardView extends View {
	
	//TODO: 
	
	private static final long serialVersionUID = 1L;
	private DashboardClienteDao dao;
	
	public ClienteDashboardView(Application app) {
		super(app);
		this.dao = new DashboardClienteDaoSQL();
		
		
		setupResumo();
	}
	
	public void setupResumo(){
		String[] columnNames = {"Código", "Produto", "Funcionario", "Status"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		JPanel body = new JPanel();
			
		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		
		table.getTableHeader().setEnabled(false);
		
		
		body.add(table.getTableHeader(), BorderLayout.PAGE_START);
		body.add(new JScrollPane(table), BorderLayout.CENTER);
		
		add(body, BorderLayout.CENTER);
	}
}
