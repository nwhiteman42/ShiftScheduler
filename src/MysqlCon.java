

import java.sql.*;
import java.util.ArrayList;

class MysqlCon { 
	
	//Gets id to assign to an employer. ID does not already exist in database
	public int getAEmployerID() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select count(*) from emp_cred";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int id = 0;
		while(rs.next()) {
			id = rs.getInt(1)+1;
		}
		boolean exists = true;
		while(exists == true) {
			String query2 = "select count(emp_id) from emp_cred where emp_id = "+ id;
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt.executeQuery(query2);
			int x = 0;
			while(rs2.next()) {
				x = rs2.getInt(1);
			}
			if(x == 0) {
				exists = false;
			} else {
				id++;
			}
		}
		return id;
	}
	
	
	//Gets an id to give to a new employee. The id does not already exist in the database
	public int getAEmployeID() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select count(*) from Employee_Data";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int id = 0;
		while(rs.next()) {
			id = rs.getInt(1)+1;
		}
		boolean exists = true;
		while(exists == true) {
			String query2 = "select count(Employee_ID) from Employee_Data where Employee_ID = "+ id;
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt.executeQuery(query2);
			int x = 0;
			while(rs2.next()) {
				x = rs2.getInt(1);
			}
			if(x == 0) {
				exists = false;
			} else {
				id++;
			}
		}
		return id;
	}
	
	
	public ArrayList<Employee> getEmployees() throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select Employee_ID, Employee_name, Employee_Title, seniority from Employee_Data";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Employee> e = new ArrayList<Employee>();
		while(rs.next()) {
			Employee x = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), getEmployeeAval(rs.getInt(1), rs.getString(2)), rs.getInt(4));
			e.add(x);
		}
		return e;
	}
	
	public TimeEntry[] getEmployeeAval(int id, String name) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select Day, Start_Time, End_Time from Employee_Shifts where Employee_id = " + id +" and Employee_name =" +"'"+name+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		//Load into array list then into array with size of number of elements to eliminate having to deal with null values
		ArrayList<TimeEntry> aval = new ArrayList<TimeEntry>();
		while(rs.next()) {
			TimeEntry x = new TimeEntry(rs.getString(1), rs.getInt(2), rs.getInt(3));
			aval.add(x);
		}
		TimeEntry[] time = new TimeEntry[aval.size()];
		for(int x = 0; x< aval.size(); x++) {
			time[x] = aval.get(x);
		}
		return time;	
	}
	
	
	
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
	public boolean insertIntoEmployee(int id, String name, String job,int seniority) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "insert into Employee_Data (Employee_ID, Employee_Name, Employee_Title, seniority )" + " values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, job);
		ps.setInt(4, seniority);
		
		boolean e = ps.execute();
		con.close();
		return e;
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
	public boolean insertIntoEmployeeShift(int id, String name, String day, String startTime, String endTime) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "insert into Employee_Shifts (Employee_ID, Employee_Name, Day, Start_Time, End_Time)" + " values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, day);
		ps.setString(4, startTime);
		ps.setString(5, endTime);
		
		return ps.execute();
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
		
	}
}