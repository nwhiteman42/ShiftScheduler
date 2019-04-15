import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class RemoveEmployee {

	private JFrame frame;
	private final JLabel lblRemoveEmployee = new JLabel("Remove Employee");
	private JTextField textField;
	private JTextField txtName;
	private JTextField textField_2;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee window = new RemoveEmployee();
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
		frame.setBounds(100, 100, 450, 405);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblRemoveEmployee.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRemoveEmployee.setBounds(113, 11, 222, 31);
		frame.getContentPane().add(lblRemoveEmployee);
		
		textField = new JTextField();
		textField.setBounds(125, 268, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(125, 243, 64, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(125, 125, 81, 20);
		frame.getContentPane().add(lblFirstName);
		
		txtName = new JTextField();
		txtName.setBounds(125, 156, 173, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(125, 187, 81, 14);
		frame.getContentPane().add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 212, 173, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFailedToRemove = new JLabel("Failed to remove Emloyee");
		lblFailedToRemove.setForeground(SystemColor.menu);
		lblFailedToRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFailedToRemove.setBounds(127, 344, 186, 14);
		frame.getContentPane().add(lblFailedToRemove);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MysqlCon sql = new MysqlCon();
				String idString = txtID.getText();
				try {
					sql.removeEmployee(lblEmail.getText());
				} catch (SQLException e) {
					lblFailedToRemove.setForeground(Color.RED);
				}
			}
		});
		btnRemove.setBounds(117, 310, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.hide();
			}
		});
		btnCancel.setBounds(222, 310, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		
	}
}