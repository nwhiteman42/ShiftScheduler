
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
		this.endTime = endTime;
	}
	
	public String getDay() {
		return day;
	}
	
	private String setDay(String day) {
		String oldDay = this.day;
		this.day = day;
		return oldDay;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	private int setStartTime(int startTime) {
		int oldStartTime = this.startTime;
		this.startTime = startTime;
		return oldStartTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	private int setEndTime(int endTime) {
		int oldEndTime = this.endTime;
		this.endTime = endTime;
		return oldEndTime;
	}
}
