/**
 * 
 */
package com.lubekenterprises.directoryPackage;

import java.util.ArrayList;

/**
 * @author Frank Lubek
 *
 */
public class Department {

	String departmentName;
	PhoneNumber phone1;
	PhoneNumber phone2;
	ArrayList<Room> rooms;
	String notes;

	/**
	 * @param departmentName
	 * @param phone1
	 */
	public Department(String departmentName, PhoneNumber phone1) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = null;
		this.notes = null;
	}

	/**
	 * @param departmentName
	 * @param phone1
	 * @param phone2
	 */
	public Department(String departmentName, PhoneNumber phone1, PhoneNumber phone2) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.notes = null;
	}

	/**
	 * @param departmentName
	 * @param phone1
	 * @param notes
	 */
	public Department(String departmentName, PhoneNumber phone1, String notes) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = null;
		this.notes = notes;
	}

	/**
	 * @param departmentName
	 * @param phone1
	 * @param phone2
	 * @param notes
	 */
	public Department(String departmentName, PhoneNumber phone1, PhoneNumber phone2, String notes) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.notes = notes;
	}

	/**
	 * @param departmentName
	 * @param phone1
	 * @param phone2
	 * @param rooms
	 */
	public Department(String departmentName, PhoneNumber phone1, PhoneNumber phone2, ArrayList<Room> rooms) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.rooms = rooms;
	}

	/**
	 * @param departmentName
	 * @param phone1
	 * @param phone2
	 * @param rooms
	 * @param notes
	 */
	public Department(String departmentName, PhoneNumber phone1, PhoneNumber phone2, ArrayList<Room> rooms,
			String notes) {
		super();
		this.departmentName = departmentName;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.rooms = rooms;
		this.notes = notes;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return phone1
	 */
	public PhoneNumber getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(PhoneNumber phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return phone2
	 */
	public PhoneNumber getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(PhoneNumber phone2) {
		this.phone2 = phone2;
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

	/**
	 * @return the rooms
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	Boolean containsStr(String search) {

		Boolean b = this.departmentName.contains(search);

		if (this.phone1 != null) {
			b = b || this.phone1.containsStr(search);
		}
		if (this.phone2 != null) {
			b = b || this.phone2.containsStr(search);
		}
		if (this.notes != null) {
			b = b || this.notes.contains(search);
		}

		return b;
	}

	/**
	 * 
	 */
	public void printInfo() {
		System.out.println("Department is  " + this.departmentName);
		this.phone1.printInfo();

		if (this.phone2 != null) {
			this.phone2.printInfo();
		}

		if (this.notes != null) {
			System.out.println("**NOTES**  " + this.notes);
		}
		System.out.println();
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [" + (departmentName != null ? "departmentName=" + departmentName + ", " : "")
				+ (phone1 != null ? "phone1=" + phone1 + ", " : "") + (phone2 != null ? "phone2=" + phone2 + ", " : "")
				+ (rooms != null ? "rooms=" + rooms + ", " : "") + (notes != null ? "notes=" + notes : "") + "]";
	}

}
