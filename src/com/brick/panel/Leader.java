package com.brick.panel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;

import com.brick.database.DatabaseHelper;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leader extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAddNewLeader = new JLabel("Add New Leader");
	private final JLabel lblLeaderName = new JLabel("Leader Name");
	private final JTextField txtname = new JTextField();
	private final JLabel lblAddress = new JLabel("Address");
	private final JTextField txtaddress = new JTextField();
	private final JLabel lblMobileNo = new JLabel("Mobile No.");
	private final JTextField txtmobile = new JTextField();
	private final JLabel lblTelephoneNo = new JLabel("Telephone No.");
	private final JTextField txttelephone = new JTextField();
	private final JLabel lblRate = new JLabel("Rate");
	private final JTextField txtrate = new JTextField();
	private final JButton btnAddLeader = new JButton("Add Leader");
	String floatcheck = "^([0-9]\\d*|0)(\\.\\d)?$";
	DatabaseHelper databaseHelper = new DatabaseHelper();
	/**
	 * Create the panel.
	 */
	public Leader() {
		txtrate.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtrate.setColumns(10);
		txttelephone.setFont(new Font("Dialog", Font.PLAIN, 14));
		txttelephone.setColumns(10);
		txtmobile.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtmobile.setColumns(10);
		txtaddress.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtaddress.setColumns(10);
		txtname.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtname.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		gbl_panel.columnWidths = new int[]{160, 160};
		//gbl_panel.columnWidths = new int[]{164, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblLeaderName = new GridBagConstraints();
		gbc_lblLeaderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeaderName.anchor = GridBagConstraints.WEST;
		gbc_lblLeaderName.gridx = 0;
		gbc_lblLeaderName.gridy = 0;
		lblLeaderName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLeaderName, gbc_lblLeaderName);
		
		GridBagConstraints gbc_txtname = new GridBagConstraints();
		gbc_txtname.insets = new Insets(7, 0, 7, 0);
		gbc_txtname.fill = GridBagConstraints.BOTH;
		gbc_txtname.gridx = 1;
		gbc_txtname.gridy = 0;
		panel.add(txtname, gbc_txtname);
		
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 1;
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblAddress, gbc_lblAddress);
		
		GridBagConstraints gbc_txtaddress = new GridBagConstraints();
		gbc_txtaddress.insets = new Insets(7, 0, 7, 0);
		gbc_txtaddress.fill = GridBagConstraints.BOTH;
		gbc_txtaddress.gridx = 1;
		gbc_txtaddress.gridy = 1;
		panel.add(txtaddress, gbc_txtaddress);
		
		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.anchor = GridBagConstraints.WEST;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 2;
		lblMobileNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblMobileNo, gbc_lblMobileNo);
		
		GridBagConstraints gbc_txtmobile = new GridBagConstraints();
		gbc_txtmobile.insets = new Insets(7, 0, 7, 0);
		gbc_txtmobile.fill = GridBagConstraints.BOTH;
		gbc_txtmobile.gridx = 1;
		gbc_txtmobile.gridy = 2;
		panel.add(txtmobile, gbc_txtmobile);
		
		GridBagConstraints gbc_lblTelephoneNo = new GridBagConstraints();
		gbc_lblTelephoneNo.anchor = GridBagConstraints.WEST;
		gbc_lblTelephoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephoneNo.gridx = 0;
		gbc_lblTelephoneNo.gridy = 3;
		lblTelephoneNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTelephoneNo, gbc_lblTelephoneNo);
		
		GridBagConstraints gbc_txttelephone = new GridBagConstraints();
		gbc_txttelephone.insets = new Insets(7, 0, 7, 0);
		gbc_txttelephone.fill = GridBagConstraints.BOTH;
		gbc_txttelephone.gridx = 1;
		gbc_txttelephone.gridy = 3;
		panel.add(txttelephone, gbc_txttelephone);
		
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.anchor = GridBagConstraints.WEST;
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 4;
		lblRate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate, gbc_lblRate);
		
		GridBagConstraints gbc_txtrate = new GridBagConstraints();
		gbc_txtrate.insets = new Insets(7, 0, 7, 0);
		gbc_txtrate.fill = GridBagConstraints.BOTH;
		gbc_txtrate.gridx = 1;
		gbc_txtrate.gridy = 4;
		panel.add(txtrate, gbc_txtrate);
		
		GridBagConstraints gbc_btnAddLeader = new GridBagConstraints();
		gbc_btnAddLeader.anchor = GridBagConstraints.SOUTH;
		gbc_btnAddLeader.gridwidth = 2;
		gbc_btnAddLeader.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddLeader.gridx = 0;
		gbc_btnAddLeader.gridy = 5;
		btnAddLeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String name = txtname.getText();
				String address = txtaddress.getText();
				String mobile = txtmobile.getText();
				String telephone = txttelephone.getText();
				String rate = txtrate.getText();
				
				if (name.trim().isEmpty() || address.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Name and Address field should not be empty", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!mobile.matches(floatcheck) && !mobile.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Please Check The Mobile Number", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!telephone.matches(floatcheck) && !telephone.trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null,
							"Please Check The Number", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!rate.trim().isEmpty())
				{
				if (!rate.matches(floatcheck) )
				{
					JOptionPane.showMessageDialog(null,
							"Please Check The Rate", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				}
				
				int result = databaseHelper.insertleader(name,address,mobile,telephone,rate);
				if(result == 1)
				{
					JOptionPane.showMessageDialog(null,
							"successfully added", "succedd",
							JOptionPane.DEFAULT_OPTION);
				txtname.setText("");
				txtaddress.setText("");
				txtmobile.setText("");
				txtrate.setText("");
				txttelephone.setText("");
				
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"There was some problem.Please try again", "Failed",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnAddLeader, gbc_btnAddLeader);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblAddNewLeader.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAddNewLeader.setForeground(new Color(0, 255, 255));
		
		panel_1.add(lblAddNewLeader);
	}

}
