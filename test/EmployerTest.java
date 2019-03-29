import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		Employee e = new Employee(1,"Ricky", "Driver", time, 0);
		e.setSeniority(50);
		assertEquals(50,e.getSeniority(), "Seniority was not set correctly");
	}
	
	@Test
	void testRemoveOneEmployee( ) {
		boolean flag = false;
		TimeEntry[ ] times = null;
		Employee e = new Employee(2,"Jon", "IT", times, 0 );
		testing.addEmployee( e );
		for ( int i = 0; i < 10; i++ ) {
			testing.addEmployee( new Employee( ) );
		}
		flag = testing.removeEmployee( e );
		assertTrue( flag );
	}
	/* Make Sure Employee List is in order of seniority */
	/*Commit Damnit */
	@Test
	void testSenioritySort() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Employee[] sorted = new Employee[5];
		empList.add(new Employee());
		empList.get(0).setSeniority(3);
		sorted[2] = empList.get(0);
		empList.add(new Employee());
		empList.get(1).setSeniority(1);
		empList.add(new Employee());
		sorted[0] = empList.get(1);
		empList.get(2).setSeniority(2);
		empList.add(new Employee());
		sorted[1] = empList.get(2);
		empList.get(3).setSeniority(5);
		empList.add(new Employee());
		sorted[4] = empList.get(3); 
		empList.get(4).setSeniority(4);
		sorted[3] = empList.get(4);
		for (int x = 0; x < 5; x++) {
			testing.addEmployee(empList.get(x));
		}
		List<Employee> temp = Arrays.asList(sorted);
		assertEquals(temp, testing.getEmployees());
	}
	@Test
	void testEmailWithAttachment() throws InterruptedException {
		String[] email = new String[] {"mtsayles@mtu.edu"};
		String subject = "test";
		String body = "This is for testing purpose";
		String attachment = "test.jpg";
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
