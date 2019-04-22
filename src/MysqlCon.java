

import java.sql.*;
import java.util.ArrayList;

class MysqlCon { 
	
	/*
	 * Gets the id of an employee currently in the database.
	 * @param String email, email of employee who's id will be received
	 * @return int id, id of an employee
	 */
	public int getACurrentEmployeeID(String email) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select Employee_id from Employee_Data where email =" +"'"+email+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int id = -1;
		while(rs.next()) {
			id = rs.getInt(1);
		}
		con.close();
		return id;
	}
	
	/*
	 * Gets id to assign to an employer. ID does not already exist in database
	 * @return int id
	 */
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
			ResultSet rs2 = stmt2.executeQuery(query2);
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
		con.close();
		return id;
	}
	
	
	/*
	 * Gets an id to give to a new employee. The id does not already exist in the database.
	 * @returns int id
	 */
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
			ResultSet rs2 = stmt2.executeQuery(query2);
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
		con.close();
		return id;
	}
	 
	/*
	 * Gets all of the employees from a given workplace
	 * @param String workplace, workplace from which to pull the employees
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Employee> getEmployees(String workplace) throws SQLException{
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select Employee_ID, Employee_name, Employee_Title, seniority, placeofwork, email from Employee_Data where placeofwork = "
				+"'"+workplace+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Employee> e = new ArrayList<Employee>();
		MysqlCon c = new MysqlCon();
		while(rs.next()){
			Employee x = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), c.getEmployeeAval(rs.getInt(1), rs.getString(2)),
					rs.getInt(4), rs.getString(5), rs.getString(6));
			e.add(x);
		}
		con.close();
		return e;
	}
	/*
	 * Gets all the employee emails for a given workplace
	 * @param String workplace, workplace to pull emails from
	 * @return, String[], an array of emails
	 */
	public String[] getEmployeesEmail(String workplace) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		String query = "select email from Employee_Data where placeofwork = "+"'"+workplace+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		String query2 = "select count(email) from Employee_Data where placeofwork = "+"'"+workplace+"'";
		Statement stmt2 = con.createStatement();
		ResultSet rs2 = stmt2.executeQuery(query2);
		int totalEmail = 0;
		while(rs2.next()){
			totalEmail = rs2.getInt(1);
		}
		String[] emails = new String[totalEmail];
		int count = 0;
		while(rs.next()) {
			emails[count] = rs.getString(1);
			count++;
		}
		con.close();
		return emails;
	}
	/*
	 * Gets the TimeEntry array for a given employee
	 * @param int id, id of employee
	 * @param String name, name of employee
	 */
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
		for(int x = 0; x < aval.size(); x++) {
			time[x] = aval.get(x);
		}
		con.close();
		return time;	
	}
	
	
	
	/* 
	 * Removes data from the "Employee_Data" list
	 * @param String email of employee to be removed
	 */
	public void removeEmployee(String email) throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "delete from Employee_Data where email = " +"'"+email+"'" ;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	} 
	
	
	/*
	 * Inserts data into the "Employee_Data" list
	 */
	public void insertIntoEmployee(int id, String name, String job,int seniority, String work, String email) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "insert into Employee_Data (Employee_ID, Employee_Name, Employee_Title, seniority, placeofwork, email )" + " values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, job);
		ps.setInt(4, seniority);
		ps.setString(5, work);
		ps.setString(6, email);
		
		ps.execute();
		con.close();
		}
	
	
	
	/*
	 * Removes data from the "Employee_Shifts" list
	 * @param int id, id of employee whos shift will be removed
	 */
	public void removeEmployeeShift(int id) throws SQLException {
	Connection con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/DRZ3zhCKwK","DRZ3zhCKwK","JLKYtPKkBL");
		
		String query = "delete from Employee_Shifts where Employee_ID = " + id;
		PreparedStatement ps = con.prepareStatement(query);
		ps.executeUpdate();
		con.close();
	}
	
	

	
	
	public static void main(String args[]) throws SQLException {
		MysqlCon x = new MysqlCon();
		x.removeEmployeeShift(500);
		
	}
}