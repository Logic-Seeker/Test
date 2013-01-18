package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;

public class Customer extends JPanel {

	/**
	 * 
	 */
	private JPanel panelAddCustomer;
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblAddNewCustomer = new JLabel("Add New Customer");
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JLabel lblPermanentAddress = new JLabel("Permanent Address");
	private final JLabel lblTemporaryAddresss = new JLabel("Temporary Addresss");
	private final JLabel lblMobileNo = new JLabel("Mobile No");
	private final JLabel lblTelephoneNo = new JLabel("Telephone No");
	private final JTextField txtCustomerName = new JTextField();
	private final JTextField txtPermanentAddress = new JTextField();
	private final JTextField txtTemporaryAddress = new JTextField();
	private final JTextField txtMobileNo = new JTextField();
	private final JTextField txtTelephoneNo = new JTextField();
	private final JButton btnCreate = new JButton("Create");

	/**
	 * Create the panel.
	 */
	public Customer() {
		panelAddCustomer = this;
		txtTelephoneNo.setColumns(10);
		txtMobileNo.setColumns(10);
		txtTemporaryAddress.setColumns(10);
		txtPermanentAddress.setColumns(10);
		txtCustomerName.setColumns(10);

		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] { 45, 45, 45, 45, 45, 80 };
		gbl_panel.columnWidths = new int[] { 186, 203 };
		// gbl_panel.columnWidths = new int[]{0, 0, 0};
		// gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
		gbc_lblCustomerName.anchor = GridBagConstraints.WEST;
		gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerName.gridx = 0;
		gbc_lblCustomerName.gridy = 0;
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblCustomerName, gbc_lblCustomerName);

		GridBagConstraints gbc_txtCustomerName = new GridBagConstraints();
		gbc_txtCustomerName.insets = new Insets(7, 0, 7, 0);
		gbc_txtCustomerName.fill = GridBagConstraints.BOTH;
		gbc_txtCustomerName.gridx = 1;
		gbc_txtCustomerName.gridy = 0;
		panel.add(txtCustomerName, gbc_txtCustomerName);

		GridBagConstraints gbc_lblPermanentAddress = new GridBagConstraints();
		gbc_lblPermanentAddress.anchor = GridBagConstraints.WEST;
		gbc_lblPermanentAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblPermanentAddress.gridx = 0;
		gbc_lblPermanentAddress.gridy = 1;
		lblPermanentAddress.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPermanentAddress, gbc_lblPermanentAddress);

		GridBagConstraints gbc_txtPermanentAddress = new GridBagConstraints();
		gbc_txtPermanentAddress.insets = new Insets(7, 0, 7, 0);
		gbc_txtPermanentAddress.fill = GridBagConstraints.BOTH;
		gbc_txtPermanentAddress.gridx = 1;
		gbc_txtPermanentAddress.gridy = 1;
		panel.add(txtPermanentAddress, gbc_txtPermanentAddress);

		GridBagConstraints gbc_lblTemporaryAddresss = new GridBagConstraints();
		gbc_lblTemporaryAddresss.anchor = GridBagConstraints.WEST;
		gbc_lblTemporaryAddresss.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemporaryAddresss.gridx = 0;
		gbc_lblTemporaryAddresss.gridy = 2;
		lblTemporaryAddresss.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTemporaryAddresss, gbc_lblTemporaryAddresss);

		GridBagConstraints gbc_txtTemporaryAddress = new GridBagConstraints();
		gbc_txtTemporaryAddress.insets = new Insets(7, 0, 7, 0);
		gbc_txtTemporaryAddress.fill = GridBagConstraints.BOTH;
		gbc_txtTemporaryAddress.gridx = 1;
		gbc_txtTemporaryAddress.gridy = 2;
		panel.add(txtTemporaryAddress, gbc_txtTemporaryAddress);

		GridBagConstraints gbc_lblMobileNo = new GridBagConstraints();
		gbc_lblMobileNo.anchor = GridBagConstraints.WEST;
		gbc_lblMobileNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobileNo.gridx = 0;
		gbc_lblMobileNo.gridy = 3;
		lblMobileNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblMobileNo, gbc_lblMobileNo);

		GridBagConstraints gbc_txtMobileNo = new GridBagConstraints();
		gbc_txtMobileNo.insets = new Insets(7, 0, 7, 0);
		gbc_txtMobileNo.fill = GridBagConstraints.BOTH;
		gbc_txtMobileNo.gridx = 1;
		gbc_txtMobileNo.gridy = 3;
		panel.add(txtMobileNo, gbc_txtMobileNo);

		GridBagConstraints gbc_lblTelephoneNo = new GridBagConstraints();
		gbc_lblTelephoneNo.anchor = GridBagConstraints.WEST;
		gbc_lblTelephoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephoneNo.gridx = 0;
		gbc_lblTelephoneNo.gridy = 4;
		lblTelephoneNo.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblTelephoneNo, gbc_lblTelephoneNo);

		GridBagConstraints gbc_txtTelephoneNo = new GridBagConstraints();
		gbc_txtTelephoneNo.insets = new Insets(7, 0, 7, 0);
		gbc_txtTelephoneNo.fill = GridBagConstraints.BOTH;
		gbc_txtTelephoneNo.gridx = 1;
		gbc_txtTelephoneNo.gridy = 4;
		panel.add(txtTelephoneNo, gbc_txtTelephoneNo);

		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreate.anchor = GridBagConstraints.SOUTH;
		gbc_btnCreate.gridwidth = 2;
		gbc_btnCreate.insets = new Insets(0, 100, 0, 100);
		gbc_btnCreate.gridx = 0;
		gbc_btnCreate.gridy = 5;

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtCustomerName.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Name Field Should not be empty", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					txtCustomerName.requestFocus();
					System.out.println("here");
				} else if (txtPermanentAddress.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Permanent Address Field Should not be empty",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					txtPermanentAddress.requestFocus();

				} else {
					DatabaseHelper databasehelper = new DatabaseHelper();
					databasehelper.insertCustomer(txtCustomerName.getText(),
							txtPermanentAddress.getText(), txtTemporaryAddress
									.getText(), Integer.valueOf(txtMobileNo
									.getText().trim().isEmpty() ? "0"
									: txtMobileNo.getText().trim()), Integer
									.valueOf(txtTelephoneNo.getText().trim()
											.isEmpty() ? "0" : txtTelephoneNo
											.getText().trim()));
					txtCustomerName.setText("");
					txtPermanentAddress.setText("");
					txtTemporaryAddress.setText("");
					txtTelephoneNo.setText("");
					txtMobileNo.setText("");
					JOptionPane.showMessageDialog(null,
							"New Employee Added Successfully", "SUCCESS",
							JOptionPane.DEFAULT_OPTION);

				}
			}
		});

		panel.add(btnCreate, gbc_btnCreate);

		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);

		panel_1.add(panel_2);
		lblAddNewCustomer.setForeground(new Color(0, 191, 255));
		lblAddNewCustomer.setFont(new Font("Dialog", Font.BOLD, 16));

		panel_2.add(lblAddNewCustomer);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);

		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panelAddCustomer.setVisible(false);
			}
		});

		//panel_3.add(button);
	}

}
