

import java.sql.*;

class MysqlCon{
	public static void main(String args[]) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
			
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			Statement stmt3 = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from Employee_Data");
			ResultSet rb = stmt2.executeQuery("select * from Employee_Shifts");


			 // INSERT a record
	         //String sqlInsert = "insert into books " // need a space
	         //      + "values (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
	         //System.out.println("The SQL query is: " + sqlInsert);  // Echo for debugging
	         //int countInserted = stmt.executeUpdate(sqlInsert);
	         //System.out.println(countInserted + " records inserted.\n");
			
			while(rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

			while(rb.next())
				System.out.println(rb.getInt(1) + "  " + rb.getString(2) + "  " + rb.getString(3) + "  " + rb.getString(4));

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}