package unittesting.parcijalni;

public class Room {

	private int roomNumber;
	private int capacity;

	public Room() {
		super();
	}

	public Room(int roomNumber, int capacity) {
		super();
		this.roomNumber = roomNumber;
		this.capacity = capacity;
	}
	public Room(int capacity){
		this.capacity = capacity;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
