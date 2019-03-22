

import java.sql.*;

class MysqlCon {
	
	/*
	 * Removes data from the "Employee_Data" list
	 */
	public void removeEmployee(int id) throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "delete from Employee_Data where Employee_ID = " + id;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
	}
	
	
	/*
	 * Inserts data into the "Employee_Data" list
	 */
	public void insertIntoEmployee(int id, String name, String job) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "insert into Employee_Data (Employee_ID, Employee_Name, Employee_Title)" + " values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, job);
		
		ps.execute();
		con.close();
	}
	
	
	
	/*
	 * Removes data from the "Employee_Shifts" list
	 */
	public void removeEmployeeShift(int id) throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "delete from Employee_Shifts where Employee_ID = " + id;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
	}
	
	
	/*
	 * Inserts data into the "Employee_Shifts" list
	 */
	public void insertIntoEmployeeShift(int id, String name, String day, String startTime, String endTime) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "insert into Employee_Shifts (Employee_ID, Employee_Name, Day, Start_Time, End_Time)" + " values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, day);
		ps.setString(4, startTime);
		ps.setString(5, endTime);
		
		ps.execute();
		con.close();
	}
	
	
	
	/*
	 * Retrieves data from database and prints 
	 */
	public void retriveData() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
			
			Statement stmt = con.createStatement();
			Statement stmt2 = con.createStatement();
			Statement stmt3 = con.createStatement(); 

			ResultSet rs = stmt.executeQuery("select * from Employee_Data");
			ResultSet rb = stmt2.executeQuery("select * from Employee_Shifts");


			while(rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

			while(rb.next())
				System.out.println(rb.getInt(1) + "  " + rb.getString(2) + "  " + rb.getString(3) + "  " + rb.getString(4) + "  " + rb.getString(5));

			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String args[]) throws SQLException {
		MysqlCon x = new MysqlCon();
		x.insertIntoEmployee(6, "Fill", "AlbumFill");
		x.insertIntoEmployeeShift(8, "Phil Swift", "Friday", "11:00", "20:00");
		x.removeEmployee(6);
		x.removeEmployeeShift(8);
		x.retriveData();
	}
}