import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditEmployee {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		frame.setBounds(100, 100, 661, 334);
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
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(515, 67, 124, 19);
		frame.getContentPane().add(textField_3);
		
		JTextArea txtrSeniority = new JTextArea();
		txtrSeniority.setText("Seniority");
		txtrSeniority.setBounds(551, 46, 72, 15);
		frame.getContentPane().add(txtrSeniority);
		
		JTextArea txtrNew = new JTextArea();
		txtrNew.setText("New");
		txtrNew.setBounds(12, 126, 31, 15);
		frame.getContentPane().add(txtrNew);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Name");
		textArea.setBounds(57, 155, 72, 15);
		frame.getContentPane().add(textArea);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(25, 170, 124, 19);
		frame.getContentPane().add(textField_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Title");
		textArea_1.setBounds(224, 155, 72, 15);
		frame.getContentPane().add(textArea_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(189, 170, 124, 19);
		frame.getContentPane().add(textField_5);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("Job ");
		textArea_2.setBounds(384, 155, 72, 15);
		frame.getContentPane().add(textArea_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(356, 170, 124, 19);
		frame.getContentPane().add(textField_6);
		
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setText("Seniority");
		textArea_3.setBounds(551, 155, 72, 15);
		frame.getContentPane().add(textArea_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(515, 170, 124, 19);
		frame.getContentPane().add(textField_7);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(89, 243, 114, 25);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(419, 243, 114, 25);
		frame.getContentPane().add(btnCancel);
	}
}
