
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
	private String setName(String name) {
		String oldName = this.name;
		this.name = name;
		return oldName;
	}

	public String getJob() {
		return job;
	}

	@SuppressWarnings("unused")
	private String setJob(String job) {
		String oldJob = this.job;
		this.job = job;
		return oldJob;
	}
	
	public TimeEntry[] getAvailability() {
		return availability;
	}
	
	@SuppressWarnings("unused")
	private TimeEntry[] setAvailability(TimeEntry[] availability) {
		TimeEntry[] oldAvailability = availability;
		this.availability = availability;
		return oldAvailability ;
	}
}
