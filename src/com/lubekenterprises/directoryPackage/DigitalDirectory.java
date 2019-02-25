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

		// add(new Person(...))

		return al;
	}

	/**
	 * @param persons (will possibly be removed in the future)
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Room> generateFakeRoomsList(ArrayList<Person> persons) {

		ArrayList<Room> roomList = new ArrayList<Room>();
		//ArrayList<Person> pl = new ArrayList<Person>();
		//ArrayList<Person> pl2 = new ArrayList<Person>();

		// add(new Room(...))

		return roomList;
	}

	/**
	 * @return roomList, a populated ArrayList of type Room
	 */
	public static ArrayList<Department> generateFakeDepartmentsList() {

		ArrayList<Department> deptList = new ArrayList<Department>();

		// add(new Department(...))

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
	 * 
	 *             If there are 2 phone numbers for one room then the second number
	 *             will be displayed in notes section
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
					// With both email and notes
					roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants,
							new PhoneNumber(room[4], "primary"), room[5], room[6]));

				} catch (Exception e) {

					try {
						// With notes but no email
						roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants,
								new PhoneNumber(room[4], "primary"), null, room[6]));
					} catch (Exception e2) {
						try {
						// With email no notes
						roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants, new PhoneNumber(room[4], "PRIMARY"), room[5], null));
						}
						catch(Exception anotherDarnException) {
							// No email or notes
							roomAL.add(new Room(room[3], room[3].substring(0, 1), room[2], occupants, new PhoneNumber(room[4], "PRIMARY"), null, null));

						}
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

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<Resident> csvReaderResidents(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<Resident> resAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] resident = line.split(splitter);

				try {
					resAL.add(new Resident(resident[1], resident[0], new PhoneNumber(resident[3], "HOME"), resident[2],
							resident[4]));
				} catch (Exception e) {

					try { // no email
						resAL.add(new Resident(resident[1], resident[0], new PhoneNumber(resident[3], "HOME"),
								resident[2], null));
					} catch (Exception e2) { // no email or phone number
						resAL.add(new Resident(resident[1], resident[0], null, resident[2], null));
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
		return resAL;

	}

	/**
	 * @author https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
	 * @author Frank Lubek
	 * @param path path to CSV file
	 * 
	 *             Edited to suit my needs
	 */
	static ArrayList<BoardMember> csvReaderBoardMembers(String path) {
		String csvFile = path;
		BufferedReader br = null;
		String line = "";
		String splitter = ",";
		ArrayList<BoardMember> bmAL = new ArrayList<>();

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] boardMember = line.split(splitter);

				if (boardMember[0].contentEquals("end")) {
					return bmAL;
				}

				// All 3 phone numbers
				if (!boardMember[3].contentEquals("null") && !boardMember[5].contentEquals("null")
						&& !boardMember[7].contentEquals("null")) {

					if (boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]),
								new PhoneNumber(boardMember[5], boardMember[6]),
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]),
								new PhoneNumber(boardMember[5], boardMember[6]),
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], null));
					}
				}

				// home and work, no cell
				else if (!boardMember[3].contentEquals("null") && !boardMember[5].contentEquals("null")
						&& boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]),
								new PhoneNumber(boardMember[5], boardMember[6]), null, boardMember[9],
								boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]),
								new PhoneNumber(boardMember[5], boardMember[6]), null, boardMember[9], null));
					}
				}

				// home and cell, no work
				else if (!boardMember[3].contentEquals("null") && boardMember[5].contentEquals("null")
						&& !boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]), null,
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]), null,
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], null));
					}
				}

				// work and cell, no home
				else if (boardMember[3].contentEquals("null") && !boardMember[5].contentEquals("null")
						&& !boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null,
								new PhoneNumber(boardMember[5], boardMember[6]),
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null,
								new PhoneNumber(boardMember[5], boardMember[6]),
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], null));
					}
				}

				// home, no work or cell
				else if (!boardMember[3].contentEquals("null") && boardMember[5].contentEquals("null")
						&& boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]), null, null, boardMember[9],
								boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2],
								new PhoneNumber(boardMember[3], boardMember[4]), null, null, boardMember[9], null));
					}
				}

				// work, no home or cell
				else if (boardMember[3].contentEquals("null") && !boardMember[5].contentEquals("null")
						&& boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null,
								new PhoneNumber(boardMember[5], boardMember[6]), null, boardMember[9],
								boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null,
								new PhoneNumber(boardMember[5], boardMember[6]), null, boardMember[9], null));
					}
				}

				// cell, no home or work
				else if (boardMember[3].contentEquals("null") && boardMember[5].contentEquals("null")
						&& !boardMember[7].contentEquals("null")) {
					if (!boardMember[10].contentEquals("null")) {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null, null,
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], boardMember[10]));
					} else {
						bmAL.add(new BoardMember(boardMember[0], boardMember[1], boardMember[2], null, null,
								new PhoneNumber(boardMember[7], boardMember[8]), boardMember[9], null));
					}
				}

				else {
					System.err.println("Unable to enter board member " + boardMember[0] + " " + boardMember[1]
							+ " into database.");
				}

			}

			// else error

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
		return bmAL;

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

	static ArrayList<Resident> findAllResidents(String search, ArrayList<Resident> residents) {

		ArrayList<Resident> residentList = new ArrayList<>();

		for (Resident r : residents) {
			if (r.containsStr(search)) {
				residentList.add(r);
			}
		}

		return residentList;
	}

	static ArrayList<BoardMember> findAllBoardMembers(String search, ArrayList<BoardMember> members) {

		ArrayList<BoardMember> memberList = new ArrayList<>();

		for (BoardMember bm : members) {
			if (bm.containsStr(search)) {
				memberList.add(bm);
			}
		}

		return memberList;
	}

	static void printRooms(ArrayList<Room> rooms) {
		if (!rooms.isEmpty()) {
			System.out.println();
			System.out.println("****** Room/Resident Results ******");

		}
		for (Room r : rooms) {
			r.printInfo();
		}
	}

	// Is the below method used or deprecated?
	static void printPersons(ArrayList<Person> people) {
		System.out.println();
		for (Person p : people) {
			p.printInfo();
		}
	}

	static void printDepartments(ArrayList<Department> departmentList) {
		if (!departmentList.isEmpty()) {
			System.out.println();
			System.out.println("****** Department Results ******");
		}
		for (Department department : departmentList) {
			department.printInfo();
		}
	}

	static void printRadioNumbers(ArrayList<Radio> radioList) {

		if (!radioList.isEmpty()) {
			System.out.println();
			System.out.println("****** Radio Numbers ******");
		}
		for (Radio rad : radioList) {
			rad.printInfo();
		}
	}

	static void printEmployees(ArrayList<Employee> employeeList) {
		if (!employeeList.isEmpty()) {
			System.out.println();
			System.out.println("****** Employee Results ******");
		}
		for (Employee e : employeeList) {
			e.printInfo();
		}
	}

	static void printResidents(ArrayList<Resident> residentList) {

		if (!residentList.isEmpty()) {
			System.out.println();
			System.out.println("****** Residents Alpha Results ******");
		}
		for (Resident r : residentList) {
			r.printInfo();
		}
	}

	static void printBoardMembers(ArrayList<BoardMember> memberList) {
		if (!memberList.isEmpty()) {
			System.out.println();
			System.out.println("****** Board of Directors Results ******");
		}
		for (BoardMember bm : memberList) {
			bm.printInfo();
		}
	}

	static void printInitialMenu() {
		System.out.println();
		System.out.println("***********************************");
		System.out.println("Please select a category to search:");
		System.out.println("1. Rooms and Residents");
		System.out.println("2. Departments");
		System.out.println("3. Employees");
		System.out.println("4. Radio Numbers");
		System.out.println("5. External Services (Not Yet Implemented)");
		System.out.println("6. Board of Directors");
		System.out.println("0. All");
		System.out.println("***********************************");
		return;
	}


	/**
	 * @param rooms
	 * @param departments
	 * @param radios
	 * @param employees
	 * @param scanner
	 * @return
	 * 
	 * Note: All params shall have been initialized in main()
	 * 
	 */
	static int userInput(ArrayList<Room> rooms, ArrayList<Department> departments, ArrayList<Radio> radios,
			ArrayList<Employee> employees, ArrayList<BoardMember> boardMembers,
			Scanner scanner) {

		printInitialMenu();

		String searchString = scanner.nextLine();

		while (!searchString.equalsIgnoreCase("exit") && !searchString.equalsIgnoreCase("quit")) {

			if (searchString.equalsIgnoreCase("clear")) {
				System.out.println("\033[H\033[2J"); // this does not clear eclipse java console
			}

			try {

				switch (searchString) {

				case "1": // Rooms
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					ArrayList<Room> roomList = findAllRooms(searchString, rooms);
					printRooms(roomList);
					break;

				case "2": // Departments
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					ArrayList<Department> deptList = findAllDepartments(searchString, departments);
					printDepartments(deptList);
					break;

				case "3": // Employees
					System.out.println("Please enter search term:");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					ArrayList<Employee> empList = findAllEmployees(searchString, employees);
					printEmployees(empList);
					break;

				case "4": // Radios
					System.out.println("Please enter search term: ");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					ArrayList<Radio> rads = findAllRadios(searchString, radios);
					printRadioNumbers(rads);
					break;

				case "6": // Board of Directors
					System.out.println("Please enter search term: ");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					ArrayList<BoardMember> boardOfDirectors = findAllBoardMembers(searchString, boardMembers);
					printBoardMembers(boardOfDirectors);
					break;

				case "0": // All
					System.out.println("Please enter search term: ");
					searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					roomList = findAllRooms(searchString, rooms); // enable partial room number?? No for now because 12												// yields cottages too
					printRooms(roomList);
//					resList = findAllResidents(searchString, residents);
//					printResidents(resList);
					deptList = findAllDepartments(searchString, departments);
					printDepartments(deptList);
					empList = findAllEmployees(searchString, employees);
					printEmployees(empList);
					rads = findAllRadios(searchString, radios);
					printRadioNumbers(rads);
					boardOfDirectors = findAllBoardMembers(searchString, boardMembers);
					printBoardMembers(boardOfDirectors);
					break;

				default: // search all by default
					//System.out.println("Please enter search term: ");
					//searchString = scanner.nextLine();
					System.out.println("***********************************");
					System.out.println();
					searchString = capitalize(searchString);
					roomList = findAllRooms(searchString, rooms); // enable partial room number?? No for now because 12												// yields cottages too
					printRooms(roomList);
//					resList = findAllResidents(searchString, residents);
//					printResidents(resList);
					deptList = findAllDepartments(searchString, departments);
					printDepartments(deptList);
					empList = findAllEmployees(searchString, employees);
					printEmployees(empList);
					rads = findAllRadios(searchString, radios);
					printRadioNumbers(rads);
					boardOfDirectors = findAllBoardMembers(searchString, boardMembers);
					printBoardMembers(boardOfDirectors);
					break;
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
		//ArrayList<Person> persons;
		ArrayList<Department> departments;
		ArrayList<Radio> radios;
		ArrayList<Employee> emps;
		//ArrayList<Resident> residents;
		ArrayList<BoardMember> boardMembers;

		// User input will be needed
		Scanner scanner = new Scanner(System.in);

		{ // Create and populate databases (move to own method?)
			// ************************************** Export code to a class DirectoryHelper
			// and call methods **************************************


			// Build rooms and residents database
			rooms = csvReaderRooms("/Users/Admin/eclipse-workspace/Directory/TestData/resRoomsTestData.csv");

			// Build departments database
			departments = csvReaderDepartments("/Users/Admin/eclipse-workspace/Directory/TestData/departmentsTestData.csv");

			// Build radio numbers database
			radios = csvReaderRadioNumbers("/Users/Admin/eclipse-workspace/Directory/TestData/radiosTestData.csv");

			// Build employee database
			emps = csvReaderEmployees("/Users/Admin/eclipse-workspace/Directory/TestData/employeesTestData.csv");

			// Build board members database
			boardMembers = csvReaderBoardMembers("/Users/Admin/eclipse-workspace/Directory/TestData/board_of_directorsTestData.csv");
		}

		// User input
		userInput(rooms, departments, radios, emps, boardMembers, scanner);
	}

}
