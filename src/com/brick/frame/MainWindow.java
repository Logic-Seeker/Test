package com.brick.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import com.brick.helper.ToolBarUtils;
import com.brick.panel.Customer;
import com.brick.panel.Employee;
import com.brick.panel.EmployeeAttendance;
import com.brick.panel.Expense;
import com.brick.panel.Labor;
import com.brick.panel.LaborWork;
import com.brick.panel.LabourReport;
import com.brick.panel.MainAdmin;
import com.brick.panel.MainCustomer;
import com.brick.panel.MainEmployee;
import com.brick.panel.MainLabor;
import com.brick.panel.MainLeader;
import com.brick.panel.MainOrder;
import com.brick.panel.NewUser;
import com.brick.panel.NewVehicle;
import com.brick.panel.Order;
import com.brick.panel.OrderReport;

public class MainWindow extends JFrame implements WindowListener {

	private static final long serialVersionUID = 1L;
	public static JPanel cards; // a panel that uses CardLayout

	final static String MAIN_ADMIN = "main admin";
	final static String ADD_EXPENSES = "Card with add expenses";
	final static String MAIN_ORDER = "main order";
	final static String MAIN_LEADER = "main leader";
	final static String MAIN_CUSTOMER = "main customer";
	final static String ADD_MAIN_LABOR = "Labor functionality";
	final static String ADD_LABOUR_REPORT = "Labor report";
	final static String ADD_ORDER_REPORT = "Order report";
	final static String MAIN_EMPLOYEE = "main employee";
	

	public JMenu mnuOperations, mnuReports, mnuHelp;
	public JMenuItem mnuMainAdmin, mnuNewLabour, mnuMainOrder,
			mnuItemReport, mnuExit, menuItemAbout,mnuMainEmployee,
			mnuMainLeader, mnuMainCustomer,mnuMainLabor,mnuLabourReport,mnuOrderReport,mnuMainExpenses;
	ToolBarUtils settings = new ToolBarUtils();
	Dimension screen;
	JPanel containerPanel;
	JPanel panel_Top = new JPanel();
	static Date td = new Date();
	static String sLogin = DateFormat.getDateTimeInstance().format(td);
	JPanel panel_Bottom = new JPanel();
	JLabel lblUsername = new JLabel("User Name:");
	JLabel lblLogDetails = new JLabel("Time Login :");
	JLabel lblTimeNow = new JLabel();
	// JPanel desktop = new JPanel();
	JFrame jFrame;

