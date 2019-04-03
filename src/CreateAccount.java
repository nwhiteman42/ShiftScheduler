import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

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
	private JTextField textField;
	private JLabel lblConfirmEmail;

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
		txtFirstName.setBounds(86, 90, 112, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(208, 90, 112, 20);
		frame.getContentPane().add(txtLastName);
		txtLastName.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(86, 146, 112, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 207, 112, 20);
		frame.getContentPane().add(passwordField);
		
		lblNewLabel = new JLabel("Confirm Password");
		lblNewLabel.setBounds(208, 193, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateAccount.setBounds(128, 25, 166, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		textField = new JTextField();
		textField.setBounds(208, 146, 112, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblConfirmEmail = new JLabel("Confirm Email");
		lblConfirmEmail.setBounds(208, 133, 86, 14);
		frame.getContentPane().add(lblConfirmEmail);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(330, 337, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
	}
}
