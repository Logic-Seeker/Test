package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class MainEmployee extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	Employee employee = new Employee();
	EmployeeAttendance employeeattendance = new EmployeeAttendance();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	EmployeeRecords records = new EmployeeRecords();
	EmployeeAdvance advances = new EmployeeAdvance();
	EmployeePayment payment = new EmployeePayment();
	
	/**
	 * Create the panel.
	 */
	public MainEmployee() {

		initGUI();
		employee.set(records);
		employee.setadvance(advances);
		employee.setattendance(employeeattendance);
		records.setEmployeeAdvance(advances);
		records.setattendance(employeeattendance);
		employee.setpayment(payment);
	}
	private void initGUI() {
		
		
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Employee Records", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(records);
		
		tabbedPane.addTab("New Eployee", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(employee);
		
		tabbedPane.addTab("Employee Attendance", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(employeeattendance);
		
		tabbedPane.addTab("Employee Report", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		tabbedPane.addTab("Advance", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(advances);
		
		tabbedPane.addTab("Payment", null, panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		panel_5.add(payment);
	}
}
