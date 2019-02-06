/**
 * 
 */
package com.lubekenterprises.directoryPackage;

/**
 * @author Frank Lubek
 *
 */
public class Resident extends Person {

	/*
	 * String firstName; String lastName; String email; String address; PhoneNumber
	 * primaryPhone; PhoneNumber secondaryPhone;
	 */

	Room room1;
	Room room2;
	Boolean onVacation;
	String notes;

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param primaryPhone
	 * @param secondaryPhone
	 * @param room1
	 * @param room2
	 * @param onVacation
	 * @param notes
	 */
	public Resident(String firstName, String lastName, String email, String address, PhoneNumber primaryPhone,
			PhoneNumber secondaryPhone, Room room1, Room room2, Boolean onVacation, String notes) {
		super(firstName, lastName, email, address, primaryPhone, secondaryPhone);
		this.room1 = room1;
		this.room2 = room2;
		this.onVacation = onVacation;
		this.notes = notes;
	}

	/**
	 * @return the room1
	 */
	public Room getRoom1() {
		return room1;
	}

	/**
	 * @param room1 the room1 to set
	 */
	public void setRoom1(Room room1) {
		this.room1 = room1;
	}

	/**
	 * @return the room2
	 */
	public Room getRoom2() {
		return room2;
	}

	/**
	 * @param room2 the room2 to set
	 */
	public void setRoom2(Room room2) {
		this.room2 = room2;
	}

	/**
	 * @return the onVacation
	 */
	public Boolean getOnVacation() {
		return onVacation;
	}

	/**
	 * @param onVacation the onVacation to set
	 */
	public void setOnVacation(Boolean onVacation) {
		this.onVacation = onVacation;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public void printInfo() {
		super.printInfo();
		this.room1.printInfo();
		if (this.room2 != null) {
			this.room2.printInfo();
		}
		System.out.println("On vacation?   " + this.onVacation);
		if (this.notes != null) {
			System.out.println(this.notes);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resident [" + (room1 != null ? "room1=" + room1 + ", " : "")
				+ (room2 != null ? "room2=" + room2 + ", " : "")
				+ (onVacation != null ? "onVacation=" + onVacation + ", " : "")
				+ (notes != null ? "notes=" + notes : "") + "]";
	}

}
