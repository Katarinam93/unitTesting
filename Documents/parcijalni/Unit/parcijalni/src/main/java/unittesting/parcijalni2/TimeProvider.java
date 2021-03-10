package unittesting.parcijalni2;


import java.util.Calendar;

public class TimeProvider {
	
	public CurrentTime getCurrentTime() {
		Calendar rightNow = Calendar.getInstance();
		
		int hour = rightNow.get(Calendar.HOUR_OF_DAY);
		int minute = rightNow.get(Calendar.MINUTE);
		int seconds = rightNow.get(Calendar.SECOND);
		
		return new CurrentTime(hour, minute, seconds);
	}

}
