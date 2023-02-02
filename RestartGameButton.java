//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: RestartGameButton.java
// Course: CS 300 Spring 2022
//
// Author: Ark Dutt
// Email: dutt3@wisc.edu
// Lecturer: Prof.Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// NONE
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// NONE
//
///////////////////////////////////////////////////////////////////////////////

import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * 
 * 
 * RestartGameButton.java shows when we press the restart button
 * 
 * 
 */

public class RestartGameButton extends Button {

	/**
	 * 
	 * 
	 * Creates a RestartGameButton object called as "Restart Game" at the top left of the screen
	 * 
	 * @param x - position in terms of x-coordinate
	 * @param y - position in terms of y-coordinate
	 * 
	 */

	public RestartGameButton(int x, int y) {
		super("Restart Game", x, y);
	}

	/**
	 * 
	 * When the mouse is pressed
	 * 
	 */

	public void mousePressed() {
		if (this.isMouseOver()) {
			((TreasureHunt) Button.processing).initGame();
		}
	}
}
