//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: OpenPosition.java
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
 * A application handler of an open position using priority queue. Only saves a new Application
 * when the queue is not full, or when it can replace older, lower-scored ones with its higher
 * scores.
 */
public class OpenPosition {
	
	private String positionName;
    private ApplicationQueue applications; // the priority queue of all applications
    private int capacity;                  // the number of vacancies
    
    /**
     * Creates a new open position with the given capacity
     * 
     * @param capacity the number of vacancies of this position
     * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
     *                                  positive integer
     */
    public OpenPosition(String positionName, int capacity) {
    	
    	// verify the value of capacity
    	if (capacity <= 0) {
    	      throw new IllegalArgumentException("ERROR! Capacity is not a positive integer!");
    	    }
    	// initialize the data fields appropriately
    	    this.positionName = positionName;
    	    this.capacity = capacity;
    	    this.applications = new ApplicationQueue(capacity);

    	
    }
    
    public String getPositionName() { 
    	return this.positionName; 
    	}
    
    /**
     * Tries to add the given Application to the priority queue of this position.  return
     * False when the new Application has a lower score than the lowest-scored Application
     * in the queue.
     * 
     * @return Whether the given Application was added successfully
     */
    public boolean add(Application application) {
    	// if the queue is full, determine whether this application has a higher score than 
    	// the current lowest-scoring application; if not, do not add it
    	if (this.applications.size() >= this.capacity) {
    	      if (this.applications.peek().compareTo(application) < 0) {
    	        this.applications.dequeue();
    	        this.applications.enqueue(application);
    	        return true;
    	        }
    	   // TODO if there is room in the queue OR this application has a higher score than the current
    	    	// lowest-scoring application, add it to the queue
    	    } else {
    	      this.applications.enqueue(application);
    	      return true;
    	    }
    	    return false;
    	    }
    
    /**
     * Returns the list of Applications in the priority queue.
     * 
     * @return The list of Applications in the priority queue, in increasing order of the
     * scores.
     */
    public String getApplications() {
        return applications.toString();
    }
    
    /**
     * Returns the total score of Applications in the priority queue.
     * 
     * @return The total score of Applications in the priority queue.
     */
    public int getTotalScore() {
    	
        // calculate the total score of all applications currently in the queue	
    	int aggregateScore = 0;
        ApplicationQueue xScore = this.applications.deepCopy();
        for (int i = 0; i < this.applications.size(); i++) {
          aggregateScore += xScore.dequeue().getScore();
        }
        return aggregateScore;
      }
    
}