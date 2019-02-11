package com.lubekenterprises.directoryPackage;

/**
 * @author Frank Lubek
 *
 */
class Status {
	enum status {
		FULL_TIME, PART_TIME, CASUAL, VOLUNTEER, OTHER
	};

	status stat;

	/**
	 * @param stat
	 */
	public Status(status stat) {
		super();
		this.stat = stat;
	}

}

/**
 * @author Frank Lubek
 *
 */
public class Employee extends Person {

	Department department;
	String jobTitle;
	String workEmail;
	Status status;

	/**
	 * @param first
	 * @param last
	 * @param email
	 * @param address
	 * @param phoneNum
	 * @param type
	 * @param phoneNum2
	 * @param type2
	 * @param department
	 * @param jobTitle
	 * @param workEmail
	 * 
	 */
	Employee(String first, String last, String email, String address, PhoneNumber phone1, PhoneNumber phone2,
			Department department, String jobTitle, String workEmail, String statusString) {
		super(first, last, email, address, phone1, phone2);
		this.department = department;
		this.jobTitle = jobTitle;
		this.workEmail = workEmail;
		this.status = verifyAndSetStatus(statusString);
	}

	/**
	 * @param first
	 * @param last
	 * @param phoneNum
	 * @param type
	 * @param department
	 * @param jobTitle
	 * @param workEmail
	 * 
	 */
	Employee(String first, String last, PhoneNumber phone1, Department department, String jobTitle, String workEmail,
			String statusString) {
		super(first, last, phone1);
		this.department = department;
		this.jobTitle = jobTitle;
		this.workEmail = workEmail;
		this.status = verifyAndSetStatus(statusString);
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param address
	 * @param primaryPhone
	 * @param secondaryPhone
	 * @param jobTitle
	 * @param workEmail
	 */
	public Employee(String firstName, String lastName, PhoneNumber primaryPhone, String jobTitle, String workEmail) {
		super(firstName, lastName, primaryPhone);
		this.jobTitle = jobTitle;
		this.workEmail = workEmail;
	}

	/**
	 * @return the department
	 * @author semi-auto created ///////////////////////////////////////////////
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the job title
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the job title to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the work email address
	 */
	public String getWorkEmail() {
		return workEmail;
	}

	/**
	 * @param workEmail the work email address to set
	 */
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	public Status verifyAndSetStatus(String statusString) {

		if (statusString.equalsIgnoreCase("FULL TIME") || statusString.equalsIgnoreCase("FT")
				|| statusString.equalsIgnoreCase("FULL") || statusString.equalsIgnoreCase("F")) {
			return new Status(com.lubekenterprises.directoryPackage.Status.status.FULL_TIME);
		}
		if (statusString.equalsIgnoreCase("PART TIME") || statusString.equalsIgnoreCase("PT")
				|| statusString.equalsIgnoreCase("PART") || statusString.equalsIgnoreCase("P")) {
			return new Status(com.lubekenterprises.directoryPackage.Status.status.PART_TIME);
		}
		if (statusString.equalsIgnoreCase("CASUAL") || statusString.equalsIgnoreCase("C")) {
			return new Status(com.lubekenterprises.directoryPackage.Status.status.CASUAL);
		}
		if (statusString.equalsIgnoreCase("VOLUNTEER") || statusString.equalsIgnoreCase("V")) {
			return new Status(com.lubekenterprises.directoryPackage.Status.status.VOLUNTEER);
		}
		// else
		return new Status(com.lubekenterprises.directoryPackage.Status.status.OTHER);

	}

	Boolean containsStr(String searchString) {

		Boolean b = Boolean.FALSE;

		if (this.firstName.contains(searchString) || this.lastName.contains(searchString)
				|| this.jobTitle.contains(searchString)) {
			b = Boolean.TRUE;
		}

		if (this.workEmail != null) {
			if (this.workEmail.contains(searchString)) {
				b = Boolean.TRUE;
			}
		}

		if (this.primaryPhone.containsStr(searchString)) {
			b = Boolean.TRUE;
		}

		return b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lubekenterprises.directoryPackage.Person#printInfo()
	 */
	void printInfo() {
		super.printInfo();
		System.out.println();
		if (this.status != null) {
			System.out.println("Status is      " + this.status.stat.toString());
		}
		if (this.workEmail != null && !this.workEmail.isEmpty()) {
			System.out.println("Work email is  " + this.workEmail);
		}
		System.out.println("Job title is   " + this.jobTitle);
		// this.department.printInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [" + (department != null ? "department=" + department + ", " : "")
				+ (jobTitle != null ? "jobTitle=" + jobTitle + ", " : "")
				+ (workEmail != null ? "workEmail=" + workEmail + ", " : "")
				+ (status != null ? "status=" + status : "") + "]";
	}

}
