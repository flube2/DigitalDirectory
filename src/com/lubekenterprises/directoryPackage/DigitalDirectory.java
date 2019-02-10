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

		return al;
	}

	/**
	 * @param persons (will possibly be removed in the future)
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Room> generateFakeRoomsList(ArrayList<Person> persons) {

		ArrayList<Room> roomList = new ArrayList<Room>();
		ArrayList<Person> pl = new ArrayList<Person>();
		ArrayList<Person> pl2 = new ArrayList<Person>();

		return roomList;
	}

	/**
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Department> generateFakeDepartmentsList() {

		ArrayList<Department> deptList = new ArrayList<Department>();

		return deptList;
	}

	static String capitalize(String s) {

		try {
			s = s.substring(0, 1).toUpperCase() + s.substring(1);
		} catch (Exception e) {
			// do nothing
		}
		return s;
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

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<Radio> csvReaderRadioNumbers(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<Radio> radioAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] radioNumber = line.split(splitter);

				try {
					radioAL.add(new Radio(radioNumber[0], radioNumber[1], radioNumber[2], radioNumber[3]));
				} catch (Exception e) { // missing last name
					radioAL.add(new Radio(radioNumber[0], radioNumber[1], radioNumber[2]));
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
		return radioAL;

	}

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<Employee> csvReaderEmployees(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<Employee> empAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] employee = line.split(splitter);

				try {
					empAL.add(new Employee(employee[1], employee[0], new PhoneNumber(employee[4], "PRIMARY"),
							employee[2], employee[5]));
				} catch (Exception e) { // missing email
					empAL.add(new Employee(employee[1], employee[0], new PhoneNumber(employee[4], "PRIMARY"),
							employee[2], null));
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
		return empAL;

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

	static ArrayList<Radio> findAllRadios(String search, ArrayList<Radio> radios) {

		ArrayList<Radio> radioList = new ArrayList<>();

		for (Radio radio : radios) {
			if (radio.containsStr(search)) {
				radioList.add(radio);
			}
		}

		return radioList;
	}

	static ArrayList<Employee> findAllEmployees(String search, ArrayList<Employee> employees) {

		ArrayList<Employee> employeeList = new ArrayList<>();

		for (Employee e : employees) {
			if (e.containsStr(search)) {
				employeeList.add(e);
			}
		}

		return employeeList;
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

	static void printRadioNumbers(ArrayList<Radio> radioList) {
		System.out.println();
		for (Radio rad : radioList) {
			rad.printInfo();
		}
	}

	static void printEmployees(ArrayList<Employee> employeeList) {
		System.out.println();
		for (Employee e : employeeList) {
			e.printInfo();
		}
	}

	static void printInitialMenu() {

		System.out.println();
		System.out.println("Please select a category to search:");
		System.out.println("1. Rooms and Residents Numerical");
		System.out.println("2. Residents Alpha (Not Yet Implemented)");
		System.out.println("3. Departments");
		System.out.println("4. Employees");
		System.out.println("5. Radio Numbers");
		System.out.println("6. External Services (Not Yet Implemented)");
		System.out.println("7. All (Not Yet Implemented)");

		return;
	}

	/**
	 * @param rooms
	 * @param departments
	 * @param rad
	 * @param scanner
	 * @param employees
	 * @return
	 * 
	 * 		1. Rooms and Residents Numerical 2. Residents Alpha 3. Departments 4.
	 *         Employees 5. Radio Call Numbers 6. External Services 7. All
	 */
	/**
	 * @param rooms
	 * @param departments
	 * @param radios
	 * @param employees
	 * @param scanner
	 * @return
	 */
	static int userInput(ArrayList<Room> rooms, ArrayList<Department> departments, ArrayList<Radio> radios,
			ArrayList<Employee> employees, Scanner scanner) {

		printInitialMenu();

		String searchString = scanner.nextLine();

		while (!searchString.equalsIgnoreCase("exit") && !searchString.equalsIgnoreCase("quit")) {

			if (searchString.equalsIgnoreCase("clear")) {
				System.out.println("\033[H\033[2J"); // this does not clear eclipse java console
			}

			try {

				switch (Integer.parseInt(searchString)) {

				case 1: // Rooms
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					searchString = capitalize(searchString);
					ArrayList<Room> roomList = findAllRooms(searchString, rooms); // enable partial room number??
					// findRoomByRoomNumber("112", rooms).printInfo();
					printRooms(roomList);
					break;

				case 3: // Departments
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					searchString = capitalize(searchString);
					ArrayList<Department> deptList = findAllDepartments(searchString, departments);
					printDepartments(deptList);
					break;

				case 4: // Employees
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					searchString = capitalize(searchString);
					ArrayList<Employee> empList = findAllEmployees(searchString, employees);
					printEmployees(empList);
					break;

				case 5: // Radios
					System.out.println("Please enter search term: ");
					searchString = scanner.nextLine();
					searchString = capitalize(searchString);
					ArrayList<Radio> rads = findAllRadios(searchString, radios);
					printRadioNumbers(rads);
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
		ArrayList<Radio> radios;
		ArrayList<Employee> emps;
		
		// User input will be needed
		Scanner scanner = new Scanner(System.in);

		{ // Create and populate databases (move to own method?)
			
			persons = generateFakePersonsList();
			// printPersons(persons);
	
			// Build rooms database
			rooms = csvReaderRooms("/Users/Admin/eclipse-workspace/rooms.csv");
	
			// Build departments database
			departments = csvReaderDepartments("/Users/Admin/eclipse-workspace/departments.csv");
	
			// Build radio numbers database
			radios = csvReaderRadioNumbers("/Users/Admin/eclipse-workspace/radios.csv");
	
			// Build employee database
			emps = csvReaderEmployees("/Users/Admin/eclipse-workspace/employees.csv");
		}
		
		// User input
		userInput(rooms, departments, radios, emps, scanner);
	}

}
