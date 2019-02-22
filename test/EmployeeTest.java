import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {
	
	//setup
	TimeEntry sunday = new TimeEntry("Sunday", 800, 1400);
	TimeEntry monday = new TimeEntry("Monday", 800, 1400);
	TimeEntry tuesday = new TimeEntry("Tuesday", 800, 1400);
	TimeEntry wensday = new TimeEntry("Wensday", 800, 1400);
	TimeEntry thursday = new TimeEntry("Thursday", 800, 1400);
	
	TimeEntry[] aval = new TimeEntry[] {sunday, monday, tuesday};
	
	
	Employee x = new Employee("bob","cook",aval);
	
	@Test
	void testEmployee() {
		Employee test = new Employee("Rick", "Baker", aval);
		assertEquals("Rick", test.getName(),"Failed as name's don't match");
		assertEquals("Baker", test.getJob(), "Failed as job's don't match");
		assertEquals(aval, test.getAvailability(), "Failed as  avalibility doesn't match");
	}


	@Test
	void testGetName() {
		assertEquals("bob", x.getName(), "Name does not Empmatch");
	}

	@Test
	void testGetJob() {
		assertEquals("cook", x.getJob(), "Job's do not match");
	}

	@Test
	void testGetAvailability() {
		assertEquals(aval,x.getAvailability(),"Availability does not match");
	}

}