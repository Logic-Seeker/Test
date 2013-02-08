package com.brick.frame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.brick.database.DatabaseHelper;

public class LoginScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblUsername, lblPasswd, lblCat;
	public JTextField txtUser;
	private JPasswordField txtPasswd;
	private JButton btnLogin, btnCancel;
	JFrame currentFrame;
	public static int id;
	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public LoginScreen() {
		super("Inventory System");
		this.currentFrame = this;
		this.getContentPane().setLayout(null);
		this.setSize(370, 250);
		this.setResizable(false);
		this.setLocation((screen.width - 500) / 2, ((screen.height - 350) / 2));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("images/appicon.png").getImage());
		lblUsername = new JLabel("Username");
		lblPasswd = new JLabel("Password");
		txtUser = new JTextField();
		txtPasswd = new JPasswordField();
		lblCat = new JLabel("Login As");

		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");

		lblUsername.setBounds(40, 30, 100, 25);
		lblPasswd.setBounds(40, 75, 100, 25);
		lblCat.setBounds(40, 100, 100, 25);
		txtUser.setBounds(150, 30, 160, 25);
		txtPasswd.setBounds(150, 75, 160, 25);

		btnLogin.setBounds(70, 150, 100, 25);
		btnCancel.setBounds(190, 150, 100, 25);

		lblUsername.setFont(new Font("monospaced", Font.BOLD, 16));
		lblPasswd.setFont(new Font("monospaced", Font.BOLD, 16));

		txtUser.setFont(new Font("monospaced", Font.CENTER_BASELINE, 16));
		txtPasswd.setFont(new Font("monospaced", Font.CENTER_BASELINE, 16));
		this.add(lblUsername);
		this.add(txtUser);
		this.add(lblPasswd);
		this.add(txtPasswd);
		this.add(btnLogin);
		this.add(btnCancel);
		this.add(btnLogin);
		this.add(btnCancel);

		// Button listner
		ButtonListener listener = new ButtonListener();
		btnLogin.addActionListener(listener);
		btnCancel.addActionListener(listener);

	}// constructor closed

	private class ButtonListener implements ActionListener {
		DatabaseHelper databaseHelper = new DatabaseHelper();

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLogin) {

				if (txtUser.getText() == null || txtUser.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter username",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtUser.requestFocus();
					return;
				}
				if (txtPasswd.getPassword() == null
						|| txtPasswd.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter password",
							"Missing field", JOptionPane.DEFAULT_OPTION);
					txtPasswd.requestFocus();
					return;
				}
				// login here
				if (databaseHelper.checkValidLogin(

				txtUser.getText().toString(), txtPasswd.getText().toString())) {
					id = databaseHelper.getid(txtUser.getText().toString(),
							txtPasswd.getText().toString());
					currentFrame.setVisible(false);
					new MainWindow();

				} else {
					JOptionPane.showMessageDialog(null, "InValid User", "lol",
							JOptionPane.DEFAULT_OPTION);
				}

			} else if (e.getSource() == btnCancel) {
				System.exit(0);
			}
		}
	}

}
