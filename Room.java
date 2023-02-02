//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Room.java
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
	 * 
	 * This class models a container for room-related information
	 *
	 */
	
public class Room {
	
  //the building and room number
  private String location;
  
  //the maximum number of people who can be in the room at a time
  private int capacity;
  

  /***
   * initialises the data fields to the values of the arguments.
   * 
   * @param location
   * @param capacity
   */
  public Room(String location, int capacity){
    this.location = location;
    this.capacity = capacity;
  }
  

  /**
   * 
   * @return the location of the room
   */
  public String getLocation() {
    return this.location;
  }
  

  /**
   * 
   * @return the capacity of the room
   */
  public int getCapacity() {
    return this.capacity;
  }
  

  /**
   * 
   * @param capacity
   * 
   * @return a new room object with the same location as this one, but 
   * with a capacity less than this one’s by the argument’s amount. 
   */
  public Room reduceCapacity(int capacity) {
    if(capacity > this.capacity) {
      throw new IllegalArgumentException("ERROR! The capacity is more than the actual capacity of the room!");
    }
    return new Room(this.location, this.capacity - capacity);
  }
}