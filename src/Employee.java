import java.util.Arrays;

public class Employee {
	int id;
	String name;
	String job;
	TimeEntry availability[];
	int seniority;

	/*
	 * Class to hold Employees, acts as User. 
	 */
	public Employee() {
		id = 0;
		name = "Employee";
		job = "Job";
		availability = new TimeEntry[7];
		seniority = 0;
	}

	public Employee(int id, String name, String job, TimeEntry availability[], int seniority) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.availability = availability;
		this.seniority = seniority;
	}

	/*
	 * Various getters and setters
	 */
	public String getName() {
		return name;
	}

	@SuppressWarnings("unused")
	public String setName(String name) {
		String oldName = this.name;
		this.name = name;
		return oldName;
	}

	public String getJob() {
		return job;
	}

	@SuppressWarnings("unused")
	public String setJob(String job) {
		String oldJob = this.job;
		this.job = job;
		return oldJob;
	}

	public TimeEntry[] getAvailability() {
		return availability;
	}

	@SuppressWarnings("unused")
	public TimeEntry[] setAvailability(TimeEntry[] availability) {
		TimeEntry[] oldAvailability = availability;
		this.availability = availability;
		return oldAvailability;
	}
	
	public int getSeniority() {
		return seniority;
	}
	public int setSeniority(int seniority) {
		int oldSeniority = this.seniority;
		this.seniority = seniority;
		return oldSeniority;
	}
	
	/*
	 *  Sorts days in TimeEntry array to be in order from Sunday to Saturday
	 *  
	 *  @param TimeEntryLength - the length of the TimeEntry array we are using
	 *  
	 *  @return the sorted array into a week's span
	 */
	public TimeEntry[] sortAvailability(int TimeEntryLength) {
		TimeEntry[] array = new TimeEntry[7];
		for (int x = 0; x < TimeEntryLength; x++) {
			if (availability[x].getDay().equalsIgnoreCase("Sunday"))
				array[0] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Monday"))
				array[1] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Tuesday"))
				array[2] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Wednesday"))
				array[3] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Thursday"))
				array[4] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Friday"))
				array[5] = availability[x];
			else if (availability[x].getDay().equalsIgnoreCase("Saturday"))
				array[6] = availability[x];
			else if (availability[x] == null) {
				
			}
			else {
				System.out.println("Invalid Day ERROR ALERT");
				return new TimeEntry[7];
			}
		}
		availability = array;
		return availability;
		
	}
}
