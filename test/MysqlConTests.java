import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MysqlConTests {
	MysqlCon x = new MysqlCon();
	
	@Test
	public void insertEmployeeTest() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		x.insertIntoEmployee(500, "Test", "Tester", 1);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from Employee_Data where Employee_ID =  500");
		int x = 0;
		while(rs.next()) {
			x = rs.getInt(1);
		}
		assertEquals(1, x, "Failed");
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
