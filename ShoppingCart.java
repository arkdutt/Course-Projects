//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 ShoppingCart
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

public class ShoppingCart {
	private static final double TAX_RATE = 0.05; // sales tax
	
	/**
	 * MarketItems is a perfect size two-dimensional array that stores the list of
	 * the available items in a given market. 
	 * MarketItems[i][0] refers to a String representation of the item identifiers.
	 * MarketItems[i][1] refers the item name. Item names are also unique.
	 * MarketItems[i][2] a String representation of
	 * the unit price of the item in dollars
	 */

	private static String[][] marketItems = new String[][] { { "4390", "Apple", "$1.59" },
			{ "4046", "Avocado", "$0.59" }, { "4011", "Banana", "$0.49" }, { "4500", "Beef", "$3.79" },
			{ "4033", "Blueberry", "$6.89" }, { "4129", "Broccoli", "$1.79" }, { "4131", "Butter", "$4.59" },
			{ "4017", "Carrot", "$1.19" }, { "3240", "Cereal", "$3.69" }, { "3560", "Cheese", "$3.49" },
			{ "3294", "Chicken", "$5.09" }, { "4071", "Chocolate", "$3.19" }, { "4363", "Cookie", "$9.5" },
			{ "4232", "Cucumber", "$0.79" }, { "3033", "Eggs", "$3.09" }, { "4770", "Grape", "$2.29" },
			{ "3553", "Ice Cream", "$5.39" }, { "3117", "Milk", "$2.09" }, { "3437", "Mushroom", "$1.79" },
			{ "4663", "Onion", "$0.79" }, { "4030", "Pepper", "$1.99" }, { "3890", "Pizza", "$11.5" },
			{ "4139", "Potato", "$0.69" }, { "3044", "Spinach", "$3.09" }, { "4688", "Tomato", "$1.79" }, null, null,
			null, null };
			
			
			/**
			* Returns details of a specific product in the market given its name
			*
			* @param name name of the product to search
			* 
			* @return A string representation of the product to search including
			* the identifier of the product, its name, and its price in
			* dollars if match found.
			*/		
			
	public static String lookupProductByName(String name) {

		for (int p = 0; p < marketItems.length; p++) {
			if (marketItems[p] == null) {

				continue;

			}

			if (marketItems[p][1].equals(name)) {

				return marketItems[p][0] + " " + marketItems[p][1] + " " + marketItems[p][2];
			}

		}

		return "No match found";

	}
	

	/**
	* users can lookup for items by the identifier
	*
	* @param id the identifier of the product or item to search
	* 
	* @return A string representation of the item whose id is
	* provided as input if a match was found.
	*/
	
	public static String lookupProductById(int id) {
		

		for (int p = 0; p < marketItems.length; p++) {
			if (marketItems[p] == null) {

				continue;

			}

			if (Integer.parseInt(marketItems[p][0]) == id) {

				return marketItems[p][0] + " " + marketItems[p][1] + " " + marketItems[p][2];
			}
		}

		return "No match found";
		

	}

	
	/**
	* users can lookup for the price of any item they enter
	*
	* @param name the name of the product to check its price
	* 
	* @return the price in dollars (a double value) of a market item given its name. 
	* If no match was found in the market catalog, this method returns -1.0.
	*/
	
	public static double getProductPrice(String name) {
		

		for (int p = 0; p < marketItems.length; p++) {
			if (marketItems[p] == null) {

				continue;
			}

			if (marketItems[p][1].equals(name)) {

				return Double.parseDouble(marketItems[p][2].substring(1));
			}
		}

		return -1.0;
		

	}
	
	

	// Returns a deep copy of the marketItems array
	
	public static String[][] getCopyOfMarketItems() {
		

		String[][] mark = new String[marketItems.length][];

		for (int p = 0; p < marketItems.length; p++) {
			if (marketItems[p] != null) {

				mark[p] = new String[marketItems[p].length];

				for (int q = 0; q < marketItems[p].length; q++) {

					mark[p][q] = marketItems[p][q];
				}

			}

		}

		return mark;
		

	}
	
	

