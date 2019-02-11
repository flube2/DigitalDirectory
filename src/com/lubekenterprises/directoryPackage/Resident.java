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

	Room room1; // implement this later
	// Room room2;
	String roomNumber;
	String email;
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
//	public Resident(String firstName, String lastName, String email, String address, PhoneNumber primaryPhone,
//			PhoneNumber secondaryPhone, Room room1, Room room2, Boolean onVacation, String notes) {
//		super(firstName, lastName, email, address, primaryPhone, secondaryPhone);
//		this.room1 = room1;
//		this.room2 = room2;
//		this.onVacation = onVacation;
//		this.notes = notes;
//	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param primaryPhone
	 * @param secondaryPhone
	 * @param roomNumber
	 * @param email2
	 */
	public Resident(String firstName, String lastName, PhoneNumber primaryPhone, String roomNumber, String email) {
		super(firstName, lastName, primaryPhone);
		this.roomNumber = roomNumber;
		this.email = email;
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
//	public Room getRoom2() {
//		return room2;
//	}

	/**
	 * @param room2 the room2 to set
	 */
//	public void setRoom2(Room room2) {
//		this.room2 = room2;
//	}

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

	Boolean containsStr(String searchString) {

		if (this.roomNumber.contains(searchString) || this.firstName.contains(searchString)
				|| this.lastName.contains(searchString)) {
			return Boolean.TRUE;
		}

		if (this.email != null) {
			if (this.email.contains(searchString)) {
				return Boolean.TRUE;
			}
		}

		if (this.primaryPhone != null) {
			if (this.primaryPhone.containsStr(searchString)) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public void printInfo() {
		super.printInfo();
//		this.room1.printInfo();
//		if (this.room2 != null) {
//			this.room2.printInfo();
//		}

		System.out.println("Room  " + this.roomNumber);
		System.out.println("Email/Notes " + this.email);

		if (this.onVacation != null) {
			System.out.println("On vacation?   " + this.onVacation);
		}
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
				+ (roomNumber != null ? "roomNumber=" + roomNumber + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (onVacation != null ? "onVacation=" + onVacation + ", " : "")
				+ (notes != null ? "notes=" + notes : "") + "]";
	}

}
