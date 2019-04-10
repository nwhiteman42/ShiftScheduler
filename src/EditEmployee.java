import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditEmployee {

	private JFrame frame;
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
		frame.setBounds(100, 100, 514, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrOld = new JTextArea();
		txtrOld.setText("Old");
		txtrOld.setBounds(12, 12, 31, 15);
		frame.getContentPane().add(txtrOld);
		
		JTextArea txtrFirstName = new JTextArea();
		txtrFirstName.setText("Name");
		txtrFirstName.setBounds(57, 46, 72, 15);
		frame.getContentPane().add(txtrFirstName);
		
		textField = new JTextField();
		textField.setBounds(25, 67, 124, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea txtrTitle = new JTextArea();
		txtrTitle.setText("Title");
		txtrTitle.setBounds(224, 46, 72, 15);
		frame.getContentPane().add(txtrTitle);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(189, 67, 124, 19);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(356, 67, 124, 19);
		frame.getContentPane().add(textField_2);
		
		JTextArea txtrJob = new JTextArea();
		txtrJob.setText("Job ");
		txtrJob.setBounds(384, 46, 72, 15);
		frame.getContentPane().add(txtrJob);
	}
}
