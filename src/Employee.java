import java.util.Arrays;

public class Employee {

	String name;
	String job;
	TimeEntry availability[];
	int seniority;

	public Employee() {
		name = "Employee";
		job = "Job";
		availability = new TimeEntry[7];
		seniority = 0;
	}

	public Employee(String name, String job, TimeEntry availability[], int seniority) {
		this.name = name;
		this.job = job;
		this.availability = availability;
		this.seniority = seniority;
	}

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
	
	/* Sorts days in TimeEntry array to be in order from Sunday to Saturday
	 * 
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
