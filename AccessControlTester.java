import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Access Control Tester
// Course: CS 300 Spring 2022
//
// Author: 		Ark Dutt
// Email: 		dutt3@wisc.edu
// Lecturer: 	Prof.Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class tests the AccessControl class through various tester methods
 */
public class AccessControlTester {

	/**
	 * Main method runs runAllTests() method.
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		System.out.println(runAllTests());
	}

	/**
	 * runs all the tester methods within this class
	 *
	 * @return true if all tests pass, false if any of the tests fail.
	 */
	public static boolean runAllTests() {
		if (!(testUserConstructorAndMethods() && testAccessControlIsValidLoginNotValidUser()
				&& testAddUserWithNoAdminPowers() && testAddRemoveUserWithAdminPowers())) {
			return false;
		}

		return true;
	}

	/**
	 * runs testers methods for the user constructor method and other methods within the
	 * class.
	 *
	 * @return true if all tests pass, false if any of the tests fail.
	 */
	public static boolean testUserConstructorAndMethods() {
		User ark = new User("ark", "password", false);
		if (!(ark.getUsername().equals("ark") && ark.getIsAdmin() == false && ark.isValidLogin("password") == true)) {
			return false;
		}

		// checks if setPassword method
		ark.setPassword("youaredabest");
		if (!(ark.isValidLogin("youaredabest"))) {
			return false;
		}

		// checks setIsAdmin method
		ark.setIsAdmin(true);
		if (!(ark.getIsAdmin() == true)) {
			return false;
		}

		// returns true if all tester methods pass
		return true;
	}

	/**
	 * runs tests for isValidLogin Method in the access control class
	 *
	 * @return true if all tests pass, false if any of the tests fail.
	 */
	public static boolean testAccessControlIsValidLoginNotValidUser() {
		AccessControl terminal = new AccessControl();
		terminal.setCurrentUser("admin");
		terminal.addUser("Christiano");
		terminal.addUser("Alabama");
		terminal.addUser("Rutherford");

		terminal.setCurrentUser("Christiano");
		terminal.changePassword("passsword");
		// checks if isValidLogin is working if correct values are passed in.
		if (AccessControl.isValidLogin("Christiano", "passsword") != true) {
			System.out.println("ERROR!! isValidLogin failed to return correct value!");
			return false;
		}

		// checks if isValidLogin is working if wrong values are passed in.
		if (AccessControl.isValidLogin("ark", "password") != false) {
			System.out.println("ERROR!! isValidLogin failed to return correct value!");
			return false;
		}

		// checks if isValidLogin is working if null values are passed in.
		if (AccessControl.isValidLogin(null, null) != false) {
			System.out.println("ERROR!! isValidLogin failed to return correct value!");
			return false;
		}

		terminal.setCurrentUser("Alabama");
		terminal.changePassword("Aniston");

		// checks if isValidLogin is working if string values are passed in.
		if (AccessControl.isValidLogin("Alabama", "Aniston") != true) {
			System.out.println("ERROR!! isValidLogin failed to return correct value!");
			return false;
		}

		terminal.setCurrentUser("Rutherford");
		terminal.changePassword("Rachel");
		if (AccessControl.isValidLogin("Rutherford", "Rachel") != true) {
			System.out.println("ERROR!! isValidLogin failed to return correct value!");
			return false;
		}

		return true;
	}
	
	/**
	 * runs tests for addUser and removeUser Method withing the AccessControl class
	 *
	 * @return true if all tests pass, false if any of the tests fail.
	 */
	public static boolean testAddRemoveUserWithAdminPowers() {
		AccessControl terminal = new AccessControl();
		terminal.setCurrentUser("admin");
		terminal.addUser("Madonna", true);
		terminal.setCurrentUser("Madonna");
		// checks if correct value returns with user with admin privileges.
		if (terminal.addUser("Russians", false) != true) {
			return false;
		}

		if (terminal.removeUser("Russians") != true) {
			return false;
		}
		
		// checks if username of less than length 5 returns correct exception - NoSuchElementException
		try {
			terminal.addUser("hmm");
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			return false;
		}

		// checks if addUser is working if duplicate values are passed in.
		
		terminal.setCurrentUser("admin");
		try {
			terminal.addUser("what");
			return false;
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			return false;
		}

		// checks if NoSuchElementException is thrown correctly and the code is working by returning true
		try {
			terminal.removeUser("hittiler");
			return false;
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * runs tests for the addUserMethod within the access control class.
	 *
	 * @return true if all tests pass
	 */
	public static boolean testAddUserWithNoAdminPowers() {
		AccessControl terminal = new AccessControl();
		terminal.setCurrentUser("admin");
		terminal.addUser("Edison", false);
		terminal.setCurrentUser("Edison");

		if (terminal.addUser("Alice") != false) {
			return false;
		}
		if (AccessControl.isValidLogin("Alice", "changeme") != false) {
			return false;
		}

		return true;
	}

}