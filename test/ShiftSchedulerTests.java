import com.opencsv.CSVWriter;

import java.awt.Desktop;
import java.io.*; 
import java.util.*;

import org.junit.Test; 

public class ShiftSchedulerTests {
	TimeEntry sunday = new TimeEntry("Sunday", 800, 1400);
	TimeEntry monday = new TimeEntry("Monday", 800, 1400);
	TimeEntry tuesday = new TimeEntry("Tuesday", 800, 1400);
	TimeEntry wednesday = new TimeEntry("Wednesday", 800, 1400);
	TimeEntry thursday = new TimeEntry("Thursday", 800, 1400);
	TimeEntry friday = new TimeEntry("Friday", 800, 1400);
	TimeEntry saturday = new TimeEntry("Saturday", 800, 1400);
	
	TimeEntry sunday2 = new TimeEntry("Sunday", 100, 2200);
	TimeEntry monday2 = new TimeEntry("Monday", 700, 900);
	TimeEntry tuesday2 = new TimeEntry("Tuesday", 1400, 1800);
	TimeEntry wednesday2 = new TimeEntry("Wednesday", 900, 900);
	TimeEntry thursday2 = new TimeEntry("Thursday", 800, 1400);
	TimeEntry friday2 = new TimeEntry("Friday", 000, 1560);
	TimeEntry saturday2 = new TimeEntry("Saturday", 0, 50);
	
	
	TimeEntry[] aval = new TimeEntry[] {sunday, monday, tuesday};
	TimeEntry[] aval2 = new TimeEntry[] {sunday2, tuesday2, wednesday2, thursday2, friday2, saturday2};
	
	Employee x = new Employee(1,"John", "Fluffer", aval, 4);
	Employee x2 = new Employee(2,"Mia Khalfia", "Entertainer", aval2, 1);
	
	@Test
	public void addDataArray() throws Exception {
		ShiftScheduler s = new ShiftScheduler();
		ArrayList<Employee> e = new ArrayList<>();
		e.add(x);
		e.add(x2);
		s.addDataArray(e, "testShift1.csv");
	}
}
