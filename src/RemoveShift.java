import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RemoveShift {
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
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblRemoveShift;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		RemoveShift x = new RemoveShift();
		x.setWorkplace(workplace);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveShift window = new RemoveShift();
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
	public RemoveShift() {
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
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 72, 112, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(87, 120, 97, 23);
		frame.getContentPane().add(chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(184, 120, 97, 23);
		frame.getContentPane().add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(286, 120, 97, 23);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(87, 171, 97, 23);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(184, 171, 97, 23);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(286, 171, 97, 23);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(184, 211, 97, 23);
		frame.getContentPane().add(chckbxSaturday);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(101, 75, 41, 14);
		frame.getContentPane().add(lblEmail);
		
		lblRemoveShift = new JLabel("Remove Shift");
		lblRemoveShift.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRemoveShift.setBounds(146, 23, 174, 26);
		frame.getContentPane().add(lblRemoveShift);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			//Checks if box was ticked and if so removes that employees shift for the corresponding day.
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon x = new MysqlCon();
				try {
				Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
				int id = x.getACurrentEmployeeID(txtEmail.getText());
				if(chckbxSunday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Sunday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxMonday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Monday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxTuesday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Tuesday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxWednesday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Wednesday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxThursday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Thursday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxFriday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Friday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				if(chckbxSaturday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Saturday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				con.close();
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnConfirm.setBounds(330, 337, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		
	
	}
}
