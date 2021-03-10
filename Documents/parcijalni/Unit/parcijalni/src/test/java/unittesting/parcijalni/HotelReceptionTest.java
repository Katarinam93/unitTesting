package unittesting.parcijalni;

import org.testng.annotations.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HotelReceptionTest {

	HotelReception hotelReception;
	Person person;
	Room room;
	PersonChecker mpersonCheck;
	RoomChecker mRoomCheck;

	@BeforeMethod
	public void setUp() {

		hotelReception = new HotelReception();
		mpersonCheck = Mockito.mock(PersonChecker.class);
		mRoomCheck = Mockito.mock(RoomChecker.class);

		hotelReception.setPersonChecker(mpersonCheck);
		hotelReception.setRoomChecker(mRoomCheck);

		System.out.println(hotelReception.currentYear);
	}

	@Test
	public void happyFlow() throws Exception {

		Calendar c = new GregorianCalendar(1995, 8, 20);
		person = new Person(c, 2);
		room = new Room(5);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(1995);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Room is successfully booked";

		assertEquals(actual, ocekivano);

	}

	@Test
	public void has18Years() throws Exception {

		Calendar c = new GregorianCalendar(2003, 8, 20);
		person = new Person(c, 2);
		room = new Room(5);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(2003);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Room is successfully booked";

		assertEquals(actual, ocekivano);

	}

	@Test(expectedExceptions = Exception.class)
	public void isMinor() throws Exception {

		Calendar c = new GregorianCalendar(2007, 1, 20);
		person = new Person(c, 2);
		room = new Room(5);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(2007);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Exception";

		assertEquals(actual, ocekivano);

	}

	@Test(expectedExceptions = Exception.class)
	public void hasMinusYears() throws Exception {

		Calendar c = new GregorianCalendar(2040, 8, 20);
		person = new Person(c, 2);
		room = new Room(5);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(2040);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Exception";

		assertEquals(actual, ocekivano);

	}

	@Test
	public void roomIsBooked() throws Exception {

		Calendar c = new GregorianCalendar(1995, 8, 20);
		person = new Person(c, 2);
		room = new Room(5);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(1995);
		when(mRoomCheck.isFree(room)).thenReturn(false);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Room is already booked";

		assertEquals(actual, ocekivano);

	}

	@Test
	public void tooManyPeople() throws Exception {

		Calendar c = new GregorianCalendar(1995, 8, 20);
		person = new Person(c, 5);
		room = new Room(4);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(1995);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Too many people for this room";

		assertEquals(actual, ocekivano);

	}

	@Test
	public void roomCapacity() throws Exception {

		Calendar c = new GregorianCalendar(1995, 8, 20);
		person = new Person(c, 3);
		room = new Room(4);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(1995);
		when(mRoomCheck.isFree(room)).thenReturn(true);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = "Room is successfully booked";

		assertEquals(actual, ocekivano);

	}

	@Test(dataProvider = "personProvide")
	public void dataProviderTest(int year, int numberOfCompanions, int roomCapacity, boolean isFull, String rez)
			throws Exception {

		Calendar c = new GregorianCalendar(1995, 8, 20);
		person = new Person(numberOfCompanions);
		room = new Room(roomCapacity);

		when(mpersonCheck.checkPersonAge(c)).thenReturn(year);
		when(mRoomCheck.isFree(room)).thenReturn(isFull);

		String actual = hotelReception.bookARoom(person, room);
		String ocekivano = rez;

		assertEquals(actual, ocekivano);

	}

	@DataProvider(name = "personProvide")
	public Object[][] provideBroj() {
		return new Object[][] { 
				{ 1995, 4, 10, true, "Room is successfully booked" }, //happy flow
				{ 1995, 10, 5, true, "Too many people for this room" }, // previse ljudi
				{ 2003, 5, 7, true, "Room is successfully booked" }, // tacno 18 godina
				{ 1995, 5, 6, true, "Room is successfully booked" }, // broj ljudi odgovara kapacitetu sobe
				{ 1995, 5, 7, false, "Room is already booked" } }; // soba nije slobodna

	}

}
