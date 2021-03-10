package unittesting.parcijalni;

import java.util.Calendar;

public class PersonChecker {
	
	public int checkPersonAge(Calendar dateOfBirth) {
		int yearOfBirth = dateOfBirth.get(Calendar.YEAR);
		
		return yearOfBirth;
	}
}
