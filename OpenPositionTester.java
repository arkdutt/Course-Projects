//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: OpenPositionTester.java
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Application, 
 * ApplicationIterator, ApplicationQueue and OpenPosition classes in the assignment.
 *
 */
public class OpenPositionTester {
	
	 /**
     * Driver method defined in this OpenPositionTester class
     * 
     * @param args input arguments if any.
     */
    public static void main(String[] args) {
      System.out.println("Application: " + testApplication());
      System.out.println("ApplicationIterator: " + testApplicationIterator());
      System.out.println("Enqueue and Dequeue: " + testEnqueueDequeue());
      System.out.println("Common Methods: " + testCommonMethods());
      System.out.println("OpenPosition: " + testOpenPosition()); 
      System.out.println("runAllTests(): " + runAllTests());
      }
    
    /**
     * This method tests and makes use of the Application constructor, getter methods,
     * toString() and compareTo() methods.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testApplication() {
      // create an Application with valid input    
      try {
        Application app = new Application("Charlie", "charlie@wisc.edu", 85);
      } catch (Exception e){
        return false;
      }
      
      try {
        Application app = new Application("Charlie", "charlie@wisc.edu", 0);
      } catch (Exception e){
        return false;
      }
      
      try {
        Application app = new Application("Charlie", "charlie@wisc.edu", 90);
      } catch (Exception e){
        return false;
      }

      // create an Application with invalid input:
      try {
        // blank name
        Application app = new Application("", "charlie@wisc.edu", 85);
        return false;
      } catch (IllegalArgumentException e) {
          
      } catch(Exception e) {
          return false;
      }
      
        
      // null email
      try {
        Application app = new Application("Charlie", null, 85);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch(Exception e) {
          return false;
      }
      
        
      // no @ email
      try {
        Application app = new Application("Charlie", "charliewisc.edu", 85);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch(Exception e) {
          return false;
      }
        
      // too many @ email
      try {
        Application app = new Application("Charlie", "c@harlie@wisc@edu", 85);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch(Exception e) {
          return false;
      }
       
      // invalid score
      try {
        Application app = new Application("Charlie", "charlie@wisc.edu", -85);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch(Exception e) {
          return false;
      }
      
      try {
        Application app = new Application("Charlie", "charlie@wisc.edu", 120);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch(Exception e) {
          return false;
      }
      
      
      // verify getters
        Application app = new Application("Charlie", "charlie@wisc.edu", 85);
        
        if(!app.getName().equals("Charlie")) return false;
        
        if(!app.getEmail().equals("charlie@wisc.edu")) return false;
        
        if(app.getScore() != 85) return false;
      
        
      // verify compareTo
      try { 
        Application appX = new Application("Charlie", "charlie@wisc.edu", 75);
        Application appY = new Application("Charlie", "charlie@wisc.edu", 85);
        Application appZ = new Application("Charlie", "charlie@wisc.edu", 90);   
        
        if(!(app.compareTo(appZ) < 0)) return false;
        
        if(!(app.compareTo(appX) > 0)) return false;

        if(!(app.compareTo(appY) == 0)) return false;
              
      } catch (Exception e) {
        return false;
      }
      
      // verify toString
      String anticipatedApp = "Charlie:charlie@wisc.edu:85";  
      if (!app.toString().equals(anticipatedApp)) return false;          
        return true;
    }

    /**
     * This method tests and makes use of the ApplicationIterator class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testApplicationIterator() {
        // create an ApplicationQueue with capacity at least 3
        // and at least 3 Applications with different scores
      ApplicationQueue queue = new ApplicationQueue(3);
      Application appI = new Application("Charlie", "charlie@wisc.edu", 75);
      Application appJ = new Application("Ark", "dutt3@wisc.edu", 70);
      Application appK = new Application("Haley", "haley9@wisc.edu", 65);  
        
        // add those Applications to the queue
      queue.enqueue(appI);
      queue.enqueue(appJ);
      queue.enqueue(appK);
        
        // verify that iterating through the queue gives you the applications in order of
        // INCREASING score
      Iterator<Application> iter = queue.iterator();
      if(iter.next().compareTo(appK) != 0) return false;
      if(iter.next().compareTo(appJ) != 0) return false;
      if(iter.next().compareTo(appI) != 0) return false;
        
      return true;
    }
    
    /**
     * This method tests and makes use of the enqueue() and dequeue() methods
     * in the ApplicationQueue class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testEnqueueDequeue() {
        // create an ApplicationQueue with capacity 3
        // and at least 4 Applications with different scores
      ApplicationQueue queue = new ApplicationQueue(3);
      Application appA = new Application("Charlie", "charlie@wisc.edu", 85);
      Application appB = new Application("Ark", "dutt3@wisc.edu", 75);
      Application appC = new Application("Haley", "haley9@wisc.edu", 70);  
      Application appD = new Application("Hakan", "hakan@wisc.edu", 65);

        // enqueue an invalid value (null)
      try {
        queue.enqueue(null);
        return false;
      } catch(NullPointerException e) {
        
      } catch (Exception e) {
        return false;
      }
      
        // enqueue one valid application
      try {
        queue.enqueue(appA);
      } catch(NullPointerException e) {
        return false;
      } catch (Exception e) {
        return false;
      }
      
        // enqueue two more valid applications
      try {
        queue.enqueue(appB);
        queue.enqueue(appC);
      } catch(NullPointerException e) {
        return false;
      } catch (Exception e) {
        return false;
      }
       
        // enqueue one more application (exceeds capacity)
      try {
        queue.enqueue(appD);
      } catch(IllegalStateException e) {
        
      } catch (Exception e) {
        return false;
      }
        
        // dequeue one application (should be lowest score)
      try {
        if(queue.dequeue().compareTo(appC) != 0) return false;       
      } catch (Exception e) {
        return false;
      }

        // dequeue all applications
      try {
        if(queue.dequeue().compareTo(appB) != 0) return false;
        if(queue.dequeue().compareTo(appA) != 0) return false;    
      } catch (Exception e) {
        return false;
      }
        
        // dequeue from an empty queue
      try {
        queue.dequeue();
        return false;
      } catch (NoSuchElementException e) {
        
      } catch (Exception e) {
        return false;
      } 
     
        return true;
    }

    /**
     * This method tests and makes use of the common methods (isEmpty(), size(), peek())
     * in the ApplicationQueue class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testCommonMethods() {
        // create an ApplicationQueue with 0 capacity (should fail)
      try {
        ApplicationQueue incorrectQueue = new ApplicationQueue(0);
        return false;
       } catch (IllegalArgumentException e) {

       } catch (Exception e) {
         return false;
       }

        // create an ApplicationQueue with capacity 3
        // and at least 3 Applications with different scores
      ApplicationQueue queue = new ApplicationQueue(3);
      Application app1 = new Application("Charlie", "charlie@wisc.edu", 85);
      Application app2 = new Application("Ark", "dutt3@wisc.edu", 70);
      Application app3 = new Application("Haley", "haley9@wisc.edu", 65); 
        
        // verify the methods' behaviors on an empty queue   
      if(!queue.isEmpty()) return false;
      if(queue.size() != 0) return false;
      try {
        queue.peek();
        return false;
      } catch (NoSuchElementException e) {
        
      } catch (Exception e) {
        return false;
      }    

        // add one Application and verify the methods' behaviors
      queue.enqueue(app1);
      if(queue.isEmpty()) return false;
      if(queue.size() != 1) return false;
      if(queue.peek().compareTo(app1) != 0) return false;
        
        // add the rest of the Applications and verify the methods' behaviors
      queue.enqueue(app2);
      queue.enqueue(app3);
      if(queue.isEmpty()) return false;
      if(queue.size() != 3) return false;   
      if(queue.peek().compareTo(app3) != 0) return false;

      return true; 
    }

    /**
     * This method tests and makes use of OpenPosition class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testOpenPosition() {
        // create an OpenPosition with 0 capacity (should fail)
      try {
        OpenPosition invOpenP = new OpenPosition("Constructor", 0);
        return false;
      } catch (IllegalArgumentException e) {
        
      } catch (Exception e) {
        return false;
      }
      

        // create an OpenPosition with capacity 3
        // and at least 5 Applications with different scores
      OpenPosition validOP = new OpenPosition("Constructor", 3);
      Application appV = new Application("Charlie", "charlie@wisc.edu", 85);
      Application appW = new Application("Ark", "dutt3@wisc.edu", 75);
      Application appX = new Application("Haley", "haley9@wisc.edu", 70);  
      Application appY = new Application("Hakan", "hakan@wisc.edu", 65);
      Application appZ = new Application("Mimi", "mimipurr@wisc.edu", 60);    
        
        // verify that the 3 MIDDLE-scoring Applications can be added
        // don't use the highest and lowest scoring applications YET
      if(!validOP.add(appW)) return false;
      if(!validOP.add(appX)) return false;
      if(!validOP.add(appY)) return false;
      
        
        // verify that getApplications returns the correct value for your input
      String expectedApplications = "Hakan:hakan@wisc.edu:65\n" + "Haley:haley9@wisc.edu:70\n"
          + "Ark:dutt3@wisc.edu:75\n";
      if(!validOP.getApplications().equals(expectedApplications)) return false;
      
        // verify that the result of getTotalScore is the sum of all 3 Application scores
      if (validOP.getTotalScore() != 210) return false;      

        // verify that the lowest-scoring application is NOT added to the OpenPosition
      if (validOP.add(appZ)) return false;
      if (!validOP.getApplications().equals(expectedApplications)) return false;
       
        // verify that the highest-scoring application IS added to the OpenPosition
      if (!validOP.add(appV)) return false;
        
        // verify that getApplications has changed correctly
      expectedApplications = "Haley:haley9@wisc.edu:70\n" + "Ark:dutt3@wisc.edu:75\n"
          + "Charlie:charlie@wisc.edu:85\n";
      if (!validOP.getApplications().equals(expectedApplications)) return false;
      
        // verify that the result of getTotalScore has changed correctly
      if (validOP.getTotalScore() != 230) return false;
           
     return true;
    }
    
    /**
     * This method calls all the test methods defined and implemented in your OpenPositionTester class.
     * 
     * @return true if all the test methods defined in this class pass, and false otherwise.
     */
    public static boolean runAllTests() {
      if(testApplication() && testApplicationIterator() && testEnqueueDequeue()
          && testCommonMethods() && testOpenPosition()) {
        return true;
      }
      
      return false;
    }
}