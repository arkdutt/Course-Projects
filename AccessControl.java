//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: AccessControl.java
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

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class defines an access control page using various methods.
 */
public class AccessControl {
	private static ArrayList<User> users; // An ArrayList of valid users
	private User currentUser; // Who is currently logged in, if anyone?
	private static final String DEFAULT_PASSWORD = "changeme"; // Default password given to new users or when
																// we reset a password of a specific user.
	public static void main(String[] args) {

	}
	
	/**
	 * 
	 * It is no-argument constructor
	 * Initializes arraylist users if null
	 * 
	 *
	 */
	public AccessControl() {
		User admin = new User("admin", "root", true);
		if (users == null) {
			users = new ArrayList<User>();
			users.add(admin);
		}
		currentUser = null;
	}

	/**
	 * Checks whether the given username and password are a correct
	 *
	 * @param username checks the username within the arraylist
	 * @param password checks whether the password corresponds to the user's
	 * @return true if username are password can be found in the
	 *         arraylist, or else it returns false.
	 */
	public static boolean isValidLogin(String username, String password) {
		if (username == null || password == null) {
			return false;
		}
		// check if the username or password are null. If they are, return false

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username) && users.get(i).isValidLogin(password)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method changes the password into a new password
	 *
	 * @param newPassword is a string value of the new password
	 */
	public void changePassword(String newPassword) {
		currentUser.setPassword(newPassword);
	}
	
	/**
	 * Sets the current user to the user with the given new username
	 * 
	 * @param username new username of the user that needs to be set to current user.
	 */
	public void setCurrentUser(String username) {
		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				currentUser = users.get(i);
			}
		}
	}

	/**
	 * The current user becomes null, making the user logout
	 */
	public void logout() {
		currentUser = null;
	}

	/**
	 * Creates a new user by adding a new instance of user to users arraylist.
	 * 
	 * @param username The username of the new user
	 * 
	 * @throws IllegalArgumentException if username is null or length is less than 5.
	 * 
	 * @return true if user was finally added, or else returns false
	 * 
	 * 
	 */
	public boolean addUser(String username) throws IllegalArgumentException {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}
		// checks if the current user is null or does not have admin privileges.
		// It returns false.

		if (username == null || username.length() < 5) {
			throw new IllegalArgumentException("ERROR!! username is null or its length is less than 5");
		}
		// if username is null or length is less than 5, throws IllegalArgumentException

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				throw new IllegalArgumentException("ERROR!! A user with that username already exists");
				// checks if there is a duplicate username.
			}
		}

		User newUser = new User(username, DEFAULT_PASSWORD, false);
		users.add(newUser);
		return true;
	}

	/**
	 * Creates a new user by adding a new instance of user to users arraylist.
	 * 
	 * @param username The username of the new user
	 * 
	 * @param isAdmin  Checks whether the given user has admin privileges.
	 * 
	 * @throws IllegalArgumentException if username is null or length is less than 5.
	 * 
	 * @return true if user finally added the new user, otherwise false.
	 * 
	 *                                  5.
	 */
	public boolean addUser(String username, boolean isAdmin) throws IllegalArgumentException {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}
		// returns false if current user in null or does not have admin privileges.

		if (username == null || username.length() < 5) {
			throw new IllegalArgumentException("ERROR!! username is null or its length is less than 5");
		}
		// if username is null or length is less than 5, throws IllegalArgumentException

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				throw new IllegalArgumentException("ERROR!! A user with that username already exists");
				// checks if there is a duplicate username.
			}
		}

		User newUser = new User(username, DEFAULT_PASSWORD, isAdmin);
		users.add(newUser);
		return true;
	}

	/**
	 * Removes a user from the users arraylist
	 * 
	 * @param username The username of the user that will be removed from users
	 * 
	 * @throws NoSuchElementException if username does not exist.
	 *                 arraylist.
	 * @return true if user was successfully removed otherwise false.
	 * 
	 */
	public boolean removeUser(String username) throws NoSuchElementException {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				users.remove(i);
				return true;
			}
		}
		throw new NoSuchElementException("ERROR: No such username exists.");
	}

	/**
	 * This method transfers admin privileges to a user.
	 * 
	 * @param username The username of the user that will be given admin privileges.
	 * 
	 * @return true if user was finally able to get admin privileges, or else return false.
	 * 
	 * @throws NoSuchElementException if the given username does not exist.
	 */
	public boolean giveAdmin(String username) throws NoSuchElementException {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}
		// returns false if currentuser is null or does not have admin privileges.

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				users.get(i).setIsAdmin(true);
				return true;
				// returns trues if successfully given.
			}
		}

		// if no such username exists, NoSuchElementException is thrown
		throw new NoSuchElementException("ERROR!! No match found");

	}

	/**
	 * Takes a user's admin privileges.
	 * 
	 * @param username The username of the user that will be whose admin privileges
	 *                 will be taken.
	 * @return true if user's admin privileges was successfully taken otherwise
	 *         false.
	 * @throws NoSuchElementException if username does not exist.
	 */
	public boolean takeAdmin(String username) {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				users.get(i).setIsAdmin(false);
				return true;
				// returns trues if the user's admin privileges were successfully taken.
			}
		}

		// if no such username exists, NoSuchElementException is thrown
		throw new NoSuchElementException("ERROR: No match found");
	}

	/**
	 * Resets a user's password to default password.
	 * 
	 * @param username The username of the user that will have its password reset.
	 * 
	 * @throws NoSuchElementException if username does not exist.
	 * 
	 * @return true if user's password was reset otherwise false.
	 * 
	 */
	public boolean resetPassword(String username) throws NoSuchElementException {
		if (currentUser == null || currentUser.getIsAdmin() == false) {
			return false;
		}

		for (int i = 0; i < users.size(); ++i) {
			if (users.get(i).getUsername().equals(username)) {
				users.get(i).setPassword(DEFAULT_PASSWORD);
				;
				return true;
			}
			// returns trues if the password is reset
		}

		// if no such username exists, NoSuchElementException is thrown
		throw new NoSuchElementException("ERROR!! No match found.");
	}

}