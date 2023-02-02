//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Fountain
// Course: Spring 2022 CS 300 
//
// Author: Ark Dutt 
// Email: dutt3@wisc.edu
// Lecturer: Prof. Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Fountain.java consists of the the main class 
 * , therefore, it uses various methods, along with tester methods
 *
 * @author Ark Dutt 
 *
 */

import java.util.Random;
import java.io.File;
import processing.core.PImage;

public class Fountain {

	// Random object
	private static Random randGen;

	// Uploads the image of the fountain
	private static PImage fountainImage;

	// a perfect size array which represents droplets
	public static Droplet[] droplets;

	private static int startColor; // blue: Utility.color(23,141,235)
	private static int endColor; // lighter blue: Utility.color(23,200,255)

	// positioning the image in terms of x-axis
	public static int positionX;

	// positioning the image in terms of y-axis
	public static int positionY;

	// velocity of the droplets in terms of x-axis
	public static float velocityX;

	// velocity of the droplets in terms of y-axis
	public static float velocityY;
	

	/**
	   * In the setup method, the necessary values are intialized. 
	   * It checks the testers methods, which makes sure whether the code is working or not.
	   * These tester methods are testupdateDroplet() and testremoveOldDroplets () respectively. 
	   * No parameters and nothing is returned
	   */
	
	public static void setup() {

		// tester methods

		testUpdateDroplet();

		testRemoveOldDroplets();

		if (testUpdateDroplet() == false) {

			System.out.println("UpdateDroplet() failed");

		}

		if (testRemoveOldDroplets() == false) {

			System.out.println("removeOldDroplets() failed");

		}

		// initialized the startColor and endColor for the droplets

		startColor = Utility.color(23, 141, 235);
		
		endColor = Utility.color(23, 200, 255);

		// initialized ranGen to new Random Object

		randGen = new Random();

		// The position of the fountain is set to the center of the screen

		positionX = Utility.width() / 2;

		positionY = Utility.height() / 2;

		// This is done to load the image of the fountain

		fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");

		// New droplet arrays are initialized with 800 null values

		droplets = new Droplet[800];

	}

	/**
	   *
	   *The draw() method draws the application display window
	   *It also updates its content in the display like background, droplets etc.
	   *There are no parameters and nothing is returned
	   *
	   */

	public static void draw() {

		//The display is set with a background and its color
		Utility.background(Utility.color(253, 245, 230));
		Utility.fill(Utility.color(23, 141, 235));

		//The display shows the image of the fountain
		Utility.image(fountainImage, positionX, positionY);

		//Calls the updateDroplet() method in a for loop. It is used for array droplets.
		for (int i = 0; i < droplets.length; i++) {
			if (droplets[i] != null) {
				updateDroplet(i);
			}
		}
		
		//creates 10 droplets
		createNewDroplets(10);

		//searches through the droplets array with an age that 
		//is greater than the 80 and then removes them
		removeOldDroplets(80);

	}

	/**
	 * This method updates the position, movement and the drawing of the droplets at
	 * a particular index
	 *
	 * @param index - The index of a certain droplets within the array
	 * 
	 */

	public static void updateDroplet(int index) {

		// draws and filss the droplets using x and y positioning
		Utility.circle(droplets[index].getPositionX(), droplets[index].getPositionY(),
				droplets[index].getSize());
		Utility.fill(Utility.color(23, 141, 235), droplets[index].getTransparency());

		// demonstrates the gravitational effect of the droplets
		droplets[index].setVelocityY(droplets[index].getVelocityY() + 0.3f);

		// increments x position by x velocity
		droplets[index].setPositionX(droplets[index].getPositionX() + droplets[index].getVelocityX());

		// increments y position by y velocity
		droplets[index].setPositionY(droplets[index].getPositionY() + droplets[index].getVelocityY());

		// increments the age of droplets by 1
		droplets[index].setAge(droplets[index].getAge() + 1);

	}

