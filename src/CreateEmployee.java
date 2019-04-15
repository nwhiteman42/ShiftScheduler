import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateEmployee {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblCreateAccount;
	private JTextField textField;
	private JLabel lblConfirmEmail;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEmployee window = new CreateEmployee();
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
		
		txtUsername = new JTextField();
		txtUsername.setBounds(86, 146, 112, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(86, 75, 65, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last name");
		lblLastName.setBounds(208, 75, 68, 14);
		frame.getContentPane().add(lblLastName);
		
		lblUsername = new JLabel("Email");
		lblUsername.setBounds(86, 133, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		lblCreateAccount = new JLabel("Create Employee");
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
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 205, 112, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setBounds(86, 190, 46, 14);
		frame.getContentPane().add(lblJobTitle);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 205, 112, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSeniority = new JLabel("Seniority");
		lblSeniority.setBounds(208, 190, 46, 14);
		frame.getContentPane().add(lblSeniority);
		
		textField_3 = new JTextField();
		textField_3.setBounds(86, 264, 112, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPlaceOfWork = new JLabel("Place of Work");
		lblPlaceOfWork.setBounds(86, 249, 98, 14);
		frame.getContentPane().add(lblPlaceOfWork);
	}
}
