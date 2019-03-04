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
	
}
