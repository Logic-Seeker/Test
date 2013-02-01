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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.LaborHelper;

public class LaborWork extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DatabaseHelper databasehelper = new DatabaseHelper();
	String[] labortype = { "", "Madeshi", "Bokenya", "Patheri" };
	private final JLabel lblLaborType = new JLabel("Labor Type");
	private final JComboBox<LaborHelper> labourname = new JComboBox<LaborHelper>();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextPane textPane = new JTextPane();
	private final JComboBox comboBoxLaborType = new JComboBox(labortype);
	private final JPanel patheri = new JPanel();
	private final JPanel madhesi = new JPanel();
	private final JPanel bokenya = new JPanel();
	private final JLabel label_5 = new JLabel("Distance A");
	private final JLabel label_6 = new JLabel("Distance B");
	private final JLabel label_7 = new JLabel("Distance C");
	private final JTextField txtDistanceA = new JTextField();
	private final JTextField txtDistanceB = new JTextField();
	private final JTextField txtDistanceC = new JTextField();
	private final JButton btnSubmit = new JButton("Submit");
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JButton button = new JButton("");
	private final JLabel label = new JLabel("Transaction");
	private final JLabel lblBrickA = new JLabel("Brick A");
	private final JLabel lblBrickB = new JLabel("Brick B");
	private final JLabel label_3 = new JLabel("Distance A");
	private final JTextField txtBrickADistanceA = new JTextField();
	private final JTextField txtBrickBDistanceA = new JTextField();
	private final JLabel label_4 = new JLabel("Distance B");
	private final JTextField txtBrickADistanceB = new JTextField();
	private final JTextField txtBrickBDistanceB = new JTextField();
	private final JLabel label_8 = new JLabel("Distance C");
	private final JTextField txtBrickADistanceC = new JTextField();
	private final JTextField txtBrickBDistanceC = new JTextField();
	private final JTextField txtBrickAmount = new JTextField();
	private final JLabel lblLaborName = new JLabel("Labor Name");
	private final JLabel label_9 = new JLabel("Brick Amount");
	private final JLabel lblLaborWorkEntry = new JLabel("Labor Work Entry");
	private JPanel panelLabourWork;
	private String currentSelected;
	private DefaultComboBoxModel model;
	private LaborWork laborWork;

	/**
	 * Create the panel.new
	 */
	public LaborWork() {
		panelLabourWork = this;
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 140, 287, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 45, 45, 0, 0, 80, 0, 0 };
		// gbl_panel.columnWidths = new int[]{156, 124, 105, 79, 41, 43, 35, 81,
		// 0};
		// gbl_panel.rowHeights = new int[]{34, 44, 120, 0, 0, 0, 53, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_lblLaborName = new GridBagConstraints();
		gbc_lblLaborName.anchor = GridBagConstraints.WEST;
		gbc_lblLaborName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaborName.gridx = 0;
		gbc_lblLaborName.gridy = 0;
		lblLaborName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLaborName, gbc_lblLaborName);
		GridBagConstraints gbc_labourname = new GridBagConstraints();
		gbc_labourname.fill = GridBagConstraints.BOTH;
		gbc_labourname.insets = new Insets(7, 0, 7, 5);
		gbc_labourname.gridx = 1;
		gbc_labourname.gridy = 0;
		labourname.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(labourname, gbc_labourname);

		// AutoCompletion.enable(labourname);
		// new AutoCompleteData(labourname);
		GridBagConstraints gbc_lblLaborType = new GridBagConstraints();
		gbc_lblLaborType.anchor = GridBagConstraints.WEST;
		gbc_lblLaborType.insets = new Insets(0, 0, 5, 5);
		gbc_lblLaborType.gridx = 0;
		gbc_lblLaborType.gridy = 1;
		lblLaborType.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblLaborType, gbc_lblLaborType);
		GridBagConstraints gbc_comboBoxLaborType = new GridBagConstraints();
		gbc_comboBoxLaborType.fill = GridBagConstraints.BOTH;
		gbc_comboBoxLaborType.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxLaborType.gridx = 1;
		gbc_comboBoxLaborType.gridy = 1;
		comboBoxLaborType.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(comboBoxLaborType, gbc_comboBoxLaborType);
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
		GridBagConstraints gbc_patheri = new GridBagConstraints();
		gbc_patheri.gridwidth = 5;
		gbc_patheri.anchor = GridBagConstraints.WEST;
		gbc_patheri.insets = new Insets(20, 0, 20, 5);
		gbc_patheri.gridx = 0;
		gbc_patheri.gridy = 3;
		panel.add(patheri, gbc_patheri);
		GridBagConstraints gbc_bokenya = new GridBagConstraints();
		gbc_bokenya.gridwidth = 5;
		gbc_bokenya.anchor = GridBagConstraints.WEST;
		gbc_bokenya.insets = new Insets(20, 0, 20, 5);
		gbc_bokenya.gridx = 0;
		gbc_bokenya.gridy = 2;
		panel.add(bokenya, gbc_bokenya);
		GridBagLayout gbl_madhesi = new GridBagLayout();
		gbl_madhesi.columnWidths = new int[] { 140, 140, 143, 0 };
		gbl_madhesi.rowHeights = new int[] { 45, 45, 45, 45, 0 };
		gbl_madhesi.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_madhesi.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		GridBagConstraints gbc_madhesi = new GridBagConstraints();
		gbc_madhesi.gridheight = 2;
		gbc_madhesi.anchor = GridBagConstraints.NORTHWEST;
		gbc_madhesi.insets = new Insets(0, 0, 5, 5);
		gbc_madhesi.gridwidth = 5;
		gbc_madhesi.gridx = 0;
		gbc_madhesi.gridy = 2;
		panel.add(madhesi, gbc_madhesi);
		madhesi.setLayout(gbl_madhesi);

		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.SOUTHWEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(label, gbc_label);

		GridBagConstraints gbc_lblBrickA = new GridBagConstraints();
		gbc_lblBrickA.anchor = GridBagConstraints.SOUTH;
		gbc_lblBrickA.insets = new Insets(0, 0, 5, 10);
		gbc_lblBrickA.gridx = 1;
		gbc_lblBrickA.gridy = 0;
		lblBrickA.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(lblBrickA, gbc_lblBrickA);

		GridBagConstraints gbc_lblBrickB = new GridBagConstraints();
		gbc_lblBrickB.anchor = GridBagConstraints.SOUTH;
		gbc_lblBrickB.insets = new Insets(0, 0, 5, 0);
		gbc_lblBrickB.gridx = 2;
		gbc_lblBrickB.gridy = 0;
		lblBrickB.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(lblBrickB, gbc_lblBrickB);

		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 1;
		label_3.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(label_3, gbc_label_3);

		GridBagConstraints gbc_txtBrickADistanceA = new GridBagConstraints();
		gbc_txtBrickADistanceA.fill = GridBagConstraints.BOTH;
		gbc_txtBrickADistanceA.insets = new Insets(7, 0, 7, 5);
		gbc_txtBrickADistanceA.gridx = 1;
		gbc_txtBrickADistanceA.gridy = 1;
		txtBrickADistanceA.setColumns(10);
		madhesi.add(txtBrickADistanceA, gbc_txtBrickADistanceA);

		GridBagConstraints gbc_txtBrickBDistanceA = new GridBagConstraints();
		gbc_txtBrickBDistanceA.fill = GridBagConstraints.BOTH;
		gbc_txtBrickBDistanceA.insets = new Insets(7, 10, 7, 0);
		gbc_txtBrickBDistanceA.gridx = 2;
		gbc_txtBrickBDistanceA.gridy = 1;
		txtBrickBDistanceA.setColumns(10);
		madhesi.add(txtBrickBDistanceA, gbc_txtBrickBDistanceA);

		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 2;
		label_4.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(label_4, gbc_label_4);

		GridBagConstraints gbc_txtBrickADistanceB = new GridBagConstraints();
		gbc_txtBrickADistanceB.fill = GridBagConstraints.BOTH;
		gbc_txtBrickADistanceB.insets = new Insets(7, 0, 7, 5);
		gbc_txtBrickADistanceB.gridx = 1;
		gbc_txtBrickADistanceB.gridy = 2;
		txtBrickADistanceB.setColumns(10);
		madhesi.add(txtBrickADistanceB, gbc_txtBrickADistanceB);

		GridBagConstraints gbc_txtBrickBDistanceB = new GridBagConstraints();
		gbc_txtBrickBDistanceB.fill = GridBagConstraints.BOTH;
		gbc_txtBrickBDistanceB.insets = new Insets(7, 10, 7, 0);
		gbc_txtBrickBDistanceB.gridx = 2;
		gbc_txtBrickBDistanceB.gridy = 2;
		txtBrickBDistanceB.setColumns(10);
		madhesi.add(txtBrickBDistanceB, gbc_txtBrickBDistanceB);

		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.anchor = GridBagConstraints.WEST;
		gbc_label_8.insets = new Insets(0, 0, 0, 5);
		gbc_label_8.gridx = 0;
		gbc_label_8.gridy = 3;
		label_8.setFont(new Font("Dialog", Font.BOLD, 14));
		madhesi.add(label_8, gbc_label_8);

		GridBagConstraints gbc_txtBrickADistanceC = new GridBagConstraints();
		gbc_txtBrickADistanceC.fill = GridBagConstraints.BOTH;
		gbc_txtBrickADistanceC.insets = new Insets(7, 0, 7, 5);
		gbc_txtBrickADistanceC.gridx = 1;
		gbc_txtBrickADistanceC.gridy = 3;
		txtBrickADistanceC.setColumns(10);
		madhesi.add(txtBrickADistanceC, gbc_txtBrickADistanceC);

		GridBagConstraints gbc_txtBrickBDistanceC = new GridBagConstraints();
		gbc_txtBrickBDistanceC.insets = new Insets(7, 10, 7, 0);
		gbc_txtBrickBDistanceC.fill = GridBagConstraints.BOTH;
		gbc_txtBrickBDistanceC.gridx = 2;
		gbc_txtBrickBDistanceC.gridy = 3;
		txtBrickBDistanceC.setColumns(10);
		madhesi.add(txtBrickBDistanceC, gbc_txtBrickBDistanceC);
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.anchor = GridBagConstraints.SOUTH;
		gbc_btnSubmit.insets = new Insets(0, 100, 0, 100);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 4;
		panel.add(btnSubmit, gbc_btnSubmit);
		
		initGUI();
		populateLaborWork();
				labourname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = (((LaborHelper) labourname.getSelectedItem()).id);
				String result = databasehelper.fetchlabourtype(id);
				System.err.println(result);
				if (result.equalsIgnoreCase("patheri"))
				{
					comboBoxLaborType.setSelectedItem(labortype[3]);
				}
				else if (result.equalsIgnoreCase("bokenya"))
				{
					comboBoxLaborType.setSelectedItem(labortype[2]);
				}
				else
				{
					comboBoxLaborType.setSelectedItem(labortype[1]);
				}
			}
		});

		btnSubmit.addActionListener(new ButtonListener());
		button.addActionListener(new ButtonListener());

	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);

		panel_1.add(panel_2);
		lblLaborWorkEntry.setForeground(new Color(0, 191, 255));
		lblLaborWorkEntry.setFont(new Font("Dialog", Font.BOLD, 16));

		panel_2.add(lblLaborWorkEntry);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);

		panel_1.add(panel_3);
		button.setIcon(new ImageIcon("images/exit.png"));

		//panel_3.add(button);
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_bokenya = new GridBagLayout();
		gbl_bokenya.columnWidths = new int[] { 140, 287, 0 };
		gbl_bokenya.rowHeights = new int[] { 45, 45, 45, 0 };
		gbl_bokenya.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_bokenya.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		bokenya.setLayout(gbl_bokenya);
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 0;
		label_5.setFont(new Font("Dialog", Font.BOLD, 14));
		bokenya.add(label_5, gbc_label_5);
		GridBagConstraints gbc_txtDistanceA = new GridBagConstraints();
		gbc_txtDistanceA.fill = GridBagConstraints.BOTH;
		gbc_txtDistanceA.insets = new Insets(7, 0, 7, 0);
		gbc_txtDistanceA.gridx = 1;
		gbc_txtDistanceA.gridy = 0;
		txtDistanceA.setFont(new Font("Dialog", Font.PLAIN, 14));
		bokenya.add(txtDistanceA, gbc_txtDistanceA);
		txtDistanceA.setColumns(10);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 1;
		label_6.setFont(new Font("Dialog", Font.BOLD, 14));
		bokenya.add(label_6, gbc_label_6);
		GridBagConstraints gbc_txtDistanceB = new GridBagConstraints();
		gbc_txtDistanceB.fill = GridBagConstraints.BOTH;
		gbc_txtDistanceB.insets = new Insets(7, 0, 7, 0);
		gbc_txtDistanceB.gridx = 1;
		gbc_txtDistanceB.gridy = 1;
		txtDistanceB.setFont(new Font("Dialog", Font.PLAIN, 14));
		bokenya.add(txtDistanceB, gbc_txtDistanceB);
		txtDistanceB.setColumns(10);
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 2;
		label_7.setFont(new Font("Dialog", Font.BOLD, 14));
		bokenya.add(label_7, gbc_label_7);
		GridBagConstraints gbc_txtDistanceC = new GridBagConstraints();
		gbc_txtDistanceC.insets = new Insets(7, 0, 7, 0);
		gbc_txtDistanceC.fill = GridBagConstraints.BOTH;
		gbc_txtDistanceC.gridx = 1;
		gbc_txtDistanceC.gridy = 2;
		bokenya.add(txtDistanceC, gbc_txtDistanceC);
		txtDistanceC.setColumns(10);
		GridBagLayout gbl_patheri = new GridBagLayout();
		gbl_patheri.columnWidths = new int[] { 140, 287, 0 };
		gbl_patheri.rowHeights = new int[] { 45, 0 };
		gbl_patheri.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_patheri.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		patheri.setLayout(gbl_patheri);
		GridBagConstraints gbc_label_9 = new GridBagConstraints();
		gbc_label_9.anchor = GridBagConstraints.WEST;
		gbc_label_9.insets = new Insets(0, 0, 0, 5);
		gbc_label_9.gridx = 0;
		gbc_label_9.gridy = 0;
		label_9.setFont(new Font("Dialog", Font.BOLD, 14));
		patheri.add(label_9, gbc_label_9);
		txtBrickAmount.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtBrickAmount.setColumns(10);
		GridBagConstraints gbc_txtBrickAmount = new GridBagConstraints();
		gbc_txtBrickAmount.insets = new Insets(7, 0, 7, 0);
		gbc_txtBrickAmount.fill = GridBagConstraints.BOTH;
		gbc_txtBrickAmount.gridx = 1;
		gbc_txtBrickAmount.gridy = 0;
		patheri.add(txtBrickAmount, gbc_txtBrickAmount);

		madhesi.setVisible(false);
		patheri.setVisible(false);
		bokenya.setVisible(false);
		comboBoxLaborType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentSelected = comboBoxLaborType.getSelectedItem()
						.toString();
				if (currentSelected == "Bokenya") {
					patheri.setVisible(false);
					madhesi.setVisible(false);
					bokenya.setVisible(true);
				} else if (currentSelected == "Madeshi") {

					patheri.setVisible(false);
					bokenya.setVisible(false);
					madhesi.setVisible(true);

				} else if (currentSelected == "Patheri") {

					bokenya.setVisible(false);
					madhesi.setVisible(false);
					patheri.setVisible(true);

				} else {

					madhesi.setVisible(false);
					patheri.setVisible(false);
					bokenya.setVisible(false);
				}

			}
		});
	}

	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnSubmit) {
				boolean result = false;
				currentSelected = comboBoxLaborType.getSelectedItem()
						.toString();
				if (comboBoxLaborType.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Labour type is missing", "Missing field",
							JOptionPane.DEFAULT_OPTION);
					comboBoxLaborType.requestFocus();
					return;
				}
				String numToken = "[\\p{Digit}]+";

				if (currentSelected.equals("Bokenya")) {

					if (!txtDistanceA.getText().toString().trim().equals("")
							&& txtDistanceA.getText().toString()
									.matches(numToken))

					{
						result = true;
					}
					if (!txtDistanceB.getText().toString().trim().equals("")
							&& txtDistanceB.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtDistanceC.getText().toString().trim().equals("")
							&& txtDistanceC.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!result) {
						JOptionPane
								.showMessageDialog(
										null,
										"At least one of the field should be filled and should be Number",
										"Missing field",
										JOptionPane.DEFAULT_OPTION);
						txtDistanceA.requestFocus();
						return;
					}
				} else if (currentSelected.equals("Madeshi")) {
					result = false;
					if (!txtBrickADistanceA.getText().toString().trim()
							.equals("")
							&& txtBrickADistanceA.getText().toString()
									.matches(numToken)) {

						result = true;
					}
					if (!txtBrickADistanceB.getText().toString().trim()
							.equals("")
							&& txtBrickADistanceB.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtBrickADistanceC.getText().toString().trim()
							.equals("")
							&& txtBrickADistanceC.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtBrickBDistanceA.getText().toString().trim()
							.equals("")
							&& txtBrickBDistanceA.getText().toString()
									.matches(numToken)) {

						result = true;
					}
					if (!txtBrickBDistanceB.getText().toString().trim()
							.equals("")
							&& txtBrickBDistanceB.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtBrickBDistanceC.getText().toString().trim()
							.equals("")
							&& txtBrickBDistanceC.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtBrickADistanceC.getText().toString().trim()
							.equals("")
							&& txtBrickADistanceC.getText().toString()
									.matches(numToken)) {

						result = true;
					}
					if (!txtBrickBDistanceC.getText().toString().trim()
							.equals("")
							&& txtBrickBDistanceC.getText().toString()
									.matches(numToken)) {

						result = true;

					}
					if (!txtBrickBDistanceC.getText().toString().trim()
							.equals("")
							&& txtBrickBDistanceC.getText().toString()
									.matches(numToken)) {

						result = true;

					}

					if (!result) {
						JOptionPane
								.showMessageDialog(
										null,
										"At least one of the field should be filled and should be Number",
										"Missing field",
										JOptionPane.DEFAULT_OPTION);
						txtDistanceA.requestFocus();
						return;
					}
				} else if (currentSelected.equals("Patheri")) {
					System.out.println("456");

					if (txtBrickAmount.getText().toString().trim().equals("")
							&& !txtBrickAmount.getText().toString().trim()
									.matches(numToken)) {
						JOptionPane.showMessageDialog(null,
								"Enter Brick Amount", "Missing field",
								JOptionPane.DEFAULT_OPTION);
						txtBrickAmount.requestFocus();
						System.out.println("123");
						return;
					}
				}

				saveData(currentSelected);

			} else if (e.getSource() == button) {
				panelLabourWork.setVisible(false);
			}
		}
	}

	public void saveData(String currLabourType) {
		// login here
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		System.out.print(currentDate);

		if (currentSelected.equals("Patheri")) {

			int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
			int noOfBrick = Integer.valueOf(txtBrickAmount.getText().toString()
					.trim());
			float rate = databasehelper.getRate("patheri", 1);
			float amount = noOfBrick * rate;
			if (databasehelper.insertWorkEntry(labourId, -1, noOfBrick, amount,
					currentDate) > 0) {

				JOptionPane.showMessageDialog(null,
						"successfuly added Labour work", "",
						JOptionPane.DEFAULT_OPTION);
				textPane.setEditable(true);
				appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
				appendToPane(textPane, "(Patheri)"+"\n",Font.BOLD,Color.pink);
				appendToPanework(textPane, "Number of Bricks ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
				resetField();

			} else {
				JOptionPane.showMessageDialog(null,
						"Database connection error", "",
						JOptionPane.DEFAULT_OPTION);

			}
		} else if (currentSelected.equals("Bokenya")) {
			int result = -1;

			if (!txtDistanceA.getText().toString().trim().equals("")) {
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtDistanceA.getText()
						.toString().trim());
				float rate = databasehelper.getRate("Red Coin", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 1, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
				appendToPane(textPane, "(Bokenya)"+"\n",Font.BOLD,Color.pink);
				appendToPanework(textPane, "Distance A ="+noOfBrick+"\n",Color.black);
				//textPane.setText(textPane.getText()+"\n"+((LaborHelper) labourname.getSelectedItem()).name+"--->"+"Bokenya");
				//textArea.append("\n");
				//textArea.append("Distance A ="+noOfBrick);
				//appendToPane(textPane, ((LaborHelper) labourname.getSelectedItem()).name+"--->"+"Bokenya"+"\n", Font.BOLD,Color.black);
				textPane.setEditable(false);
			}
			if (!txtDistanceB.getText().toString().trim().equals("")) {
				if (txtDistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Bokenya)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtDistanceB.getText()
						.toString().trim());
				float rate = databasehelper.getRate("blue", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 1, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance B ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (!txtDistanceC.getText().toString().trim().equals("")) {
				if (txtDistanceB.getText().toString().trim().equals("") && txtDistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Bokenya)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtDistanceC.getText()
						.toString().trim());
				float rate = databasehelper.getRate("yellow", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 1, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance C ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (result > 0) {

				JOptionPane.showMessageDialog(null,
						"successfuly added Labour work", "",
						JOptionPane.DEFAULT_OPTION);
				resetField();
			} else {
				JOptionPane.showMessageDialog(null,
						"Database connection error", "",
						JOptionPane.DEFAULT_OPTION);
			}

		} else if (currentSelected.equals("Madeshi")) {
			int result = -1;
			// assumption brickA-->brick_id=1
			// brickB-->brick_id=2
			// distanceA-->Red Coin
			// distanceA-->blue
			// distanceA-->yellow
			if (!txtBrickADistanceA.getText().toString().trim().equals("")) {
				System.out.print("sss" + labourname.getSelectedItem());
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickADistanceA.getText()
						.toString().trim());
				float rate = databasehelper.getRate("Red Coin", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 1, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
				appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
				appendToPanework(textPane, "Distance A(Brick A) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (!txtBrickADistanceB.getText().toString().trim().equals("")) {
				if (txtBrickADistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickADistanceB.getText()
						.toString().trim());
				float rate = databasehelper.getRate("blue", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 2, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance B(Brick A) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (!txtBrickADistanceC.getText().toString().trim().equals("")) {
				if (txtBrickADistanceB.getText().toString().trim().equals("") && txtBrickADistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickADistanceC.getText()
						.toString().trim());
				float rate = databasehelper.getRate("yellow", 1);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 3, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance C(Brick A) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}

			if (!txtBrickBDistanceA.getText().toString().trim().equals("")) {
				if (txtBrickADistanceC.getText().toString().trim().equals("") && txtBrickADistanceB.getText().toString().trim().equals("") && txtBrickADistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				System.out.print("sss1" + labourname.getSelectedItem());
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickBDistanceA.getText()
						.toString().trim());
				float rate = databasehelper.getRate("Red Coin", 2);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 4, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance A(Brick B) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (!txtBrickBDistanceB.getText().toString().trim().equals("")) {
				if (txtBrickBDistanceA.getText().toString().trim().equals("") && txtBrickADistanceC.getText().toString().trim().equals("") && txtBrickADistanceB.getText().toString().trim().equals("") && txtBrickADistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickBDistanceB.getText()
						.toString().trim());
				float rate = databasehelper.getRate("blue", 2);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 5, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance B(Brick B) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (!txtBrickBDistanceC.getText().toString().trim().equals("")) {
				if (txtBrickBDistanceB.getText().toString().trim().equals("") && txtBrickBDistanceA.getText().toString().trim().equals("") && txtBrickADistanceC.getText().toString().trim().equals("") && txtBrickADistanceB.getText().toString().trim().equals("") && txtBrickADistanceA.getText().toString().trim().equals("")) {
					textPane.setEditable(true);
					appendToPane(textPane, "\n"+((LaborHelper) labourname.getSelectedItem()).name,Font.BOLD,Color.blue);
					appendToPane(textPane, "(Madesha)"+"\n",Font.BOLD,Color.pink);
					textPane.setEditable(false);
				}
				int labourId = ((LaborHelper) labourname.getSelectedItem()).id;
				int noOfBrick = Integer.valueOf(txtBrickBDistanceC.getText()
						.toString().trim());
				float rate = databasehelper.getRate("yellow", 2);
				float amount = noOfBrick * rate;
				result = databasehelper.insertWorkEntry(labourId, 6, noOfBrick,
						amount, currentDate);
				textPane.setEditable(true);
				appendToPanework(textPane, "Distance C(Brick B) ="+noOfBrick+"\n",Color.black);
				textPane.setEditable(false);
			}
			if (result > 0) {

				JOptionPane.showMessageDialog(null,
						"successfuly added Labour work", "",
						JOptionPane.DEFAULT_OPTION);
				resetField();

			} else {
				JOptionPane.showMessageDialog(null,
						"Database connection error", "",
						JOptionPane.DEFAULT_OPTION);
			}

		}

	}
	
	private void appendToPane(JTextPane tp, String msg, int bold,Color c)
    {
		System.err.println(bold);
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground,c);
        aset = sc.addAttribute(aset, StyleConstants.CharacterConstants.Bold, true);
        aset = sc.addAttribute(aset, StyleConstants.FontSize,18);
        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
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

	public void resetField() {
		txtBrickADistanceA.setText("");
		txtBrickADistanceB.setText("");
		txtBrickADistanceC.setText("");
		txtBrickBDistanceA.setText("");
		txtBrickBDistanceB.setText("");
		txtBrickBDistanceC.setText("");
		txtDistanceA.setText("");
		txtDistanceB.setText("");
		txtDistanceC.setText("");
		txtBrickAmount.setText("");

	}
	
	public void populateLaborWork(){
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		list = databasehelper.fetchLaborName();
		labourname.setEditable(true);
		labourname.setRenderer(new ComboBoxItemRenderer());
		labourname.setEditor(new ComboBoxItemEditor());
		model=new DefaultComboBoxModel();
		labourname.setModel(model);
		if(list.isEmpty())
		{
			
			labourname.setSelectedItem(new LaborHelper());
		}
		for (LaborHelper laborHelper : list) {
			System.err.println("laborwork 876");
			model.addElement(laborHelper);
		}

	}
	
}
