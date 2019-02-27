import java.util.Arrays;

public class Employee {

	String name;
	String job;
	TimeEntry availability[];

	public Employee() {
		name = "Employee";
		job = "Job";
		availability = new TimeEntry[7];
	}

	public Employee(String name, String job, TimeEntry availability[]) {
		this.name = name;
		this.job = job;
		this.availability = availability;
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
	
	/* Sorts days in TimeEntry array to be in order from Sunday to Monday
	 * 
	 */
	public TimeEntry[] sortAvailability(int TimeEntryLength) {
		TimeEntry[] array = new TimeEntry[7];
		for (int x = 0; x < TimeEntryLength; x++) {
			if (availability[x].getDay() == "Sunday")
				array[0] = availability[x];
			else if (availability[x].getDay() == "Monday")
				array[1] = availability[x];
			else if (availability[x].getDay() == "Tuesday")
				array[2] = availability[x];
			else if (availability[x].getDay() == "Wednesday")
				array[3] = availability[x];
			else if (availability[x].getDay() == "Thursday")
				array[4] = availability[x];
			else if (availability[x].getDay() == "Friday")
				array[5] = availability[x];
			else if (availability[x].getDay() == "Saturday")
				array[6] = availability[x];
			else {
				System.out.println("Invalid Day ERROR ALERT");
				return new TimeEntry[7];
			}
		}
		availability = array;
		return array;
		
	}
}
