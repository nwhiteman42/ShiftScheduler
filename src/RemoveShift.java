import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
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
import java.awt.Color;

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
		x.setWorkplace(workplace);//Sets workplace to the workplace of the current user
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveShift window = new RemoveShift();
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
	public RemoveShift() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 72, 112, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSunday.setBorder(new LineBorder(Color.WHITE));
		chckbxSunday.setBounds(35, 120, 115, 23);
		frame.getContentPane().add(chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBackground(Color.GRAY);
		chckbxMonday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxMonday.setForeground(Color.WHITE);
		chckbxMonday.setBorder(new LineBorder(Color.WHITE));
		chckbxMonday.setBounds(152, 120, 112, 23);
		frame.getContentPane().add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxTuesday.setBorder(new LineBorder(Color.WHITE));
		chckbxTuesday.setBounds(266, 120, 97, 23);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxWednesday.setBorder(new LineBorder(Color.WHITE));
		chckbxWednesday.setBounds(35, 171, 115, 23);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxThursday.setBorder(new LineBorder(Color.WHITE));
		chckbxThursday.setBounds(152, 171, 112, 23);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxFriday.setBorder(new LineBorder(Color.WHITE));
		chckbxFriday.setBounds(266, 171, 97, 23);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxSaturday.setBorder(new LineBorder(Color.WHITE));
		chckbxSaturday.setBounds(152, 215, 112, 23);
		frame.getContentPane().add(chckbxSaturday);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(98, 73, 44, 16);
		frame.getContentPane().add(lblEmail);
		
		lblRemoveShift = new JLabel("Remove Shift");
		lblRemoveShift.setForeground(Color.WHITE);
		lblRemoveShift.setBackground(Color.BLACK);
		lblRemoveShift.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRemoveShift.setBounds(146, 23, 174, 26);
		frame.getContentPane().add(lblRemoveShift);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.addActionListener(new ActionListener() {
			//Checks if box was ticked and if so removes that employees shift for the corresponding day.
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon x = new MysqlCon();
				try {
				Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
				int id = x.getACurrentEmployeeID(txtEmail.getText()); //Gets employee id
				//If box is selected removes employee's shift for Sunday
				if(chckbxSunday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Sunday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Monday
				if(chckbxMonday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Monday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Tuesday
				if(chckbxTuesday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Tuesday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Wednesday
				if(chckbxWednesday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Wednesday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Thursday
				if(chckbxThursday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Thursday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Friday
				if(chckbxFriday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Friday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				//If box is selected removes employee's shift for Saturday
				if(chckbxSaturday.isSelected()) {
					String query = "delete from Employee_Shifts where Employee_ID = ? and Day = 'Saturday'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, id);
					ps.executeUpdate();
				}
				con.close();
				//Opens main menu after shifts are removed
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
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setBackground(Color.GRAY);
		btnGoBack.setBorder(new LineBorder(Color.WHITE));
		btnGoBack.addActionListener(new ActionListener() {
			//Opens main menu when button is pressed
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
