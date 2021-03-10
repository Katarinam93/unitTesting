package unittesting.parcijalni;

import java.util.Calendar;

public class Person {

	private String name;
	private String lastName;
	private Calendar dateOfBirth;
	private int numberOfCompanions;

	public Person() {
		super();
	}

	public Person(String name, String lastName, Calendar dateOfBirth, int numberOfCompanions) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.numberOfCompanions = numberOfCompanions;
	}
	
	public Person(Calendar dateOfBirth, int numberOfCompanions){
		this.dateOfBirth = dateOfBirth;
		this.numberOfCompanions = numberOfCompanions;
	}
	
	public Person(int numberOfCompanions){
		this.numberOfCompanions = numberOfCompanions;
		
	}
	public Person(Calendar dateOfBirth){
		this.dateOfBirth = dateOfBirth;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getNumberOfCompanions() {
		return numberOfCompanions;
	}

	public void setNumberOfCompanions(int numberOfCompanions) {
		this.numberOfCompanions = numberOfCompanions;
	}

}
