package com.brick.helper;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 * Editor for JComboBox
 * @author wwww.codejava.net
 *
 */
public class ComboBoxItemEditor extends BasicComboBoxEditor {
	private JPanel panel = new JPanel();
	private JLabel labelItem = new JLabel();
	private String selectedValue;
	
	public ComboBoxItemEditor() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		constraints.insets = new Insets(2, 5, 2, 2);
		
		labelItem.setOpaque(false);
		labelItem.setFont(new Font("Dialog", Font.BOLD, 14));
		labelItem.setHorizontalAlignment(JLabel.LEFT);
		labelItem.setForeground(Color.BLACK);
		
		panel.add(labelItem, constraints);
		panel.setBackground(Color.WHITE);		
	}
	
	public Component getEditorComponent() {
		return this.panel;
	}
	
	public Object getItem() {
		return this.selectedValue;
	}
	
	public void setItem(Object value) {
		if (value == null) {
			return;
		}
		if (value instanceof CustomerHelper) {
			CustomerHelper tt = (CustomerHelper) value;
			setText(tt.name);
		} else if (value instanceof BrickHelper) {
			BrickHelper tt = (BrickHelper) value;
			setText(tt.name);
		} else if (value instanceof EmployeeHelper) {
			EmployeeHelper tt = (EmployeeHelper) value;
			setText(tt.name);
		} else if (value instanceof VehicleInfo) {
			VehicleInfo tt = (VehicleInfo) value;
			setText(tt.vechileNo);
		} else if (value instanceof LaborHelper) {
			LaborHelper tt = (LaborHelper) value;
			setText(tt.name);

		}else if (value instanceof LeaderHelper) {
			LeaderHelper tt = (LeaderHelper) value;
			setText(tt.name);

		}
		

		//labelItem.setIcon(new ImageIcon(countryItem[1]));		
	}
	public void setText(String name){
		labelItem.setText(name);
	}
}