//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExamScheduler.java 
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

/**
 * 
 * This class incorporates a collection of static recursive utility 
 * methods to help create the Schedule
 *
 */

public class ExamScheduler {
	
	/**
	 * This method only contains  a call to the helper method, 
	 * providing an empty starting Schedule
	 * 
	 * @param rooms
	 * 
	 * @param courses
	 * 
	 * @returns a valid Schedule for the given set of rooms and courses
	 * 
	 * 
	 */
  public static Schedule findSchedule(Room[] rooms, Course[] courses) {
    return findScheduleHelper(new Schedule(rooms, courses), 0);
  }

  
  /**
   * a private, recursive method that assigns all unassigned 
   * courses in a Schedule beginning from the index provided
   * 
   * @param schedule
   * 
   * @param index
   * 
   * @throw an IllegalStateException if no such schedule exists.
   * 
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index) {
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        return schedule;
      }
      throw new IllegalStateException("ERROR! Schedule is not complete!");
    }
    if (schedule.isAssigned(index))
      return findScheduleHelper(schedule, index + 1);
    else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule newSchedule = schedule.assignCourse(index, i);
          return findScheduleHelper(newSchedule, index + 1);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      throw new IllegalStateException("ERROR! Schedule is not valid!");
    }
  }

  /**
   * 
   * @param rooms
   * 
   * @param courses
   * 
   * @return an ArrayList containing all possible Schedules for the given set of rooms and courses.
   * 
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    return findAllSchedulesHelper(new Schedule(rooms, courses), 0);
  }

  /**
   * 
   * a private, recursive method that assigns all unassigned
   * courses in a Schedule in ALL POSSIBLE ways, beginning from the index provided
   * 
   * @param schedule an object of Schedule
   * 
   * @param index
   * 
   * @throws IllegalStateException if the schedule is not complete
   * 
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    ArrayList<Schedule> schedules = new ArrayList<Schedule>();
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        schedules.add(schedule);
        return schedules;
      }
      throw new IllegalStateException("ERROR! The schedule is invalid!");
    }
    if (schedule.isAssigned(index)) {
      schedules.addAll(findAllSchedulesHelper(schedule, index + 1));
      return schedules;
    } else {
      for (int i = 0; i < schedule.getNumRooms(); i++) {
        try {
          Schedule newSchedule = schedule.assignCourse(index, i);
          schedules.addAll(findAllSchedulesHelper(newSchedule, index + 1));
        } catch (Exception e) {
          System.out.println(e);
        }
      }
      return schedules;
    }
  }
}
