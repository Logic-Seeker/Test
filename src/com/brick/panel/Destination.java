package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;

public class Destination extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblNewDestination = new JLabel("Add New Destination");
	private final JLabel lblDestination = new JLabel("Destination");
	private final JLabel lblRate = new JLabel("Tipper Rate");
	private final JTextField name = new JTextField();
	private final JTextField rateA = new JTextField();
	private final JLabel lblRate_1 = new JLabel("Truck Rate");
	private final JTextField rateB = new JTextField();
	private final JButton btnNewButton = new JButton("Submit");
	DatabaseHelper databaseHelper = new DatabaseHelper();
	String numToken = "[\\p{Digit}]+";

	/**
	 * Create the panel.
	 */
	public Destination() {
		rateB.setFont(new Font("Dialog", Font.PLAIN, 14));
		rateB.setColumns(10);
		rateA.setFont(new Font("Dialog", Font.PLAIN, 14));
		rateA.setColumns(10);
		name.setFont(new Font("Dialog", Font.PLAIN, 14));
		name.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{120, 240};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 0;
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblDestination, gbc_lblDestination);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(7, 0, 7, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(name, gbc_textField);
		
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.anchor = GridBagConstraints.WEST;
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 1;
		lblRate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate, gbc_lblRate);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(7, 0, 7, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(rateA, gbc_textField_1);
		
		GridBagConstraints gbc_lblRate_1 = new GridBagConstraints();
		gbc_lblRate_1.anchor = GridBagConstraints.WEST;
		gbc_lblRate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate_1.gridx = 0;
		gbc_lblRate_1.gridy = 2;
		lblRate_1.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate_1, gbc_lblRate_1);
		
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(7, 0, 7, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(rateB, gbc_textField_2);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnNewButton, gbc_btnNewButton);
		panel_1.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(name.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Please Enter The Location's Name", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(rateA.getText().trim().isEmpty() 
						||!rateA.getText().trim().matches(numToken))
				{
					JOptionPane.showMessageDialog(null,
							"Please Enter The Rate for Tripper For This Loaction", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(rateB.getText().trim().isEmpty() |!rateB	.getText().trim().matches(numToken))
				{
					JOptionPane.showMessageDialog(null,
							"Please Enter The Rate for Truck For This Loaction", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				databaseHelper.insertLocation(name.getText(),Integer.valueOf(rateA.getText().toString()), Integer.valueOf(rateB.getText().trim()));
				JOptionPane.showMessageDialog(null,
						"New Location Entered", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				name.setText("");
				rateA.setText("");
				rateB.setText("");
				
			}
		});
		
		add(panel_1, BorderLayout.NORTH);
		lblNewDestination.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewDestination.setForeground(new Color(0, 191, 255));
		
		panel_1.add(lblNewDestination);
	}

}
