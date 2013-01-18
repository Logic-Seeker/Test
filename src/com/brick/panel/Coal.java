package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.brick.database.DatabaseHelper;

public class Coal extends JPanel {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateFormat.format(date);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblCoalExpense = new JLabel("Coal Expense");
	private final JLabel lblDate = new JLabel("Date");
	private final JLabel lblAmount = new JLabel("Amount");
	private final JLabel lblRate = new JLabel("Rate");
	private final JTextField textField = new JTextField(currentDate);
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JLabel lblInKg = new JLabel("in Kg");
	private final JButton btnNewButton = new JButton("Submit\n");
	String floatcheck = "^([1-9]\\d*|0)(\\.\\d)?$";
	DatabaseHelper databaseHelper = new DatabaseHelper();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();
	

	/**
	 * Create the panel.
	 */
	public Coal() {
		textField_2.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField.setFont(new Font("Dialog", Font.PLAIN, 14));
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{120, 240, 0};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 80};
		//gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 0;
		lblDate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 30, 0, 0);
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		//gbc_textPane.setRows(1);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		panel.add(scrollPane,gbc_scrollPane);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(7, 0, 7, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_lblAmount = new GridBagConstraints();
		gbc_lblAmount.anchor = GridBagConstraints.WEST;
		gbc_lblAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAmount.gridx = 0;
		gbc_lblAmount.gridy = 1;
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblAmount, gbc_lblAmount);
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(7, 0, 7, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		
		GridBagConstraints gbc_lblInKg = new GridBagConstraints();
		gbc_lblInKg.insets = new Insets(0, 0, 5, 0);
		gbc_lblInKg.gridx = 2;
		gbc_lblInKg.gridy = 1;
		lblInKg.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblInKg, gbc_lblInKg);
		
		GridBagConstraints gbc_lblRate = new GridBagConstraints();
		gbc_lblRate.anchor = GridBagConstraints.WEST;
		gbc_lblRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRate.gridx = 0;
		gbc_lblRate.gridy = 2;
		lblRate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblRate, gbc_lblRate);
		
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(7, 0, 7, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel.add(textField_2, gbc_textField_2);
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.SOUTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date = textField.getText();
				String amount = textField_1.getText();
				String rate = textField_2.getText();
				System.err.println(amount);
				if (!isValidDate(date))
				{
					JOptionPane.showMessageDialog(null,
							"Date is not Valid", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!amount.matches(floatcheck) && !rate.matches(floatcheck))
				{	
					JOptionPane.showMessageDialog(null,
							"Please check the format of Amount or Rate", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
					
				}
				
				Object value[] = (Object[])databaseHelper.insertCoal(date,amount,rate);
				if ((Integer)value[0] == 1)
				{
					JOptionPane.showMessageDialog(null,
							"New entry success", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					textField.setText(currentDate);
					textField_1.setText("");
					textField_2.setText("");
					textPane.setEditable(true);
					appendToPanework(textPane, "\nDate = "+date+"\n",Color.BLUE);
					appendToPanework(textPane, "Amount = "+amount+"\n", Color.BLUE);
					appendToPanework(textPane, "Rate = "+rate+"\n", Color.BLUE);
					textPane.setEditable(false);
				}
				
			}
		});
		panel.add(btnNewButton, gbc_btnNewButton);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblCoalExpense.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCoalExpense.setForeground(new Color(0, 191, 255));
		lblCoalExpense.setBackground(new Color(0, 191, 255));
		
		panel_1.add(lblCoalExpense);
	}
	public boolean isValidDate(String date) {
		String errormessage=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date testDate = null;
		try {
		testDate = sdf.parse(date);
		} catch (ParseException e) {
		errormessage = "the date you provided is in an invalid date" +
		" format.";
		return false;
		}
		if (!sdf.format(testDate).equals(date)) {
		errormessage = "The date that you provided is invalid.";
		return false;
		}
		System.out.print(errormessage);
		return true;
		}
	private void appendToPanework(JTextPane tp, String msg,Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground,c);
        aset = sc.addAttribute(aset, StyleConstants.CharacterConstants.Bold, true);
        aset = sc.addAttribute(aset, StyleConstants.FontSize,15);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }
}
