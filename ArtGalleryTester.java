//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ArtGalleryTester class - P09 Art Gallery
// Course:   CS 300 Spring 2022
//
// Author:   Ark Dutt
// Email:    dutt3@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Naman Parekh
// Partner Email:   ncparekh@wisc.edu
// Partner Lecturer's Name: Hobbes Legault
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 * 
 * @author Naman Parekh
 * @author Ark Dutt
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {
	  
	  Artwork artGalleryTest = new Artwork("Mona Lisa", 1945, 50.5);
	  Artwork artGalleryReplicate = new Artwork("Mona Lisa", 1945, 50.5);

	    if (artGalleryTest.compareTo(artGalleryReplicate) != 0) {
	      System.out.println("Error: The compareTo() method doesn't work");
	      return false;
	    }

	    Artwork artGalleryTest2 = new Artwork("Josue", 1944, 1.0);

	    if (artGalleryTest.compareTo(artGalleryTest2) == 0) {
	      System.out.println("Error: The compareTo() method doesn't work");
	      return false;
	    }
	    
	    Artwork artGalleryTest3 = new Artwork("The Lamp", 1946, 50.5);

	    if (artGalleryTest3.compareTo(artGalleryTest) < 0) {
	      System.out.println("Error: The compareTo() method doesn't work");
	      return false;
	    }

	    Artwork artGalleryTest4 = new Artwork("Starry Night", 1945, 150);
	    Artwork artGalleryTest5 = new Artwork("Starry Night", 1945, 76);

	    if (artGalleryTest5.compareTo(artGalleryTest4) > 0) {
	      System.out.println("Error: The compareTo() method doesn't work");
	      return false;
	    }

	    if (!(artGalleryTest.equals(artGalleryReplicate))) {
	      System.out.println("Error: The equals() method doesn't work");
	    }

	    if (artGalleryTest.equals(artGalleryTest3)) {
	      System.out.println("Error: The equals() method doesn't work");
	      return false;
	    }

	    return true; // returns true if all test cases pass, returns false otherwise.
  }
	  
  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
	  
	 // (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
	    // and that its string representation is an empty string "".
	    
	    ArtGallery artGalleryTest = new ArtGallery();
	    
	    if (!(artGalleryTest.isEmpty())) {
		      System.out.println("Error: The isEmpty() method doesn't work");
		      return false;
		    }
	    
	    if (artGalleryTest.size() != 0) {
		      System.out.println("Error: The size() method doesn't work");
		      return false;
		    }
	    
	    if (!(artGalleryTest.toString().equals(""))) {
	      System.out.println("Error: The equals() method doesn't work");
	      return false;
	    }
	    
	 // (2) try adding one artwork and then
	 // check that the addArtwork() method call returns true, the tree is not empty
	 // ,its size is 1 and the .toString() called on the tree returns the expected output.
	    
	    
	    int year = 1945;
	    double cost = 50.5;
	    String name = "Mona Lisa";
	    
	    Artwork artWorkTest = new Artwork(name, year, cost);
	    
	    if (!(artGalleryTest.addArtwork(artWorkTest))) {
	      System.out.println("Error: The addArtwork() method doesn't work");
	      return false;
	    }
	    if (artGalleryTest.isEmpty()) {
	      System.out.println("Error: The isEmpty() method doesn't work.");
	      return false;
	    }
	    if (artGalleryTest.size() != 1) {
	      System.out.println("Error: The size() method doesn't work.");
	      return false;
	    }

	    // Tests for 3, 4, 5 and 6 
	   
	    artGalleryTest.addArtwork(new Artwork("The Horse", year - 1, cost - 1));
	    artGalleryTest.addArtwork(new Artwork("NightHawk", year + 1, cost + 1));
	    artGalleryTest.addArtwork(new Artwork("The Sweeper", year - 2, cost - 2));
	    artGalleryTest.addArtwork(new Artwork("Tostitos", year + 2, cost + 2));
	    
	    if (!(artGalleryTest.toString()
			       .equals("[(Name: The Sweeper) (Year: 1943) (Cost: $48.5)]\n"
			        		+ "[(Name: The Horse) (Year: 1944) (Cost: $49.5)]\n"
			        		+ "[(Name: Mona Lisa) (Year: 1945) (Cost: $50.5)]\n"
			        		+ "[(Name: NightHawk) (Year: 1946) (Cost: $51.5)]\n"
			        		+ "[(Name: Tostitos) (Year: 1947) (Cost: $52.5)]"))){
	    	
	    
	      
	      System.out.println("Error: The toString() method doesn't work.");
	      return false;
	    }
	    
	    if (artGalleryTest.size() != 5) {
	      System.out.println("Error: The size() method doesn't work.");
	      return false;
	    }
	    
	    return true; // returns true if all test cases pass, returns false otherwise.
  }
	  
    
    

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
		
	  // (1) Create a new ArtworkGallery. Then, check that calling the lookup() method 
	  // on an empty ArtworkGallery returns false. 
	   
		ArtGallery artGalleryTest = new ArtGallery();
		
	  // (2) Consider a ArtworkGallery of height 3 which lookup at least 5 artwork. Then, 
	  // try to call lookup() method to search for the artwork having a match at the root of the tree.
		
		artGalleryTest.addArtwork(new Artwork("Mona Lisa", 1945, 50.5));
		artGalleryTest.addArtwork(new Artwork("The Horse", 1944, 49.5));
		artGalleryTest.addArtwork(new Artwork("NightHawk", 1946, 51.5));
		artGalleryTest.addArtwork(new Artwork("The Sweeper", 1943, 48.5));
		artGalleryTest.addArtwork(new Artwork("Tostitos", 1947, 52.5));
		
		if (!(artGalleryTest.lookup("Mona Lisa", 1945, 50.5))) {
			System.out.println("Error: The lookup() method doesn't work");
			return false;
		}
		
	    if (!(artGalleryTest.lookup("Tostitos", 1947, 52.5))) {
	    	System.out.println("Error: The lookup() method doesn't work");
			return false;
		}
	    
	    return true; // returns true if all test cases pass, returns false otherwise.
  }
	
 /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. 
   *               (*) 
   *              /  \ 
   *            (*)  (*) 
   *             \   / \ 
   *            (*) (*) (*) 
   *                    / 
   *                   (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
	  
	  ArtGallery artGalleryTest = new ArtGallery();
	  
	  if (artGalleryTest.height() != 0) {
		  System.out.println("Error: The height() method doesn't work");
		  return false;
	  }
	  
	  artGalleryTest.addArtwork(new Artwork("Mona Lisa", 1945, 50.5));
	  
	  if (artGalleryTest.height() != 1) {
		  System.out.println("Error: The height() method doesn't work");
		  return false;
	  }
	  
	  artGalleryTest.addArtwork(new Artwork("Mona Lisa Duplicate 2", 1944, 51.5));
	  artGalleryTest.addArtwork(new Artwork("Mona Lisa Duplicate 3", 1943, 49.5));
	  artGalleryTest.addArtwork(new Artwork("Mona Lisa Duplicate 4", 1942, 48.5));
	  
	  if (artGalleryTest.height() != 4) {
		  System.out.println("Error: The height() method doesn't work");
		  return false;
	  }
	  
	  return true; // returns true if all test cases pass, returns false otherwise.
  }
			  
  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
	 
	  ArtGallery artGalleryTest = new ArtGallery();
	    
	  Artwork artGalleryTree = new Artwork("Mona Lisa Duplicate 2", 1944, 51.5);
	  Artwork artGalleryTree2 = new Artwork("Mona Lisa Duplicate 2", 1950, 60.0);
	  
	  artGalleryTest.addArtwork(artGalleryTree);
	  artGalleryTest.addArtwork(artGalleryTree2);
	  
	  if (artGalleryTest.getBestArtwork() != artGalleryTree2) {
		  System.out.println("Error: The getBestArtwork() method doesn't work");
		  return false;
	    }
	    
	    return true; // returns true if all test cases pass, returns false otherwise.
  }
  
  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on an empty tree. (2) Ensures that the
   * ArtworkGallery.lookupAll() method returns an array list which contains all the artwork satisfying
   * the search criteria of year and cost, when called on a non empty artwork tree with one match,
   * and two matches and more. Vary your search criteria such that the lookupAll() method must check
   * in left and right subtrees. (3) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
	  
	  ArtGallery artGalleryTest = new ArtGallery();
	    
	  ArrayList<Artwork> artArrayTester = new ArrayList<>();
	  ArrayList<Artwork> lookUpTester = new ArrayList<>();
	    
	  if (artArrayTester == artGalleryTest.lookupAll(1945, 52.5)) {
	      System.out.println("Error: The lookupAll() method doesn't work");
	      return false;
	    }
	    
	  Artwork tester1 = new Artwork("Lost", 1942, 50.5);
	  Artwork tester2 = new Artwork("Second tester",1943, 51.5);
	  Artwork tester3 = new Artwork("Third tester", 1944, 52.5);
	    
	  artGalleryTest.addArtwork(tester1);
	  artGalleryTest.addArtwork(tester2);
	  artGalleryTest.addArtwork(tester3);
	  lookUpTester.add(tester1);
	  lookUpTester.add(tester2);
	  lookUpTester.add(tester3);
	    
	  if (artGalleryTest.lookupAll(1945, 52.5) == lookUpTester) {
	      System.out.println("Error:The lookupAll() method doesn't work");
	      return false;
	    }
	  
	  return true; // Default return statement added to resolve compiler errors
  }
  
  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
	  
	  // (1) Buying artwork that is at leaf node 
	  
	  try {
	      
		  ArtGallery artGalleryTest = new ArtGallery();
		  Artwork[] artArrayTester = new Artwork[] {
				  new Artwork("Whistler", 1871, 100), new Artwork("Guernica", 1868, 45),
				  new Artwork("Gothic", 1870, 550), new Artwork("Cantabrico", 1876, 1000), 
				  new Artwork("Amazone", 1873, 625)};

	      for (Artwork addArtToArray : artArrayTester) {
	        artGalleryTest.addArtwork(addArtToArray);
	      }

	      artGalleryTest.buyArtwork("Guernica", 1868, 45);
	      String current =
	          "[(Name: Gothic) (Year: 1870) (Cost: $550.0)]\n"
	          + "[(Name: Whistler) (Year: 1871) (Cost: $100.0)]\n"
	          + "[(Name: Amazone) (Year: 1873) (Cost: $625.0)]\n"
	          + "[(Name: Cantabrico) (Year: 1876) (Cost: $1000.0)]";
	      
	      if (!(artGalleryTest.toString().equals(current))) {
	        return false;
	      }
	  }
	       catch (Exception err) {
	    	   return false;
	    }


	    // (2) Buying artwork at non-leaf node
	    
	    ArtGallery artGalleryTest = new ArtGallery();
	    Artwork[] artArrayTester = new Artwork[] {
	    		new Artwork("Torices", 1871, 100), new Artwork("Torices", 1868, 45),
				new Artwork("Torices", 1870, 550), new Artwork("Torices", 1876, 1000), 
				new Artwork("Torices", 1873, 625)};

	    for (Artwork addArtToArray : artArrayTester) {
	      artGalleryTest.addArtwork(addArtToArray);
	    }
	    
	    artGalleryTest.buyArtwork("Torices", 1871, 100.0);

	    if (artGalleryTest.size() != 4) {
	      System.out.println("Error: The buyArtwork() method doesn't work");
	      return false;
	    }

	    // (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
	    // when called on an artwork that is not present in the BST
	    
	    boolean exceptionInArt = false;
	    
	    try {
	      
	      artGalleryTest.buyArtwork("Dali", 1456, 783);
	    } 
	    catch (NoSuchElementException err) {
	      exceptionInArt = true;
	    }

	    return exceptionInArt; 
  }

	 
  
  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
	  
	  return testArtworkCompareToEquals() && testAddArtworkToStringSize() && testLookup() && 
			  testLookupAll() && testGetBestArtwork() & testHeight() && testBuyArtwork();
  }
  
  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
   public static void main(String[] args) {
		    System.out.println("testArtworkCompareToEquals(): " + testArtworkCompareToEquals()); 
			System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
		    System.out.println("testLookup(): " + testLookup());
		    System.out.println("testHeight(): " + testHeight());
		    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
		    System.out.println("testLookupAll(): " + testLookupAll());
		    System.out.println("testBuyArtwork(): " + testBuyArtwork());
		    System.out.println("runAllTests(): " + runAllTests());
		  }
}
		
	 
	  
	  
  


