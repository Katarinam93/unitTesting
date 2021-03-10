package unittesting.parcijalni2;

import java.time.DateTimeException;

public class SmartHouse {
	
	private TimeProvider timeProvider;

	public String GetTimeOfDay() {
		CurrentTime currentTime = timeProvider.getCurrentTime();

		if (currentTime.getHours() < 0 || currentTime.getHours() > 24) {
			throw new DateTimeException(null);
		}

		if (currentTime.getHours() >= 0 && currentTime.getHours() < 6) {
			return "Night";
		} else if (currentTime.getHours() >= 6 && currentTime.getHours() < 12) {
			return "Morning";
		} else if (currentTime.getHours() >= 12 && currentTime.getHours() < 18) {
			return "Noon";
		}
		return "Evening";
	}

	public TimeProvider getTimeProvider() {
		return timeProvider;
	}

	public void setTimeProvider(TimeProvider timeProvider) {
		this.timeProvider = timeProvider;
	}

}
