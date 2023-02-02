//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExamSchedulerTester.java
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



import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



/**
 * This class uses various tester methods and checks whether they are functional
 * 
 */

public class ExamSchedulerTester {
	
	
	/**
	 * This is the Main method which runs all the test cases
	 *
	 * @param args input arguments
	 */
	
	  public static void main(String[] args) {
		    System.out.println(testCourse());
		    System.out.println(testRoom());
		    System.out.println(testScheduleAccessors());
		    System.out.println(testAssignCourse());
		    System.out.println(testFindAllSchedules());
		    System.out.println(testFindSchedule());
		  }

	
	/**
	   * Checks Room() whether it is functional
	   * 
	   * @return true if tests pass, false otherwise
	   */
	  public static boolean testRoom() {
	    // Tests constructors
	    {
	      String testLocation = "Biology";
	      int testCapacity = 22;
	      try {
	        Room testRoom = new Room(testLocation, testCapacity);
	        if (!testRoom.getLocation().equals(testLocation)) {
	          System.out.println("ERROR! getName() method is not working!");
	          return false;
	        }
	        if (testRoom.getCapacity() != testCapacity) {
	          System.out.println("ERROR! getNumStudents() method is not working!");
	          return false;
	        }
	      } catch (Exception e) {
	        System.out.println("Invalid exception thrown!");
	        return false;
	      }
	    }
	    

	    {
	      String testLocation = "Computer Science";
	      int testCapacity = -34;


	      {
	        try {
	          Room testRoom = new Room(testLocation, testCapacity);
	        } catch (IllegalArgumentException e) {
	        } catch (Exception e) {
	          System.out.println("Invalid exception thrown!");
	          return false;
	        }
	      }
	    }

	    {
	      final String location = "Computer Science";
	      final int capacity = 34;
	      try {
	        Room room = new Room(location, capacity);
	        Room newRoom = room.reduceCapacity(12);
	        if (newRoom.getCapacity() != (capacity - 12)) {
	            System.out.println("ERROR! Room.reduceCapacity() is not working");
	            return false;
	          }
	        if (newRoom == room) {
	          System.out.println("ERROR! Room.reduceCapacity() cannot create a new Room object");
	          return false;
	        }
	      } catch (Exception e) {
	        System.out.println("Invalid exception thrown!");
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  
	  
  /**
   * Checks Course() method whether it is functional
   * 
   * @return true if tests pass, false otherwise
   */
  public static boolean testCourse() {
    {
      String testName = "Computer Science";
      int testNumStudents = 14;
      try {
        Course testCourse = new Course(testName, testNumStudents);
        if (!testCourse.getName().equals(testName)) {
          System.out.println("ERROR! getName() method is not working!");
          return false;
        }
        if (testCourse.getNumStudents() != testNumStudents) {
          System.out.println("ERROR! getNumStudents() method is not working!");
          return false;
        }
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }
    
    {
      String testName = "Computer Science";
      int testNumStudents = -23;
      try {
        Course testCourse = new Course(testName, testNumStudents);
      } catch (IllegalArgumentException e) {
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }
    return true;
  }


  /**
   * Checks the scheduleAccessors() method whether it is functional
   * 
   * @return true if tests pass, false otherwise
   */
  public static boolean testScheduleAccessors() {
    {

      int testRoomSize = 100;
      int testCourseSize = 50;
      Course[] testCourses = new Course[testCourseSize];
      Room[] testRooms = new Room[testRoomSize];
      

      try {
        Schedule testSchedule = new Schedule(testRooms, testCourses);


        if (testSchedule.getNumCourses() != testCourseSize) {
          return false;
        }
        if (testSchedule.getNumRooms() != testRoomSize) {
            return false;
          }
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }

    {
      
      int testCourseIndex = 20;
      int testRoomSize = 100;
      int testCourseSize = 70;
      int testRoomIndex = 90;
      
      Course[] testCourses = new Course[testCourseSize];
      Room[] testRooms = new Room[testRoomSize];
     
      testCourses[testCourseIndex] = new Course("Mathematics", 122);
      testRooms[testRoomIndex] = new Room("Anthropology", 111);
      

      try {
        Schedule schedule = new Schedule(testRooms, testCourses);
        
        Course newCourse = schedule.getCourse(testCourseIndex);
        if (newCourse.getNumStudents() != testCourses[testCourseIndex].getNumStudents()
            || !(newCourse.getName().equals(testCourses[testCourseIndex].getName()))) {
          System.out.println("ERROR! Schedule.getCourse() is not working!");
          return false;
        }
        
        Room newRoom = schedule.getRoom(testRoomIndex);
        if ((newRoom.getCapacity() != testRooms[testRoomIndex].getCapacity())
            || !(newRoom.getLocation().equals(testRooms[testRoomIndex].getLocation()))) {
          System.out.println("ERROR! Schedule.getRoom() is not working!");
          return false;
        }
        
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }

    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      Schedule testSchedule = ExamScheduler.findSchedule(testRooms, testCourses);
      if (!testSchedule.isComplete()) {
        System.out.println("ERROR! Schedule.isComplete() is not working!");
        return false;
      }
      if (!testSchedule.isAssigned(0)) {
        System.out.println("ERROR! Schedule.isAssigned() is not working!");
        return false;
      }
    }
    return true;
  }

  /**
   * Checks the assignCourse() method whether it is functional
   * 
   * @return true if tests pass, false otherwise
   */
  public static boolean testAssignCourse() {
    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      Schedule schedule = new Schedule(testRooms, testCourses);
      Schedule newSchedule = schedule.assignCourse(0, 2);
      if (!newSchedule.isAssigned(0)) {
        System.out.println("Schedule.assignCourse() failed!");
        return false;
      }
    }

   
    
    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      Schedule schedule = new Schedule(testRooms, testCourses);
      try {
        Schedule newSchedule = schedule.assignCourse(1, 2);
        return false;
      } catch (IllegalArgumentException e) {
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }


    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      Schedule schedule = new Schedule(testRooms, testCourses);
      try {
        Schedule newSchedule = schedule.assignCourse(100, 200);
        return false;
      } catch (IndexOutOfBoundsException e) {
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
    }
    return true;
  }
  
  /**
   * Checks the findAllSchedules() method whether it is functional
   * 
   * @return true if tests pass, false otherwise
   */
  public static boolean testFindAllSchedules() {
 // 1. Valid Course
    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};

      ArrayList<Schedule> schedules = ExamScheduler.findAllSchedules(testRooms, testCourses);
      String expectedSchedule1 = "{Anthropology: Philosophy, Mathematics: Business Studies, Chemistry: Physics}";
      String expectedSchedule2 = "{Anthropology: Philosophy, Mathematics: Business Studies, Chemistry: Physics}";
      for (Schedule schedule : schedules) {
        String strings = schedule.toString();
        if (!(strings.equals(expectedSchedule1) || strings.equals(expectedSchedule2))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Checks the findSchedule() method whether it is functional
   * 
   * @return true if tests pass, false otherwise
   */
  public static boolean testFindSchedule() {
    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      String expectedSchedule = "{Anthropology: Philosophy, Mathematics: Business Studies, Chemistry: Physics}";
      Schedule schedule = ExamScheduler.findSchedule(testRooms, testCourses);;
      if (!schedule.toString().equals(expectedSchedule)) {
        return false;
      }
    }

    {
      Course[] testCourses =
          new Course[] {new Course("Anthropology", 10), new Course("Mathematics", 60), new Course("Chemistry", 40)};
      Room[] testRooms =
          new Room[] {new Room("Physics", 50), new Room("Business Studies", 70), new Room("Philosophy", 20)};
      try {
        Schedule schedule = ExamScheduler.findSchedule(testRooms, testCourses);
        return false;
      } catch (IllegalStateException e) {
      } catch (Exception e) {
        System.out.println("Invalid exception thrown!");
        return false;
      }
      return true;
    }
  }
}