	private static void createNewDroplets(int emergingDrops) {

		int numOfDrops = 0;
		for (int i = 0; i < droplets.length; i++) {
			if (droplets[i] == null) {
				numOfDrops++;
				droplets[i] = new Droplet();

				// The x position of each droplet begin within 3 pixels (+/-) of Fountain.positionX
				droplets[i].setPositionX(positionX + randGen.nextFloat() * 6 - 3);
				
				// The y position of each droplet begin within 3 pixels (+/-) of Fountain.positionY.
				droplets[i].setPositionY(positionY + randGen.nextFloat() * 6 - 3);

				 // The x velocity of each droplet begin between -1 and 1.
				float velocityOfDropletX = randGen.nextFloat() * 2 - 1; droplets[i].setVelocityX(velocityOfDropletX);

				 // The y velocity of each droplet begin between -5 and -10.
				float velocityOfDropletY = randGen.nextFloat() * 5 - 10;
				droplets[i].setVelocityY(velocityOfDropletY);
				
				//The size of each droplet begin between 4 and 11.
				float sizeOfDroplet = randGen.nextFloat() * 8 + 4;
				droplets[i].setSize(sizeOfDroplet);
				
				// age of droplets is between 0 and 40
				int ageOfDroplet = randGen.nextInt(41);
				droplets[i].setAge(ageOfDroplet);

				// the transparency of droplets is between 32 and 127
				int transparencyOfDroplet = randGen.nextInt(96) + 32;
				droplets[i].setTransparency(transparencyOfDroplet);

				// the color of droplets
		        //begin between Fountain.startColor and Fountain.endColor
				int colourOfDroplet = Utility.lerpColor(startColor, endColor, randGen.nextInt());
				droplets[i].setColor(colourOfDroplet);
			}
		    if (numOfDrops >= emergingDrops) {
		        break;
			}
		}
	}

	/**
	 * This method searches through the droplets array for references to droplets 
	 * with an age that is greater than 80.
	 * 
	 * @param ageGreater
	 * 
	 * It has no return value
	 */

	public static void removeOldDroplets(int ageGreater) {
		for (int i = 0; i < droplets.length; i++) {
			if (droplets[i] != null) {
				if (droplets[i].getAge() > ageGreater) {
					droplets[i] = null;
				}
			}
		}
	}


	/**
	 * If the s key is pressed then a screenshot is taken and saved
	 *
	 * @param key - the letterKey is pressed
	 */

	public static void keyPressed(char key) {
		if (key == 's' || key == 'S') {
			Utility.save("Screenshot.png");
		}
	}
	
	/**
	 * Move the fountain's x and y position to
	 * match the cursor of the mouse whenever the user holds the mouse
	 *
	 */
	public static void mousePressed() {

		Fountain.positionX = Utility.mouseX();
		Fountain.positionY = Utility.mouseY();

	}

	
	/**
	 * calls the runApplication method
	 * 
	 * @param args - The input arguments return.
	 * 
	 *
	 */
	public static void main(String args[]) {
		Utility.runApplication();
	}

	
	
	/**
	 * This particular tester initializes the droplet array to hold three droplets.
	 * This creates a droplet position at (3,3) with velocity (-1,-2). Then the
	 * updateDroplet is checked. This droplet is index correctly and changes its
	 * position to (2.0,1.3).
	 * 
	 * @return if true is returned then no defect is found, and false is returned
	 *         otherwise.
	 * 
	 */
	private static boolean testUpdateDroplet() {

		droplets = new Droplet[1];
		droplets[0] = new Droplet(3, 3, 4, 4);
		droplets[0].setVelocityX(-1);
		droplets[0].setVelocityY(-2);
		updateDroplet(0);

		if (droplets[0].getPositionX() == 2.0 && droplets[0].getPositionY() == 1.3) {
			return true;
		}
		return false;
	}


	/**
	 * The tester initializes the array droplets to hold at least 3 droplets.
	 * removeOldDroplets (6) on an array with three droplets (two of which have ages
	 * over six and the other does not) It then checks whether the old droplets were
	 * removed and the younger droplets were left alone.
	 *
	 * @return if true is returned then no defect is found, if otherwise then false
	 *         is returned.
	 */

	private static boolean testRemoveOldDroplets() {

		droplets = new Droplet[3];
		droplets[0] = new Droplet();
		droplets[1] = new Droplet();
		droplets[2] = new Droplet();

		droplets[0].setAge(9);
		droplets[1].setAge(11);
		droplets[2].setAge(2);

		removeOldDroplets(6);

		if (droplets[0] == null && droplets[1] == null && droplets[2].getAge() == 2) {
			return true;
		}
		return false;
	}
}