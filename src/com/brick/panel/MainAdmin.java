package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class MainAdmin extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();

	/**
	 * Create the panel.
	 */
	public MainAdmin() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("New User\n", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(new NewUser());
		
		tabbedPane.addTab("New Vehicle", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(new NewVehicle());
		
		tabbedPane.addTab("New Destination\n", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(new Destination());
	}
}
