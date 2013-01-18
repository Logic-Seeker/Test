package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import com.brick.database.DatabaseHelper;

public class Labor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] labortype = { "", "Madeshi", "Bokenya", "Patheri" };

	private final JTextPane textPane = new JTextPane();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JLabel lblNewLabel = new JLabel("Labor Name");
	private final JLabel lblLaborType = new JLabel("Labor Type");
	private final JTextField textField = new JTextField();
	private final JButton btnAddNewLabor = new JButton("Add New Labor");
	private final JComboBox comboBox = new JComboBox(labortype);
	private final JLabel lblBrickAmount = new JLabel("Brick Amount");
	private final JTextField textField_1 = new JTextField();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel lblNewLaborForm = new JLabel("New Labor Form");
	private JPanel panelLabour;
	private LaborRecords laborRecord;
	private LaborWork laborWork;
	private LabourAdvance labourAdvance;

	/**
	 * Create the panel.
	 */
	public Labor() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 134, 277 };
		gbl_panel.rowHeights = new int[] { 45, 45, 45, 80 };
		// gbl_panel.columnWidths = new int[]{202, 114, 139, 0};
		// gbl_panel.rowHeights = new int[]{25, 15, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);
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
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(7, 0, 7, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(21);
		GridBagConstraints gbc_lblLaborType = new GridBagConstraints();
		gbc_lblLaborType.anchor = GridBagConstraints.WEST;
		gbc_lblLaborType.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaborType.gridx = 0;
		gbc_lblLaborType.gridy = 1;
		lblLaborType.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLaborType, gbc_lblLaborType);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(7, 0, 7, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		panel.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_lblBrickAmount = new GridBagConstraints();
		gbc_lblBrickAmount.anchor = GridBagConstraints.WEST;
		gbc_lblBrickAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblBrickAmount.gridx = 0;
		gbc_lblBrickAmount.gridy = 2;
		lblBrickAmount.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblBrickAmount, gbc_lblBrickAmount);
		lblBrickAmount.setVisible(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(7, 0, 7, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(21);
		textField_1.setVisible(false);
		GridBagConstraints gbc_btnAddNewLabor = new GridBagConstraints();
		gbc_btnAddNewLabor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAddNewLabor.insets = new Insets(0, 120, 0, 120);
		gbc_btnAddNewLabor.gridwidth = 2;
		gbc_btnAddNewLabor.anchor = GridBagConstraints.SOUTH;
		gbc_btnAddNewLabor.gridx = 0;
		gbc_btnAddNewLabor.gridy = 3;
		btnAddNewLabor.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(btnAddNewLabor, gbc_btnAddNewLabor);
		panelLabour = this;
		initGUI();
	}

	private void initGUI() {
		btnAddNewLabor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText() != null
						&& comboBox.getSelectedItem().toString() != null) {

					DatabaseHelper databaseHelper = new DatabaseHelper();
					if (databaseHelper.insertLabour(textField.getText()
							.toString(), comboBox.getSelectedItem().toString(),
							textField_1.getText().toString()) > 0) {
						JOptionPane.showMessageDialog(null,
								"successfully added", "succedd",
								JOptionPane.DEFAULT_OPTION);
						textPane.setEditable(true);
						appendToPanework(textPane, "\n"+textField.getText()
							.toString()+"\n", Color.blue);
						appendToPanework(textPane, "Type = "+comboBox.getSelectedItem().toString()+"\n", Color.blue);
						if(!comboBox.getSelectedItem().toString().equalsIgnoreCase("patheri"))
						{
							appendToPanework(textPane, "Brick Amount = "+textField_1.getText().toString()+"\n", Color.blue);
						}
						textPane.setEditable(false);
						laborRecord.populateTable();
						laborWork.populateLaborWork();
						labourAdvance.populateLabourAdvance();
						resetFields();
					}

				}

			}
		});
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelLabour.setVisible(false);
			}
		});

		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.CENTER);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = comboBox.getSelectedItem().toString();
				if (name == "Bokenya" || name == "Madeshi") {
					lblBrickAmount.setVisible(true);
					textField_1.setVisible(true);

				} else {
					lblBrickAmount.setVisible(false);
					textField_1.setVisible(false);

				}
			}
		});

		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);

		panel_1.add(panel_2);
		lblNewLaborForm.setForeground(new Color(0, 191, 255));
		lblNewLaborForm.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLaborForm.setHorizontalAlignment(SwingConstants.LEFT);

		panel_2.add(lblNewLaborForm);
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);

		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));

		//panel_3.add(button);
	}

	private void resetFields() {
		textField.setText("");
		textField_1.setText("");
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
	
	public void setLaborRecord(LaborRecords laborRecords){
	
		this.laborRecord = laborRecords;
	}
	public void setLaborWork(LaborWork laborWorks){
		
		this.laborWork = laborWorks;
	}
public void setLaborAdvance(LabourAdvance labourAdvances){
		
		this.labourAdvance = labourAdvances;
	}
	
}
