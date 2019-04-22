import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	public void insertEmployeeAndRemoveEmployeeTest() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		x.insertIntoEmployee(500, "test", "test", 1, "test", "test");
		String q = "Select Employee_ID from Employee_Data where Employee_Name = 'test' and placeofwork = 'test'";
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet r = ps.executeQuery(q);
		int id = -1;
		while(r.next()) {
			id = r.getInt(1);
		}
		assertEquals(500, id, "Insert failed");
		x.removeEmployee("test");
		int exists = 1;
		String q2 = "Select count(Employee_ID) from Employee_Data where Employee_ID = 500";
		PreparedStatement ps2 = con.prepareStatement(q2);
		ResultSet r2 = ps.executeQuery(q2);
		while(r2.next()){
			exists = r2.getInt(1);
		}
		assertEquals(0, exists, "Failed to remove employee");
		con.close(); 
	}

}
