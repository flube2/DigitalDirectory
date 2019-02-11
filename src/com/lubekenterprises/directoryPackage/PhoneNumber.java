/**
 * 
 */
package com.lubekenterprises.directoryPackage;

import com.lubekenterprises.directoryPackage.PhoneNumber.PhoneType.PhoneNumberType;

/**
 * @author Frank Lubek
 *
 */
public class PhoneNumber {

	static class PhoneType {
		enum PhoneNumberType {
			WORK, OFFICE, HOME, CELL, FAX, PRIMARY, SECONDARY
		};

		PhoneNumberType type;
	}

	String fullNumber;
	String extension;
	PhoneNumberType type;

	/**
	 * @param fullNumber phone number to set
	 * @param typeString the type of phone number
	 */
	public PhoneNumber(String fullNumber, String typeString) {

		fullNumber = this.stripNonNumeric(fullNumber);
		fullNumber = this.addPrefixIfNotExist(fullNumber);

		// If a valid 10 digit phone number was entered, continU will hold Boolean.TRUE
		Boolean continU = this.isValidPhoneNumber(fullNumber);

		if (continU == Boolean.TRUE) {
			this.fullNumber = fullNumber;
			this.extension = getExtensionValue(this.fullNumber);
			this.type = getValidEnum(typeString);
		} else {
			// TODO: implement exiting to main menu, not exiting the program
			System.out.println("Error: Invalid Phone Number In Database");
			System.out.println(fullNumber);
		}
	}

	String addPrefixIfNotExist(String fullNumber) {

		if (fullNumber.length() == 7) {
			fullNumber = "708" + fullNumber;
		}

		return fullNumber;
	}

	/**
	 * @param fullNumber the fullNumber to get the extension from
	 * @return the last 4 digits of the fullNumber iff it is a number that may come
	 *         from within the building (588 and 482 area codes)
	 */
	String getExtensionValue(String fullNumber) {

		String localCode = fullNumber.substring(3, 6);
		Integer val = Integer.parseInt(localCode);
		if (val == 588 || val == 482) {
			return fullNumber.substring(6);
		} else {
			return "";
		}
	}

	/**
	 * @param typeString the string of the enum value
	 * @return the actual enum value
	 */
	PhoneNumberType getValidEnum(String typeString) {

		if (typeString.equalsIgnoreCase("HOME")) {
			return PhoneNumberType.HOME;
		}
		if (typeString.equalsIgnoreCase("CELL")) {
			return PhoneNumberType.CELL;
		}
		if (typeString.equalsIgnoreCase("WORK")) {
			return PhoneNumberType.WORK;
		}
		if (typeString.equalsIgnoreCase("OFFICE")) {
			return PhoneNumberType.OFFICE;
		}
		if (typeString.equalsIgnoreCase("FAX")) {
			return PhoneNumberType.FAX;
		}
		if (typeString.equalsIgnoreCase("PRIMARY")) {
			return PhoneNumberType.PRIMARY;
		}
		if (typeString.equalsIgnoreCase("SECONDARY")) {
			return PhoneNumberType.SECONDARY;
		}

		return null;
	}

	/**
	 * @param s the string to analyze
	 * @return the analyzed string
	 */
	Boolean isValidPhoneNumber(String s) {
		return this.isTenDigits(this.stripNonNumeric(s));
	}

	/**
	 * @param s the raw string
	 * @return the numeric string
	 */
	String stripNonNumeric(String s) {
		// Bellow regex is from
		// https://stackoverflow.com/questions/10372862/java-string-remove-all-non-numeric-characters
		return s.replaceAll("[^\\d.]", "");
	}

	/**
	 * @param s the string to analyze
	 * @return true iff the strings length is exactly 10 chars
	 */
	Boolean isTenDigits(String s) {
		return s.length() == 10;
	}

	Boolean containsStr(String search) {
		return search.equalsIgnoreCase(this.extension) || search.equalsIgnoreCase(this.fullNumber)
				|| search.equalsIgnoreCase(this.type.toString());
	}

	/**
	 * 
	 */
	void printInfo() {
		System.out.println("Type is        " + this.type.toString());
		//System.out.println(this.fullNumber);
		System.out.println("Full number is " + "(" + this.fullNumber.substring(0, 3) + ")" + this.fullNumber.substring(3,  6) + "-" + this.fullNumber.substring(6));
		if (this.extension != "" && this.type != PhoneNumberType.FAX) {
			System.out.println("Extension is   " + this.extension);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PhoneNumber [" + (fullNumber != null ? "fullNumber=" + fullNumber + ", " : "")
				+ (extension != null ? "extension=" + extension + ", " : "") + (type != null ? "type=" + type : "")
				+ "]";
	}

}
