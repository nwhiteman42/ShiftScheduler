import com.opencsv.CSVWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Desktop;
import java.io.*; 
import java.util.*;

import org.junit.Test; 

public class ShiftSchedulerTests {
		
	@Test
	public void makeSchedule() throws Exception {
		ShiftScheduler s = new ShiftScheduler();
		MysqlCon x = new MysqlCon();
		ArrayList<Employee> e = x.getEmployees("TestCase"); //Pulls employee data from database
		assertEquals(true,s.makeSchedule(e, "testShift1.csv"), "Failed to write shift to a file"); 
	} 
}
