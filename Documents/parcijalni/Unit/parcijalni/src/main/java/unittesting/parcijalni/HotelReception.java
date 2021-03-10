package unittesting.parcijalni;

import java.util.Calendar;

public class HotelReception {

	private RoomChecker roomChecker;
	private PersonChecker personChecker;

	public int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	public String bookARoom(Person person, Room room) throws Exception {

		int personAge = personChecker.checkPersonAge(person.getDateOfBirth());

		if (currentYear - personAge < 18) {
			throw new Exception();
		}

		if (roomChecker.isFree(room)) {

			if (room.getCapacity() >= person.getNumberOfCompanions() + 1) {
				return "Room is successfully booked";
			} else {
				return "Too many people for this room";
			}
		}

		return "Room is already booked";

	}

	public RoomChecker getRoomChecker() {
		return roomChecker;
	}

	public void setRoomChecker(RoomChecker roomChecker) {
		this.roomChecker = roomChecker;
	}

	public PersonChecker getPersonChecker() {
		return personChecker;
	}

	public void setPersonChecker(PersonChecker personChecker) {
		this.personChecker = personChecker;
	}

}
