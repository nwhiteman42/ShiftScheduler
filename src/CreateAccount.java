import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
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
import java.awt.Color;
import java.util.Base64;

public class CreateAccount {
	
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
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JPasswordField pwdPassword;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField pwdconField;
	private JLabel lblNewLabel;
	private JLabel lblCreateAccount;
	private JTextField txtConfirmEmail;
	private JLabel lblConfirmEmail;
	private JTextField WorkplacetextField;
	private JLabel lblWorkplace;
	private JLabel lblInvalidInput;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		CreateAccount x = new CreateAccount();
		x.setWorkplace(workplace); //Set workplace
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
	public CreateAccount() {
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
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		frame.setBounds(100, 100, 450, 390);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(Color.DARK_GRAY);
		pwdPassword.setBounds(95, 207, 124, 20);
		frame.getContentPane().add(pwdPassword);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(95, 75, 124, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(223, 75, 124, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Email");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(95, 130, 124, 14);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(95, 190, 124, 14);
		frame.getContentPane().add(lblPassword);
		
		pwdconField = new JPasswordField();
		pwdconField.setBounds(223, 207, 124, 20);
		frame.getContentPane().add(pwdconField);
		
		lblNewLabel = new JLabel("Confirm Password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(223, 190, 133, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setForeground(Color.WHITE);
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCreateAccount.setBounds(150, 25, 171, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		txtConfirmEmail = new JTextField();
		txtConfirmEmail.setBounds(223, 146, 124, 20);
		frame.getContentPane().add(txtConfirmEmail);
		txtConfirmEmail.setColumns(10);
		
		lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setForeground(Color.WHITE);
		lblConfirmEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmEmail.setBounds(223, 130, 133, 14);
		frame.getContentPane().add(lblConfirmEmail);
		
		JLabel lblPasswordsDoNot = new JLabel("Passwords do not match!");
		lblPasswordsDoNot.setForeground(Color.GRAY);
		lblPasswordsDoNot.setBounds(298, 238, 152, 15);
		frame.getContentPane().add(lblPasswordsDoNot);
		
		WorkplacetextField = new JTextField();
		WorkplacetextField.setColumns(10);
		WorkplacetextField.setBounds(158, 252, 124, 20);
		frame.getContentPane().add(WorkplacetextField);
		
		lblWorkplace = new JLabel("Place of Work");
		lblWorkplace.setForeground(Color.WHITE);
		lblWorkplace.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWorkplace.setBounds(158, 238, 133, 15);
		frame.getContentPane().add(lblWorkplace);
		
		JLabel lblEmailsDoNot = new JLabel("Emails do not match!");
		lblEmailsDoNot.setForeground(Color.GRAY);
		lblEmailsDoNot.setBounds(298, 175, 152, 15);
		frame.getContentPane().add(lblEmailsDoNot);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = txtFirstName.getText();
				String lName = txtLastName.getText();
				String email = txtEmail.getText();
				String conEmail = txtConfirmEmail.getText();
				String workplaceTemp = WorkplacetextField.getText();
				char[] tempPswd = pwdPassword.getPassword();
				char[] tempConPswd = pwdconField.getPassword();
				String pswd = String.copyValueOf(tempPswd);
				String conPswd = String.copyValueOf(tempConPswd);
				
				if(fName.isEmpty() || lName.isEmpty() || email.isEmpty() || workplaceTemp.isEmpty() || pswd.isEmpty()) {
					lblInvalidInput.setForeground(Color.RED);
					return;
				}
				//Encrypts the password and sends it to the database
				String encodedPass = Base64.getEncoder().encodeToString(pswd.getBytes());
				
				
				if(email.equals(conEmail)) {//Checks that both email feilds match
					lblEmailsDoNot.setForeground(Color.GRAY);
					if(pswd.equals(conPswd)) { //Checks to make sure both password feilds match
						lblPasswordsDoNot.setForeground(Color.GRAY);
						MysqlCon x = new MysqlCon();
						Connection con;
						try {
							//Inserts account into the database
						con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
						String query = "insert into emp_cred (emp_id, firstname, lastname, email, password, workplace)" + " values(?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1,x.getAEmployerID());
						ps.setString(2, fName);
						ps.setString(3, lName);
						ps.setString(4, email);
						ps.setString(5, encodedPass);
						ps.setString(6, workplaceTemp);
						ps.execute();
						con.close();
						//opens the login page after account creation
						LoginPage.main(null);
						frame.setVisible(false);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {//error message for when password feilds don't match
						lblPasswordsDoNot.setForeground(Color.RED);
					}
				} else {//error message for when email feilds dont match
					lblEmailsDoNot.setForeground(Color.RED);
				}
			}
		});
		btnConfirm.setBounds(247, 306, 100, 26);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBackground(Color.GRAY);
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setBorder(new LineBorder(Color.WHITE));
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Opens Login page
				LoginPage.main(null);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(95, 306, 100, 26);
		frame.getContentPane().add(btnGoBack);
		
		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setForeground(Color.GRAY);
		lblInvalidInput.setBounds(101, 284, 118, 14);
		frame.getContentPane().add(lblInvalidInput);
		
		
		frame.setUndecorated(true);
		
	}
}