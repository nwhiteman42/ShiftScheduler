import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 405);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblRemoveEmployee.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRemoveEmployee.setBounds(113, 11, 222, 31);
		frame.getContentPane().add(lblRemoveEmployee);
		
		
		
		txtemail = new JTextField();
		txtemail.setBounds(125, 268, 173, 20);
		frame.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(125, 156, 173, 20);
		frame.getContentPane().add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(125, 212, 173, 20);
		frame.getContentPane().add(txtlastname);
		txtlastname.setColumns(10);
		
		
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(125, 243, 64, 14);
		frame.getContentPane().add(lblEmail);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(125, 125, 81, 20);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(125, 187, 81, 14);
		frame.getContentPane().add(lblLastName);
		
		lblFailedToRemove = new JLabel("Failed to remove Emloyee");
		lblFailedToRemove.setForeground(SystemColor.menu);
		lblFailedToRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFailedToRemove.setBounds(127, 344, 186, 14);
		frame.getContentPane().add(lblFailedToRemove);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gets data from text feilds
				String empName = txtfirstname.getText() + " " + txtlastname.getText();
				String email = txtemail.getText();
				
				/**
				 * TODO: Create a check to make throw an error if the program failed to remove someone.
				 */
				Connection con;
				try {
					//Deletes employee from database
					con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String query = "DELETE FROM Employee_Data WHERE Employee_Name= " + "'" + empName + "'" + " AND email= " +  "'" + email + "'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.executeUpdate();
						
					}
					catch (SQLException e1) {
						e1.printStackTrace();
					}
					//opens main menu after the deletion
					ShiftSchedulerWindow.main(workplace);
					frame.setVisible(false);
			}
		});
		
		btnRemove.setBounds(117, 310, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			//Opens main menu if this is closed
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.hide();
			}
		});
		btnCancel.setBounds(222, 310, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
	}
}