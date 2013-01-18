package com.brick.panel;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class Expense extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	Coal coal = new Coal();
	LandAndOthers land = new LandAndOthers();

	/**
	 * Create the panel.
	 */
	public Expense() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Coal Expense", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(coal);
		
		tabbedPane.addTab("Land And Others", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(land);
	}

}
