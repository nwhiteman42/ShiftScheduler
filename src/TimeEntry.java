/*
 * Class to handle the avaiblible times an employee can work for each day
 */

public class TimeEntry {
	
	public String day;
	public int startTime;
	public int endTime;
	
	public TimeEntry() {
		day = "Sunday";
		startTime = 0;
		endTime = 2359; 
	}
	
	public TimeEntry(String day, int startTime, int endTime) {
		this.day = day;
		this.startTime = startTime;
		if( startTime < 0 || startTime > 2400) {
			throw new IndexOutOfBoundsException("Invalid Time Inputted ");
		} 
		this.endTime = endTime;
		if( endTime < 0 || endTime > 2400) {
			throw new IndexOutOfBoundsException("Invalid Time Inputted ");
		}
	}
	
	/*
	 * Various getters and setters
	 */
	public String getDay() {
		return day;
	}
	
	@SuppressWarnings("unused")
	public String setDay(String day) {
		String oldDay = this.day;
		this.day = day;
		return oldDay;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	@SuppressWarnings("unused")
	public int setStartTime(int startTime) {
		int oldStartTime = this.startTime;
		this.startTime = startTime;
		return oldStartTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	@SuppressWarnings("unused")
	public int setEndTime(int endTime) {
		int oldEndTime = this.endTime;
		this.endTime = endTime;
		return oldEndTime;
	}
}
