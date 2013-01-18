package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class Main_Labor extends JPanel {
	private final JPanel panel = new JPanel();
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel_3 = new JPanel();
	private final JPanel panel_4 = new JPanel();
	Labor newLabour = new Labor();
	LaborWork laborwork = new LaborWork();

	/**
	 * Create the panel.
	 */
	public Main_Labor() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("New Labor Detail\n", null, panel_3, null);
		tabbedPane.setMnemonicAt(0, 1);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel_3.setLayout(new BorderLayout(20, 40));
		panel_3.add(newLabour);
		
		tabbedPane.addTab("Labor Work Entry\n", null, panel_4, null);
		tabbedPane.setMnemonicAt(1, 2);
		tabbedPane.setDisplayedMnemonicIndexAt(1, 2);
		tabbedPane.setEnabledAt(1, true);
		panel_4.setLayout(new BorderLayout(0, 15));
		panel_4.add(laborwork);
	}

}
