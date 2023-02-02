//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 ShoppingCartTester
// Course:   CS300 Spring 2022
//
// Author:   Ark Dutt
// Email:    dutt3@wisc.edu
// Lecturer: Prof.Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

public class ShoppingCartTester {
	
	/**
	 * The ShoppingCartTester.java class uses tester methods 
	 * to check the validity of the methods
	 * in the ShoppingCart.java class through numerous test cases.
	 *
	 * @author Ark Dutt
	 *
	 * @return true if the program is right,
	 * otherwise false will be returned.
	 */
	public static boolean testLookupMethods() {

		// define test scenarios.
		// The item to find is at index 0 of the marketItems array
		
		String expectedOutput = "4030 Pepper $1.99";
		if (!ShoppingCart.lookupProductByName("Pepper").equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductByName() method " 
		+ "failed to return the expected output when passed Pepper as input");
			return false;
		}

		// The item can be found at the first index of the marketItems array
		if (!ShoppingCart.lookupProductById(4030).equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductById() method "
					+ "failed to return the expected output when passed the id " + "of Pepper as input");
			return false;
		}

		expectedOutput = "No match found";
		if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductByName() method "
					+ "failed to return the expected output when passed the name of "
					+ "a product not found in the market.");
			return false;
		}

		if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductById() method "
					+ "failed to return the expected output when passed the identifier"
					+ "of a product not found in the market.");
			return false;
		}

		// This is to find the last non- null position of the marketSize array
		expectedOutput = "4363 Cookie $9.5";
		if (!ShoppingCart.lookupProductByName("Cookie").equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductByName() method "
					+ "failed to return the expected output when cookie was passed as input");
			return false;
		}

		if (!ShoppingCart.lookupProductById(4363).equals(expectedOutput)) {
			System.out.println("Problem detected: Your lookupProductById() method "
					+ "failed to return the expected output when the id of cookie was passed as input");
			return false;
		}

		// This can be used to find the position of middle of the marketItems array
		expectedOutput = "4131 Butter $4.59";
		if (!ShoppingCart.lookupProductByName("Butter").equals(expectedOutput)) {
			System.out.println("Problem Detected: Your lookupProductByName() method "
					+ "failed to return the expected output when passed butter as input");
			return false;
		}

		if (!ShoppingCart.lookupProductById(4131).equals(expectedOutput)) {
			System.out.println("Problem Detected: Your lookupProductById() method "
					+ "failed to return the expected output when the ID of butter is passed");
			return false;
		}

		return true;
	}

	/**
	 * This checks the validity of the ShoppingCart.getProductPrice() method
	 *
	 * @return true when the test verifies a correct methodology, false otherwise
	 *
	 */

	public static boolean testGetProductPrice() {
		double expectedPrice = 1.59;
		if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
			return false;
		}
		return true;

	}

	/**
	 * This checks the validity of the ShoppingCart.getProductQuantity() method
	 *
	 * @returns true when the test verifies a correct methodology, false otherwise
	 *
	 */
	public static boolean testAddItemToCartContainsNbOccurances() {
		// define test scenarios
		// the item at index 0 is to be added
		String[] cart = new String[10];
		int size = 0;
		int expectedSize = 1;
		if (ShoppingCart.addItemToCart("Apple", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected output when passed Apple as input");
			return false;
		}
		if (!cart[0].equals("Apple")) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to add the item to the cart at the right position");
			return false;
		}
		cart = new String[] { "Apple", "Banana", "Milk", "Pizza" };
		size = 4;
		expectedSize = 4;
		if (ShoppingCart.addItemToCart("Eggs", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected output when passed Eggs as input");
			return false;
		}
		if (cart[3].equals("Eggs")) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to add item to the cart at the right position");
			return false;
		}
		// Assuming that the item to be added is at some arbitary position in the middle
		// of the
		// marketItem array
		cart = new String[] { "Milk", "Apple", "Banana", "Pizza", null, null };
		size = 4;
		expectedSize = 5;
		if (ShoppingCart.addItemToCart("Eggs", cart, size) != expectedSize) {
			System.out.println("Problem detected: Your addItemToCart() method "
					+ "failed to return the expected value when eggs was passed as an input");
			return false;
		}
		return true;
	}

	/**
	 * This checks the validity of the ShoppingCart.getCartTotal() method 
	 * through numerous test cases
	 *
	 * @returns true when the method is working, otherwise false is returned
	 *
	 */
	public static boolean testRemoveItem() {
		// define test scenarios
		// the item at index 0 is to be added
		String[] cart = new String[7];
		int size = 0;
		int expectedSize = 0;
		if (ShoppingCart.removeItem(cart, "Apple", size) != expectedSize) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected output when passed Apple as input");
			return false;
		}
		if (cart[0] != null) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");
			return false;
		}
		// Using this the last non-null position of the item from the cart is removed
		cart = new String[] { "Apple", "Banana", "Milk", "Pizza" };
		size = 4;
		expectedSize = 3;
		if (ShoppingCart.removeItem(cart, "Pizza", size) != expectedSize) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected output when passed Pizza as input");
			return false;
		}
		if (cart[3].equals("Eggs")) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");
			return false;
		}
		if (cart[3] != null) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");
			return false;
		}
		// The item to be removed is at some defined position in the middle of the
		// marketItem array
		cart = new String[] { "Milk", "Apple", "Banana", "Pizza", null, null };
		size = 4;
		expectedSize = 4;
		if (ShoppingCart.removeItem(cart, "Eggs", size) != expectedSize) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to return the expected value when eggs was passed as an input");
			return false;
		}
		if (cart[4] != null) {
			System.out.println("Problem detected: Your removeItem() method "
					+ "failed to remove item to the cart at the right position");
			return false;
		}
		return true;
	}

	/**
	 * This checks the validity of the ShoppingCart.getCartTotal() method 
	 * through numerous test cases
	 *
	 * @returns true when the method is working, otherwise false is returned
	 *
	 */
	public static boolean testCheckoutGetCartSummary() {
		
		String[] cart = new String[7]; // the array has 7 null references
		int size = 0;
		String expectedOutput = "";
		String actualOutput = ShoppingCart.getCartSummary(cart, size);
		if (!actualOutput.equals(expectedOutput)) {
			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when passed an empty cart");
			return false;
		}
		// when the cart contains dulpicate items
		cart = new String[] { "Apple", "Banana", "Milk", "Pizza", "Milk", "Milk" };
		size = 6; // because its a non-empty cart of size 5
		expectedOutput = "(3) Apple\n(1) Banana\n(1) Milk\n(1) Pizza\n";
		actualOutput = ShoppingCart.getCartSummary(cart, size);
		System.out.println(actualOutput);
		if (!actualOutput.equals(expectedOutput)) {
			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when the cart is passed with duplicate items");
			return false;
		}
		// when the cart contains unique items
		cart = new String[] { "Apple", "Banana", "Milk", "Pizza", null, null };
		size = 4; // because its a non-empty cart of size 4
		expectedOutput = "(1) Apple\n(1) Banana\n(1) Milk\n(1) Pizza\n";
		actualOutput = ShoppingCart.getCartSummary(cart, size);
		System.out.println(actualOutput);
		if (!actualOutput.equals(expectedOutput)) {
			System.out.println("Problem detected: Your getCartSummary() method "
					+ "failed to return the expected output when the cart is passed with unique items");
			return false;
		}
		return true;
	}

	/**
	 * This tester checks the validity of the ShoppingCart class
	 *
	 * @return true when the test verifies a correct methodology, false otherwise
	 *
	 */
	public static boolean runAllTests() {
		if ((!testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurances()
				&& testRemoveItem() && testCheckoutGetCartSummary())) {
			return false;
		}
		return true;
	}

	/**
	 * Main method
	 *
	 * @param args any input argument
	 */
	public static void main(String[] args) {

		System.out.println("runAllTests() = " + runAllTests());
	}
}
