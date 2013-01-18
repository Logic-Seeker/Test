package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class MainLeader extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	Leader leader = new Leader();
	LeaderRecords record = new LeaderRecords();
	/**
	 * Create the panel.
	 */
	public MainLeader() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane);
		
		tabbedPane.addTab("Leader Records\n", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(record);
		
		tabbedPane.addTab("New Leader", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(leader);
		
		tabbedPane.addTab("Advance", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(new LeaderAdvance());
	}
}
