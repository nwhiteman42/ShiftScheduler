import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreateAccount {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		pwdPassword = new JPasswordField();
		pwdPassword.setForeground(Color.DARK_GRAY);
		pwdPassword.setBounds(86, 207, 112, 20);
		frame.getContentPane().add(pwdPassword);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(86, 75, 65, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setBounds(208, 75, 68, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Email");
		lblUsername.setBounds(86, 133, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(86, 193, 61, 14);
		frame.getContentPane().add(lblPassword);
		
		pwdconField = new JPasswordField();
		pwdconField.setBounds(208, 207, 112, 20);
		frame.getContentPane().add(pwdconField);
		
		lblNewLabel = new JLabel("Confirm Password");
		lblNewLabel.setBounds(208, 193, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateAccount.setBounds(128, 25, 166, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		txtConfirmEmail = new JTextField();
		txtConfirmEmail.setBounds(208, 146, 112, 20);
		frame.getContentPane().add(txtConfirmEmail);
		txtConfirmEmail.setColumns(10);
		
		lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setBounds(208, 133, 86, 14);
		frame.getContentPane().add(lblConfirmEmail);
		
		JLabel lblPasswordsDoNot = new JLabel("Passwords do not match");
		lblPasswordsDoNot.setForeground(Color.WHITE);
		lblPasswordsDoNot.setBounds(71, 310, 223, 15);
		frame.getContentPane().add(lblPasswordsDoNot);
		
		WorkplacetextField = new JTextField();
		WorkplacetextField.setColumns(10);
		WorkplacetextField.setBounds(164, 255, 112, 20);
		frame.getContentPane().add(WorkplacetextField);
		
		lblWorkplace = new JLabel("Workplace");
		lblWorkplace.setBounds(164, 239, 112, 15);
		frame.getContentPane().add(lblWorkplace);
		
		JLabel lblEmailsDoNot = new JLabel("Emails do not match");
		lblEmailsDoNot.setForeground(Color.WHITE);
		lblEmailsDoNot.setBounds(70, 283, 171, 15);
		frame.getContentPane().add(lblEmailsDoNot);
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = txtFirstName.getText();
				String lName = txtLastName.getText();
				String email = txtEmail.getText();
				String conEmail = txtConfirmEmail.getText();
				String workplace = WorkplacetextField.getText();
				char[] tempPswd = pwdPassword.getPassword();
				char[] tempConPswd = pwdconField.getPassword();
				String pswd = String.copyValueOf(tempPswd);
				String conPswd = String.copyValueOf(tempConPswd);
				
				if(email.equals(conEmail)) {
					lblEmailsDoNot.setForeground(Color.WHITE);
					if(pswd.equals(conPswd)) {
						lblPasswordsDoNot.setForeground(Color.WHITE);
						MysqlCon x = new MysqlCon();
						Connection con;
						try {
						con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
						String query = "insert into emp_cred (emp_id, firstname, lastname, email, password, workplace)" + " values(?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setInt(1,x.getAEmployerID());
						ps.setString(2, fName);
						ps.setString(3, lName);
						ps.setString(4, email);
						ps.setString(5, pswd);
						ps.setString(6, workplace);
						ps.execute();
						LoginPage.main(null);
						frame.setVisible(false);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					} else {
						lblPasswordsDoNot.setForeground(Color.RED);
					}
				} else {
					lblEmailsDoNot.setForeground(Color.RED);
				}
			}
		});
		btnConfirm.setBounds(330, 337, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage.main(null);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		
		
		
	}
}
