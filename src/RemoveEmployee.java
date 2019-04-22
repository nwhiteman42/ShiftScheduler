import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class RemoveEmployee {
	
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
	private final JLabel lblRemoveEmployee = new JLabel("Remove Employee");
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblFailedToRemove;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtemail;
	

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		RemoveEmployee x = new RemoveEmployee();
		x.setWorkplace(workplace);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee window = new RemoveEmployee();
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
	public RemoveEmployee() {
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
		frame.setBounds(100, 100, 425, 405);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblRemoveEmployee.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblRemoveEmployee.setBounds(117, 24, 211, 37);
		lblRemoveEmployee.setForeground(Color.WHITE);
		frame.getContentPane().add(lblRemoveEmployee);
		
		
		
		txtemail = new JTextField();
		txtemail.setBounds(127, 233, 173, 22);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(127, 118, 173, 22);
		frame.getContentPane().add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(127, 175, 173, 22);
		frame.getContentPane().add(txtlastname);
		txtlastname.setColumns(10);
		
		
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(127, 219, 64, 14);
		frame.getContentPane().add(lblEmail);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(127, 101, 81, 20);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(127, 161, 81, 14);
		frame.getContentPane().add(lblLastName);
		
		lblFailedToRemove = new JLabel("Failed to remove Employee!");
		lblFailedToRemove.setForeground(Color.GRAY);
		lblFailedToRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFailedToRemove.setBounds(137, 266, 196, 14);
		frame.getContentPane().add(lblFailedToRemove);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.GRAY);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setBorder(new LineBorder(Color.WHITE));
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets data from text fields
				String empName = txtfirstname.getText() + " " + txtlastname.getText();
				String email = txtemail.getText();
				MysqlCon x = new MysqlCon();
				int id = -1;
				try {
					id = x.getACurrentEmployeeID(email);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				Connection con;
				try {
					//Deletes employee from database
					con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String query = "DELETE FROM Employee_Data WHERE Employee_Name= " + "'" + empName + "'" + " AND email= " +  "'" + email + "'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.executeUpdate();
					
					String query2 = "DELETE FROM Employee_Shifts WHERE Employee_ID =" +id;
					PreparedStatement ps2 = con.prepareStatement(query2);
					ps2.executeUpdate();
						
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					//opens main menu after the deletion
					ShiftSchedulerWindow.main(workplace);
					frame.setVisible(false);
			}
		});
		
		btnRemove.setBounds(224, 286, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnCancel = new JButton("Go Back");
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorder(new LineBorder(Color.WHITE));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			//Opens main menu if this is closed
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.hide();
			}
		});
		btnCancel.setBounds(119, 286, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		frame.setUndecorated(true);
	}
}