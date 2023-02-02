//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: User.java
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
 * This class defines the abilities of a user to do within the class
 * AccessControl.java using various methods
 */

public class User {
	private final String USERNAME; // The name of the user
	private String password; // The password of the user
	private boolean isAdmin; // Whether or not the user has Admin powers

	/**
	 * With the given user name and admin status, this method creates a new user.
	 *
	 * @param username user name of the user
	 * @param password password of the user
	 * @param isAdmin  does the user has admin privileges
	 */
	public User(String username, String password, boolean isAdmin) {
		USERNAME = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	/**
	 * Reports whether the password is correct
	 *
	 * @param password password of the user used to login
	 * @return true if password matches field password/ is correct, false otherwise.
	 */
	public boolean isValidLogin(String password) {
		if (password.equals(this.password)) {
			return true;
		}
		return false;
	}

	/**
	 * It is a getter method for username
	 *
	 * @return USERNAME of the given user instance.
	 */
	public String getUsername() {
		return USERNAME;
	}

	/**
	 * It is a getter method for isAdmin Reports whether the user is an admin
	 *
	 * @return isAdmin boolean value representing admin privileges.
	 */
	public boolean getIsAdmin() {
		return isAdmin;
	}

	/**
	 * It is a setter method for password. It sets a new password
	 *
	 * @param password new version of password that needs to be set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * It is setter method for isAdmin Set the new admin status
	 *
	 * @param isAdmin new boolean value isAdmin will be set to.
	 */
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
