import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class CreateAccount {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblCreateAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount window = new CreateAccount();
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
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(60, 90, 86, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(178, 90, 86, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(60, 146, 86, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(60, 207, 86, 20);
		frame.getContentPane().add(pwdPassword);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(60, 75, 65, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setBounds(178, 75, 68, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(60, 133, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(60, 193, 61, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 265, 86, 20);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel = new JLabel("Confirm Password");
		lblNewLabel.setBounds(60, 249, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateAccount.setBounds(60, 25, 166, 26);
		frame.getContentPane().add(lblCreateAccount);
	}
}
