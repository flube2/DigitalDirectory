/**
 * 
 */
package com.lubekenterprises.directoryPackage;

/**
 * @author Frank Lubek
 *
 */
public class Radio {

	String radioNumber;
	String department;
	String firstName;
	String lastName;

	/**
	 * @param radioNumber
	 * @param department
	 * @param firstName
	 * @param lastName
	 */
	public Radio(String radioNumber, String department, String firstName, String lastName) {
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
	public Radio(String radioNumber, String department, String firstName) {
		super();
		this.radioNumber = radioNumber;
		this.department = department;
		this.firstName = firstName;
	}

	/**
	 * @param radioNumber
	 * @param department
	 */
	public Radio(String radioNumber, String department) {
		super();
		this.radioNumber = radioNumber;
		this.department = department;
	}

	/**
	 * @return the radioNumber
	 */
	public String getRadioNumber() {
		return radioNumber;
	}

	/**
	 * @param radioNumber the radioNumber to set
	 */
	public void setRadioNumber(String radioNumber) {
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

	Boolean containsStr(String search) {
		
		if(this.department.contains(search)) {
			return Boolean.TRUE;
		}
		
		if(this.firstName.contains(search)) {
			return Boolean.TRUE;
		}
		
		
		if(this.lastName != null && this.lastName.contains(search)) {
			return Boolean.TRUE;
		}
		
		if(this.radioNumber.contentEquals(search)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	void printInfo() {

		System.out.print("#" + this.radioNumber + " " + this.department + " ");

		if (this.firstName != null) {
			System.out.print(this.firstName + " ");
		}
		if (this.lastName != null) {
			System.out.print(this.lastName);
		}
		System.out.print("\n");
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
