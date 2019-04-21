import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.SystemColor;

public class ShiftSchedulerWindow {
	
	//Holds the workplace of signed in employeer
	public static String workplace = null;
	
	//Getter for workplace
	public String getWorkplace() {
		return workplace;
	}
	//Setter for workplace
	public void setWorkplace(String newWorkplace) {
		workplace = newWorkplace;
	}
	
	private JFrame frame;
	private JTable table;
	private JMenuItem mntmExit;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		ShiftSchedulerWindow x = new ShiftSchedulerWindow();
		x.setWorkplace(workplace); //Sets workplace to the workplace of whoever is logged in
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShiftSchedulerWindow window = new ShiftSchedulerWindow();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShiftSchedulerWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][grow]"));
		Employer emp = new Employer();
		
		JButton btnMakeSchedule = new JButton("Make Schedule");
		btnMakeSchedule.setBackground(Color.GRAY);
		btnMakeSchedule.setForeground(Color.WHITE);
		btnMakeSchedule.setBorder(new LineBorder(Color.WHITE));
		btnMakeSchedule.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMakeSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon m = new MysqlCon();
				ShiftScheduler x = new ShiftScheduler();
				try {
					System.out.println(workplace);
					ArrayList<Employee> emps = m.getEmployees(workplace);//Pulls employees from database
					x.makeSchedule(emps, "testShift1.csv");//Makes array
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnMakeSchedule, "cell 0 1");
		
		JButton btnEmailSchedule = new JButton("Email Schedule");
		btnEmailSchedule.setBackground(Color.GRAY);
		btnEmailSchedule.setForeground(Color.WHITE);
		btnEmailSchedule.setBorder(new LineBorder(Color.WHITE));
		btnEmailSchedule.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEmailSchedule.addActionListener(new ActionListener() {
			//Send email to all employees of logged in user's workplace
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon x = new MysqlCon();
				String[] emails = null;
				try {
					emails = x.getEmployeesEmail(workplace); //Gets employees and puts them in a string[]
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				String subject = "New Schedule";
				String body = "Here is your schdeule dummies.  Come to work!";
				String attachment = "testShift1.csv";
				try {
					emp.massEmail(emails, attachment, subject, body);//Calls mass email method
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		JButton btnAddEmployee = new JButton("Create Employee");
		btnAddEmployee.setBackground(Color.GRAY);
		btnAddEmployee.setForeground(Color.WHITE);
		btnAddEmployee.setBorder(new LineBorder(Color.WHITE));
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddEmployee.addActionListener(new ActionListener() {
			//Opens create employee page 
			public void actionPerformed(ActionEvent e) {
				CreateEmployee.main(workplace);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnAddEmployee, "cell 4 1");
		frame.getContentPane().add(btnEmailSchedule, "cell 0 2");
		
		JButton btnEditEmployee = new JButton("Edit Employee");
		btnEditEmployee.setBackground(Color.GRAY);
		btnEditEmployee.setForeground(Color.WHITE);
		btnEditEmployee.setBorder(new LineBorder(Color.WHITE));
		btnEditEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditEmployee.addActionListener(new ActionListener() {
			//Opens edit employee page
			public void actionPerformed(ActionEvent arg0) {
				EditEmployee.main(workplace);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnEditEmployee, "cell 4 2");
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.setBackground(Color.GRAY);
		btnRemoveEmployee.setForeground(Color.WHITE);
		btnRemoveEmployee.setBorder(new LineBorder(Color.WHITE));
		btnRemoveEmployee.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemoveEmployee.addActionListener(new ActionListener() {
			//Opens remove employee page
			public void actionPerformed(ActionEvent arg0) {
				RemoveEmployee.main(workplace);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnRemoveEmployee, "cell 4 3");
		
		JButton btnRemoveShift = new JButton("Edit Shift");
		btnRemoveShift.setBackground(Color.GRAY);
		btnRemoveShift.setForeground(Color.WHITE);
		btnRemoveShift.setBorder(new LineBorder(Color.WHITE));
		btnRemoveShift.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemoveShift.addActionListener(new ActionListener() {
			//Opens edit shift page
			public void actionPerformed(ActionEvent arg0) {
				EditShift.main(workplace);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnRemoveShift, "cell 4 4");
		
		JButton btnNewButton = new JButton("Remove Shift");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			//Opens remove shift page
			public void actionPerformed(ActionEvent e) {
				RemoveShift.main(workplace);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 4 5");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnFile.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			//logs out user and opens login page
			public void actionPerformed(ActionEvent arg0) {
				LoginPage.main(null);
				frame.setVisible(false);
			}
		});
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		
		JMenuItem mntmUs = new JMenuItem("Us");
		mntmUs.addActionListener(new ActionListener() {
			//Opens about page
			public void actionPerformed(ActionEvent arg0) {
				AboutWindow.main(null);
			}
		});
		
		mnAbout.add(mntmUs);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelpPage = new JMenuItem("Help Page");
		mntmHelpPage.addActionListener(new ActionListener() {
			//Opens help page
			public void actionPerformed( ActionEvent arg0 ) {
				HelpPage.main(null);
			}
		});
		mnHelp.add(mntmHelpPage);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		frame.setUndecorated(true);
		
	}
}
