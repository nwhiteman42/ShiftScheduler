import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;
	private JLabel txtLogin;
	private JLabel txtEmail;
	private JPasswordField passwordField;
	private JLabel txtPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtLogin = new JLabel();
		txtLogin.setText("Login:");
		txtLogin.setBounds(200, 37, 43, 20);
		frame.getContentPane().add(txtLogin);
		
		txtEmail = new JLabel();
		txtEmail.setText("Email: ");
		txtEmail.setBounds(92, 99, 62, 20);
		frame.getContentPane().add(txtEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 132, 134, 20);
		frame.getContentPane().add(passwordField);
		
		txtPassword = new JLabel();
		txtPassword.setText("Password:");
		txtPassword.setBounds(94, 132, 65, 20);
		frame.getContentPane().add(txtPassword);
		

		JLabel lblError = new JLabel("Username or password incorrect");
		lblError.setForeground(Color.WHITE);
		lblError.setBounds(129, 68, 181, 14);
		frame.getContentPane().add(lblError);
		
		
		textField = new JTextField();
		textField.setBounds(176, 99, 134, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String em = textField.getText(); //Gets email
				char[] pass = passwordField.getPassword();
				String password = String.copyValueOf(pass); //Converts password to string.
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String query = "SELECT count(password) FROM emp_cred where password =" +"'"+ password +"'" +" and email = " +"'" + em + "'";
					System.out.println(query);
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet rs = ps.executeQuery();
					System.out.println("ran");
					int x = 0;
					while(rs.next()) {
						x = rs.getInt(1);
					}
					System.out.println("ran2");
					System.out.println(x);
					if(x != 1) { //Open new window
						lblError.setForeground(Color.RED);
					} else if( x == 1) {
						lblError.setForeground(Color.WHITE);
					}
					
				} catch (SQLException e) {
					//TODO: Make exception page
				}
				
			}
		});
		btnLogin.setBounds(107, 180, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(221, 180, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(292, 227, 132, 23);
		frame.getContentPane().add(btnForgotPassword);
		
	}

}
