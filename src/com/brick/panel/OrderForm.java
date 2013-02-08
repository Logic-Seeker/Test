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
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.CustomerHelper;

public class OrderForm extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblOrder = new JLabel("Order");
	private final JLabel lblCustomerName = new JLabel("Customer Name");
	private final JLabel lblBrick = new JLabel("GradeA");
	private final JLabel lblBrickB = new JLabel("GradeB");
	private final JCheckBox chckbxHalf = new JCheckBox("Half");
	private final JLabel lblDestination = new JLabel("Destination");
	private final JComboBox comboBoxCustomerName = new JComboBox();
	private final JTextField txtDestination = new JTextField();
	private final JTextField txtBrickA = new JTextField();
	private final JTextField txtBrickB = new JTextField();
	private final JTextField txtHalf = new JTextField();
	private final JButton btnOrder = new JButton("Order");
	private JPanel panelOrderForm;
	private DatabaseHelper databaseHelper = new DatabaseHelper();
	private DefaultComboBoxModel model;

	/**
	 * Create the panel.
	 */
	public OrderForm() {
		txtHalf.setColumns(10);
		txtBrickA.setColumns(10);
		txtBrickB.setColumns(10);
		txtDestination.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{165, 200};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
		gbc_lblCustomerName.anchor = GridBagConstraints.WEST;
		gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomerName.gridx = 0;
		gbc_lblCustomerName.gridy = 0;
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblCustomerName, gbc_lblCustomerName);
		
		GridBagConstraints gbc_comboBoxCustomerName = new GridBagConstraints();
		gbc_comboBoxCustomerName.insets = new Insets(7, 0, 7, 0);
		gbc_comboBoxCustomerName.fill = GridBagConstraints.BOTH;
		gbc_comboBoxCustomerName.gridx = 1;
		gbc_comboBoxCustomerName.gridy = 0;
		panel.add(comboBoxCustomerName, gbc_comboBoxCustomerName);
		
		GridBagConstraints gbc_lblDestination = new GridBagConstraints();
		gbc_lblDestination.anchor = GridBagConstraints.WEST;
		gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestination.gridx = 0;
		gbc_lblDestination.gridy = 1;
		lblDestination.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblDestination, gbc_lblDestination);
		
		GridBagConstraints gbc_txtDestination = new GridBagConstraints();
		gbc_txtDestination.insets = new Insets(7, 0, 7, 0);
		gbc_txtDestination.fill = GridBagConstraints.BOTH;
		gbc_txtDestination.gridx = 1;
		gbc_txtDestination.gridy = 1;
		panel.add(txtDestination, gbc_txtDestination);
		
		GridBagConstraints gbc_lblBrick = new GridBagConstraints();
		gbc_lblBrick.anchor = GridBagConstraints.WEST;
		gbc_lblBrick.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrick.gridx = 0;
		gbc_lblBrick.gridy = 2;
		lblBrick.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblBrick, gbc_lblBrick);
		
		GridBagConstraints gbc_lblBrickB = new GridBagConstraints();
		gbc_lblBrick.anchor = GridBagConstraints.WEST;
		gbc_lblBrick.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrick.gridx = 0;
		gbc_lblBrick.gridy = 3;
		lblBrickB.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblBrickB, gbc_lblBrick);
		
		GridBagConstraints gbc_txtBrick = new GridBagConstraints();
		gbc_txtBrick.insets = new Insets(7, 0, 7, 0);
		gbc_txtBrick.fill = GridBagConstraints.BOTH;
		gbc_txtBrick.gridx = 1;
		gbc_txtBrick.gridy = 2;
		txtBrickA.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(txtBrickA, gbc_txtBrick);
		
		GridBagConstraints gbc_txtBrickB = new GridBagConstraints();
		gbc_txtBrickB.insets = new Insets(7, 0, 7, 0);
		gbc_txtBrickB.fill = GridBagConstraints.BOTH;
		gbc_txtBrickB.gridx = 1;
		gbc_txtBrickB.gridy = 3;
		txtBrickB.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(txtBrickB, gbc_txtBrickB);
		
		GridBagConstraints gbc_chckbxHalf = new GridBagConstraints();
		gbc_chckbxHalf.anchor = GridBagConstraints.WEST;
		gbc_chckbxHalf.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxHalf.gridx = 0;
		gbc_chckbxHalf.gridy = 4;
		chckbxHalf.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(chckbxHalf, gbc_chckbxHalf);
		
		GridBagConstraints gbc_txtHalf = new GridBagConstraints();
		gbc_txtHalf.insets = new Insets(7, 0, 7, 0);
		gbc_txtHalf.fill = GridBagConstraints.BOTH;
		gbc_txtHalf.gridx = 1;
		gbc_txtHalf.gridy = 4;
		panel.add(txtHalf, gbc_txtHalf);
		
		GridBagConstraints gbc_btnOrder = new GridBagConstraints();
		gbc_btnOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOrder.gridwidth = 2;
		gbc_btnOrder.anchor = GridBagConstraints.SOUTH;
		gbc_btnOrder.insets = new Insets(0, 100, 0, 100);
		gbc_btnOrder.gridx = 0;
		gbc_btnOrder.gridy = 5;
		btnOrder.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnOrder, gbc_btnOrder);
		
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);
		
		panel_1.add(panel_2);
		lblOrder.setFont(new Font("Dialog", Font.BOLD, 16));
		lblOrder.setForeground(new Color(0, 191, 255));
		
		panel_2.add(lblOrder);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);
		
		panel_1.add(panel_3);
		
		
		panel_3.add(button);
		button.addActionListener(new CustomActionListner());
		btnOrder.addActionListener(new CustomActionListner());

		comboBoxCustomerName.setEditable(true);
		comboBoxCustomerName.setRenderer(new ComboBoxItemRenderer());

		ArrayList<CustomerHelper> customerList = databaseHelper.getCustomer();
		comboBoxCustomerName.setEditor(new ComboBoxItemEditor());
		model=new DefaultComboBoxModel();
		comboBoxCustomerName.setModel(model);
		for (CustomerHelper customerHelper : customerList) {
			model.addElement(customerHelper);
		}

	}

	
	public class CustomActionListner implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnOrder) {
				if (((CustomerHelper) comboBoxCustomerName.getSelectedItem()).name
						.equals("")) {
					JOptionPane.showMessageDialog(null, " Select Customer",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					comboBoxCustomerName.requestFocus();
					return;
				}
				if (txtDestination.getText().toString().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter description",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtDestination.requestFocus();
					return;
				}
				if (txtBrickA.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter brick ",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtBrickA.requestFocus();
					return;
				}
				int id = ((CustomerHelper) comboBoxCustomerName
						.getSelectedItem()).id;
				int gradeA = Integer.valueOf(txtBrickA.getText().trim()
						.equals("") ? "0" : txtBrickA.getText().toString());
				int gradeB = Integer.valueOf(txtBrickB.getText().trim()
						.equals("") ? "0" : txtBrickB.getText().toString());
				int half_brick = Integer.valueOf(txtHalf.getText().trim()
						.equals("") ? "0" : txtHalf.getText().toString());

				int result = databaseHelper.insertOrderEntry(id, txtDestination
						.getText().toString(),gradeA,gradeB, half_brick);
				if (result > 0) {

					JOptionPane.showMessageDialog(null,
							"successfuly added order entry", "",
							JOptionPane.DEFAULT_OPTION);
					resetField();

				} else {
					JOptionPane.showMessageDialog(null,
							"Database connection error", "",
							JOptionPane.DEFAULT_OPTION);
				}

			} else if (e.getSource() == button) {
				panelOrderForm.setVisible(false);
			}
		}
	}

	public void resetField() {
		txtBrickA.setText("");
		txtDestination.setText("");
		txtHalf.setText("");
	}
}
