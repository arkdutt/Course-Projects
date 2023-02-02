//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ScreenshotButton.java
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
 * ScreeshotButton models a screenshot button in the Treasure Hunt game
 */

public class ScreenshotButton extends Button {


  /**
   * Creates a new ScreenshotButton object, which calls "Take a screenshot" 
   * on the screen
   * 
   * @param x - position in terms of x-coordinate
   * @param y - position in terms of y-coordinate
   */

  public ScreenshotButton(int x, int y) {
    super("Take a screenshot", x, y);
  }

  /**
   * When the mouse is pressed
   */
  public void mousePressed() {
    if (isMouseOver()) {
      processing.save("screenshot.png");
    }
  }
  
}