	// Appends an item to a given cart (appends means adding to the end).
	// If the cart is already full (meaning its size equals its length),
	// the item will not be added to the cart.
	// item - the name of the product to be added to the cart
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns the size of the oversize array cart after trying to add item
	// to the cart. This method returns the same of size without making
	// any change to the contents of the array if it is full.
	
	public static int addItemToCart(String item, String[] cart, int size) {

		
		if (cart.length > size) {

			cart[size] = item;
			
			
			size = size + 1;

		}

		return size;

	}

	// Returns the number of occurrences of a given item within a cart. This
	// method must not make any changes to the contents of the cart.
	// item - the name of the item to search
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns the number of occurrences of item (exact match) within the oversize
	// array cart. Zero or more occurrences of item can be present in the cart.
	public static int nbOccurrences(String item, String[] cart, int size) {

		int numOccur = 0;

		for (int p = 0; p < size; p++) {

			if (cart[p].equals(item)) {

				numOccur = numOccur + 1;
			}

		}

		return numOccur;

	}
	// Checks whether a cart contains at least one occurrence of a given item.
	// This method must not make any changes to the contents of the cart.
	// item - the name of the item to search
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns true if there is a match (exact match) of item within the
	// provided cart, and false otherwise.
	public static boolean contains(String item, String[] cart, int size) {

		boolean checkItem = false;

		for (int p = 0; p < size; p++) {

			if (cart[p].equals(item)) {

				checkItem = true;

				return checkItem;
			}

		}

		return checkItem;
	}

	// This method returns the total value in dollars of the cart. All
	// products in the market are taxable (subject to TAX_RATE).
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns the total value in dollars of the cart accounting taxes.
	public static double checkout(String[] cart, int size) {

		double totalVal = 0.0;

		for (int p = 0; p < size; p++) {

			totalVal += getProductPrice(marketItems[p][1]);

		}

		return totalVal;

	}

	// Removes one occurrence of item from a given cart. If no match with item
	// was found in the cart, the method returns the same value of input size
	// without making any change to the contents of the array.
	// item - the name of the item to remove
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns the size of the oversize array cart after trying to remove item
	// from the cart.
	public static int removeItem(String[] cart, String item, int size) {

		String[] afterRemovalCart = new String[size];

		for (int p = 0, q = 0; p < size; p++) {

			if (!(cart[p].equals(item))) {

				afterRemovalCart[q++] = cart[p];

				size = size - 1;

				return size;
			}

		}

		return size;
	}

	// Removes all items from a given cart. The array cart must be empty (contains
	// only null references) after this method returns.
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns the size of the cart after removing all its items.
	public static int emptyCart(String[] cart, int size) {

		for (int p = 0; p < size; p++) {

			cart[p] = null;

		}

		return size;

	}

	// Returns a string representation of the summary of the contents of a given
	// cart.
	// The format of the returned string contains a set of lines where each line
	// contains
	// the number of occurrences of a given item, between parentheses, followed by
	// one space followed by the name of a unique item in the cart.
	// (#occurrences) name1
	// (#occurrences) name2
	// etc.
	// Further details about the format of the returned string is provided
	// in the next section.
	// cart - an array of strings which contains the names of items in the cart
	// size - the number of items in the cart
	// Returns a string representation of the summary of the contents of the cart
	public static String getCartSummary(String[] cart, int size) {

		String out = "";

		String[] wholeCart = new String[cart.length];

		int wholeSize = 0;

		boolean checke = false;
		if (size <= 0) {

			return out;
		}

		for (int p = 0; p < size; p++) {
			for (int r = 0; r < wholeSize; r++) {
				if (wholeCart[r] == cart[p]) {

					checke = true;

				}
			}

			if (checke == false) {

				out = out + "(" + nbOccurrences(cart[p], cart, size) + ") " + cart[p] + '\n';
				wholeCart[wholeSize] = cart[p];
				wholeSize = wholeSize + 1;

			}

			checke = false;

		}

		return out.trim();

	}

}