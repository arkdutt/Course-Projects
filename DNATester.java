//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  DNATester.java
// Course: CS300 Spring 2022
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


import java.util.NoSuchElementException;

/**
 * This tester implements various tester classes to check if P08 is functional.
 */
public class DNATester {

  /**
   * Tests enqueue() and dequeue() methods
   * @return if the two methods work correctly, false otherwise
   */
  public static boolean testEnqueueDequeue() {

    try {
      LinkedQueue <Character> queueTesting = new LinkedQueue <>();


      try {
        queueTesting.dequeue();
        System.out.println("ERROR! The dequeue() method cannot correctly handle" +
                " an empty queue");
        return false;
      } catch (NoSuchElementException e) {
      }


      queueTesting.enqueue('E');
      if (!(queueTesting.toString().trim().equals("E"))) {
        System.out.println("ERROR! The enqueue() method cannot add a Character to" +
                " an empty queue");
        return false;
      }


      if (!(queueTesting.dequeue().equals('E') && queueTesting.toString().trim().equals(""))) {
        System.out.println("ERROR! The dequeue() method cannot correctly remove a " +
                "Character from a valid queue with 1 Character");
      }

      queueTesting.enqueue('F');
      queueTesting.enqueue('G');
      queueTesting.enqueue('D');
      if (!(queueTesting.toString().trim().equals("F G D"))) {
        System.out.println("ERROR! The enqueue() method cannot correctly add " +
                "multiple Characters to a queue");
        return false;
      }

 
      if (!(queueTesting.dequeue().equals('F') && queueTesting.toString().trim().equals("G D"))) {
        System.out.println("ERROR! The dequeue() method cannot correctly remove a " +
                "Character from a valid queue with 1+ Characters");
        return false;
      }

      return true;

    } catch (Exception e) {
      System.out.println("An unknown exception occurred in the testEnqueueDequeue() method.");
      return false;
    }
  }

  
  
  
  
  /**
   * Tests size() and isEmpty() methods
   * @return true if the methods work correctly, false otherwise
   */
  public static boolean testQueueSize() {

    try {
      LinkedQueue<Character> sizeTestingX = new LinkedQueue<>();

      LinkedQueue<Character> sizeTestingY = new LinkedQueue<>();
      sizeTestingY.enqueue('A');
      sizeTestingY.enqueue('T');
      sizeTestingY.enqueue('B');

      // Tests size() for size = 0
      try {
        if (sizeTestingX.size() != 0) {
          return false;
        }
      } catch (Exception e) {
        System.out.println("ERROR! The size of sizeTester is incorrectly shown for " +
                "an empty queue");
      }

      // Tests isEmpty() for an empty queue (size == 0)
      try {
        if (!sizeTestingX.isEmpty()) {
          return false;
        }
      } catch (Exception e) {
        System.out.println("ERROR! The isEmpty() method is not working properly incorrectly");
      }

      // Tests size() for valid size > 0
      try {
        if (sizeTestingY.size() != 3) {
          return false;
        }
      } catch (Exception e) {
        System.out.println("ERROR! The size of sizeTester is incorrectly shown for " +
                "a valid queue");
      }

      // Tests isEmpty() for valid size > 0
      try {
        if (sizeTestingY.isEmpty()) {
          return false;
        }
      } catch (Exception e) {
        System.out.println("ERROR! The isEmpty() method does not work properly for a " +
                "non-empty queue");
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  
  
  
  
  /**
   * Tests the transcribeDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {

    // Tests a normal sequence
    DNA dnaBoolX = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mrnaBoolX = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    System.out.println(dnaBoolX.transcribeDNA().toString());
    if (!(dnaBoolX.transcribeDNA().toString().replaceAll(" ", "").equals(mrnaBoolX))) {
      return false;
    }

    // Tests an empty sequence
    DNA dnaBoolY = new DNA("");
    String mrnaBoolY = "";
    System.out.println(dnaBoolY.transcribeDNA().toString());
    if (!(dnaBoolY.transcribeDNA().toString().replaceAll(" ", "").equals(mrnaBoolY))) {
      return false;
    }
    return true;
  }


  
  
  /**
   * Tests the testMRNATranslate() method
   * @return true if the method is functional
   */
  public static boolean testMRNATranslate() {

    DNA dnaTestingX = new DNA("GGAGTCAGTTAAGCG");
    LinkedQueue <Character> mrnaTestingX = dnaTestingX.transcribeDNA();
    if (!(dnaTestingX.mRNATranslate(mrnaTestingX).toString().trim().
            replaceAll(" ", "").equals("PQSIR"))) {
      System.out.println("ERROR! the testMRNATranslate() method does not work for a valid case");
      return false;
    }
    
    DNA dnaTestingY = new DNA("GGAGTCAGTTAAGCGC");
    LinkedQueue <Character> mrnaTestingY = dnaTestingY.transcribeDNA();
    if (!(dnaTestingY.mRNATranslate(mrnaTestingY).toString().trim().
            replaceAll(" ", "").equals("PQSIR"))) {
      System.out.println("ERROR! the testMRNATranslate() method does not work for a valid case");
      return false;
    }

   
    DNA dnaTestingZ = new DNA("GGAGTCAGTATCTAAGCG");
    LinkedQueue <Character> mrnaTestingZ = dnaTestingZ.transcribeDNA();
    if (!(dnaTestingZ.mRNATranslate(mrnaTestingZ).toString().trim().
            replaceAll(" ", "").equals("PQS"))) {
      System.out.println("ERROR! the testMRNATranslate() method does not work for a valid case");
      return false;
    }
    return true;
  }

  
  
  /**
   * Tests the translateDNA() method
   * @return true if the method is functional
   */
  public static boolean testTranslateDNA() {


    DNA dnaTesting1 = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    System.out.println(dnaTesting1.translateDNA().toString());
    if (!(dnaTesting1.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD"))) {
      return false;
    }


    DNA dnaTesting2 = new DNA("");
    System.out.println(dnaTesting2.translateDNA().toString());
    if (!(dnaTesting2.translateDNA().toString().replaceAll(" ", "").equals(""))) {
      return false;
    }


    DNA dnaTesting3 = new DNA("GGAGTCAGTTA");
    System.out.println(dnaTesting3.translateDNA().toString());
    if (!(dnaTesting3.translateDNA().toString().replaceAll(" ", "").equals("PQS"))) {
      return false;
    }


    DNA dnaTesting4 = new DNA("GGAGTCACTAGTTAA");
    System.out.println(dnaTesting4.translateDNA().toString());
    if (!(dnaTesting4.translateDNA().toString().replaceAll(" ", "").equals("PQ"))) {
      return false;
    }

    return true;
  }

  /**
   * Runs all the tester methods
   *
   * @return true if all methods work, false otherwise
   */
  public static boolean All() {
    return (testTranslateDNA() && testEnqueueDequeue() && testTranscribeDNA()
            && testMRNATranslate() && testQueueSize());
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  public static void main(String[] args) {
	  
    System.out.println("Running all tests: " + All());
  }

}