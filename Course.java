//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  Course.java
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

public class Course {
	
	/**
	 * 
	 * This class models a container for course-related information
	 *
	 */
	
  //The name of the course
  private String name;
  
  //the number of students enrolled in the course
  private int numStudents;
  
  //initialises the data fields to the values of the arguments
  public Course(String name, int numStudents){
    this.name = name;
    this.numStudents = numStudents;
  }
  

  /**
   * @return the name of the course
   */
  public String getName() {
    return this.name;
  }
  
  
  /**
   * 
   * @return the number of students enrolled in this course
   */
  public int getNumStudents() {
    return this.numStudents;
  }
}