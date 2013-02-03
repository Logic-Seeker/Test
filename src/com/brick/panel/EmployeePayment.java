package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.EmployeeHelper;

public class EmployeePayment extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblEmployeePayment = new JLabel("Employee Payment");
	private final JLabel lblEmployeeName = new JLabel("Employee Name");
	private final JLabel lblDate = new JLabel("Date");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JComboBox <EmployeeHelper> comboBox = new JComboBox<EmployeeHelper>();
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JButton btnSubmit = new JButton("Submit");
	DatabaseHelper databasehelper = new DatabaseHelper();
	private DefaultComboBoxModel model;

	/**
	 * Create the panel.
	 */
	public EmployeePayment() {
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);

		initGUI();
		populateEmployeeAdvance();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.GRAY);
		
		add(panel, BorderLayout.NORTH);
		lblEmployeePayment.setForeground(new Color(0, 206, 209));
		lblEmployeePayment.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel.add(lblEmployeePayment);
		
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 240};
		gbl_panel_1.rowHeights = new int[]{0, 45, 45, 45, 80};
		//gbl_panel_1.columnWidths = new int[]{0, 240, 0};
		//gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 0;
		gbc_lblEmployeeName.gridy = 1;
		lblEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblEmployeeName, gbc_lblEmployeeName);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(7, 0, 7, 0);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		comboBox.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.anchor = GridBagConstraints.WEST;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 2;
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblAmount, gbc_lblAmount);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(7, 0, 7, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel_1.add(textField, gbc_textField);
		
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 3;
		lblDate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(7, 0, 7, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		panel_1.add(textField_1, gbc_textField_1);
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 4;
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(btnSubmit, gbc_btnSubmit);
	}
	
	public void populateEmployeeAdvance(){
		ArrayList<EmployeeHelper> employeelist = new ArrayList<EmployeeHelper>();
		employeelist = databasehelper.fetchEmployeeName();
		comboBox.setEditable(true);
		comboBox.setRenderer(new ComboBoxItemRenderer());
		comboBox.setEditor(new ComboBoxItemEditor());
		model = new DefaultComboBoxModel();
		comboBox.setModel(model);
		for (EmployeeHelper employeeHelper : employeelist) {
			model.addElement(employeeHelper);
			System.out.println(employeeHelper.name);
		}
		this.revalidate();
		}


}
