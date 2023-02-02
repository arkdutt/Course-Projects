//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Clickable Interface
// Course: CS300 Spring 2022
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
public interface Clickable {
	public void draw(); // draws this Clickable object to the screen
	
	public void mousePressed(); // defines the behavior of this Clickable object
	// each time the mouse is pressed
	
	public void mouseReleased(); // defines the behavior of this Clickable object
	// each time the mouse is released
	
	public boolean isMouseOver(); // returns true if the mouse is over this clickable object

}
