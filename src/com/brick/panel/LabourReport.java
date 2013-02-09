package com.brick.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.brick.database.DatabaseHelper;
import com.brick.helper.ComboBoxItemEditor;
import com.brick.helper.ComboBoxItemRenderer;
import com.brick.helper.LaborHelper;

public class LabourReport extends JPanel {
	private final JPanel panel = new JPanel();
	private final JLabel lblLabourReport = new JLabel("Labour Report");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JLabel lblLabourName = new JLabel("Labour Name");
	private final JComboBox<LaborHelper> labourname = new JComboBox<LaborHelper>();
	private final JButton btnGenerateReport = new JButton("Generate Report");
	DatabaseHelper databasehelper = new DatabaseHelper();
	private DefaultComboBoxModel model;
	/**
	 * Create the panel.
	 */
	public LabourReport() {

		initGUI();
		populateLaborWork();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		panel.setBackground(Color.GRAY);
		
		add(panel, BorderLayout.NORTH);
		lblLabourReport.setForeground(new Color(0, 206, 209));
		lblLabourReport.setFont(new Font("Dialog", Font.BOLD, 16));
		
		panel.add(lblLabourReport);
		
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 240, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{45};
		//gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		//gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_2.rowWeights = new double[]{0.0};
		panel_2.setLayout(gbl_panel_2);
		
		GridBagConstraints gbc_lblLabourName = new GridBagConstraints();
		gbc_lblLabourName.insets = new Insets(0, 0, 0, 5);
		gbc_lblLabourName.anchor = GridBagConstraints.EAST;
		gbc_lblLabourName.gridx = 0;
		gbc_lblLabourName.gridy = 0;
		panel_2.add(lblLabourName, gbc_lblLabourName);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_2.add(labourname, gbc_comboBox);
		
		GridBagConstraints gbc_btnGenerateReport = new GridBagConstraints();
		gbc_btnGenerateReport.anchor = GridBagConstraints.EAST;
		gbc_btnGenerateReport.gridx = 7;
		gbc_btnGenerateReport.gridy = 0;
		panel_2.add(btnGenerateReport, gbc_btnGenerateReport);
		btnGenerateReport.addActionListener(customActionListener);
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
	private ActionListener customActionListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnGenerateReport){
				databasehelper.generateReport("report/labourreport.jrxml",((LaborHelper)labourname.getSelectedItem()).id);
			}
			
		}
	};

}
