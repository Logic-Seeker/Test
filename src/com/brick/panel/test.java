package com.brick.panel;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.TextField;

import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class test extends JPanel {
	private final JPanel panel = new JPanel();
	private final JTextField textField = new JTextField();
	private final JButton btnConfirm = new JButton("Confirm");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();

	/**
	 * Create the panel.
	 */
	public test() {
		textField.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 100};
		//gbl_panel.columnWidths = new int[]{0, 300, 0};
		//gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 0;
		gbc_btnConfirm.gridy = 4;
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(textPane);
		panel.add(btnConfirm, gbc_btnConfirm);
	}

}
