package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.LaborHelper;

public class LabourAdvance extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAdvance = new JLabel("Advance");
	private final JLabel lblLabourName = new JLabel("Labour Name");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JTextField textField = new JTextField();
	private final JComboBox<LaborHelper> labourname = new JComboBox<LaborHelper>();
	private final JButton btnSubmit = new JButton("Submit");
	DatabaseHelper databasehelper = new DatabaseHelper();
	private DefaultComboBoxModel model;

	/**
	 * Create the panel.
	 */
	public LabourAdvance() {
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		populateLabourAdvance();
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
		
		GridBagConstraints gbc_lblLabourName = new GridBagConstraints();
		gbc_lblLabourName.anchor = GridBagConstraints.WEST;
		gbc_lblLabourName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabourName.gridx = 0;
		gbc_lblLabourName.gridy = 0;
		lblLabourName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLabourName, gbc_lblLabourName);
		
		GridBagConstraints gbc_labourname = new GridBagConstraints();
		gbc_labourname.fill = GridBagConstraints.BOTH;
		gbc_labourname.insets = new Insets(7, 0, 7, 5);
		gbc_labourname.gridx = 1;
		gbc_labourname.gridy = 0;
		labourname.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(labourname, gbc_labourname);
		
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

	public void populateLabourAdvance(){
		System.err.println("niraj ji ko halchabar");
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		list = databasehelper.fetchLaborName();
		labourname.setEditable(true);
		labourname.setRenderer(new ComboBoxItemRenderer());
		labourname.setEditor(new ComboBoxItemEditor());
		model=new DefaultComboBoxModel();
		labourname.setModel(model);
		if (list.isEmpty())
		{
			labourname.setSelectedItem(new LaborHelper());
		}
		
		for (LaborHelper laborHelper : list) {

			model.addElement(laborHelper);
		}

	}
}
