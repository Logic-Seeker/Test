package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.brick.database.DatabaseHelper;
import com.mysql.jdbc.ResultSetMetaData;

public class LeaderRecords extends JPanel implements TableModelListener{
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblLeaderRecords = new JLabel("Leader Records");
	private final JScrollPane scrollPane = new JScrollPane();
	JTable table;
	DatabaseHelper databaseHelper = new DatabaseHelper();
	Vector row;
	Vector columnNames = new Vector();
	Vector data = new Vector();
	DefaultTableModel test;
	String numToken = "[\\p{Digit}]+";
	boolean isTableInit=false;
	String floatcheck = "^([1-9]\\d*|0)(\\.\\d)?$";
	LeaderAdvance advance = new LeaderAdvance();

	/**
	 * Create the panel.
	 */
	public LeaderRecords() {

		initGUI();
		table.getModel().addTableModelListener(this);
		String date = "2069-09-14";
		//String newdate = "";
				/*try {
			
			Utilities.getEngFromNepali(date);
			System.err.println("this is the convered date="+newdate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void populateTable(){
		try {
			ResultSet resultSet = databaseHelper.fetchleaderrecords();
			ResultSetMetaData metaData = (ResultSetMetaData) resultSet
					.getMetaData();
			int columns = metaData.getColumnCount();

			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnLabel(i));
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

		table.getColumn("Remove").setCellRenderer(new ButtonRenderer());
		tableChanged(null);


		
	}

	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.GRAY);
		
		add(panel, BorderLayout.NORTH);
		lblLeaderRecords.setFont(new Font("Dialog", Font.BOLD, 16));
		lblLeaderRecords.setForeground(new Color(0, 191, 255));
		
		panel.add(lblLeaderRecords);
		
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_1.add(scrollPane);
		populateTable();
	}
	public void tableChanged(TableModelEvent e) {
		
		if (e==null)
		{
			table.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(),-1,-1));
			System.err.println("fuck");
			return;
		}
		int row = e.getFirstRow();
		int column = e.getColumn();
		System.err.println("i am in table change event");
		// TableModel model = (TableModel)e.getSource();
		String name = table.getValueAt(row, 1).toString();
		String address = table.getValueAt(row, 2).toString();
		String mobile = table.getValueAt(row, 3).toString();
		String telephone = table.getValueAt(row, 4).toString();
		String rate =table.getValueAt(row, 5).toString();
		int id = Integer.valueOf(table.getValueAt(row, 0).toString());
		

		if (!mobile.matches(numToken)) {
			JOptionPane.showMessageDialog(null, "Must be integer", "Error",
					JOptionPane.DEFAULT_OPTION);
			//int original = databaseHelper.fetchbrickamount(id);
			long original = databaseHelper.fetchLeaderMobile(id);

			table.setValueAt(original, row, column);

			System.err.println("gooooo");
			return;
		}

		if (!telephone.matches(numToken)) {
			JOptionPane.showMessageDialog(null, "Must be integer", "Error",
					JOptionPane.DEFAULT_OPTION);
			//int original = databaseHelper.fetchbrickamount(id);
			long original = databaseHelper.fetchLeaderTelephone(id);

			table.setValueAt(original, row, column);

			System.err.println("gooooo");
			return;
		}

		if (!rate.matches(floatcheck)) {
			JOptionPane.showMessageDialog(null, "Must be integer", "Error",
					JOptionPane.DEFAULT_OPTION);
			//int original = databaseHelper.fetchbrickamount(id);
			float original = databaseHelper.fetchLeaderRate(id);

			table.setValueAt(original, row, column);

			System.err.println("gooooo");
			return;
		}
		if (column==6)
		{
		databaseHelper.updateLeader(id);
		table.getModel().removeTableModelListener(this);
		populateTable();
		advance.populateLeader();
		table.getModel().addTableModelListener(this);
		}
		float r = Float.valueOf(rate);
		databaseHelper.updateleader(id, name, address, mobile,telephone,r);
		
	}
	public void setAdvance(LeaderAdvance advances)
	{
		this.advance = advances;
	}
}
