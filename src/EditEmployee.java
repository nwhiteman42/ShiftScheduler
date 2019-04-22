import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditEmployee {

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
	private JLabel txtEmail;
	private JLabel txtrOld;
	private JLabel txtrNew;
	private JLabel textArea_1;
	private JLabel txtrPlaceOfWork;
	private JLabel txtrEmail;
	private JTextField textField;
	private JTextField textLastName;
	private JTextField textField_5;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblInvalidInput;
	private JTextField textFirstName;
	private JLabel lblLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String workplace) {
		EditEmployee x = new EditEmployee();
		x.setWorkplace(workplace);//Sets workplace to current users workplace
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployee window = new EditEmployee();
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
	public EditEmployee() {
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
		frame.setBounds(100, 100, 425, 390);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtrOld = new JLabel("Old Employee Data:");
		txtrOld.setForeground(Color.WHITE);
		txtrOld.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtrOld.setBounds(41, 39, 146, 15);
		frame.getContentPane().add(txtrOld);
		
		txtEmail = new JLabel("Email");
		txtEmail.setForeground(Color.WHITE);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEmail.setBounds(51, 65, 72, 15);
		frame.getContentPane().add(txtEmail);
		
		textField = new JTextField();
		textField.setBounds(51, 79, 124, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtrNew = new JLabel("New Employee Data:");
		txtrNew.setForeground(Color.WHITE);
		txtrNew.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtrNew.setBounds(227, 39, 173, 15);
		frame.getContentPane().add(txtrNew);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(237, 122, 124, 20);
		frame.getContentPane().add(textLastName);
		
		textArea_1 = new JLabel("Title");
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_1.setBounds(237, 153, 72, 15);
		frame.getContentPane().add(textArea_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(237, 167, 124, 20);
		frame.getContentPane().add(textField_5);
		
		lblInvalidInput = new JLabel("Invalid Input");
		lblInvalidInput.setForeground(Color.GRAY);
		lblInvalidInput.setBounds(41, 252, 82, 14);
		frame.getContentPane().add(lblInvalidInput);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.addActionListener(new ActionListener() {
		
			
		public void actionPerformed(ActionEvent arg0){
				MysqlCon x = new MysqlCon();
				if(textField_1.getText().isEmpty() || textField_5.getText().isEmpty() || textField.getText().isEmpty()||
					textLastName.getText().isEmpty() || textField_2.getText().isEmpty() || textFirstName.getText().isEmpty() ||
					textLastName.getText().isEmpty()) {
					lblInvalidInput.setForeground(Color.RED);
					return;
				}
				try {
					//Updates the employee information
					int id = x.getACurrentEmployeeID(textField.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					//Gets previous place of work
					String workQuery = "select placeofwork from Employee_Data where Employee_ID = "+id;
					PreparedStatement workps = con.prepareStatement(workQuery);
					ResultSet rs = workps.executeQuery();
					String previousWorkplace = null;
					while(rs.next()) {
						previousWorkplace = rs.getString(1);
					}
					String newWorkplace = textField_1.getText();
					if(previousWorkplace.equals(newWorkplace)) {
						String query = "update Employee_Shifts set Employee_Name = ? where Employee_ID = "+ id;
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, textLastName.getText());
						ps.executeUpdate();
					} else {
						String query = "delete from Employee_Shifts where Employee_ID = "+id;
						PreparedStatement ps = con.prepareStatement(query);
						ps.executeUpdate();
					}
					String query = "update Employee_Data set Employee_Name = '"+ textFirstName.getText() +" "+textLastName.getText() + "', "
							+ "Employee_Title = '" + textField_5.getText() + "', seniority = '"+ 1 + "', placeofwork = '" + 
							textField_1.getText() + "', email = '" + textField_2.getText() + "' where Employee_ID = '" + id + "'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.executeUpdate();
					con.close();
					ShiftSchedulerWindow.main(workplace);
					frame.setVisible(false);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			}
		});
		btnConfirm.setBounds(227, 329, 114, 25);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Go Back");
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBorder(new LineBorder(Color.WHITE));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			//Opens main menu when cancel is pressed
			public void actionPerformed(ActionEvent e) {
				ShiftSchedulerWindow.main(workplace);
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(86, 329, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(237, 212, 124, 20);
		frame.getContentPane().add(textField_1);
		
		txtrPlaceOfWork = new JLabel("Place of Work");
		txtrPlaceOfWork.setForeground(Color.WHITE);
		txtrPlaceOfWork.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrPlaceOfWork.setBounds(237, 198, 96, 15);
		frame.getContentPane().add(txtrPlaceOfWork);
		
		txtrEmail = new JLabel("Email");
		txtrEmail.setForeground(Color.WHITE);
		txtrEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrEmail.setBounds(237, 243, 96, 15);
		frame.getContentPane().add(txtrEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(237, 260, 124, 20);
		frame.getContentPane().add(textField_2);
		
		textFirstName = new JTextField();
		textFirstName.setColumns(10);
		textFirstName.setBounds(237, 79, 124, 20);
		frame.getContentPane().add(textFirstName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(237, 66, 72, 15);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(237, 110, 72, 15);
		frame.getContentPane().add(lblLastName);
		
		
		
		frame.setUndecorated(true);
	}
}
