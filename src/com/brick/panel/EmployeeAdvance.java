package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class EmployeeAdvance extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAdvance = new JLabel("Advance");
	private final JLabel lblEmployeeName = new JLabel("Employee Name");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JTextField textField = new JTextField();
	private final JComboBox<EmployeeHelper> comboBoxEmployeeName = new JComboBox<EmployeeHelper>();
	private final JButton btnSubmit = new JButton("Submit");
	DatabaseHelper databasehelper = new DatabaseHelper();
	private DefaultComboBoxModel model;
	/**
	 * Create the panel.
	 */
	public EmployeeAdvance() {
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{160, 240};
		gbl_panel.rowHeights = new int[]{45, 45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 0;
		gbc_lblEmployeeName.gridy = 0;
		lblEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblEmployeeName, gbc_lblEmployeeName);
		
		GridBagConstraints gbc_comboBoxEmployeeName = new GridBagConstraints();
		gbc_comboBoxEmployeeName.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxEmployeeName.fill = GridBagConstraints.BOTH;
		gbc_comboBoxEmployeeName.gridx = 1;
		gbc_comboBoxEmployeeName.gridy = 0;
		
		comboBoxEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(comboBoxEmployeeName, gbc_comboBoxEmployeeName);
		ArrayList<EmployeeHelper> employeelist = new ArrayList<EmployeeHelper>();
		employeelist = databasehelper.fetchEmployeeName();
		comboBoxEmployeeName.setEditable(true);
		comboBoxEmployeeName.setRenderer(new ComboBoxItemRenderer());
		comboBoxEmployeeName.setEditor(new ComboBoxItemEditor());
		model = new DefaultComboBoxModel();
		comboBoxEmployeeName.setModel(model);
		for (EmployeeHelper employeeHelper : employeelist) {
			model.addElement(employeeHelper);
			System.out.println(employeeHelper.name);
		}
		
		
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.anchor = GridBagConstraints.WEST;
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 1;
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblAmount, gbc_lblAmount);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(7, 0, 7, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 2;
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnSubmit, gbc_btnSubmit);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblAdvance.setForeground(new Color(0, 191, 255));
		lblAdvance.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_1.add(lblAdvance);
	}

}
