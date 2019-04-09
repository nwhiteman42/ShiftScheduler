import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RemoveEmployee {

	private JFrame frame;
	private final JLabel lblRemoveEmployee = new JLabel("Remove Employee");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame.setBounds(100, 100, 450, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblRemoveEmployee.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRemoveEmployee.setBounds(113, 11, 222, 31);
		frame.getContentPane().add(lblRemoveEmployee);
		
		textField = new JTextField();
		textField.setBounds(125, 204, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(125, 190, 64, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFirstName.setBounds(125, 65, 81, 20);
		frame.getContentPane().add(lblFirstName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 86, 173, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastName.setBounds(125, 127, 81, 14);
		frame.getContentPane().add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 148, 173, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setBounds(80, 295, 89, 23);
		frame.getContentPane().add(btnRemove);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(246, 295, 89, 23);
		frame.getContentPane().add(btnCancel);
	}
}