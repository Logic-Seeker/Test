package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;
import java.awt.Font;

public class NewUser extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblNewLabel = new JLabel("User Name");
	private final JLabel lblPassword = new JLabel("Password");
	private final JLabel lblReenterPassword = new JLabel("Re-enter Password");
	private final JTextField txtUsername = new JTextField();
	private final JPasswordField txtPassword = new JPasswordField();
	private final JPasswordField txtCPassword = new JPasswordField();
	private final JButton btnSave = new JButton("Save");
	private final JLabel lblAddNewUser = new JLabel("Add New User");

	private JPanel newuserPanel;

	/**
	 * Create the panel.
	 */
	public NewUser() {
		txtUsername.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtUsername.setColumns(21);
		txtUsername.setBounds(40, 30, 100, 25);
		newuserPanel = this;
		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 167, 266 };
		gbl_panel.rowHeights = new int[] { 45, 45, 45, 80 };
		// gbl_panel.columnWidths = new int[]{0, 0, 0};
		// gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.insets = new Insets(7, 0, 7, 0);
		gbc_txtUsername.fill = GridBagConstraints.BOTH;
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		panel.add(txtUsername, gbc_txtUsername);

		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblPassword, gbc_lblPassword);

		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(7, 0, 7, 0);
		gbc_txtPassword.fill = GridBagConstraints.BOTH;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		panel.add(txtPassword, gbc_txtPassword);

		GridBagConstraints gbc_lblReenterPassword = new GridBagConstraints();
		gbc_lblReenterPassword.anchor = GridBagConstraints.WEST;
		gbc_lblReenterPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblReenterPassword.gridx = 0;
		gbc_lblReenterPassword.gridy = 2;
		lblReenterPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblReenterPassword, gbc_lblReenterPassword);

		GridBagConstraints gbc_txtCPassword = new GridBagConstraints();
		gbc_txtCPassword.insets = new Insets(7, 0, 7, 0);
		gbc_txtCPassword.fill = GridBagConstraints.BOTH;
		gbc_txtCPassword.gridx = 1;
		gbc_txtCPassword.gridy = 2;
		panel.add(txtCPassword, gbc_txtCPassword);

		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 120, 0, 120);
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave.gridwidth = 2;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 3;
		btnSave.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnSave, gbc_btnSave);

		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);

		panel_1.add(panel_2);
		lblAddNewUser.setForeground(new Color(0, 191, 255));
		lblAddNewUser.setFont(new Font("Dialog", Font.BOLD, 16));

		panel_2.add(lblAddNewUser);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);

		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));

		txtUsername.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE)
						|| (Character.isDigit(c)) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Invalid Character",
							"ERROR", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});

		btnSave.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(ActionEvent e) {
				DatabaseHelper databaseHelper = new DatabaseHelper();
				if (txtUsername.getText() == null
						|| txtUsername.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Username",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtUsername.requestFocus();
					return;
				}
				if (txtPassword.getText() == null
						|| txtPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Password",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtPassword.requestFocus();
					return;
				}
				if (txtCPassword.getText() == null
						|| txtCPassword.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Confirm your password", "Missing fields",
							JOptionPane.DEFAULT_OPTION);
					txtCPassword.requestFocus();
					return;
				}
				if (!txtPassword.getText().equals(txtCPassword.getText())) {
					JOptionPane.showMessageDialog(null,
							"Passwords do not match.", "ERROR",
							JOptionPane.DEFAULT_OPTION);
					txtCPassword.requestFocus();
					return;
				}

				if (databaseHelper.addNewUser(txtUsername.getText().toString(),
						txtPassword.getText().toString()) > 0) {
					JOptionPane.showMessageDialog(null,
							"A new user is created", "SUCCESS",
							JOptionPane.DEFAULT_OPTION);
					resetField();

				}

			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				newuserPanel.setVisible(false);
			}
		});

	}

	private void resetField() {
		txtCPassword.setText("");
		txtPassword.setText("");
		txtUsername.setText("");
	}

}
