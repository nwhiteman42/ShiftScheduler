import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
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
	private JLabel lblSeniority;
	private JLabel lblPlaceOfWork;
	private JLabel lblJobTitle;
	private JLabel lblConfirmEmail;
	private JLabel lblCreateAccount;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtjobTitle;
	private JTextField txtseniority;
	private JTextField txtplaceofwork;
	private JTextField txtConfirmEmail;

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
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		/**
		 * TextFields First name, Last name, Email, job title, seniority, and place of work.
		 */
		txtFirstName = new JTextField();
		txtFirstName.setBounds(86, 90, 112, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(208, 90, 112, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(86, 146, 112, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtjobTitle = new JTextField();
		txtjobTitle.setBounds(86, 205, 112, 20);
		frame.getContentPane().add(txtjobTitle);
		txtjobTitle.setColumns(10);
		
		txtseniority = new JTextField();
		txtseniority.setBounds(208, 205, 112, 20);
		frame.getContentPane().add(txtseniority);
		txtseniority.setColumns(10);
		
		txtplaceofwork = new JTextField();
		txtplaceofwork.setBounds(86, 264, 112, 20);
		frame.getContentPane().add(txtplaceofwork);
		txtplaceofwork.setColumns(10);
		
		
		/**
		 * JLabels First Name, Last Name, Email, job title, seniority, and place of work.
		 */
		lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(86, 75, 112, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(208, 75, 112, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Email");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(86, 133, 112, 14);
		frame.getContentPane().add(lblUsername);
		
		lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setForeground(Color.WHITE);
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblJobTitle.setBounds(86, 190, 98, 14);
		frame.getContentPane().add(lblJobTitle);
		
		lblSeniority = new JLabel("Seniority");
		lblSeniority.setForeground(Color.WHITE);
		lblSeniority.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeniority.setBounds(208, 190, 112, 14);
		frame.getContentPane().add(lblSeniority);
		
		lblPlaceOfWork = new JLabel("Place of Work");
		lblPlaceOfWork.setForeground(Color.WHITE);
		lblPlaceOfWork.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPlaceOfWork.setBounds(86, 249, 98, 14);
		frame.getContentPane().add(lblPlaceOfWork);
		
		txtConfirmEmail = new JTextField();
		txtConfirmEmail.setBounds(208, 146, 112, 20);
		frame.getContentPane().add(txtConfirmEmail);
		txtConfirmEmail.setColumns(10);
		
		//Header
		lblCreateAccount = new JLabel("Create Employee");
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreateAccount.setBounds(128, 25, 166, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setForeground(Color.WHITE);
		lblConfirmEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmEmail.setBounds(208, 133, 112, 14);
		frame.getContentPane().add(lblConfirmEmail);
		
		JLabel lblEmailsDoNot = new JLabel("Emails do not match");
		lblEmailsDoNot.setForeground(Color.GRAY);
		lblEmailsDoNot.setBounds(70, 283, 171, 15);
		frame.getContentPane().add(lblEmailsDoNot);

		
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
				String workplaceTemp = txtplaceofwork.getText();
				String seniority = txtseniority.getText();
				

			
				if(email.equals(conEmail)) {//Makes sure the emails were confirmed
					lblEmailsDoNot.setForeground(Color.WHITE);
					MysqlCon x = new MysqlCon();
					Connection con;
					try {
						//Inserts employee into database
						con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
						String query = "insert into Employee_Data (Employee_ID, Employee_Name, Employee_Title, seniority, placeofwork, email)" + " values(?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1,x.getAEmployeID()); //Employee_ID
						ps.setString(2, empName); //Employee_Name
						ps.setString(3, jobtitle); //Employee_Title
						ps.setString(4, seniority); //seniority
						ps.setString(5, workplaceTemp); //placeofwork
						ps.setString(6, email); //email
						ps.execute();//Executes query
						con.close();
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
		btnConfirm.setBounds(330, 337, 89, 23);
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
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		frame.setUndecorated(true);

	}
}
