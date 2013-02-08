package com.brick.panel;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import com.brick.database.DatabaseHelper;
import com.brick.helper.VehicleInfo;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewVehicle extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JLabel lblVehicleNumber = new JLabel("Vehicle Number");
	private final JLabel lblVehicleDescription = new JLabel("Vehicle Tpye");
	private final JButton btnCancle = new JButton("Save");
	private final JTextField txtVehicleNo = new JTextField();
	String[] comboBoxArray = {"Tripper","Truck"};
	private final JComboBox txtVehicleDescription = new JComboBox(comboBoxArray);
	private final JLabel lblVehicle = new JLabel("New Vehicle Information");
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private JPanel panelNewVechile;

	/**
	 * Create the panel.
	 */
	public NewVehicle() {
		panelNewVechile=this;
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{45, 45, 80};
		gbl_panel.columnWidths = new int[]{193, 287};
		//gbl_panel.columnWidths = new int[]{184, 287};
		//gbl_panel.rowHeights = new int[]{45, 45, 80};
		//gbl_panel.rowHeights = new int[]{38, 36, 34, 42, 37};
		//gbl_panel.columnWidths = new int[]{92, 77, 4, 0};
		//gbl_panel.rowHeights = new int[]{40, 38, 34, 42, 37};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_lblVehicleNumber = new GridBagConstraints();
		gbc_lblVehicleNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVehicleNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleNumber.gridx = 0;
		gbc_lblVehicleNumber.gridy = 0;
		lblVehicleNumber.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblVehicleNumber, gbc_lblVehicleNumber);
		txtVehicleNo.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtVehicleNo.setColumns(10);
		GridBagConstraints gbc_txtVehicleNo = new GridBagConstraints();
		gbc_txtVehicleNo.fill = GridBagConstraints.BOTH;
		gbc_txtVehicleNo.insets = new Insets(7, 0, 7, 0);
		gbc_txtVehicleNo.gridx = 1;
		gbc_txtVehicleNo.gridy = 0;
		panel.add(txtVehicleNo, gbc_txtVehicleNo);
		GridBagConstraints gbc_lblVehicleDescription = new GridBagConstraints();
		gbc_lblVehicleDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVehicleDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblVehicleDescription.gridx = 0;
		gbc_lblVehicleDescription.gridy = 1;
		lblVehicleDescription.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblVehicleDescription, gbc_lblVehicleDescription);
		GridBagConstraints gbc_txtVehicleDescription = new GridBagConstraints();
		gbc_txtVehicleDescription.fill = GridBagConstraints.BOTH;
		gbc_txtVehicleDescription.insets = new Insets(7, 0, 7, 0);
		gbc_txtVehicleDescription.gridx = 1;
		gbc_txtVehicleDescription.gridy = 1;
		txtVehicleDescription.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(txtVehicleDescription, gbc_txtVehicleDescription);
		GridBagConstraints gbc_btnCancle = new GridBagConstraints();
		gbc_btnCancle.gridwidth = 2;
		gbc_btnCancle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancle.anchor = GridBagConstraints.SOUTH;
		gbc_btnCancle.insets = new Insets(0, 120, 0, 120);
		gbc_btnCancle.gridx = 0;
		gbc_btnCancle.gridy = 2;
		btnCancle.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnCancle, gbc_btnCancle);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);
		
		panel_1.add(panel_2);
		lblVehicle.setForeground(new Color(0, 191, 255));
		panel_2.add(lblVehicle);
		lblVehicle.setFont(new Font("Dialog", Font.BOLD, 16));
		lblVehicle.setVerticalAlignment(SwingConstants.TOP);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);
		
		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));
		
		button.addActionListener(new ButtonListener());
		btnCancle.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener {
		DatabaseHelper databaseHelper = new DatabaseHelper();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCancle) {
				if (txtVehicleNo.getText() == null
						|| txtVehicleNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter Vechile no",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtVehicleNo.requestFocus();
					return;
				}
				/*if (txtVehicleDescription.getText() == null
						|| txtVehicleDescription.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter vechile description",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtVehicleNo.requestFocus();
					return;
				}*/
				// login here
				if (databaseHelper.addNewVechile(txtVehicleNo.getText()
						.toString(), txtVehicleDescription.getSelectedItem().toString()) != -1) {

					JOptionPane.showMessageDialog(null,
							"successfuly added new vechile", "",
							JOptionPane.DEFAULT_OPTION);
					txtVehicleNo.setText("");
					

				} else {
					JOptionPane.showMessageDialog(null, "error in connecton",
							"", JOptionPane.DEFAULT_OPTION);
				}

			} else if (e.getSource() == button) {
				panelNewVechile.setVisible(false);
			}
		}
	}
}
