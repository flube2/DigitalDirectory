/**
 * 
 */
package com.lubekenterprises.directoryPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Frank Lubek
 *
 */

public class DigitalDirectory {

	final static String ESC = "\033[";

	/**
	 * @return al, a populated ArrayList of type Person
	 */
	public static ArrayList<Person> generateFakePersonsList() {

		ArrayList<Person> al = new ArrayList<Person>();

		Person p = new Person("Bob", "Dylan", "bdylan@aol.com", "123 Oak Street, Hinsdale, IL, 60690",
				new PhoneNumber("1234567890", "HOME"), new PhoneNumber("1029383847", "cell"));
		Employee e = new Employee("Frank", "Lubek", "flubek@gmail.com", "9339 Monroe Ave, Brookfield, IL, 60513",
				new PhoneNumber("7084852700", "HOME"), null,
				new Department("Security", new PhoneNumber("7084315006", "work"),
						new PhoneNumber("7085886419", "office")),
				"Security Officer", "franklubek@plymouthplace.org", "C");
		// Resident r = new Resident("Matt", "McGoo", "gooBall@tuta.io", "315 N LaGrange
		// Road, LaGrange Park IL, 24689", new PhoneNumber("7085880105", "HOME"), null,
		// new Room("105", "1", "Independent Living", null, null), null, Boolean.FALSE,
		// null);
		// Patient pt = new Patient("George", "Sickly", null, null, new
		// PhoneNumber("7084820345", "HOME"), null, new Room("345", "3", "Medical",
		// null, "Room phone is listed as personal phone"), Bed.BedType.B, null);
		ArrayList<Person> ap = new ArrayList<Person>();
		ArrayList<Person> ap2 = new ArrayList<Person>();
		// ap.add(r);
		// r.room1.setOccupants(ap);
		// ap2.add(pt);
		// pt.room.setOccupants(ap2);

		al.add(p);
		al.add(e);
		// al.add(r);
		// al.add(pt);

		return al;
	}

/////////////////////////////////////////////////////////////////////////////////
	/**
	 * @param persons (will possibly be removed in the future)
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Room> generateFakeRoomsList(ArrayList<Person> persons) {

		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Person> pl = new ArrayList<Person>();
		ArrayList<Person> pl2 = new ArrayList<Person>();
		// pl.add(persons.get(2));

//		Room securityOffice = new Room("LL83", "LL", "Facilities", new ArrayList<Person>(persons.subList(0, 2)), null);
//		Room resident105 = new Room("105", "1", "Independent Living", pl, null); // this line does nothing
//		pl2.add(persons.get(3));
//		Room medical345 = new Room("345", "3", "Medical", pl2, null);

//		 roomList.add(securityOffice);
//		 roomList.add(resident105);
//		 roomList.add(medical345);
		return roomList;
	}

	/**
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Department> generateFakeDepartmentsList() {

		ArrayList<Department> deptList = new ArrayList<Department>();

		Department security = new Department("Security", new PhoneNumber("7084315006", "work"),
				new PhoneNumber("7085886419", "office"));
		Department maintenance = new Department("Maintenance", new PhoneNumber("7085886419", "office"));

		deptList.add(security);
		deptList.add(maintenance);
		return deptList;
	}

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<Room> csvReaderRooms(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<Room> roomAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] room = line.split(splitter);

				ArrayList<String> occupants = new ArrayList<String>();
				String[] sArr;

				String firstNames = room[1];
				String lastName = room[0];

				if (firstNames.contains("&")) { // Double Occupancy
					sArr = firstNames.split("&", 2);
					occupants.add(sArr[0].replaceAll("\\s", "") + " " + lastName);
					occupants.add(sArr[1].replaceAll("\\s", "") + " " + lastName);
				} else { // Single Occupancy
					occupants.add(firstNames + " " + lastName);
				}

				try {
					// If there are 2 phone numbers for one room than the second number will be
					// displayed in notes section
					roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants,
							new PhoneNumber(room[4], "primary"), room[5]));

				} catch (Exception e) {

					try {
						roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants,
								new PhoneNumber(room[4], "primary"), null));
					} catch (Exception e2) { // missing phone number
						roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants, null, null));
					}

				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return roomAL;

	}

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<Department> csvReaderDepartments(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<Department> deptAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] dept = line.split(splitter);

				try {
					deptAL.add(new Department(dept[0], new PhoneNumber(dept[2], "PRIMARY"),
							new PhoneNumber(dept[3], "SECONDARY"), dept[1]));
				} catch (Exception e) { // missing secondary phone number
					deptAL.add(new Department(dept[0], new PhoneNumber(dept[2], "PRIMARY"), dept[1]));
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return deptAL;

	}

	static void printDivider() {
		System.out.println();
		System.out.println("--------------------------------------");
		System.out.println();
	}

	static ArrayList<Department> findAllDepartments(String search, ArrayList<Department> departments) {

		ArrayList<Department> depts = new ArrayList<>();

		for (Department d : departments) {
			if (d.containsStr(search)) {
				depts.add(d);
			}
		}

		return depts;
	}

	static Room findRoomByRoomNumber(String roomNumber, ArrayList<Room> rooms) {

		for (Room room : rooms) {
			if (room.containsRoomNumber(roomNumber)) {
				return room;
			}
		}
		return null;
	}

	static ArrayList<Room> findAllRooms(String search, ArrayList<Room> rooms) {

		ArrayList<Room> roomList = new ArrayList<>();

		for (Room room : rooms) {
			if (room.containsStr(search)) {
				roomList.add(room);
			}
		}

		return roomList;
	}

	static void printRooms(ArrayList<Room> rooms) {
		System.out.println();
		for (Room r : rooms) {
			r.printInfo();
		}
	}

	static void printPersons(ArrayList<Person> people) {
		System.out.println();
		for (Person p : people) {
			p.printInfo();
		}
	}

	static void printDepartments(ArrayList<Department> departmentList) {
		System.out.println();
		for (Department department : departmentList) {
			department.printInfo();
		}
	}

	static void printInitialMenu() {
		System.out.println();
		System.out.println("Please select a category to search:");
		System.out.println("1. Rooms and Residents Numerical");
		System.out.println("2. Departments");
		return;
	}

	static int userInput(ArrayList<Room> rooms, ArrayList<Department> departments, Scanner scanner) {

		printInitialMenu();

		String searchString = scanner.nextLine();

		while (!searchString.equalsIgnoreCase("exit") && !searchString.equalsIgnoreCase("quit")) {

			if (searchString.equalsIgnoreCase("clear")) {
				System.out.println("\033[H\033[2J"); // this does not clear eclipse java console
			}

			try {

				switch (Integer.parseInt(searchString)) {

				case 1:
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					searchString = searchString.substring(0, 1).toUpperCase() + searchString.substring(1);
					ArrayList<Room> roomList = findAllRooms(searchString, rooms); // enable partial room number??
					// findRoomByRoomNumber("112", rooms).printInfo();
					printRooms(roomList);
					break;

				case 2:
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					searchString = searchString.substring(0, 1).toUpperCase() + searchString.substring(1);
					ArrayList<Department> deptList = findAllDepartments(searchString, departments);
					printDepartments(deptList);
					break;

				default:
					System.out.println("Invalid Selection");

				}

			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a category first");
			}
			printInitialMenu();
			searchString = scanner.nextLine();
		}

		return 0;
	}

	/**
	 * @author Frank Lubek
	 * @param args
	 */
	public static void main(String[] args) {

		// Declare necessary variables
		ArrayList<Room> rooms;
		ArrayList<Person> persons;
		ArrayList<Department> departments;
		Scanner scanner = new Scanner(System.in); // scanner.nextLine() to read input strings

		// Create and populate databases
		persons = generateFakePersonsList();
		// printPersons(persons);

		
//        rooms = generateFakeRoomsList(persons);
//        printRooms(rooms)
//        printDivider();

		// ArrayList<Department> depts = generateFakeDepartmentsList();
		// printDepartments(depts);

		// Build rooms database
		rooms = csvReaderRooms("/Users/Admin/eclipse-workspace/rooms.csv");
		// printRooms(rooms);
		// printDivider();

		// Build departments database
		departments = csvReaderDepartments("/Users/Admin/eclipse-workspace/departments.csv");
		// printDepartments(departments);

		// User input
		userInput(rooms, departments, scanner);
	}

}
