import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
	private JLabel txtrFirstName;
	private JLabel txtrOld;
	private JLabel txtrNew;
	private JLabel textArea;
	private JLabel textArea_1;
	private JLabel textArea_3;
	private JLabel txtrPlaceOfWork;
	private JLabel txtrEmail;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 450, 292);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtrOld = new JLabel("Old");
		txtrOld.setForeground(Color.WHITE);
		txtrOld.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrOld.setBounds(12, 12, 31, 15);
		frame.getContentPane().add(txtrOld);
		
		txtrFirstName = new JLabel("Email");
		txtrFirstName.setForeground(Color.WHITE);
		txtrFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrFirstName.setBounds(45, 25, 72, 15);
		frame.getContentPane().add(txtrFirstName);
		
		textField = new JTextField();
		textField.setBounds(25, 51, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtrNew = new JLabel("New");
		txtrNew.setForeground(Color.WHITE);
		txtrNew.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrNew.setBounds(282, 12, 31, 15);
		frame.getContentPane().add(txtrNew);
		
		textArea = new JLabel("Name");
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea.setBounds(310, 25, 72, 15);
		frame.getContentPane().add(textArea);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(296, 51, 124, 19);
		frame.getContentPane().add(textField_4);
		
		textArea_1 = new JLabel("Title");
		textArea_1.setForeground(Color.WHITE);
		textArea_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_1.setBounds(310, 71, 72, 15);
		frame.getContentPane().add(textArea_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(296, 91, 124, 19);
		frame.getContentPane().add(textField_5);
		
		
		textArea_3 = new JLabel("Seniority");
		textArea_3.setForeground(Color.WHITE);
		textArea_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		textArea_3.setBounds(310, 122, 72, 15);
		frame.getContentPane().add(textArea_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(296, 138, 124, 19);
		frame.getContentPane().add(textField_7);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(Color.GRAY);
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBorder(new LineBorder(Color.WHITE));
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				MysqlCon x = new MysqlCon();
				try {
					//Updates the employee information
					int id = x.getACurrentEmployeeID(textField.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String query = "update Employee_Data set Employee_Name = '"+ textField_4.getText() + "', Employee_Title = '" + textField_5.getText() + "', seniority = '"+ textField_7.getText() + "', placeofwork = '" + textField_1.getText() + "', email = '" + textField_2.getText() + "' where Employee_ID = '" + id + "'";
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
		btnConfirm.setBounds(35, 104, 114, 25);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
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
		btnCancel.setBounds(35, 164, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 190, 124, 19);
		frame.getContentPane().add(textField_1);
		
		txtrPlaceOfWork = new JLabel("Place of Work");
		txtrPlaceOfWork.setForeground(Color.WHITE);
		txtrPlaceOfWork.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrPlaceOfWork.setBounds(310, 169, 96, 15);
		frame.getContentPane().add(txtrPlaceOfWork);
		
		txtrEmail = new JLabel("Email");
		txtrEmail.setForeground(Color.WHITE);
		txtrEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtrEmail.setBounds(310, 214, 96, 15);
		frame.getContentPane().add(txtrEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(296, 231, 124, 19);
		frame.getContentPane().add(textField_2);
		
		frame.setUndecorated(true);
	}
}
