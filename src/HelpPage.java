import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

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
	public HelpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 577);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMakeSchecule = new JLabel("Make Schecule - Creates a schedule in a spreadsheet for all the employees you have added.");
		lblMakeSchecule.setBounds(10, 11, 526, 25);
		frame.getContentPane().add(lblMakeSchecule);
		
		JLabel lblEmailSchedule = new JLabel("Email Schedule - Emails the created schedule to all your employees");
		lblEmailSchedule.setBounds(10, 60, 526, 14);
		frame.getContentPane().add(lblEmailSchedule);
		
		JLabel lblCreateEmployee = new JLabel("Create Employee - adds an employee under your account");
		lblCreateEmployee.setBounds(10, 110, 447, 14);
		frame.getContentPane().add(lblCreateEmployee);
		
		JLabel lblEditEmployee = new JLabel("Edit Employee - allows you to change an existing employee's information");
		lblEditEmployee.setBounds(10, 260, 593, 14);
		frame.getContentPane().add(lblEditEmployee);
		
		JLabel lblRemoveEmployee = new JLabel("Remove Employee - when an employee leaves or is fired, this removes them from your account");
		lblRemoveEmployee.setBounds(10, 307, 593, 14);
		frame.getContentPane().add(lblRemoveEmployee);
		
		JLabel lblEditShift = new JLabel("Edit Shift - adds/edits changes to an employee's worktimes");
		lblEditShift.setBounds(10, 357, 573, 14);
		frame.getContentPane().add(lblEditShift);
		
		JLabel lblRemoveShift = new JLabel("Remove Shift - Takes an employee's shifts off your schedule");
		lblRemoveShift.setBounds(10, 431, 593, 14);
		frame.getContentPane().add(lblRemoveShift);
		
		JLabel lblUsingExistingEmployees = new JLabel("Using existing employee's and shifts, this generates a schedule for you. ");
		lblUsingExistingEmployees.setBounds(42, 35, 472, 14);
		frame.getContentPane().add(lblUsingExistingEmployees);
		
		JLabel lblUsingExisingEmployees = new JLabel("Using exising employee's emails, this mass emails your created schedule to all employees.");
		lblUsingExisingEmployees.setBounds(42, 85, 561, 14);
		frame.getContentPane().add(lblUsingExisingEmployees);
		
		JLabel lblThisIsHow = new JLabel("This is how you make a new Employee. ");
		lblThisIsHow.setBounds(42, 135, 458, 14);
		frame.getContentPane().add(lblThisIsHow);
		
		JLabel lblYouInputTheir = new JLabel("You input their name, email, job title, place of work, and senority.");
		lblYouInputTheir.setBounds(42, 160, 401, 14);
		frame.getContentPane().add(lblYouInputTheir);
		
		JLabel lblTheSeniorityIs = new JLabel("The seniority is a number that determines order of precidence to get a shift.");
		lblTheSeniorityIs.setBounds(42, 185, 494, 14);
		frame.getContentPane().add(lblTheSeniorityIs);
		
		JLabel lblIsThe = new JLabel("1 is the highest priority senority. ");
		lblIsThe.setBounds(42, 210, 472, 14);
		frame.getContentPane().add(lblIsThe);
		
		JLabel lblPlaceOfWork = new JLabel("Place of work is needed to sort who is on what schedule.");
		lblPlaceOfWork.setBounds(42, 235, 472, 14);
		frame.getContentPane().add(lblPlaceOfWork);
		
		JLabel lblSimilarToCreate = new JLabel("Similar to create employee, but will update the information on an already existing employee.");
		lblSimilarToCreate.setBounds(42, 282, 561, 14);
		frame.getContentPane().add(lblSimilarToCreate);
		
		JLabel lblRemovesAnEmployee = new JLabel("Removes an employee based on email. Does not remove the shifts.");
		lblRemovesAnEmployee.setBounds(42, 332, 561, 14);
		frame.getContentPane().add(lblRemovesAnEmployee);
		
		JLabel lblAddsupdatesAShift = new JLabel("Here you can add shifts by checking the day and placing the start and end times. ");
		lblAddsupdatesAShift.setBounds(42, 382, 561, 14);
		frame.getContentPane().add(lblAddsupdatesAShift);
		
		JLabel lblIfADay = new JLabel("If a day is not checked, it will not be added.");
		lblIfADay.setBounds(42, 407, 561, 14);
		frame.getContentPane().add(lblIfADay);
		
		JLabel lblRemovesShiftsFrom = new JLabel("Removes shifts from the schedule similar to how Edit Shifts adds them. ");
		lblRemovesShiftsFrom.setBounds(42, 456, 561, 14);
		frame.getContentPane().add(lblRemovesShiftsFrom);
		
		JLabel lblIfADay_1 = new JLabel("If a day is not checked, it is not removed. ");
		lblIfADay_1.setBounds(42, 481, 561, 14);
		frame.getContentPane().add(lblIfADay_1);
		
		JLabel lblWhenAnEmployee = new JLabel("When an employee is removed from your account, the shifts are still there.");
		lblWhenAnEmployee.setBounds(42, 506, 561, 14);
		frame.getContentPane().add(lblWhenAnEmployee);
		
	}

	
}
