package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

public class LaborRecords extends JPanel implements TableModelListener {
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblLaborRecords = new JLabel("Labor Records");
	JTable table;
	DatabaseHelper databaseHelper = new DatabaseHelper();
	Vector row;
	Vector columnNames = new Vector();
	Vector data = new Vector();
	DefaultTableModel test = new DefaultTableModel();
	private final JScrollPane scrollPane = new JScrollPane();
	String numToken = "[\\p{Digit}]+";
	boolean isTableInit=false;
	int check =0;
	private LaborWork laborWork;
	private LabourAdvance labourAdvance;
	/**
	 * Create the panel.
	 */
	public LaborRecords() {

		initGUI();
	}

	public void populateTable(){
		try {
			ResultSet resultSet = databaseHelper.fetchlaborrecords();
			ResultSetMetaData metaData = (ResultSetMetaData) resultSet
					.getMetaData();
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

		
		
		if(!isTableInit){
			test = new DefaultTableModel(data, columnNames) {
				public boolean isCellEditable(int row, int column) {
					// only columns 0 and 1 are editable
					return column == 1 || column == 3 || column == 4;
				}
			};
			test.addTableModelListener(this); 
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
		

		panel_1.add(lblLaborRecords);

		table.getColumn("Remove").setCellRenderer(new ButtonRenderer());
		//tableChanged(null);
		table.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(),-1,-1));

	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));

		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		panel.add(scrollPane);
		panel_1.setBackground(Color.GRAY);

		add(panel_1, BorderLayout.NORTH);
		lblLaborRecords.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLaborRecords.setForeground(new Color(0, 255, 255));
		
		
		populateTable();
			}

	
	@Override
	public void tableChanged(TableModelEvent e) {
		System.err.println("randi");
	
		if (e==null)
		{
			table.getColumn("Remove").setCellEditor(new ButtonEditor(new JCheckBox(),-1,-1));
			System.err.println("LaborRecords 124");
			return;
		}
		System.err.println("laborrecords 139"+e.getSource());
		System.err.println("laborrecords 133"+e.getType());
		int row = e.getFirstRow();
		int column = e.getColumn();
		System.err.println("i am in table change event");
		// TableModel model = (TableModel)e.getSource();
		String name = table.getValueAt(row, 1).toString();
		String type = table.getValueAt(row, 2).toString();
		Object brickamount = table.getValueAt(row, 3);
		// int bamount = Integer.valueOf(brickamount.toString());
		int id = Integer.valueOf(table.getValueAt(row, 0).toString());
		int original = databaseHelper.fetchbrickamount(id);
		int id_original = databaseHelper.fetchid(id);
		if (id_original==0)
		{
			System.err.println("laborrecords 146 id not matched");
		}
	

		if (!brickamount.toString().matches(numToken)) {
			JOptionPane.showMessageDialog(null, "Must be integer", "Error",
					JOptionPane.DEFAULT_OPTION);
			//int original = databaseHelper.fetchbrickamount(id);
			System.err.println(original);
			table.setValueAt(original, row, column);
			return;
		}
		if (table.getValueAt(row, 2).toString().equalsIgnoreCase("patheri")
				&& Integer.valueOf(table.getValueAt(row,3).toString())!=0
				&& column ==3  ) {
			JOptionPane.showMessageDialog(null, "mmmmm", "Error",
					JOptionPane.DEFAULT_OPTION);
			System.err.println(original);
			table.setValueAt(original, row, column);
			return;
		
			
			
		}
		if(column == 4)
		{
			
			databaseHelper.updatelabour(id);
			table.getModel().removeTableModelListener(this);
			populateTable();
			laborWork.populateLaborWork();
			labourAdvance.populateLabourAdvance();
			table.getModel().addTableModelListener(this);
			
		}
		int bamount = Integer.valueOf(brickamount.toString());
		databaseHelper.updatelabour(id, name, type, bamount);
	}
public void setLaborWork(LaborWork laborWorks){
		
		this.laborWork = laborWorks;
	}
public void setLaborAdvance(LabourAdvance labourAdvances){
	
	this.labourAdvance = labourAdvances;
}
	
	
}