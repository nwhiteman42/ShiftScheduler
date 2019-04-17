import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ShiftSchedulerWindow {

	private JFrame frame;
	private JTable table;
	private JMenuItem mntmExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][grow]"));
		Employer emp = new Employer();
		JButton btnMakeSchedule = new JButton("Make Schedule");
		btnMakeSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShiftSchedulerTests obj = new ShiftSchedulerTests();
				try {
					obj.addDataArray();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnMakeSchedule, "cell 0 1");
		
		JButton btnEmailSchedule = new JButton("Email Schedule");
		btnEmailSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] emails = new String[] {"mtsayles@mtu.edu", "nhwhitem@mtu.edu"};
				String subject = "New Schedule";
				String body = "Here is your schdeule dummies.  Come to work!";
				String attachment = "testShift1.csv";
				try {
					emp.massEmail(emails, attachment, subject, body);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateEmployee.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnAddEmployee, "cell 4 1");
		frame.getContentPane().add(btnEmailSchedule, "cell 0 2");
		
		JButton btnEditEmployee = new JButton("Edit Employee");
		btnEditEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditEmployee.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnEditEmployee, "cell 4 2");
		
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveEmployee.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnRemoveEmployee, "cell 4 3");
		
		JButton btnRemoveShift = new JButton("Edit Shift");
		btnRemoveShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditShift.main(null);
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnRemoveShift, "cell 4 4");
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnFile.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPage.main(null);
				frame.setVisible(false);
			}
		});
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		
		JMenuItem mntmUs = new JMenuItem("Us");
		mntmUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AboutWindow.main(null);
			}
		});
		
		mnAbout.add(mntmUs);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
