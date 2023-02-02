//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ExceptionalShoppingCartTester.java
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
 * The ExceptionalShoppingCart.java implements various methods for the items in the cart
 * 
 * The ExceptionalShoppingCartTester.java class uses tester methods 
 * to check the validity of the methods
 * in the ExceptionalShoppingCart.java class through numerous test cases.
 * 
 * 
 * @author Ark Dutt
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;
import java.util.Scanner;
import java.util.Arrays;

public class ExceptionalShoppingCartTester {

	/**
	 * This is the Main method which runs all the test cases through runAllTests()
	 *
	 * @param args input arguments
	 */
	public static void main(String[] aregs) {
		System.out.print(runAllTests());
	}

	/**
	 * Checks whether ExceptionalShoppingCartTester.lookupProductByName() and
	 * ExceptionalShoppingCartTester.lookupProductById() methods are functional
	 * through multiple test cases
	 *
	 * @return true when this test case is functional, and false if it does not work
	 */
	public static boolean testLookupMethods() {

		try {
			ExceptionalShoppingCart.lookupProductByName("Ice Cream & Grape");
			System.out.println("lookupProductByName() failed: did not throw an exception");
			return false;
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			System.out.println("lookupProductByName() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.lookupProductById(456);
			System.out.println("lookupProductById() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("lookupProductById() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.lookupProductById(4557);
			System.out.println("lookupProductById() failed: did not throw an exception");
			return false;
		} catch (NoSuchElementException e) {
		} catch (Exception e) {
			System.out.println("lookupProductById() failed: threw an unchecked exception");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether ExceptionalShoppingCart.addItemToMarketCatalog method is
	 * functional.
	 *
	 * @return true when this test case is functional, and false if it does not work
	 */
	public static boolean testAddItemToMarketCatalog() {
		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("456s", "Ice Cream & Grape", "$0.73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("456", "Ice Cream & Grape", "$0.73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("4557", null, "$0.73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("4557", "", "$0.73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("4557", "Ice Cream & Grape", "$0.s73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}

		try {
			ExceptionalShoppingCart.addItemToMarketCatalog("4557", "Ice Cream & Grape", "0.73");
			System.out.println("addItemToMarketCatalog() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("addItemToMarketCatalog() failed: threw an unchecked exception");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether ExceptionalShoppingCart.saveCartSummary method is functional
	 * 
	 * @return true when this test case is functional, and false if it does not work
	 */
	public static boolean testSaveCartSummary() {
		try {
			String[] cart = { "Avocado", "Banana", "Cucumber", "Onion", null };
			int size = -4;
			File file = new File("Cart.txt");
			ExceptionalShoppingCart.saveCartSummary(cart, size, file);
			System.out.println("saveCartSummary() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println("saveCartSummary() failed: threw an unchecked exception");
			return false;
		}

		try {
			String[] testCart = { "Avocado", "Banana", "Cucumber", "Onion", null };
			int size = 4;
			File myFile = new File("Cart.txt");
			ExceptionalShoppingCart.saveCartSummary(testCart, size, myFile);
		} catch (Exception e) {
			System.out.println("saveCartSummary() failed: threw an exception, it wasnt supposed to");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether ExceptionalShoppingCart.loadCartSummary method is functional
	 * 
	 * @return true when this test case is functional, and false if it does not work
	 */
	public static boolean testLoadCartSummary() {
		try {
			File file = new File("Cart.txt");
			PrintWriter fileInput = new PrintWriter(file);
			fileInput.println("( 2 ) Onion");
			fileInput.println("( 2 ) Avocado");
			fileInput.println("( 1 ) Cucumber");
			fileInput.close();
			String[] cart = { "Banana", null, null, null, null, null, null, null };
			String[] expectedCart = { "Banana", "Onion", "Onion", "Avocado", "Avocado", "Cucumber", null, null };
			int size = 1;
			int expectedValue = 6;
			size = ExceptionalShoppingCart.loadCartSummary(file, cart, size);
			if (expectedValue != size) {
				System.out.println("loadCartSummary() failed: to return the updated size of the cart");
				return false;
			}
			for (int i = 0; i < size; ++i) {
				if (!cart[i].equals(expectedCart[i])) {
					System.out.println("loadCartSummary() failed: to update the cart as expected");
					return false;
				}
			}
		} catch (Exception e) {
			System.out.println(e + "loadCartSummary() failed: threw an exception when it wasnt supposed to");
			return false;
		}

		try {
			File file = new File("Cart.txt");
			PrintWriter fileInput = new PrintWriter(file);
			fileInput.println("( 2 ) Onion");
			fileInput.println("( 2 ) Avocado");
			fileInput.println("( 1 ) Cucumber");
			fileInput.close();
			String[] cart = { "Banana", null, null, null, null, null, null, null };
			int size = -4;
			size = ExceptionalShoppingCart.loadCartSummary(file, cart, size);
			System.out.println("loadCartSummary() failed: did not throw an exception");
			return false;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.out.println(e + "loadCartSummary() failed: threw an incorrect exception");
			return false;
		}

		try {
			File file = new File("Cart.txt");
			PrintWriter fileInput = new PrintWriter(file);
			fileInput.println("( 2 ) Onion");
			fileInput.println("( 2 ) Avocado");
			fileInput.println("( 3 ) Cucumber");
			fileInput.close();
			String[] cart = { "Banana", null, null, null, null, null, null };
			int size = 1;
			size = ExceptionalShoppingCart.loadCartSummary(file, cart, size);
			System.out.println("loadCartSummary() failed: did not throw an exception");
			return false;
		} catch (IllegalStateException e) {
		} catch (Exception e) {
			System.out.println(e + "loadCartSummary() failed: threw an incorrect exception");
			return false;
		}

		return true;
	}

	/**
	 * this tester runs all the other tester methods
	 *
	 * @return true when this test case is functional, and false if it does not work
	 */
	public static boolean runAllTests() {
		// checks if all the methods work as required
		if (!testLookupMethods()) {
			return false;
		}
		if (!testAddItemToMarketCatalog()) {
			return false;
		}
		if (!testSaveCartSummary()) {
			return false;
		}
		if (!testLoadCartSummary()) {
			return false;
		}
		return true;
	}

}
