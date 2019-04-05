import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlConTests {
	MysqlCon x = new MysqlCon();
	@Test
	public void insertIntoEmployeeTest() throws SQLException {
		x.insertIntoEmployee(500, "Test", "Tester", 4);
	}
	@Test
	public void removeEmployeeTest() throws SQLException {
		x.removeEmployee(500);
	}
	@Test
	public void retriveDataTest() {
		x.retriveData();
	}

}
