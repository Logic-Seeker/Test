package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.brick.database.DatabaseHelper;
import com.mysql.jdbc.ResultSetMetaData;

import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrderRecords extends JPanel {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblOrderRecords = new JLabel("Order Records");
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	private final JPanel panel_5 = new JPanel();
	private final JPanel panel_6 = new JPanel();
	private final JPanel panel_7 = new JPanel();
	private final JLabel lblOrderToBe = new JLabel("Order To Be Delivered");
	private final JLabel lblOrderDelivered = new JLabel("Order Delivered");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JScrollPane scrollPane1 = new JScrollPane();

	JTable table;
	JTable table1;
	DatabaseHelper databaseHelper = new DatabaseHelper();
	Vector row;
	Vector row1;
	Vector columnNames = new Vector();
	Vector columnNames1= new Vector();
	Vector data= new Vector();
	Vector data1= new Vector();
	DefaultTableModel test,test1;
	String numToken = "[\\p{Digit}]+";
	boolean isTableInit,isTableInit1=false;
	String floatcheck = "^([1-9]\\d*|0)(\\.\\d)?$";
	LeaderAdvance advance = new LeaderAdvance();

	/**
	 * Create the panel.
	 */

	public void populateTable(){
		try {
			ResultSet resultSet = databaseHelper.fetchorder();
			ResultSetMetaData metaData1 = (ResultSetMetaData) resultSet
					.getMetaData();
			int columns = metaData1.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData1.getColumnLabel(i));
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

		
		
		if(!isTableInit){
			test = new DefaultTableModel(data, columnNames) {
				public boolean isCellEditable(int row, int column) {
					// only columns 0 and 1 are editable
					return column == 1 || column == 3 || column == 4 ||column == 2 || column == 5 || column == 6;
				}
			};
			 
			table = new JTable(test){
				  public Component prepareRenderer
				  (TableCellRenderer renderer,int Index_row, int Index_col) {
				  Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
				  //even index, selected or not selected
				  if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
				  comp.setBackground(Color.lightGray);
				  } 
				  else if (isRowSelected(Index_row))
				  {
					  comp.setBackground(Color.BLUE);
				  }
				  else {
				  comp.setBackground(Color.white);
				  }
				  return comp;
				  }
				  };
			table.getColumnModel().getColumn(0).setMaxWidth(0);
		    table.getColumnModel().getColumn(0).setMinWidth(0);
		    table.getColumnModel().getColumn(0).setPreferredWidth(0);
			isTableInit = true;
			table.setRowHeight(20);
		}

		int count = table.getRowCount();
		System.err.println(count);
		int count1 = scrollPane.countComponents();
		System.err.println(count1);
		table.revalidate();
		scrollPane.setViewportView(table);
		table.isCellEditable(1, 1);
		//table.getModel().addTableModelListener(this);

		

		
	}
	
	public void populateTable1(){
		try {
			ResultSet resultSet = databaseHelper.fetchleaderrecords();
			ResultSetMetaData metaData = (ResultSetMetaData) resultSet
					.getMetaData();
			int columns = metaData.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames1.addElement(metaData.getColumnLabel(i));
				System.err.println(metaData.getColumnLabel(i));
			}
			data1.removeAllElements();
			while (resultSet.next()) {
				row1 = new Vector(columns);
				for (int i = 1; i <= columns; i++) {
					row1.addElement(resultSet.getObject(i));
				}

				data1.addElement(row);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
		
		if(!isTableInit1){
			test1 = new DefaultTableModel(data1, columnNames1) {
				public boolean isCellEditable(int row, int column) {
					// only columns 0 and 1 are editable
					return column == 1 || column == 3 || column == 4 ||column == 2 || column == 5 || column == 6;
				}
			};
			 
			table1 = new JTable(test1){
				  public Component prepareRenderer
				  (TableCellRenderer renderer,int Index_row, int Index_col) {
				  Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
				  //even index, selected or not selected
				  if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
				  comp.setBackground(Color.lightGray);
				  } 
				  else if (isRowSelected(Index_row))
				  {
					  comp.setBackground(Color.BLUE);
				  }
				  else {
				  comp.setBackground(Color.white);
				  }
				  return comp;
				  }
				  };
			table1.getColumnModel().getColumn(0).setMaxWidth(0);
		    table1.getColumnModel().getColumn(0).setMinWidth(0);
		    table1.getColumnModel().getColumn(0).setPreferredWidth(0);
			isTableInit1 = true;
			table1.setRowHeight(20);
		}

		int count = table1.getRowCount();
		System.err.println(count);
		int count1 = scrollPane1.countComponents();
		System.err.println(count1);
		table1.revalidate();
		scrollPane1.setViewportView(table1);
		table1.isCellEditable(1, 1);
		//table.getModel().addTableModelListener(this);



		
	}

	
	public OrderRecords() {

		initGUI();
		populateTable();
		populateTable1();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_2.add(panel_4, BorderLayout.CENTER);
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(scrollPane);
		
		panel_2.add(panel_5, BorderLayout.NORTH);
		lblOrderToBe.setForeground(new Color(0, 191, 255));
		lblOrderToBe.setFont(new Font("Dialog", Font.BOLD, 14));
		
		panel_5.add(lblOrderToBe);
		
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_3.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_6.add(scrollPane1);
		
		panel_3.add(panel_7, BorderLayout.NORTH);
		lblOrderDelivered.setFont(new Font("Dialog", Font.BOLD, 14));
		lblOrderDelivered.setForeground(new Color(0, 206, 209));
		
		panel_7.add(lblOrderDelivered);
		panel_1.setBackground(Color.GRAY);
		
		add(panel_1, BorderLayout.NORTH);
		lblOrderRecords.setForeground(new Color(0, 191, 255));
		lblOrderRecords.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel_1.add(lblOrderRecords);
	}

}
