
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
		if( startTime < 0 || startTime > 2359) {
			throw new IndexOutOfBoundsException("Invalid Time Inputted ");
		}
		this.endTime = endTime;
		if( endTime < 0 || endTime > 2359) {
			throw new IndexOutOfBoundsException("Invalid Time Inputted ");
		}
	}
	
	public String getDay() {
		return day;
	}
	
	@SuppressWarnings("unused")
	private String setDay(String day) {
		String oldDay = this.day;
		this.day = day;
		return oldDay;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	@SuppressWarnings("unused")
	private int setStartTime(int startTime) {
		int oldStartTime = this.startTime;
		this.startTime = startTime;
		return oldStartTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	@SuppressWarnings("unused")
	private int setEndTime(int endTime) {
		int oldEndTime = this.endTime;
		this.endTime = endTime;
		return oldEndTime;
	}
}
