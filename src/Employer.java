import java.util.ArrayList;

public class Employer extends Employee {
	private ArrayList<Employee> employees = new ArrayList<>();
	
	/*
	 * Adds new employee to the list; returns true if it worked, false if it failed
	 *TODO: add a sorting function to help with finding employees
	 * @param: e - employee to add
	 * 
	 * @return: if the addition succeeded
	 */
	@SuppressWarnings("unused")
	public boolean addEmployee( Employee e ) {
		int len1 = employees.size();
		employees.add(e);
		int len2 = employees.size();
		if ( len1 >= len2 ) {
			return false;
		}
		return true;
	}
	
	/*
	 * Removes an employee from the list; returns true if it worked, false if it failed
	 * 
	 * @param: e - employee to remove
	 * 
	 * @return: if the removal worked
	 */
	@SuppressWarnings("unused")
	public boolean removeEmployee( Employee e ) {
		int len1 = employees.size();
		employees.remove( e );
		int len2 = employees.size();
		if ( len1 <= len2 ) {
			return false;
		}
		return true;
	}
	
	/*
	 * Searches for an employee in the list using their name
	 * 
	 * @param: name - the employee's name you try to find
	 * 
	 * @return: the Employee object attached to that name
	 */
	@SuppressWarnings("unused")
	public Employee getEmployee( String name ) {
		Employee find = new Employee();
		for ( Employee e : employees ) {
			if ( e.getName().equals(name) ) {
				find = e;
				break;
			}
		}
		return find;
	}
	
	//TODO: editScheudle
	//TODO: massEmail
	//TODO: deleteUser
}
