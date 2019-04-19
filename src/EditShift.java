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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EditShift {
	
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
	private JLabel lblFirstName;
	private JLabel lblCreateAccount;
	private JTextField txtSunStart;
	private JTextField txtSunEnd;
	private JTextField txtMonStart;
	private JTextField txtTuesStart;
	private JTextField txtWedStart;
	private JTextField txtThursStart;
	private JTextField txtFriStart;
	private JTextField txtSatStart;
	private JTextField txtMonEnd;
	private JTextField txtTuesEnd;
	private JTextField txtWedEnd;
	private JTextField txtThursEnd;
	private JTextField txtFriEnd;
	private JTextField txtSatEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		EditShift x = new EditShift();
		x.setWorkplace(workplace);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditShift window = new EditShift();
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
	public EditShift() {
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
		txtFirstName.setBounds(152, 72, 112, 20);
		frame.getContentPane().add(txtFirstName);
		txtFirstName.setColumns(10);
		
		lblFirstName = new JLabel("Email");
		lblFirstName.setBounds(101, 75, 41, 14);
		frame.getContentPane().add(lblFirstName);
		
		lblCreateAccount = new JLabel("Edit Shift");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateAccount.setBounds(164, 25, 156, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(231, 337, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		txtSunStart = new JTextField();
		txtSunStart.setBounds(190, 121, 86, 20);
		frame.getContentPane().add(txtSunStart);
		txtSunStart.setColumns(10);
		
		txtSunEnd = new JTextField();
		txtSunEnd.setBounds(286, 121, 86, 20);
		frame.getContentPane().add(txtSunEnd);
		txtSunEnd.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(200, 108, 76, 14);
		frame.getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(298, 108, 74, 14);
		frame.getContentPane().add(lblEndTime);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setBounds(87, 120, 97, 23);
		frame.getContentPane().add(chckbxSunday);
		
		txtMonStart = new JTextField();
		txtMonStart.setColumns(10);
		txtMonStart.setBounds(190, 152, 86, 20);
		frame.getContentPane().add(txtMonStart);
		
		txtTuesStart = new JTextField();
		txtTuesStart.setColumns(10);
		txtTuesStart.setBounds(190, 183, 86, 20);
		frame.getContentPane().add(txtTuesStart);
		
		txtWedStart = new JTextField();
		txtWedStart.setColumns(10);
		txtWedStart.setBounds(190, 214, 86, 20);
		frame.getContentPane().add(txtWedStart);
		
		txtThursStart = new JTextField();
		txtThursStart.setColumns(10);
		txtThursStart.setBounds(190, 245, 86, 20);
		frame.getContentPane().add(txtThursStart);
		
		txtFriStart = new JTextField();
		txtFriStart.setColumns(10);
		txtFriStart.setBounds(190, 276, 86, 20);
		frame.getContentPane().add(txtFriStart);
		
		txtSatStart = new JTextField();
		txtSatStart.setColumns(10);
		txtSatStart.setBounds(190, 307, 86, 20);
		frame.getContentPane().add(txtSatStart);
		
		txtMonEnd = new JTextField();
		txtMonEnd.setColumns(10);
		txtMonEnd.setBounds(286, 152, 86, 20);
		frame.getContentPane().add(txtMonEnd);
		
		txtTuesEnd = new JTextField();
		txtTuesEnd.setColumns(10);
		txtTuesEnd.setBounds(286, 183, 86, 20);
		frame.getContentPane().add(txtTuesEnd);
		
		txtWedEnd = new JTextField();
		txtWedEnd.setColumns(10);
		txtWedEnd.setBounds(286, 214, 86, 20);
		frame.getContentPane().add(txtWedEnd);
		
		txtThursEnd = new JTextField();
		txtThursEnd.setColumns(10);
		txtThursEnd.setBounds(286, 245, 86, 20);
		frame.getContentPane().add(txtThursEnd);
		
		txtFriEnd = new JTextField();
		txtFriEnd.setColumns(10);
		txtFriEnd.setBounds(286, 276, 86, 20);
		frame.getContentPane().add(txtFriEnd);
		
		txtSatEnd = new JTextField();
		txtSatEnd.setColumns(10);
		txtSatEnd.setBounds(286, 307, 86, 20);
		frame.getContentPane().add(txtSatEnd);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(86, 151, 97, 23);
		frame.getContentPane().add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(86, 182, 97, 23);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(86, 213, 97, 23);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(87, 244, 97, 23);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(86, 275, 97, 23);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBounds(86, 306, 97, 23);
		frame.getContentPane().add(chckbxSaturday);
	
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon x = new MysqlCon();
				try {
					int id = x.getACurrentEmployeeID(txtFirstName.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String q = "select Employee_name from Employee_Data where Employee_id = "+id;
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery(q);
					String name = null;
					while(rs.next()) {
						name = rs.getString(1);
					}
					
					String query = "delete from Employee_Shifts where Employee_ID = " + id ;
					PreparedStatement ps = con.prepareStatement(query);
					ps.execute();
					
					if(chckbxSunday.isSelected()) {
						String qSun = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pSun = con.prepareStatement(qSun);
						pSun.setInt(1, id);
						pSun.setString(2, name);
						pSun.setString(3, "Sunday");
						pSun.setInt(4, Integer.parseInt(txtSunStart.getText()));
						pSun.setInt(5, Integer.parseInt(txtSunEnd.getText()));
						pSun.execute();
					}
					if(chckbxMonday.isSelected()) {
						String qMon = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pMon = con.prepareStatement(qMon);
						pMon.setInt(1, id);
						pMon.setString(2, name);
						pMon.setString(3, "Monday");
						pMon.setInt(4, Integer.parseInt(txtMonStart.getText()));
						pMon.setInt(5, Integer.parseInt(txtMonEnd.getText()));
						pMon.execute();
						
					}
					if(chckbxTuesday.isSelected()) {
						String qTue = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pTue = con.prepareStatement(qTue);
						pTue.setInt(1, id);
						pTue.setString(2, name);
						pTue.setString(3, "Tuesday");
						pTue.setInt(4, Integer.parseInt(txtTuesStart.getText()));
						pTue.setInt(5, Integer.parseInt(txtTuesEnd.getText()));
						pTue.execute();
					}
					if(chckbxWednesday.isSelected()) {
						String qWed = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pWed = con.prepareStatement(qWed);
						pWed.setInt(1, id);
						pWed.setString(2, name);
						pWed.setString(3, "Wednesday");
						pWed.setInt(4, Integer.parseInt(txtWedStart.getText()));
						pWed.setInt(5, Integer.parseInt(txtWedEnd.getText()));
						pWed.execute();
					}
					if(chckbxThursday.isSelected()) {
						String qThu = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pThu = con.prepareStatement(qThu);
						pThu.setInt(1, id);
						pThu.setString(2, name);
						pThu.setString(3, "Thursday");
						pThu.setInt(4, Integer.parseInt(txtThursStart.getText()));
						pThu.setInt(5, Integer.parseInt(txtThursEnd.getText()));
						pThu.execute();
					}
					if(chckbxFriday.isSelected()) {
						String qFri = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pFri = con.prepareStatement(qFri);
						pFri.setInt(1, id);
						pFri.setString(2, name);
						pFri.setString(3, "Friday");
						pFri.setInt(4, Integer.parseInt(txtFriStart.getText()));
						pFri.setInt(5, Integer.parseInt(txtFriEnd.getText()));
						pFri.execute();
					}
					if(chckbxSaturday.isSelected()) {
						String qSat = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pSat = con.prepareStatement(qSat);
						pSat.setInt(1, id);
						pSat.setString(2, name);
						pSat.setString(3, "Saturday");
						pSat.setInt(4, Integer.parseInt(txtSatStart.getText()));
						pSat.setInt(5, Integer.parseInt(txtSatEnd.getText()));
						pSat.execute();
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnConfirm.setBounds(330, 337, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
	}
	
	private void addTimeEntry(String start, String end, TimeEntry[] times, int index) {
		int startTime = Integer.parseInt(start);
		int endTime = Integer.parseInt(end);
		TimeEntry newest = times[index];
		newest.setStartTime(startTime);
		newest.setEndTime(endTime);
	}
	
	private TimeEntry[] timeEntryMerge(TimeEntry[] older, TimeEntry[] newer) {
		TimeEntry[] merged = new TimeEntry[7];
		for( int i = 0; i < 7; i++ ) {
			if( newer[i] != null ) {
				merged[i] = newer[i];
			} else if( older[i] != null ) {
				merged[i] = older[i];
			}
		}
		return merged;
	}
}
