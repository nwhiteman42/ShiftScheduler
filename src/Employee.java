import java.util.ArrayList;

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
	
}
