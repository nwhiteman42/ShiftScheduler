import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployerTest {

	Employer testing;
	@BeforeEach
	void setUp() {
		testing = new Employer( );
	}
	
	@Test
	void testAddOneEmployee() {
		boolean flag = testing.addEmployee( new Employee( ) );
		assertTrue( flag );
	}
	
	@Test
	void testAddManyEmployees( ) {
		boolean flag = false;
		for( int i = 0; i < 2000; i++ ) {
			flag = testing.addEmployee( new Employee( ) );
		}
		assertTrue( flag );
	}
	
	@Test
	void testSetSeniority() {
		TimeEntry fillerday = new TimeEntry("Monday", 800, 1200);
		TimeEntry[] time = new TimeEntry[] {fillerday};
		Employee e = new Employee("Ricky", "Driver", time, 0);
		e.setSeniority(50);
		assertEquals(50,e.getSeniority(), "Seniority was not set correctly");
	}
	
	@Test
	void testRemoveOneEmployee( ) {
		boolean flag = false;
		TimeEntry[ ] times = null;
		Employee e = new Employee( "Jon", "IT", times, 0 );
		testing.addEmployee( e );
		for ( int i = 0; i < 10; i++ ) {
			testing.addEmployee( new Employee( ) );
		}
		flag = testing.removeEmployee( e );
		assertTrue( flag );
	}
	
	@Test
	void testEmailWithAttachment() throws InterruptedException {
		String[] email = new String[] {"mtsayles@mtu.edu"};
		String subject = "test";
		String body = "This is for testing purpose";
		String attachment = "C:/Users/wilma/git/ShiftScheduler/test/test.jpg";
		assertEquals(1, testing.massEmail(email, attachment, subject, body));
	}
	
	@Test
	void testEmailWithoutAttachment() throws InterruptedException{
		String[] email = new String[] {"mtsayles@mtu.edu"};
		String subject = "test";
		String body = "This is for testing purpose";
		assertEquals(1, testing.massEmail(email, null, subject, body));
	}

}
