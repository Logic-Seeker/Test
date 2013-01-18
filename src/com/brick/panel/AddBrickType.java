package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import com.brick.database.DatabaseHelper;

public class AddBrickType extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblAddBrickType = new JLabel("Add Brick Type");
	private final JLabel lblBrickType = new JLabel("Brick Type");
	private final JLabel lblBrickDescription = new JLabel("Brick Description");
	private final JLabel lblRate = new JLabel("Rate");
	private final JTextField txtBrickType = new JTextField();
	private final JTextField txtBrickDescription = new JTextField();
	private final JTextField txtRate = new JTextField();
	private final JButton btnAdd = new JButton("Add");
	private JPanel panelAddBrickType;

	/**
	 * Create the panel.
	 */
	public AddBrickType() {
		panelAddBrickType = this;
		txtRate.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtRate.setColumns(10);
		txtBrickDescription.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtBrickDescription.setColumns(10);
		txtBrickType.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtBrickType.setColumns(10);
		final String numToken = "[\\p{Digit}]+";
		txtRate.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				if (txtRate.getText().toString().trim().length() > 0
						&& !txtRate.getText().toString().trim()
								.matches(numToken)) {
					JOptionPane.showMessageDialog(null,
							"Rate should be a number", "Invalid input",
							JOptionPane.DEFAULT_OPTION);
					txtRate.requestFocus();
				}
			}
		});

		initGUI();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] { 45, 45, 45, 80 };
		gbl_panel.columnWidths = new int[] { 0, 200 };
		// gbl_panel.columnWidths = new int[]{0, 0, 0};
		// gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);

		GridBagConstraints gbc_lblBrickType = new GridBagConstraints();
		gbc_lblBrickType.anchor = GridBagConstraints.WEST;
		gbc_lblBrickType.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrickType.gridx = 0;
		gbc_lblBrickType.gridy = 0;
		lblBrickType.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblBrickType, gbc_lblBrickType);

		GridBagConstraints gbc_txtBrickType = new GridBagConstraints();
		gbc_txtBrickType.insets = new Insets(7, 0, 7, 0);
		gbc_txtBrickType.fill = GridBagConstraints.BOTH;
		gbc_txtBrickType.gridx = 1;
		gbc_txtBrickType.gridy = 0;
		panel.add(txtBrickType, gbc_txtBrickType);

		GridBagConstraints gbc_lblBrickDescription = new GridBagConstraints();
		gbc_lblBrickDescription.anchor = GridBagConstraints.WEST;
		gbc_lblBrickDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrickDescription.gridx = 0;
		gbc_lblBrickDescription.gridy = 1;
		lblBrickDescription.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblBrickDescription, gbc_lblBrickDescription);

		GridBagConstraints gbc_txtBrickDescription = new GridBagConstraints();
		gbc_txtBrickDescription.insets = new Insets(7, 0, 7, 0);
		gbc_txtBrickDescription.fill = GridBagConstraints.BOTH;
		gbc_txtBrickDescription.gridx = 1;
		gbc_txtBrickDescription.gridy = 1;
		panel.add(txtBrickDescription, gbc_txtBrickDescription);

		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.anchor = GridBagConstraints.WEST;
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 2;
		lblRate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate, gbc_lblRate);

		GridBagConstraints gbc_txtRate = new GridBagConstraints();
		gbc_txtRate.insets = new Insets(7, 0, 7, 0);
		gbc_txtRate.fill = GridBagConstraints.BOTH;
		gbc_txtRate.gridx = 1;
		gbc_txtRate.gridy = 2;
		panel.add(txtRate, gbc_txtRate);

		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.gridwidth = 2;
		gbc_btnAdd.anchor = GridBagConstraints.SOUTH;
		gbc_btnAdd.insets = new Insets(0, 100, 0, 100);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 14));
		btnAdd.addActionListener(new CustomActionListner());
		panel.add(btnAdd, gbc_btnAdd);

		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);

		panel_1.add(panel_2);
		lblAddBrickType.setForeground(new Color(0, 191, 255));
		lblAddBrickType.setFont(new Font("Dialog", Font.BOLD, 16));

		panel_2.add(lblAddBrickType);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);

		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));
		button.addActionListener(new CustomActionListner());

		panel_3.add(button);
	}

	public class CustomActionListner implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			DatabaseHelper databaseHelper = new DatabaseHelper();
			if (e.getSource() == btnAdd) {
				if (txtBrickType.getText() == null
						|| txtBrickType.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Brick type",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtBrickType.requestFocus();
					return;
				}
				if (txtBrickDescription.getText() == null
						|| txtBrickDescription.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Enter brick description", "Missing fields",
							JOptionPane.DEFAULT_OPTION);
					txtBrickDescription.requestFocus();
					return;
				}
				if (txtRate.getText() == null || txtRate.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter rate for type",
							"Missing fields", JOptionPane.DEFAULT_OPTION);
					txtRate.requestFocus();
					return;
				}
				int result = databaseHelper.addBrickType(txtBrickType.getText()
						.toString(), txtBrickDescription.getText().toString(),
						Float.parseFloat(txtRate.getText().toString()));
				if (result > 0) {
					JOptionPane.showMessageDialog(null,
							"successfuly added brick type", "",
							JOptionPane.DEFAULT_OPTION);
					resetFields();

				} else {
					JOptionPane.showMessageDialog(null,
							"Database connection error", "",
							JOptionPane.DEFAULT_OPTION);

				}

			} else if (e.getSource() == button) {
				panelAddBrickType.setVisible(false);
			}
		}
	}
	private void resetFields(){
		txtRate.setText("");
		txtBrickDescription.setText("");
		txtBrickType.setText("");
	}

}
