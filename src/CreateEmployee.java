import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CreateEmployee {
	
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
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblJobTitle;
	private JLabel lblConfirmEmail;
	private JLabel lblCreateAccount;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtjobTitle;
	private JTextField txtConfirmEmail;
	private JLabel lblInvalidInput;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		CreateEmployee x = new CreateEmployee();
		x.setWorkplace(workplace);//Sets workplace to current users workplace
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee window = new CreateEmployee();
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
	public CreateEmployee() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 390);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		/**
		 * TextFields First name, Last name, Email, job title, seniority, and place of work.
		 */
		txtFirstName = new JTextField();
		txtFirstName.setBounds(95, 90, 124, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(223, 90, 124, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(95, 146, 124, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtjobTitle = new JTextField();
		txtjobTitle.setBounds(150, 203, 124, 20);
		frame.getContentPane().add(txtjobTitle);
		txtjobTitle.setColumns(10);
		
		
		/**
		 * JLabels First Name, Last Name, Email, job title, seniority, and place of work.
		 */
		lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(95, 75, 124, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(223, 75, 124, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Email");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(95, 130, 124, 14);
		frame.getContentPane().add(lblUsername);
		
		lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setForeground(Color.WHITE);
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJobTitle.setBounds(150, 189, 112, 14);
		frame.getContentPane().add(lblJobTitle);
		
		txtConfirmEmail = new JTextField();
		txtConfirmEmail.setBounds(223, 146, 124, 20);
		frame.getContentPane().add(txtConfirmEmail);
		txtConfirmEmail.setColumns(10);
		
		//Header
		lblCreateAccount = new JLabel("Create Employee");
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreateAccount.setBounds(150, 25, 171, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setForeground(Color.WHITE);
		lblConfirmEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmEmail.setBounds(223, 130, 124, 14);
		frame.getContentPane().add(lblConfirmEmail);
		
		JLabel lblEmailsDoNot = new JLabel("Emails do not match!");
		lblEmailsDoNot.setForeground(Color.GRAY);
		lblEmailsDoNot.setBounds(176, 251, 171, 15);
		frame.getContentPane().add(lblEmailsDoNot);

			lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setForeground(Color.GRAY);
		lblInvalidInput.setBounds(95, 209, 69, 14);
		frame.getContentPane().add(lblInvalidInput);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets information from the text feilds
				String empName = txtFirstName.getText() + " " + txtLastName.getText();
				String email = txtEmail.getText();
				String conEmail = txtConfirmEmail.getText();
				String jobtitle = txtjobTitle.getText();
				
				if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || email.isEmpty() ||
						jobtitle.isEmpty()) {
					lblInvalidInput.setForeground(Color.RED);
					return;
				}
			
				if(email.equals(conEmail)) {//Makes sure the emails were confirmed
					lblEmailsDoNot.setForeground(Color.WHITE);
					MysqlCon x = new MysqlCon();
					Connection con;
					try {
						//Inserts employee into database
						x.insertIntoEmployee(x.getAEmployeID(), empName, jobtitle, 1, workplace, email);
					} 
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					//Opens shift scheduler menu 
					ShiftSchedulerWindow.main(workplace);
					frame.setVisible(false);
				} 
				else {
					lblEmailsDoNot.setForeground(Color.RED);
				}
			}
		});
		btnConfirm.setBounds(247, 285, 100, 26);
		frame.getContentPane().add(btnConfirm);
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setBackground(Color.GRAY);
		btnGoBack.setBorder(new LineBorder(Color.WHITE));
		btnGoBack.addActionListener(new ActionListener() {
			//opens the shift scheduler window when this button is pushed
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(95, 285, 100, 26);
		frame.getContentPane().add(btnGoBack);
		
	
		frame.setUndecorated(true);

	}
}
