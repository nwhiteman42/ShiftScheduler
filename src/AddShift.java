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
import java.awt.event.ActionEvent;

public class AddShift {

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddShift window = new AddShift();
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
	public AddShift() {
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
		
		lblCreateAccount = new JLabel("Remove Shift");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCreateAccount.setBounds(164, 25, 156, 26);
		frame.getContentPane().add(lblCreateAccount);
		
		
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				TimeEntry[] times = new TimeEntry[7];
				//TODO: Make the database give us the old timeEntry here: 
				TimeEntry[] oldStuff = null;
				if( chckbxSunday.isSelected()) {
					String start = txtSunStart.getText();
					String end = txtSunEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 0;
					times[index].setDay("Sunday");
					addTimeEntry(start, end, times, index);
				} if( chckbxMonday.isSelected() ) {
					String start = txtMonStart.getText();
					String end = txtMonEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 1; 
					times[index].setDay("Monday");
					addTimeEntry(start, end, times, index);
				} if( chckbxTuesday.isSelected() ) {
					String start = txtTuesStart.getText();
					String end = txtTuesEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 2; 
					times[index].setDay("Tuesday");
					addTimeEntry(start, end, times, index);
				} if( chckbxWednesday.isSelected() ) {
					String start = txtWedStart.getText();
					String end = txtWedEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 3; 
					times[index].setDay("Wednesday");
					addTimeEntry(start, end, times, index);
				} if( chckbxThursday.isSelected() ) {
					String start = txtThursStart.getText();
					String end = txtThursEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 4; 
					times[index].setDay("Thursday");
					addTimeEntry(start, end, times, index);
				} if( chckbxFriday.isSelected() ) {
					String start = txtFriStart.getText();
					String end = txtFriEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 5;
					times[index].setDay("Friday"); 
					addTimeEntry(start, end, times, index);
				} if( chckbxSaturday.isSelected() ) {
					String start = txtSatStart.getText();
					String end = txtSatEnd.getText();
					start = start.replaceAll(":", "");
					end = end.replaceAll(":", "");
					int index = 6; 
					times[index].setDay("Saturday");
					addTimeEntry(start, end, times, index);
				}
				
				times = timeEntryMerge(oldStuff, times);
				//TODO: Add pushing this to the database
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
