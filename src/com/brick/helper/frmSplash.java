package com.brick.helper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class frmSplash {

	private JLabel SplashImage;
	private JLabel SplashText;
	private JWindow window;
	private JPanel panel;

	public frmSplash(int duration) {
		window = new JWindow();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setBounds((screen.width - 490) / 2, (screen.height - 300) / 2,
				400, 300);

		panel = (JPanel) window.getContentPane();
		SplashImage = new JLabel(new ImageIcon("images/ss.png"));
		SplashText = new JLabel("revol-tech", SwingConstants.CENTER);
		panel.add(SplashImage, BorderLayout.CENTER);
		panel.add(SplashText, BorderLayout.SOUTH);

		window.setVisible(true);
		try {
			Thread.sleep(duration);
		} catch (Exception ex) {
		}// try catch closed
		window.setVisible(false);
		window.dispose();
	}// constructr closed

	

}// class closed

