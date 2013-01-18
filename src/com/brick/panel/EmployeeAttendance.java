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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

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
import javax.swing.SwingConstants;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.EmployeeHelper;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeAttendance extends JPanel {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateFormat.format(date);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JLabel lblEmployeeName = new JLabel("Employee Name");
	private final JCheckBox chckbxAbsent = new JCheckBox("Absent");
	private final JCheckBox chckbxLeave = new JCheckBox("Leave");
	private final JLabel lblDate = new JLabel("Date");
	private final JTextField txtdate = new JTextField(currentDate);
	private final JTextField txtreason = new JTextField();
	private final JTextField txtNoofDay = new JTextField();
	private final JButton button = new JButton("");
	private final JLabel lblAttendance = new JLabel("Attendance");
	private final JButton btnAttend = new JButton("Attend");
	private DefaultComboBoxModel model;
	private final JComboBox<EmployeeHelper> comboBoxEmployeeName = new JComboBox<EmployeeHelper>();
	DatabaseHelper databasehelper = new DatabaseHelper();
	private final JScrollPane scrollPane = new JScrollPane();
	JTable table;
	private final JLabel lblNoOfDays = new JLabel("No of Days");
	DatabaseHelper databaseHelper = new DatabaseHelper();
	Vector row;
	Vector columnNames = new Vector();	
	Vector data = new Vector();
	int b=1;
	DefaultTableModel test;
	
	
	

	 /**
	 * Create the panel.
	 */
	public EmployeeAttendance() {
		txtNoofDay.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtNoofDay.setColumns(10);
		txtreason.setToolTipText("Reason");
		txtreason.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtreason.setColumns(10);
		txtdate.setToolTipText("Year-Month-Day");
		txtdate.setFont(new Font("Dialog", Font.PLAIN, 14));
		txtdate.setColumns(10);

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 80, 300};
		gbl_panel.columnWidths = new int[]{350, 180, 240, 350};
		//gbl_panel.rowHeights = new int[]{45, 45, 45, 45, 45, 80, 0};
		//gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		GridBagConstraints gbc_lblEmployeeName = new GridBagConstraints();
		gbc_lblEmployeeName.anchor = GridBagConstraints.WEST;
		gbc_lblEmployeeName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmployeeName.gridx = 1;
		gbc_lblEmployeeName.gridy = 0;
		lblEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblEmployeeName, gbc_lblEmployeeName);
		
		GridBagConstraints gbc_comboBoxEmployeeName = new GridBagConstraints();
		gbc_comboBoxEmployeeName.insets = new Insets(7, 0, 7, 5);
		gbc_comboBoxEmployeeName.fill = GridBagConstraints.BOTH;
		gbc_comboBoxEmployeeName.gridx = 2;
		gbc_comboBoxEmployeeName.gridy = 0;
		comboBoxEmployeeName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = ((EmployeeHelper) comboBoxEmployeeName.getSelectedItem()).id;
				display(id);
			}
		});
		comboBoxEmployeeName.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(comboBoxEmployeeName, gbc_comboBoxEmployeeName);
		ArrayList<EmployeeHelper> employeelist = new ArrayList<EmployeeHelper>();
		employeelist = databasehelper.fetchEmployeeName();
		comboBoxEmployeeName.setEditable(true);
		comboBoxEmployeeName.setRenderer(new ComboBoxItemRenderer());
		comboBoxEmployeeName.setEditor(new ComboBoxItemEditor());
		model = new DefaultComboBoxModel();
		comboBoxEmployeeName.setModel(model);
		for (EmployeeHelper employeeHelper : employeelist) {
			model.addElement(employeeHelper);
			System.out.println(employeeHelper.name);
		}
		
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 1;
		gbc_lblDate.gridy = 1;
		lblDate.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_txtdate = new GridBagConstraints();
		gbc_txtdate.insets = new Insets(7, 0, 7, 5);
		gbc_txtdate.fill = GridBagConstraints.BOTH;
		gbc_txtdate.gridx = 2;
		gbc_txtdate.gridy = 1;
		panel.add(txtdate, gbc_txtdate);
		
		GridBagConstraints gbc_chckbxAbsent = new GridBagConstraints();
		gbc_chckbxAbsent.anchor = GridBagConstraints.WEST;
		gbc_chckbxAbsent.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAbsent.gridx = 1;
		gbc_chckbxAbsent.gridy = 2;
		chckbxAbsent.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(chckbxAbsent, gbc_chckbxAbsent);
		
		GridBagConstraints gbc_chckbxLeave = new GridBagConstraints();
		gbc_chckbxLeave.anchor = GridBagConstraints.WEST;
		gbc_chckbxLeave.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxLeave.gridx = 1;
		gbc_chckbxLeave.gridy = 3;
		chckbxLeave.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(chckbxLeave, gbc_chckbxLeave);
		
		GridBagConstraints gbc_txtreason = new GridBagConstraints();
		gbc_txtreason.insets = new Insets(7, 0, 7, 5);
		gbc_txtreason.fill = GridBagConstraints.BOTH;
		gbc_txtreason.gridx = 2;
		gbc_txtreason.gridy = 3;
		panel.add(txtreason, gbc_txtreason);
		
		GridBagConstraints gbc_lblNoOfDays = new GridBagConstraints();
		gbc_lblNoOfDays.insets = new Insets(0, 0, 5, 5);
		gbc_lblNoOfDays.anchor = GridBagConstraints.WEST;
		gbc_lblNoOfDays.gridx = 1;
		gbc_lblNoOfDays.gridy = 4;
		lblNoOfDays.setFont(new Font("Dialog", Font.BOLD, 14));
		panel.add(lblNoOfDays, gbc_lblNoOfDays);
		
		GridBagConstraints gbc_txtNoofDay = new GridBagConstraints();
		gbc_txtNoofDay.insets = new Insets(7, 0, 7, 5);
		gbc_txtNoofDay.fill = GridBagConstraints.BOTH;
		gbc_txtNoofDay.gridx = 2;
		gbc_txtNoofDay.gridy = 4;
		panel.add(txtNoofDay, gbc_txtNoofDay);
		
		GridBagConstraints gbc_btnAttend = new GridBagConstraints();
		gbc_btnAttend.insets = new Insets(0, 0, 5, 5);
		gbc_btnAttend.gridwidth = 2;
		gbc_btnAttend.gridx = 1;
		gbc_btnAttend.gridy = 5;
		btnAttend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int id =((EmployeeHelper) comboBoxEmployeeName.getSelectedItem()).id;
				Date date;
				try {
					date = dateFormat.parse(txtdate.getText());
				} catch (ParseException e1) {
				
					e1.printStackTrace();
					return;
				}
				
				
				if (chckbxAbsent.isSelected() && chckbxLeave.isSelected())
				{
					JOptionPane.showMessageDialog(null,
							"Please select only one option, Either Absent or Leave", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (!chckbxAbsent.isSelected() && !chckbxLeave.isSelected())
				{
					JOptionPane.showMessageDialog(null,
							"Please select one option, Either Absent or Leave", "Failed",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
					int absent=0;
					int leave=0;
				
				 if (chckbxAbsent.isSelected())
				 {
					 absent =1;
					 leave =0;
				 }
				 if (chckbxLeave.isSelected())
				 {
					 leave =1;
					 absent =0;
					 if (txtreason.getText().trim().isEmpty())
					 {
						 JOptionPane.showMessageDialog(null,
									"Please Enter reason fo Leave", "Failed",
									JOptionPane.ERROR_MESSAGE);
						 return;
						 
					 }
				 }
				 String reason = txtreason.getText();
				 int NoOfDays =Integer.valueOf( txtNoofDay.getText().trim().isEmpty() ? "1" : txtNoofDay.getText().trim()) ;
				 
				 
				 
				 while (NoOfDays>0)
				 {
				 Calendar c = Calendar.getInstance();
					c.setTime(date);
					c.add(Calendar.DATE, 1);
					Date newDate = c.getTime();
					databaseHelper.insertabsent(id,date,absent,leave,reason);
					System.err.println(newDate);
					System.err.println("shobhab");
					date = newDate;
					NoOfDays = NoOfDays-1;
				 }
				
				table.revalidate();
				scrollPane.revalidate();
				scrollPane.repaint();
				display(1);
				
			}
		});
		panel.add(btnAttend, gbc_btnAttend);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		panel.add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(table);
		
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.setBackground(Color.GRAY);
		
		panel_1.add(panel_2);
		lblAttendance.setForeground(new Color(0, 191, 255));
		lblAttendance.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_2.add(lblAttendance);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_3.setBackground(Color.GRAY);
		
		panel_1.add(panel_3);
		button.setHorizontalAlignment(SwingConstants.RIGHT);
		button.setIcon(new ImageIcon("/home/shobhab/Development/workspace/Inventory Management1.0/images/exit.png"));
		
		//panel_3.add(button);
	}

	public void display(int id) {

		// scrollPane.setVisible(false);
		// scrollPane_1.setVisible(true);
		System.out.println(id);
		try {
			ResultSet resultSet = databaseHelper.fetchattendance(id);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columns = metaData.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnName(i));
			}

			data.removeAllElements();
			while (resultSet.next()) {
				row = new Vector(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(resultSet.getObject(i));
				}

				data.addElement(row);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (b == 1) {
			test = new DefaultTableModel(data, columnNames);
			table = new JTable(test);
			b = b - 1;
		}

		table.revalidate();
		scrollPane.setViewportView(table);
		System.out.print("madishi her");

	}
}
