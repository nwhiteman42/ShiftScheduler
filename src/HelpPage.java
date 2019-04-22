import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpPage window = new HelpPage();
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
					Point newLocation = new Point(middle.x - (window.frame.getWidth() + 300), 
					                              middle.y - (window.frame.getHeight() / 2));
					window.frame.setLocation(newLocation);
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
	public HelpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 629, 577);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMakeSchecule = new JLabel("Make Schecule - Creates a schedule in a spreadsheet for all the employees,");
		lblMakeSchecule.setBounds(10, 11, 573, 25);
		frame.getContentPane().add(lblMakeSchecule);
		
		JLabel lblEmailSchedule = new JLabel("Email Schedule - Emails the created schedule to all your employees");
		lblEmailSchedule.setBounds(10, 60, 526, 14);
		frame.getContentPane().add(lblEmailSchedule);
		
		JLabel lblCreateEmployee = new JLabel("Create Employee - adds an employee under your account");
		lblCreateEmployee.setBounds(10, 110, 447, 14);
		frame.getContentPane().add(lblCreateEmployee);
		
		JLabel lblEditEmployee = new JLabel("Edit Employee - allows you to change an existing employee's information");
		lblEditEmployee.setBounds(10, 181, 593, 14);
		frame.getContentPane().add(lblEditEmployee);
		
		JLabel lblRemoveEmployee = new JLabel("Remove Employee - This removes an employee from your account");
		lblRemoveEmployee.setBounds(10, 221, 593, 14);
		frame.getContentPane().add(lblRemoveEmployee);
		
		JLabel lblEditShift = new JLabel("Edit Shift - adds/edits changes to an employee's worktimes");
		lblEditShift.setBounds(10, 247, 573, 14);
		frame.getContentPane().add(lblEditShift);
		
		JLabel lblRemoveShift = new JLabel("Remove Shift - Takes an employee's shifts off your schedule");
		lblRemoveShift.setBounds(10, 325, 593, 14);
		frame.getContentPane().add(lblRemoveShift);
		
		JLabel lblUsingExistingEmployees = new JLabel("using existing employee's and shifts.");
		lblUsingExistingEmployees.setBounds(42, 35, 472, 14);
		frame.getContentPane().add(lblUsingExistingEmployees);
		
		JLabel lblUsingExisingEmployees = new JLabel("Using exising employee's emails, this mass emails your created schedule.");
		lblUsingExisingEmployees.setBounds(42, 85, 561, 14);
		frame.getContentPane().add(lblUsingExisingEmployees);
		
		JLabel lblThisIsHow = new JLabel("This is how you make a new Employee. ");
		lblThisIsHow.setBounds(42, 135, 458, 14);
		frame.getContentPane().add(lblThisIsHow);
		
		JLabel lblYouInputTheir = new JLabel("You input their name, email, job title");
		lblYouInputTheir.setBounds(42, 160, 401, 14);
		frame.getContentPane().add(lblYouInputTheir);
		
		JLabel lblSimilarToCreate = new JLabel("Used to update the information on an already existing employee.");
		lblSimilarToCreate.setBounds(42, 203, 561, 14);
		frame.getContentPane().add(lblSimilarToCreate);
		
		JLabel lblAddsupdatesAShift = new JLabel("Add shifts by checking the day and placing the start and end times. ");
		lblAddsupdatesAShift.setBounds(42, 273, 561, 14);
		frame.getContentPane().add(lblAddsupdatesAShift);
		
		JLabel lblIfADay = new JLabel("If a day is not checked, it will not be added.");
		lblIfADay.setBounds(42, 299, 561, 14);
		frame.getContentPane().add(lblIfADay);
		
		JLabel lblRemovesShiftsFrom = new JLabel("Removes shifts from the schedule similar to how Edit Shifts adds them. ");
		lblRemovesShiftsFrom.setBounds(42, 351, 561, 14);
		frame.getContentPane().add(lblRemovesShiftsFrom);
		
		JLabel lblIfADay_1 = new JLabel("If a day is not checked, it is not removed. ");
		lblIfADay_1.setBounds(42, 377, 561, 14);
		frame.getContentPane().add(lblIfADay_1);
		
	}

	
}
