package com.brick.panel;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
 
/**
 * @version 1.0 11/09/98
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {
 
  public ButtonRenderer() {
	  System.err.println("ButtonRenderer 16");
    setOpaque(true);
  }
  
  public Component getTableCellRendererComponent(JTable table, Object value,
                   boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else{
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText( (value ==null) ? "" : value.toString() );
    return this;
  }
}