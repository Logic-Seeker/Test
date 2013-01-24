package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.CustomerHelper;
import com.brick.helper.LaborHelper;
import com.brick.helper.LeaderHelper;

public class LeaderAdvance extends JPanel {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateFormat.format(date);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblAdvance = new JLabel("Advance");
	private final JTextField textField = new JTextField();
	private final JLabel lblLeaderName = new JLabel("Leader Name");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JLabel lblDate = new JLabel("Date");
	private final JTextField textDate = new JTextField(currentDate);
	private final JComboBox<LeaderHelper> leadername = new JComboBox<LeaderHelper>();
	private final JButton btnNewButton = new JButton("New button");
	DatabaseHelper databasehelper = new DatabaseHelper();
	private DefaultComboBoxModel model;
	String numToken = "[\\p{Digit}]+";

	/**
	 * Create the panel.
	 */
	public LeaderAdvance() {
		textField.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		populateLeader();
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{160, 240};
		gbl_panel.rowHeights = new int[]{45, 45,45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblLeaderName = new GridBagConstraints();
		gbc_lblLeaderName.anchor = GridBagConstraints.WEST;
		gbc_lblLeaderName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLeaderName.gridx = 0;
		gbc_lblLeaderName.gridy = 0;
		lblLeaderName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLeaderName, gbc_lblLeaderName);
		
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 2;
		lblDate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblDate, gbc_lblDate);
	
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		leadername.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(leadername, gbc_comboBox);
		
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
		
		GridBagConstraints gbc_textDate = new GridBagConstraints();
		gbc_textDate.insets = new Insets(7, 0, 7, 0);
		gbc_textDate.fill = GridBagConstraints.BOTH;
		gbc_textDate.gridx = 1;
		gbc_textDate.gridy = 2;
		panel.add(textDate, gbc_textDate);
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		panel_1.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
				{
					int id =((LeaderHelper) leadername.getSelectedItem()).id;
					String amount =textField.getText();
					try {
						date = dateFormat.parse(textDate.getText());
					} catch (ParseException e1) {
					
						e1.printStackTrace();
						return;
					}
					
					if (amount.trim().isEmpty() && !amount.matches(numToken))
					{
						JOptionPane.showMessageDialog(null, "Please check the amount", "Failed", JOptionPane.ERROR_MESSAGE);
					}
					
					Object result[]=(Object[])databasehelper.insertleaderadvance(id, amount, date);
					
					if ((Integer)result[0] == 1)
					{
						JOptionPane.showMessageDialog(null,
								"New entry success", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						textDate.setText(currentDate);
						textField.setText("");
					}
					
				}
		});

		
		add(panel_1, BorderLayout.NORTH);
		lblAdvance.setForeground(new Color(0, 191, 255));
		lblAdvance.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_1.add(lblAdvance);
	}

	public void populateLeader(){
		ArrayList<LeaderHelper> list = new ArrayList<LeaderHelper>();
		list = databasehelper.fetchLeaderName();
		leadername.setEditable(true);
		leadername.setRenderer(new ComboBoxItemRenderer());
		leadername.setEditor(new ComboBoxItemEditor());
		model=new DefaultComboBoxModel();

		for (LeaderHelper leaderHelper : list) {
			model.addElement(leaderHelper);
		}
		leadername.setModel(model);

	}

}
