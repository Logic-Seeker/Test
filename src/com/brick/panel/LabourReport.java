package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.brick.database.DatabaseHelper;
import com.brick.helper.LaborHelper;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class LabourReport extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel lblLabourName = new JLabel("Labour Name");
	private final JComboBox<LaborHelper> comboBoxLabourName = new JComboBox<LaborHelper>();
	private final JScrollPane scrollPane = new JScrollPane();
	Vector row;
	Vector columnNames = new Vector();
	Vector data = new Vector();
	Vector row1;
	Vector columnNames1 = new Vector();
	Vector data1 = new Vector();

	JTable table, table1;
	DefaultTableModel test, test1;
	int a = 1;
	int b = 1;
	DatabaseHelper databaseHelper = new DatabaseHelper();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();

	/**
	 * Create the panel.
	 */
	public LabourReport() {

		initGUI();
		revalidate();
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panel_1.add(lblLabourName);
		comboBoxLabourName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(((LaborHelper) comboBoxLabourName
						.getSelectedItem()).type);
				int id = ((LaborHelper) comboBoxLabourName.getSelectedItem()).id;
				if (((LaborHelper) comboBoxLabourName.getSelectedItem()).type
						.equalsIgnoreCase("patheri")) {
					System.err.println("any");
					displaypatheri(id);
				} else {
					display(id);
				}
			}
		});

		panel_1.add(comboBoxLabourName);
		DatabaseHelper databasehelper = new DatabaseHelper();
		ArrayList<LaborHelper> list = new ArrayList<LaborHelper>();
		list = databasehelper.fetchLaborName();
		comboBoxLabourName.setRenderer(new MyListRender());
		comboBoxLabourName.setEditor(new searchComboBoxEditor());
		for (LaborHelper laborHelper : list) {

			comboBoxLabourName.addItem(laborHelper);
		}
		
		
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new CardLayout(0, 0));

		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(scrollPane);

		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(scrollPane_1);
		// try{
		// ResultSet resultSet = databaseHelper.fetchworkdetail(1);
		// ResultSetMetaData metaData = resultSet.getMetaData();
		// int columns = metaData.getColumnCount();
		// for (int i = 1; i <= columns; i++) {
		// columnNames.addElement(metaData.getColumnName(i));
		// }
		// while (resultSet.next()) {
		// Vector row = new Vector(columns);
		// for (int i = 1; i <= columns; i++) {
		// row.addElement(resultSet.getObject(i));
		// }
		// data.addElement(row);
		// }
		// }catch (SQLException e) {
		//
		// e.printStackTrace();
		// }
		// table = new JTable(data,columnNames);

		// table.getColumnModel().getColumn(0).setMinWidth(96);
		// table.getColumnModel().getColumn(1).setPreferredWidth(81);
		// table.getColumnModel().getColumn(1).setMinWidth(81);
		// table.getColumnModel().getColumn(2).setPreferredWidth(135);
		// table.getColumnModel().getColumn(2).setMinWidth(135);
		//

	}

	public class MyListRender extends JLabel implements
			ListCellRenderer<Object> {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(
				JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			LaborHelper tt = (LaborHelper) value;

			setText(tt.name);
			return this;
		}

	}

	class searchComboBoxEditor implements ComboBoxEditor {
		JTextField jTextField;

		public searchComboBoxEditor() {
			super();
			jTextField = new JTextField();
		}

		@Override
		public void setItem(Object anObject) {

			if (anObject instanceof LaborHelper) {
				LaborHelper o = (LaborHelper) anObject;
				jTextField.setText(o.name);
			} else {
				jTextField.setText((String) anObject);
			}

		}

		@Override
		public Object getItem() {
			return jTextField.getText();
		}

		@Override
		public Component getEditorComponent() {
			// TODO Auto-generated method stub
			return jTextField;
		}

		@Override
		public void selectAll() {
			jTextField.selectAll();

		}

		@Override
		public void addActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

		@Override
		public void removeActionListener(ActionListener l) {
			// TODO Auto-generated method stub

		}

	}

	public void display(int id) {

		panel_4.setVisible(true);
		panel_3.setVisible(false);
		// scrollPane.setVisible(false);
		// scrollPane_1.setVisible(true);
		System.out.println(id);
		try {
			ResultSet resultSet = databaseHelper.fetchworkdetail(id);
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
		scrollPane_1.setViewportView(table);
		System.out.print("madishi her");

	}

	public void displaypatheri(int id) {
		panel_3.setVisible(true);
		panel_4.setVisible(false);
		// scrollPane.setVisible(true);
		// scrollPane_1.setVisible(false);
		System.out.println("here");
		try {
			ResultSet resultSet = databaseHelper.fetchpatheri(id);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columns = metaData.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames1.addElement(metaData.getColumnName(i));
			}

			data1.removeAllElements();
			while (resultSet.next()) {
				row1 = new Vector(columns);
				for (int i = 1; i <= columns; i++) {
					row1.addElement(resultSet.getObject(i));
				}

				data1.addElement(row1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (a == 1) {
			test1 = new DefaultTableModel(data1, columnNames1);
			table1 = new JTable(test1);
			a = a - 1;
		}
		int count = table1.getRowCount();
		System.err.println(count);
		int count1 = scrollPane.countComponents();
		System.err.println(count1);
		table1.revalidate();
		scrollPane.setViewportView(table1);

		System.out.print("atheri her");
	}

}
