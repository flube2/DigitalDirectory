/**
 * 
 */
package com.lubekenterprises.directoryPackage;

import java.util.ArrayList;

/**
 * @author Frank Lubek
 *
 */
public class Room {

	String roomNumber;
	String floor;
	String unit;
	ArrayList<String> occupants;
	PhoneNumber phone;
	String email;
	String notes;

	/**
	 * @param roomNumber
	 * @param floor
	 * @param unit
	 * @param occupants
	 * @param phoneNumber
	 * @param notes
	 */
	public Room(String roomNumber, String floor, String unit, ArrayList<String> occupants, PhoneNumber phoneNumber,
			String email, String notes) {
		super();
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.unit = unit;
		this.occupants = occupants;
		this.phone = phoneNumber;
		this.email = email;
		this.notes = notes;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the floor
	 */
	public String getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public void setFloor(String floor) {
		this.floor = floor;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the occupants
	 */
	public ArrayList<String> getOccupants() {
		return occupants;
	}

	/**
	 * @param occupants the occupants to set
	 */
	public void setOccupants(ArrayList<String> occupants) {
		this.occupants = occupants;
	}

	/**
	 * @return the phone
	 */
	public PhoneNumber getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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

	Boolean containsRoomNumber(String roomNumber) {
		return roomNumber.equalsIgnoreCase(this.roomNumber);
	}

	Boolean containsStr(String search) {

		// below line could also do this.roomNumber.contains(search) to search all rooms
		// ending in 12, etc.
		//
		// 2/12/19 The above comment is necessary for new database with patient room
		// numbers like 302-1
		if (this.roomNumber.contains(search) || this.unit.contains(search)) {
			return Boolean.TRUE;
		}
		;

		if (this.occupants != null) {

			for (String occupant : occupants) {
				if (occupant.toLowerCase().contains(search.toLowerCase())) {
					return Boolean.TRUE;
				}
			}

		}

		if (this.phone != null) {
			if (this.phone.containsStr(search)) {
				return Boolean.TRUE;
			}
			;
		}

		if (this.email != null) {
			if (this.email.contains(search)) {
				return Boolean.TRUE;
			}
			;
		}

		if (this.notes != null) {
			if (this.notes.contains(search)) {
				return Boolean.TRUE;
			}
			;
		}
		return Boolean.FALSE;
	}

	/**
	 * 
	 */
	public void printInfo() {
		System.out.println(
				"Room number " + this.roomNumber + " is on floor " + this.floor + " in the " + this.unit + " unit");
		if (occupants != null) {
			System.out.print("Occupants:     ");
			for (String s : occupants) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
		if (this.phone != null) {
			this.phone.printInfo();
		}
		if (this.email != null) {
			System.out.println("Email is      " + this.email);
		}
		if (this.notes != null && this.notes != "null") {
			System.out.println("**Notes** " + this.notes);
		}
		System.out.println();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [" + (roomNumber != null ? "roomNumber=" + roomNumber + ", " : "")
				+ (floor != null ? "floor=" + floor + ", " : "") + (unit != null ? "unit=" + unit + ", " : "")
				+ (occupants != null ? "occupants=" + occupants + ", " : "")
				+ (phone != null ? "phone=" + phone + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (notes != null ? "notes=" + notes : "") + "]";
	}

}
