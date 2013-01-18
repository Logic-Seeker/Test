package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

import com.brick.helper.CustomerAdvance;

public class MainCustomer extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	CustomerRecords record = new CustomerRecords();
	Customer customer = new Customer();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	/**
	 * Create the panel.
	 */
	public MainCustomer() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Customer Records", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(record);
		
		tabbedPane.addTab("New Customer", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(customer);
		
		tabbedPane.addTab("Customer Report", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tabbedPane.addTab("Advance", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(new CustomerAdvance());
	}
}
