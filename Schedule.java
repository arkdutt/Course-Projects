//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Schedule.java
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


import java.util.Arrays;


/**
 * 
 * This class models an object to maintain the current draft schedule
 *
 */



public class Schedule {
	
  //an array of the Room objects available for exams
  private Room[] rooms;
  
  //an array of the Course objects which require exam rooms
  private Course[] courses;
  
  //an array where the integer at index N is the index of the room that
  //course[N] has been assigned to
  private int[] assignments;
  
  /**
   * Initialises the rooms and courses arrays to the provided
   * values, and creates an assignments array of the correct length where all values are -1, 
   * indicating that the corresponding course has not yet been assigned a room.
   * 
   * @param rooms an array of the Room objects available for exams
   * @param courses an array of the Course objects which require exam rooms
   */
  

  public Schedule(Room[] rooms, Course[] courses) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = new int[courses.length];
    for (int i = 0; i < assignments.length; ++i) {
      this.assignments[i] = -1;
    }
  }
  
  
  /**
   * 
   * 
   * a private constructor that initialises the rooms and
   * courses arrays to the provided values and assignments to the provided assignments array. May
   * assume the assignments array is the correct length (equal to the length of the courses array).
   * 
   * 
   * @param rooms an array of the Room objects available for exams
   * @param courses an array of the Course objects which require exam rooms
   * @param assignments an array where the integer at index N is the index of the room that 
   * course[N] has been assigned to
   */
  private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
    this.rooms = rooms;
    this.courses = courses;
    this.assignments = assignments;
  }

  /**
   * 
   * @return the number of rooms available in this schedule
   */
  public int getNumRooms() {
    return this.rooms.length;
  }
  
  /**
   * 
   * @param index
   * @return the Room object at the given index in the rooms array;
   * @throws an IndexOutOfBoundsException with a descriptive error message if the given index is invalid
   */ 
  public Room getRoom(int index) {
    try {
      return this.rooms[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("ERROR! The index is not valid!");
    }
  }
  
  /**
   * 
   * @return the number of courses in this schedule
   */
  public int getNumCourses() {
    return this.courses.length;
  }
  
  
  /**
   * 
   * @param index
   * @return the Course object at the given index in the courses array; 
   * @throws an IndexOutOfBoundsException with a descriptive error message if the given index is invalid
   */

  public Course getCourse(int index) {
    try {
      return this.courses[index];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("ERROR! The given index is not valid!");
    }
  }

  /**
   * 
   * 
   * @param index given index in the array
   * 
   * @return true if and only if the course at the given index has been assigned a room; 
   * false otherwise
   * 
   */
  public boolean isAssigned(int index) {
    return this.assignments[index] != -1;
  }

  


  /**
   * 
   * @return true if and only if all courses have been assigned to rooms; false otherwise
   * 
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; ++i) {
      if (this.assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }
  
  
  /**
   * 
   * @param index given index in the array
   * 
   * @throws IllegalArgumentException if the course has not been assigned a room
   * 
   * @throws IndexOutOfBoundsException with a descriptive error message if the given course index is invalid
   * 
   */
  public Room getAssignment(int index) {
    try {
      if (this.assignments[index] == -1) {
        throw new IllegalArgumentException("ERROR! The course has not been assigned a room");
      }
      return this.rooms[this.assignments[index]];
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("ERROR! The given index is not valid!");
    }
  }
  
  /**
   * 
   * 
   * 
   * @param iOne
   * 
   * @param iTwo
   * 
   * @return a NEW Schedule object with the course at the first argument index 
   * assigned to the room at the second argument index
   * 

   * 
   * @throws an IllegalArgumentException with a descriptive error message if the 
   * given course has already been assigned a room, or if the room does not have sufficient capacity.
   * 
   * @throws an IndexOutOfBoundsException with a descriptive error message 
   * if the given course or room index is invalid
   * 
   */
  public Schedule assignCourse(int iOne, int iTwo) {
    try {
      if (isAssigned(iOne)
          || this.rooms[iTwo].getCapacity() < this.courses[iOne].getNumStudents()) {
        throw new IllegalArgumentException(
            "ERROR! The given course has been assigned a room "
            + "or doesnt have sufficient space!");
      }
      Room[] newRooms = Arrays.copyOf(this.rooms, rooms.length);
      Course[] newCourses = Arrays.copyOf(this.courses, courses.length);
      int[] newAssignments = Arrays.copyOf(this.assignments, assignments.length);
      newAssignments[iOne] = iTwo;
      newRooms[iTwo] = newRooms[iTwo].reduceCapacity(courses[iOne].getNumStudents());
      return new Schedule(newRooms, newCourses, newAssignments);
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("ERROR! Index is not valid");
    }
  }

  /**
   * 
   * 
   * 
   */
  @Override
  public String toString() {
    String stringe = "{";
    for (int i = 0; i < courses.length; ++i) {
      if (assignments[i] == -1) {
        stringe +=
            this.courses[i].getName() + ": Unassigned, ";
      }else {
        stringe +=
            this.courses[i].getName() + ": " + this.rooms[assignments[i]].getLocation() + ", ";
      }
    }
    stringe =
        stringe.substring(0, stringe.lastIndexOf(", "));
    return stringe + "}";
  }

}