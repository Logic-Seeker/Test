package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;


public class MainLabor extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	LaborRecords records = new LaborRecords();
	Labor new_labor = new Labor();
	LaborWork work = new LaborWork();
	LabourAdvance labourAdvance=new LabourAdvance();
	
	

	/**
	 * Create the panel.
	 */
	public MainLabor() {
		
		initGUI();
		new_labor.setLaborRecord(records);
		new_labor.setLaborWork(work);
		new_labor.setLaborAdvance(labourAdvance);
		records.setLaborWork(work);
		records.setLaborAdvance(labourAdvance);
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Labor Records\n", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(records);
		
		tabbedPane.addTab("New Labor", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(new_labor);
		
		tabbedPane.addTab("Labor Work", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(work);
		
		tabbedPane.addTab("Labor Reports\n", null, panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		panel_3.add(new LabourReport());
		
		tabbedPane.addTab("Advance", null, panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(labourAdvance);
		
		
		
	}

}
