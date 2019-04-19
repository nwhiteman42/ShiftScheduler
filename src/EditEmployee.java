import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
		x.setWorkplace(workplace);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployee window = new EditEmployee();
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
		frame.setBounds(100, 100, 450, 292);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrOld = new JTextArea();
		txtrOld.setText("Old");
		txtrOld.setBounds(12, 12, 31, 15);
		frame.getContentPane().add(txtrOld);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setText("Email");
		txtrFirstName.setBounds(45, 25, 72, 15);
		frame.getContentPane().add(txtrFirstName);
		
		textField = new JTextField();
		textField.setBounds(25, 51, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrNew = new JTextArea();
		txtrNew.setText("New");
		txtrNew.setBounds(282, 12, 31, 15);
		frame.getContentPane().add(txtrNew);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Name");
		textArea.setBounds(310, 25, 72, 15);
		frame.getContentPane().add(textArea);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(296, 51, 124, 19);
		frame.getContentPane().add(textField_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Title");
		textArea_1.setBounds(310, 71, 72, 15);
		frame.getContentPane().add(textArea_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(296, 91, 124, 19);
		frame.getContentPane().add(textField_5);
		
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("Seniority");
		textArea_3.setBounds(310, 122, 72, 15);
		frame.getContentPane().add(textArea_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(296, 138, 124, 19);
		frame.getContentPane().add(textField_7);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				MysqlCon x = new MysqlCon();
				try {
					int id = x.getACurrentEmployeeID(textField.getText());
					Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
					String query = "update Employee_Data set Employee_Name = '"+ textField_4.getText() + "', Employee_Title = '" + textField_5.getText() + "', seniority = '"+ textField_7.getText() + "', placeofwork = '" + textField_1.getText() + "', email = '" + textField_2.getText() + "' where Employee_ID = '" + id + "'";
					PreparedStatement ps = con.prepareStatement(query);
					ps.executeUpdate();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		btnConfirm.setBounds(35, 104, 114, 25);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setBounds(35, 164, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(296, 190, 124, 19);
		frame.getContentPane().add(textField_1);
		
		JTextArea txtrPlaceOfWork = new JTextArea();
		txtrPlaceOfWork.setText("Place of Work");
		txtrPlaceOfWork.setBounds(310, 169, 96, 15);
		frame.getContentPane().add(txtrPlaceOfWork);
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("Email");
		txtrEmail.setBounds(310, 214, 96, 15);
		frame.getContentPane().add(txtrEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(296, 231, 124, 19);
		frame.getContentPane().add(textField_2);
	}
}
