/**
 * 
 */
package com.lubekenterprises.directoryPackage;

/**
 * @author Admin
 *
 */
public class BoardMember {

	String firstName;
	String lastName;
	String address;
	PhoneNumber home;
	PhoneNumber work;
	PhoneNumber cell;
	String email;
	String notes;
	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param home
	 * @param work
	 * @param cell
	 * @param email
	 * @param notes
	 */
	public BoardMember(String firstName, String lastName, String address, PhoneNumber home, PhoneNumber work,
			PhoneNumber cell, String email, String notes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.home = home;
		this.work = work;
		this.cell = cell;
		this.email = email;
		this.notes = notes;
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
	 * @return the home
	 */
	public PhoneNumber getHome() {
		return home;
	}
	/**
	 * @param home the home to set
	 */
	public void setHome(PhoneNumber home) {
		this.home = home;
	}
	/**
	 * @return the work
	 */
	public PhoneNumber getWork() {
		return work;
	}
	/**
	 * @param work the work to set
	 */
	public void setWork(PhoneNumber work) {
		this.work = work;
	}
	/**
	 * @return the cell
	 */
	public PhoneNumber getCell() {
		return cell;
	}
	/**
	 * @param cell the cell to set
	 */
	public void setCell(PhoneNumber cell) {
		this.cell = cell;
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
	
	Boolean containsStr(String searchString) {
		
		if(this.firstName.contains(searchString) || this.lastName.contains(searchString) || this.address.contains(searchString) || this.email.contains(searchString)) {
		return Boolean.TRUE;	
		}
		
		if(this.home != null) {
			if(this.home.containsStr(searchString)) {
				return Boolean.TRUE;
			}
		}
		
		if(this.work != null) {
			if(this.work.containsStr(searchString)) {
				return Boolean.TRUE;
			}
		}
		
		if(this.cell != null) {
			if(this.cell.containsStr(searchString)) {
				return Boolean.TRUE;
			}
		}
		
		if(this.notes != null) {
			if(this.notes.contains(searchString)) {
				return Boolean.TRUE;
			}
			
		}
		
		return Boolean.FALSE;
		
	}
	
	void printInfo() {
		System.out.println(this.firstName + " " + this.lastName);
		System.out.println(this.address);
		System.out.println(this.email);
		
		if(this.home != null) {
			this.home.printInfo();
		}
		
		if(this.work != null) {
			this.work.printInfo();
		}
		
		if(this.cell != null) {
			this.cell.printInfo();
		}
		
		if(this.notes != null && !this.notes.contentEquals("null")) {
			System.out.println(this.notes);
		}
		System.out.println();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BoardMember [" + (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (address != null ? "address=" + address + ", " : "") + (home != null ? "home=" + home + ", " : "")
				+ (work != null ? "work=" + work + ", " : "") + (cell != null ? "cell=" + cell + ", " : "")
				+ (email != null ? "email=" + email + ", " : "") + (notes != null ? "notes=" + notes : "") + "]";
	}
	
	
	
	
}
