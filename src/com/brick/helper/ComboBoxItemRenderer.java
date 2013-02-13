package com.brick.helper;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * Customer renderer for JComboBox
 * 
 * @author www.codejava.net
 * 
 */
public class ComboBoxItemRenderer extends JPanel implements ListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelItem = new JLabel();

	public ComboBoxItemRenderer() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		constraints.insets = new Insets(2, 2, 2, 2);

		labelItem.setOpaque(true);
		labelItem.setFont(new Font("Dialog", Font.BOLD, 14));

		labelItem.setHorizontalAlignment(JLabel.LEFT);

		add(labelItem, constraints);
		setBackground(Color.LIGHT_GRAY);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		if (value instanceof CustomerHelper) {
			CustomerHelper tt = (CustomerHelper) value;
			setText(tt.name, isSelected);
		} else if (value instanceof BrickHelper) {
			BrickHelper tt = (BrickHelper) value;
			setText(tt.name, isSelected);
		} else if (value instanceof EmployeeHelper) {
			EmployeeHelper tt = (EmployeeHelper) value;
			setText(tt.name, isSelected);
		} else if (value instanceof VehicleInfo) {
			VehicleInfo tt = (VehicleInfo) value;
			setText(tt.vechileNo, isSelected);
		} else if (value instanceof LaborHelper) {
			LaborHelper tt = (LaborHelper) value;
			setText(tt.name, isSelected);

		}else if (value instanceof LeaderHelper) {
			LeaderHelper tt = (LeaderHelper) value;
			setText(tt.name, isSelected);

		}else if (value instanceof DestinationHelper) {
			DestinationHelper tt = (DestinationHelper) value;
			setText(tt.name, isSelected);

		}

		// Custom countryItem = (Custom) value;

		return this;
	}

	public void setText(String item, boolean isSelected) {
		// set country name
		labelItem.setText(item);

		// set country flag
		// labelItem.setIcon(new ImageIcon(countryItem[1]));

		if (isSelected) {
			labelItem.setBackground(Color.DARK_GRAY);
			labelItem.setForeground(Color.WHITE);
		} else {
			labelItem.setForeground(Color.BLACK);
			labelItem.setBackground(Color.LIGHT_GRAY);
		}

	}

}