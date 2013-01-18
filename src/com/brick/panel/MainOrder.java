package com.brick.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class MainOrder extends JPanel {
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();

	/**
	 * Create the panel.
	 */
	public MainOrder() {

		initGUI();
	}
	private void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Order Records\n", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		tabbedPane.addTab("New Order\n", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(new OrderForm());
		
		tabbedPane.addTab("Order Delivery", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_2.add(new Order());
	}
}