	Container cont;
	public MainWindow() {
		// Create and set up the window.
		super("Inventory Management System");
		jFrame=this;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new BorderLayout(10, 10));
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("images/appicon.png").getImage());

		this.setJMenuBar(CreateJMenuBar());
		// Display the window.

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		JTextField username = new JTextField();
		username.setEditable(false);
		JTextField logtime = new JTextField();
		logtime.setEditable(false);
		username.setText("krish");
		logtime.setText(sLogin);

		panel_Bottom.setLayout(new FlowLayout());
		panel_Bottom.setPreferredSize(new Dimension(10, 25));
		panel_Bottom.setBackground(Color.LIGHT_GRAY);
		panel_Bottom.add(lblUsername);
		panel_Bottom.add(username);
		panel_Bottom.add(lblLogDetails);
		panel_Bottom.add(logtime);

		NewUser newUser = new NewUser();
		Order order = new Order();
		NewVehicle newvehicle = new NewVehicle();
		LaborWork laborwork = new LaborWork();
		Labor newLabour = new Labor();
		Employee employee = new Employee();
		Customer customer = new Customer();
		//Main_Labor mainlabor = new Main_Labor();
		LabourReport labourreport = new LabourReport();
		OrderReport orderreport = new OrderReport();
		MainLabor mainlabor  = new MainLabor();
		EmployeeAttendance employeeattendance = new EmployeeAttendance();
		Expense expense = new Expense();
		MainEmployee mainemployee = new MainEmployee();
		MainCustomer maincustomer = new MainCustomer();
		MainLeader mainleader = new MainLeader();
		MainOrder mainorder = new MainOrder();
		MainAdmin mainadmin = new MainAdmin();
		// Create the panel that contains the "cards".
		cards = new JPanel();
		cards.setLayout(new CardLayout());
		cards.add(new JPanel(), "1");
		cards.add(mainadmin, MAIN_ADMIN);
		cards.add(mainorder, MAIN_ORDER);
		cards.add(expense, ADD_EXPENSES);
		cards.add(mainleader, MAIN_LEADER);
		cards.add(maincustomer, MAIN_CUSTOMER);
		cards.add(mainlabor, ADD_MAIN_LABOR);
		cards.add(new LabourReport(), ADD_LABOUR_REPORT);
		cards.add(orderreport, ADD_ORDER_REPORT);
		cards.add(mainemployee, MAIN_EMPLOYEE);

		getContentPane().setLayout(new BorderLayout(0, 0));
		panel_Top.setLayout(new BorderLayout(0, 0));

		panel_Top.add(createJToolBar());
		getContentPane().add(panel_Top, BorderLayout.NORTH);
		getContentPane().add(cards, BorderLayout.CENTER);
		getContentPane().add(panel_Bottom, BorderLayout.PAGE_END);
		cont = getContentPane();
		this.pack();
		this.setVisible(true);
	}

	protected JToolBar createJToolBar() {
		JToolBar toolbar = new JToolBar("Toolbar");

		toolbar.add(settings.CreateJToolbarButton("Exit", "images/exit.png",
				"File_Exit", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Add - Employee",
				"images/employee.png", "Emp_Add", JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Edit - Employee",
				"images/edit.png", "Emp_Edit", JToolBarActionListener));
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Delete - Employee",
				"images/delete.png", "Emp_Delete", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Employee Position Settings",
				"images/setting.png", "Settings", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("Calculator",
				"images/calc.png", "Tools_Calculator", JToolBarActionListener));
		toolbar.add(settings.CreateJToolbarButton("NotePad",
				"images/notepad.png", "Tools_NotePad", JToolBarActionListener));
		toolbar.addSeparator();
		toolbar.addSeparator();

		toolbar.add(settings.CreateJToolbarButton("Employee - Report",
				"images/emp_rpt.png", "Reports_Employee",
				JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Help - Author",
				"images/xp.png", "Help_Author", JToolBarActionListener));

		toolbar.add(settings.CreateJToolbarButton("Help - Help",
				"images/help.png", "Help_Help", JToolBarActionListener));
		return toolbar;

	}

	public JMenuBar CreateJMenuBar() {
		JMenuBar menubar = new JMenuBar();
		/********** CREATING OPERATIONS MENU ***********************/
		mnuOperations = new JMenu("Master   ");
		mnuOperations.setForeground((Color.blue));
		mnuOperations.setActionCommand("men");
		mnuOperations.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuOperations.setMnemonic('O');
		mnuOperations.setEnabled(true);

		/******************* menu report *****************************/
		mnuReports = new JMenu("Reports   ");
		mnuReports.setForeground((Color.blue));
		mnuReports.setActionCommand("men");
		mnuReports.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuReports.setMnemonic('O');

		/********************* menu help *****************************/
		mnuHelp = new JMenu("help   ");
		mnuHelp.setForeground((Color.blue));
		mnuHelp.setActionCommand("men");
		mnuHelp.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuHelp.setMnemonic('O');

		/*********************** menuitem ************************************/
		mnuMainAdmin = new JMenuItem("Admin");
		mnuMainAdmin.setForeground(Color.blue);
		mnuMainAdmin.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainAdmin.setMnemonic('L');
		mnuMainAdmin.setIcon(new ImageIcon("images/user.png"));
		mnuMainAdmin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuMainAdmin.setActionCommand("mainadmin");
		mnuMainAdmin.addActionListener(menulistener);

		// mainLabour
		mnuMainLabor = new JMenuItem("Labour");
		mnuMainLabor.setForeground(Color.blue);
		mnuMainLabor.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainLabor.setMnemonic('E');
		mnuMainLabor.setIcon(new ImageIcon("images/user.png"));
		mnuMainLabor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuMainLabor.setActionCommand("addmainlabor");
		mnuMainLabor.addActionListener(menulistener);

		// attendance
		mnuMainEmployee = new JMenuItem("Employee");
		mnuMainEmployee.setForeground(Color.blue);
		mnuMainEmployee.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainEmployee.setMnemonic('E');
		mnuMainEmployee.setIcon(new ImageIcon("images/user.png"));
		mnuMainEmployee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuMainEmployee.setActionCommand("mainemployee");
		mnuMainEmployee.addActionListener(menulistener);

		
		// mnuNewLabour
		mnuMainExpenses = new JMenuItem("Expenses");
		mnuMainExpenses.setForeground(Color.blue);
		mnuMainExpenses.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainExpenses.setMnemonic('E');
		mnuMainExpenses.setIcon(new ImageIcon("images/user.png"));
		mnuMainExpenses.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		mnuMainExpenses.setActionCommand("mainexpenses");
		mnuMainExpenses.addActionListener(menulistener);

		
		// Add Employee
		mnuMainLeader = new JMenuItem("Leader");
		mnuMainLeader .setForeground(Color.blue);
		mnuMainLeader .setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainLeader .setMnemonic('e');
		mnuMainLeader .setIcon(new ImageIcon("images/print.png"));
		mnuMainLeader .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		mnuMainLeader .setActionCommand("MainLeader");
		mnuMainLeader .addActionListener(menulistener);

		// Add Customer
		mnuMainCustomer = new JMenuItem("Customer");
		mnuMainCustomer.setForeground(Color.blue);
		mnuMainCustomer.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainCustomer.setMnemonic('e');
		mnuMainCustomer.setIcon(new ImageIcon("images/print.png"));
		mnuMainCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		mnuMainCustomer.setActionCommand("MainCustomer");
		mnuMainCustomer.addActionListener(menulistener);

		
		// order
		mnuMainOrder = new JMenuItem("Order");
		mnuMainOrder.setForeground(Color.blue);
		mnuMainOrder.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuMainOrder.setMnemonic('o');
		mnuMainOrder.setIcon(new ImageIcon("images/products.png"));
		mnuMainOrder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		mnuMainOrder.setActionCommand("mainorder");
		mnuMainOrder.addActionListener(menulistener);

		
		// menu exit
		mnuExit = new JMenuItem("Exit");
		mnuExit.setForeground(Color.blue);
		mnuExit.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuExit.setMnemonic('E');
		mnuExit.setIcon(new ImageIcon("images/exit.png"));
		mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		mnuExit.setActionCommand("exit");
		mnuExit.addActionListener(menulistener);

		mnuItemReport = new JMenuItem("generate Order reports");
		mnuItemReport.setForeground(Color.blue);
		mnuItemReport.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuItemReport.setMnemonic('L');
		mnuItemReport.setIcon(new ImageIcon("images/report.png"));
		mnuItemReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuItemReport.setActionCommand("orderreport");
		mnuItemReport.addActionListener(menulistener);
		
		//Labour report
		mnuLabourReport = new JMenuItem("generate Labour reports");
		mnuLabourReport.setForeground(Color.blue);
		mnuLabourReport.setFont(new Font("monospaced", Font.PLAIN, 14));
		mnuLabourReport.setMnemonic('L');
		mnuLabourReport.setIcon(new ImageIcon("images/report.png"));
		mnuLabourReport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				ActionEvent.CTRL_MASK));
		mnuLabourReport.setActionCommand("labourreport");
		mnuLabourReport.addActionListener(menulistener);

		menuItemAbout = new JMenuItem("about");
		menuItemAbout.setForeground(Color.blue);
		menuItemAbout.setFont(new Font("monospaced", Font.PLAIN, 14));
		menuItemAbout.setMnemonic('A');
		menuItemAbout.setIcon(new ImageIcon("images/help.png"));
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				ActionEvent.CTRL_MASK));
		menuItemAbout.setActionCommand("about");
		menuItemAbout.addActionListener(menulistener);

		/******************* add menu item to master ***************************/

		mnuOperations.add(mnuMainAdmin);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainEmployee);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainCustomer);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainLeader);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainLabor);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainOrder);
		mnuOperations.addSeparator();
		mnuOperations.add(mnuMainExpenses);
		mnuOperations.add(mnuExit);

		/******************* add menu item to reports ***************************/
		mnuReports.add(mnuItemReport);
		mnuReports.add(mnuLabourReport);

		mnuHelp.add(menuItemAbout);

		menubar.add(mnuOperations);
		menubar.add(mnuReports);
		menubar.add(mnuHelp);
		return menubar;
	}

	ActionListener JToolBarActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			CardLayout cl = (CardLayout) (cards.getLayout());
			if (source == "File_Exit") {
				cl.show(cards, MAIN_ADMIN);
			} else if (source == "Emp_Add") {

				cl.show(cards, MAIN_ORDER);

			} else if (source == "mainorder") {

				cl.show(cards, MAIN_ORDER);

			}
		}

	};
	ActionListener menulistener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			String ActCmd = e.getActionCommand();
			CardLayout cl = (CardLayout) (cards.getLayout());
			if (ActCmd.equalsIgnoreCase("mainadmin")) {
				cl.show(cards, MAIN_ADMIN);
			} else if (ActCmd.equalsIgnoreCase("mainexpenses")) {
				cl.show(cards, ADD_EXPENSES);
			}else if (ActCmd.equalsIgnoreCase("addmainlabor")) {
				cl.show(cards, ADD_MAIN_LABOR);
			}
			else if (ActCmd.equalsIgnoreCase("mainorder")) {
				cl.show(cards, MAIN_ORDER);
			}else if (ActCmd.equalsIgnoreCase("orderreport")) {
				cl.show(cards, ADD_ORDER_REPORT);
			}
			 else if (ActCmd.equalsIgnoreCase("MainLeader")) {
				cl.show(cards, MAIN_LEADER);
			} else if (ActCmd.equalsIgnoreCase("MainCustomer")) {
				cl.show(cards, MAIN_CUSTOMER);
			} else if (ActCmd.equalsIgnoreCase("labourreport")) {
				cl.show(cards, ADD_LABOUR_REPORT); }
			else if (ActCmd.equalsIgnoreCase("mainemployee")) {
				cl.show(cards, MAIN_EMPLOYEE);
			}
			else if (ActCmd.equalsIgnoreCase("exit")) {
				ConfirmExit();
			}
		}
	};

	private void ConfirmExit() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(null,
				"Are you sure to exit?", "Confirm exit",
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
				ObjButtons, ObjButtons[1]);
		if (PromptResult == 0) {
			System.exit(0);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		ConfirmExit();

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
	
	
}
