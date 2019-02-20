import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeEntryTest {
	TimeEntry test = new TimeEntry();

	@Test
	void testTimeEntry() {
		
		assertEquals("Default Constructor : Day = ", "Sunday", test.getDay());
		assertEquals("Default Constructor : Start Time = ", 0, test.getStartTime());
		assertEquals("Default Constructor : End Time = ", 2359, test.getEndTime());
		
	}

	@Test
	void testGetDay() {
		test = new TimeEntry("Monday", 50, 300);
		assertEquals("Default Constructor : Day = ", "Monday", test.getDay());
		
	}
	
	@Test
	void testGetDay2() {
		test = new TimeEntry("Tuesday", 50, 300);
		assertEquals("Default Constructor : Day = ", "Tuesday", test.getDay());
	}

	@Test
	void testGetStartTime() {
		test = new TimeEntry("Wednesday", 50, 300);
		assertEquals("Default Constructor : Start Time = ", 50, test.getStartTime());
	}
	
	@Test
	void testGetStartTime2() {
		test = new TimeEntry("Thursday", 1456, 300);
		assertEquals("Default Constructor : Start Time = ", 1456, test.getStartTime());
	}
	
	@Test
	void testGetStartTime3() {
		test = new TimeEntry("Friday", 2359, 300);
		assertEquals("Default Constructor : Start Time = ", 2359, test.getStartTime());
	}

	@Test
	void testGetEndTime() {
		test = new TimeEntry("Friday", 0, 300);
		assertEquals("Default Constructor : Start Time = ", 300, test.getEndTime());
	}
	
	@Test
	void testGetEndTime2() {
		test = new TimeEntry("Friday", 0, 2359);
		assertEquals("Default Constructor : Start Time = ", 2359, test.getEndTime());
	}
	
	@Test
	void testGetEndTime3() {
		test = new TimeEntry("Friday", 0, 333);
		assertEquals("Default Constructor : Start Time = ", 333, test.getEndTime());
	}
	
	

}
