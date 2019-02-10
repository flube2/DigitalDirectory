/**
 * 
 */
package com.lubekenterprises.directoryPackage;

/**
 * @author Frank Lubek
 *
 */
public class Person {
	
	String firstName;
	String lastName;
	String email;
	String address;
	PhoneNumber primaryPhone;
	PhoneNumber secondaryPhone;
	
	

	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param primaryPhone
	 * @param secondaryPhone
	 */
	public Person(String firstName, String lastName, String email, String address, PhoneNumber primaryPhone,
			PhoneNumber secondaryPhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
	}
	

	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param primaryPhone
	 * @param secondaryPhone
	 */
	public Person(String firstName, String lastName, String email, PhoneNumber primaryPhone,
			PhoneNumber secondaryPhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
	}



	/**
	 * @param firstName
	 * @param lastName
	 * @param primaryPhone
	 */
	public Person(String firstName, String lastName, PhoneNumber primaryPhone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryPhone = primaryPhone;
	}



	/**
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the first name to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the last name to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email address
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the primary phone number
	 */
	public PhoneNumber getPrimaryPhone() {
		return primaryPhone;
	}

	/**
	 * @param primaryPhone the primary phone number to set
	 */
	public void setPrimaryPhone(PhoneNumber primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	/**
	 * @return the secondary phone number
	 */
	public PhoneNumber getSecondaryPhone() {
		return secondaryPhone;
	}

	/**
	 * @param secondaryPhone the secondary phone number to set
	 */
	public void setSecondaryPhone(PhoneNumber secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	/**
	 * 
	 */
	void printInfo() {
		System.out.println("First Name is  " + this.firstName);
		System.out.println("Last Name is   " + this.lastName);
		if(this.email != null) {
		System.out.println("Email is       " + this.email);
		}
		if(this.address != null) {
		System.out.println("Address is     " + this.address);
		}
        System.out.println();

        System.out.println("Primary Phone: ");
        this.primaryPhone.printInfo();
        if (this.secondaryPhone != null) {

            System.out.println("Secondary Phone: ");
            this.secondaryPhone.printInfo();
        }
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [" + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (address != null ? "address=" + address + ", " : "")
				+ (primaryPhone != null ? "primaryPhone=" + primaryPhone + ", " : "")
				+ (secondaryPhone != null ? "secondaryPhone=" + secondaryPhone : "") + "]";
	}

}
