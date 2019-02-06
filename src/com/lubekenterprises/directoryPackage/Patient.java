/**
 * 
 */
package com.lubekenterprises.directoryPackage;

import com.lubekenterprises.directoryPackage.Bed.BedType;

/**
 * @author Frank Lubek
 *
 */
class Bed {
	enum BedType {
		A, B
	};

	BedType bed;
}

public class Patient extends Person {

	Room room;
	BedType bed;
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
			PhoneNumber secondaryPhone, Room room, BedType bed, String notesString) {
		super(firstName, lastName, email, address, primaryPhone, secondaryPhone);
		this.room = room;
		this.bed = bed;
		this.notes = notesString;
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * @return the bed
	 */
	public BedType getBed() {
		return bed;
	}

	/**
	 * @param bed the bed to set
	 */
	public void setBed(BedType bed) {
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
		System.out.println("Patient room # " + this.room.roomNumber + "-" + this.bed.toString());
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
