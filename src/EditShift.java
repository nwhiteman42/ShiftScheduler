import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
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
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JList;

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
		/*Converts the time from the comboboxes to the int type that our database uses
		 * @param time, This is the time that will be passed in from a combo box
		 * @result int, int that will be used to insert time into the database
		 */
		public int getTime(String time) {
			int timeData = 0;
			if(time.equals("0:00")){
				timeData = 0;
			} else if(time.equals("1:00")) {
				timeData=100;
			} else if(time.equals("2:00")){
				timeData=200;
			} else if (time.equals("3:00")) {
				timeData= 300;
			} else if(time.equals("4:00")) {
				timeData = 400;
			} else if(time.equals("5:00")) {
				timeData = 500;
			} else if(time.equals("6:00")) {
				timeData = 500;
			} else if(time.equals("7:00")){
				timeData = 700;
			} else if(time.equals("8:00")) {
				timeData = 800;
			} else if(time.equals("9:00")) {
				timeData = 900;
			} else if(time.equals("10:00")) {
				timeData = 1000;
			} else if(time.equals("11:00")) {
				timeData = 1100;
			} else if (time.equals("12:00")) {
				timeData = 1200;
			} else if (time.equals("13:00")) {
				timeData = 1300;
			} else if (time.equals("14:00")) {
				timeData = 1400;
			} else if (time.equals("15:00")) {
				timeData = 1500;
			} else if (time.equals("16:00")) {
				timeData = 1600;
			} else if (time.equals("17:00")) {
				timeData = 1700;
			} else if (time.equals("18:00")) {
				timeData = 1800;
			} else if (time.equals("19:00")) {
				timeData = 1900;
			} else if (time.equals("20:00")) {
				timeData = 2000;
			} else if (time.equals("21:00")) {
				timeData = 2100;
			} else if (time.equals("22:00")) {
				timeData = 2200;
			} else if (time.equals("23:00")) {
				timeData = 2300;
			} else if (time.equals("24:00")) {
				timeData = 2400; 
			}
			return timeData;
		}

		
	private JFrame frame;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblEditShift;
	private JLabel lblInvalidInput;
	private JComboBox SunComboBox;
	private JComboBox SunEndcomboBox;
	private JComboBox MonStartComboBox;
	private JComboBox MonEndcomboBox;
	private JComboBox TuesStartcomboBox;
	private JComboBox TuesEndcomboBox;
	private JComboBox WedStartComboBox;
	private JComboBox WedEndComboBox;
	private JComboBox ThurStartComboBox;
	private JComboBox ThurEndComboBox;
	private JComboBox FriStartComboBox;
	private JComboBox FriEndComboBox;
	private JComboBox SatStartComboBox;
	private JComboBox SatEndComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		EditShift x = new EditShift();
		x.setWorkplace(workplace);//Sets workplace to workplace of current user
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditShift window = new EditShift();
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
	public EditShift() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.WHITE));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 72, 140, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(101, 75, 41, 14);
		frame.getContentPane().add(lblEmail);
		
		lblEditShift = new JLabel("Edit Shift");
		lblEditShift.setForeground(Color.WHITE);
		lblEditShift.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblEditShift.setBounds(164, 25, 156, 26);
		frame.getContentPane().add(lblEditShift);
		
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.setForeground(Color.WHITE);
		btnGoBack.setBackground(Color.GRAY);
		btnGoBack.setBorder(new LineBorder(Color.WHITE));
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGoBack.addActionListener(new ActionListener() {
			//Opens main menu when "Go Back" is pressed
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnGoBack.setBounds(117, 336, 89, 23);
		frame.getContentPane().add(btnGoBack);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setForeground(Color.WHITE);
		lblStartTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStartTime.setBounds(188, 103, 76, 14);
		frame.getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setForeground(Color.WHITE);
		lblEndTime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndTime.setBounds(286, 103, 84, 14);
		frame.getContentPane().add(lblEndTime);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(87, 120, 97, 23);
		frame.getContentPane().add(chckbxSunday);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setForeground(Color.WHITE);
		chckbxMonday.setBackground(Color.GRAY);
		chckbxMonday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxMonday.setBounds(87, 150, 97, 23);
		frame.getContentPane().add(chckbxMonday);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxTuesday.setBounds(87, 180, 97, 23);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxWednesday.setBounds(87, 210, 97, 23);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxThursday.setBounds(87, 240, 97, 23);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(87, 270, 97, 23);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxSaturday.setBounds(87, 300, 97, 23);
		frame.getContentPane().add(chckbxSaturday);
	
		String[] times = {"0:00", "1:00", "2:00", "3:00" ,"4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00",
				"13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00","22:00","23:00","24:00"};
		
		SunComboBox = new JComboBox(times);
		SunComboBox.setBounds(190, 120, 85, 25);
		frame.getContentPane().add(SunComboBox);
	
		SunEndcomboBox = new JComboBox(times);
		SunEndcomboBox.setBounds(290, 120, 85, 25);
		frame.getContentPane().add(SunEndcomboBox);
		
		MonStartComboBox = new JComboBox(times);
		MonStartComboBox.setBounds(190, 150, 85, 25);
		frame.getContentPane().add(MonStartComboBox);
		
		MonEndcomboBox = new JComboBox(times);
		MonEndcomboBox.setBounds(290, 150, 85, 25);
		frame.getContentPane().add(MonEndcomboBox);
		
		TuesStartcomboBox = new JComboBox(times);
		TuesStartcomboBox.setBounds(190, 180, 85, 25);
		frame.getContentPane().add(TuesStartcomboBox);
		
		TuesEndcomboBox = new JComboBox(times);
		TuesEndcomboBox.setBounds(290, 180, 85, 25);
		frame.getContentPane().add(TuesEndcomboBox);
		
		WedStartComboBox = new JComboBox(times);
		WedStartComboBox.setBounds(190, 210, 85, 25);
		frame.getContentPane().add(WedStartComboBox);
		
		WedEndComboBox = new JComboBox(times);
		WedEndComboBox.setBounds(290, 210, 85, 25);
		frame.getContentPane().add(WedEndComboBox);
		
		ThurStartComboBox = new JComboBox(times);
		ThurStartComboBox.setBounds(190, 240, 85, 25);
		frame.getContentPane().add(ThurStartComboBox);
		
		ThurEndComboBox = new JComboBox(times);
		ThurEndComboBox.setBounds(290, 240, 85, 25);
		frame.getContentPane().add(ThurEndComboBox);
		
		FriStartComboBox = new JComboBox(times);
		FriStartComboBox.setBounds(190, 270, 85, 25);
		frame.getContentPane().add(FriStartComboBox);
		
		FriEndComboBox = new JComboBox(times);
		FriEndComboBox.setBounds(290, 270, 85, 25);
		frame.getContentPane().add(FriEndComboBox);
		
		SatStartComboBox = new JComboBox(times);
		SatStartComboBox.setBounds(190, 300, 85, 25);
		frame.getContentPane().add(SatStartComboBox);
		
		SatEndComboBox = new JComboBox(times);
		SatEndComboBox.setBounds(290, 300, 85, 25);
		frame.getContentPane().add(SatEndComboBox);
		
		lblInvalidInput = new JLabel("Invalid input");
		lblInvalidInput.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvalidInput.setForeground(Color.GRAY);
		lblInvalidInput.setBounds(175, 370, 134, 29);
		frame.getContentPane().add(lblInvalidInput);
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon x = new MysqlCon();
				EditShift y = new EditShift();
				try {
					if(txtEmail.getText().isEmpty()) {
						lblInvalidInput.setForeground(Color.RED);
						return;
					}
					lblInvalidInput.setForeground(Color.GRAY);
					//Gets Employee id and name from corresponding text fields
					int id = x.getACurrentEmployeeID(txtEmail.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String q = "select Employee_name from Employee_Data where Employee_id = "+id;
					Statement stmt= con.createStatement();
					ResultSet rs = stmt.executeQuery(q);
					String name = null;
					while(rs.next()) {
						name = rs.getString(1);
					}
					//Removes previous shift information from database
					String query = "delete from Employee_Shifts where Employee_ID = " + id ;
					PreparedStatement ps = con.prepareStatement(query);
					ps.execute();
					//Inserts shift data for Sunday if selected
					if(chckbxSunday.isSelected()) {
						if(y.getTime(SunComboBox.getSelectedItem().toString()) > y.getTime(SunEndcomboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qSun = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pSun = con.prepareStatement(qSun);
						pSun.setInt(1, id);
						pSun.setString(2, name);
						pSun.setString(3, "Sunday");
						pSun.setInt(4, y.getTime(SunComboBox.getSelectedItem().toString()));
						pSun.setInt(5, y.getTime(SunEndcomboBox.getSelectedItem().toString()));
						pSun.execute();
					}
					//Inserts shift data for Monday if selected
					if(chckbxMonday.isSelected()) {
						if(y.getTime(MonStartComboBox.getSelectedItem().toString()) > y.getTime(MonEndcomboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qMon = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pMon = con.prepareStatement(qMon);
						pMon.setInt(1, id);
						pMon.setString(2, name);
						pMon.setString(3, "Monday");
						pMon.setInt(4, y.getTime(MonStartComboBox.getSelectedItem().toString()));
						pMon.setInt(5, y.getTime(MonEndcomboBox.getSelectedItem().toString()));
						pMon.execute();
						
					}
					//Inserts shift data for Tuesday if selected
					if(chckbxTuesday.isSelected()) {
						if(y.getTime(TuesStartcomboBox.getSelectedItem().toString()) > y.getTime(TuesEndcomboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qTue = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pTue = con.prepareStatement(qTue);
						pTue.setInt(1, id);
						pTue.setString(2, name);
						pTue.setString(3, "Tuesday");
						pTue.setInt(4, y.getTime(TuesStartcomboBox.getSelectedItem().toString()));
						pTue.setInt(5, y.getTime(TuesEndcomboBox.getSelectedItem().toString()));
						pTue.execute();
					}
					//Inserts shift data for Wednesday if selected
					if(chckbxWednesday.isSelected()) {
						if(y.getTime(WedStartComboBox.getSelectedItem().toString()) > y.getTime(WedEndComboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qWed = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pWed = con.prepareStatement(qWed);
						pWed.setInt(1, id);
						pWed.setString(2, name);
						pWed.setString(3, "Wednesday");
						pWed.setInt(4, y.getTime(WedStartComboBox.getSelectedItem().toString()));
						pWed.setInt(5, y.getTime(WedEndComboBox.getSelectedItem().toString()));
						pWed.execute();
					}
					//Inserts shift data for Thursday if selected
					if(chckbxThursday.isSelected()) {
						if(y.getTime(ThurStartComboBox.getSelectedItem().toString()) > y.getTime(ThurEndComboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qThu = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pThu = con.prepareStatement(qThu);
						pThu.setInt(1, id);
						pThu.setString(2, name);
						pThu.setString(3, "Thursday");
						pThu.setInt(4, y.getTime(ThurStartComboBox.getSelectedItem().toString()));
						pThu.setInt(5, y.getTime(ThurEndComboBox.getSelectedItem().toString()));
						pThu.execute();
					}
					//Inserts shift data for Friday if selected
					if(chckbxFriday.isSelected()) {
						if(y.getTime(FriStartComboBox.getSelectedItem().toString()) > y.getTime(FriEndComboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qFri = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pFri = con.prepareStatement(qFri);
						pFri.setInt(1, id);
						pFri.setString(2, name);
						pFri.setString(3, "Friday");
						pFri.setInt(4, y.getTime(FriStartComboBox.getSelectedItem().toString()));
						pFri.setInt(5, y.getTime(FriEndComboBox.getSelectedItem().toString()));
						pFri.execute();
					}
					//Inserts shift data for Saturday if selected
					if(chckbxSaturday.isSelected()) {
						if(y.getTime(SatStartComboBox.getSelectedItem().toString()) > y.getTime(SatEndComboBox.getSelectedItem().toString())) {
							lblInvalidInput.setForeground(Color.RED);
							return;
						}
						String qSat = "insert into Employee_Shifts (Employee_id, Employee_name, Day, Start_Time, End_Time) values (?,?,?,?,?)";
						PreparedStatement pSat = con.prepareStatement(qSat);
						pSat.setInt(1, id);
						pSat.setString(2, name);
						pSat.setString(3, "Saturday");
						pSat.setInt(4, y.getTime(SatStartComboBox.getSelectedItem().toString()) );
						pSat.setInt(5, y.getTime(SatEndComboBox.getSelectedItem().toString()));
						pSat.execute();
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				//Opens main menu after shift information are put into database
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
				
			}
		});
		btnConfirm.setBounds(231, 336, 89, 23);
		frame.getContentPane().add(btnConfirm);
		
		frame.setUndecorated(true);
	
	}
}
