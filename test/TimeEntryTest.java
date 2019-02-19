import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeEntryTest {

	@Test
	void testTimeEntry() {
		TimeEntry test = new TimeEntry();
		assertEquals("Default Constructor : Day = ", "Sunday", test.getDay());
		assertEquals("Default Constructor : Start Time = ", 0, test.getStartTime());
		assertEquals("Default Constructor : End Time = ", "2359", test.getEndTime());
		
	}

	@Test
	void testTimeEntryStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDay() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStartTime() {
		fail("Not yet implemented");
	}

	@Test
	void testGetEndTime() {
		fail("Not yet implemented");
	}

}
