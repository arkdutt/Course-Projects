//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Application.java
// Course: CS 300 Spring 2022
//
// Author: Ark Dutt 
// Email: dutt3@wisc.edu
// Lecturer: Prof.Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a application with a name and due date
 */
public class Application implements Comparable<Application>{
    private final String name;  // name of this applicant
    private final String email; // email of this applicant
    private final int score;    // estimated score of this applicant
    
    /**
     * Creates a new Application with the given information
     *
     * @param name       name of this applicant
     * @param email      email of this applicant
     * @param score      estimated score of this applicant (must be in the range 0 .. 100)
     * @throws IllegalArgumentException if the provided name is null or blank, or if the email is
     *                                  null or does not have a single {@literal @}, or if score
     *                                  is not in the 0 .. 100 range.
     */
    public Application(String name, String email, int score) {
    	
    	// throws an IllegalArgumentException if the provided name is null or blank
    	if (name == null || name == "") {
    	      throw new IllegalArgumentException("ERROR! The provided name is null or blank!");
    	    }
    	
        // ... or if the provided email is null, or has no or multiple @
    	    if (email == null || email == "") {
    	      throw new IllegalArgumentException("ERROR! The email is null or blank!");
    	    }
    	    if (email.contains("@")) {
    	      int check = 0;
    	      for (int i = 0; i < email.length(); ++i) {
    	        if (email.charAt(i) == '@') {
    	          ++check;
    	        }
    	        if (check >= 2) {
    	          throw new IllegalArgumentException("ERROR! The email has too many @s!");
    	        }
    	      }
    	    } else {
    	      throw new IllegalArgumentException("ERROR! The email has no @!");
    	    }
    	    
            // ... or if the provided score is not in the 0 .. 100 range
    	    if (score < 0 || score > 100) {
    	      throw new IllegalArgumentException("ERROR! The score is not in the 0 to 100 range!");
    	    }
    	 // initialize values (TODO change these)
    	    this.name = name;
    	    this.email = email;
    	    this.score = score;
    }

    /**
     * Returns the name of this Applicant
     * 
     * @return the name of this Applicant
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the email of this Applicant
     * 
     * @return the email of this Applicant
     */
    public String getEmail() {
    	return this.email;
    }

    /**
     * Returns the score of this Applicant
     * 
     * @return the score of this Applicant
     */
    public int getScore() {
    	return this.score;
    }
    
    /**
     * 
     * Compares this Applicant to another applicant based on their score
     * 
     * @return a negative integer if this Applicant has an lower score, {@code 0} if the two
     *         Applicants have the same score, and a positive integer if this
     *         Applicant has a higher score.
     * @throws NullPointerException if the other assignment o is null
     */
    @Override
    public int compareTo(Application other) {
    	if (other == null) {
    	      throw new NullPointerException("ERROR! The other application is null!");
    	    }
    	    if (this.score < other.getScore()) {
    	      return -1;
    	    } else if (this.score == other.score) {
    	      return 0;
    	    } else {
    	      return 1;
    	    }
    }

    /**
     * Returns a String representing this Application containing its name, email and score.
     * (This implementation is provided for you.)
     * 
     * @return a String representing this Application
     */
    @Override
    public String toString() {
        return name + ":" + email + ":" + score;
    }
}