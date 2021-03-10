package unittesting.parcijalni;

import org.testng.annotations.Test;

import unittesting.parcijalni2.CurrentTime;
import unittesting.parcijalni2.SmartHouse;
import unittesting.parcijalni2.TimeProvider;

import static org.testng.Assert.assertEquals;

import java.time.DateTimeException;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class SmartHouseTest {

	SmartHouse smartHouse;
	TimeProvider mockedTimeProvider;
	CurrentTime currentTime;

	@BeforeMethod
	public void beforeMethod() {

		smartHouse = new SmartHouse();
		mockedTimeProvider = Mockito.mock(TimeProvider.class);
		smartHouse.setTimeProvider(mockedTimeProvider);
	}

	@Test(dataProvider = "data_provider", priority = 1)
	public void getTimeOFDayTest(int hours, String rez) {

		Mockito.when(mockedTimeProvider.getCurrentTime()).thenReturn(new CurrentTime(hours));

		String actual = smartHouse.GetTimeOfDay();

		assertEquals(actual, rez);
		
		System.out.println("When the time is " + hours + " than this method throws " + rez + " message!");
	}
	
	

	@DataProvider
	public Object[][] data_provider() {
		return new Object[][] { 
			new Object[] { 1, "Night" }, // granicne vrednosti 
			new Object[] { 0, "Night" }, // granicne vrednosti 
			new Object[] { 10, "Morning" },
			new Object[] { 6, "Morning" },// granicne vrednosti 
			new Object[] { 7, "Morning" },// granicne vrednosti 
			new Object[] { 5, "Night" },// granicne vrednosti 
			new Object[] { 15, "Noon" }, 
			new Object[] { 12, "Noon" },// granicne vrednosti
			new Object[] { 13, "Noon" },// granicne vrednosti
			new Object[] { 11, "Morning" },// granicne vrednosti
			new Object[] { 20, "Evening" }, 
			new Object[] { 17, "Noon" },// granicne vrednosti
			new Object[] { 18, "Evening" },// granicne vrednosti
			new Object[] { 19, "Evening" },// granicne vrednosti
			new Object[] { 23, "Evening" },// granicne vrednosti
			
			};
	}
	
	@Test(priority = 2, expectedExceptions = DateTimeException.class)
	public void testExeption() throws DateTimeException {

			Mockito.when(mockedTimeProvider.getCurrentTime()).thenReturn(new CurrentTime(30));

			smartHouse.GetTimeOfDay();
			

			Mockito.when(mockedTimeProvider.getCurrentTime()).thenReturn(new CurrentTime(-30));
			
			smartHouse.GetTimeOfDay();
			
			Mockito.when(mockedTimeProvider.getCurrentTime()).thenReturn(new CurrentTime(-1));//granicna vrednost
			
			smartHouse.GetTimeOfDay();
			
			
			Mockito.when(mockedTimeProvider.getCurrentTime()).thenReturn(new CurrentTime(24));//granicna vrednost
			
			smartHouse.GetTimeOfDay();

	}
}
