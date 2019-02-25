/**
 * 
 */
package com.lubekenterprises.directoryPackage;


/**
 * @author Frank Lubek
 *
 */


public class Patient extends Person {

	/*Room*/String room;
	String bed;
	String notes;

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param primaryPhone
	 * @param secondaryPhone
	 * @param room
	 * @param bed
	 */
	public Patient(String firstName, String lastName, String email, String address, PhoneNumber primaryPhone,
			PhoneNumber secondaryPhone, /*Room*/String room, String bed, String notesString) {
		super(firstName, lastName, email, address, primaryPhone, secondaryPhone);
		this.room = room;
		this.bed = bed;
		this.notes = notesString;
	}
	
	public Patient(String firstName, String lastName, PhoneNumber phoneNumber, /*Room*/String room) {
		super(firstName, lastName, phoneNumber);
		this.room = room;
	}

//	/**
//	 * @return the room
//	 */
//	public Room getRoom() {
//		return room;
//	}
//
//	/**
//	 * @param room the room to set
//	 */
//	public void setRoom(Room room) {
//		this.room = room;
//	}

	/**
	 * @return the bed
	 */
	public String getBed() {
		return bed;
	}

	/**
	 * @param bed the bed to set
	 */
	public void setBed(String bed) {
		this.bed = bed;
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
	 * @see com.lubekenterprises.directoryPackage.Person#printInfo()
	 */
	public void printInfo() {
		super.printInfo();
		System.out.println("Patient room # " + this.room + "-" + this.bed);
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
		return "Patient [" + (room != null ? "room=" + room + ", " : "") + (bed != null ? "bed=" + bed + ", " : "")
				+ (notes != null ? "notes=" + notes : "") + "]";
	}

}
