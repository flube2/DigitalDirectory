/**
 * 
 */
package com.lubekenterprises.directoryPackage;

/**
 * @author Frank Lubek
 *
 */
public class Radio {

	int radioNumber;
	String department;
	String firstName;
	String lastName;

	/**
	 * @param radioNumber
	 * @param department
	 * @param firstName
	 * @param lastName
	 */
	public Radio(int radioNumber, String department, String firstName, String lastName) {
		super();
		this.radioNumber = radioNumber;
		this.department = department;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @param radioNumber
	 * @param department
	 * @param firstName
	 */
	public Radio(int radioNumber, String department, String firstName) {
		super();
		this.radioNumber = radioNumber;
		this.department = department;
		this.firstName = firstName;
	}

	/**
	 * @param radioNumber
	 * @param department
	 */
	public Radio(int radioNumber, String department) {
		super();
		this.radioNumber = radioNumber;
		this.department = department;
	}

	/**
	 * @return the radioNumber
	 */
	public int getRadioNumber() {
		return radioNumber;
	}

	/**
	 * @param radioNumber the radioNumber to set
	 */
	public void setRadioNumber(int radioNumber) {
		this.radioNumber = radioNumber;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Radio [radioNumber=" + radioNumber + ", "
				+ (department != null ? "department=" + department + ", " : "")
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName : "") + "]";
	}

}
