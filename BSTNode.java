//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BSTNode class - P09 Art Gallery
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

/**
 * Generic class implementing a Binary Node of a Binary Search Tree (BST)
 *
 * @param <T> type of the data carried by this binary node
 * @author Rajesh Shashi Kumar
 */
public class BSTNode<T extends Comparable<T>> {
  // Note: DO NOT MAKE ANY CHANGE TO THIS CLASS AND DO NOT SUBMIT IT TO GRADESCOPE
  private T data; // data in the node field
  private BSTNode<T> left; // reference to the left child
  private BSTNode<T> right; // reference to the right child

  /**
   * Creates a BSTNode with a given data value
   * 
   * @param data data carried by this binary node
   * @throws NullPointerException if data is null
   */
  public BSTNode(T data) {
    if (data == null)
      throw new NullPointerException();
    this.data = data;
  }

  /**
   * Creates a BSTNode with given data value, a reference to a left child (left BST subtree) and a
   * reference to a right child (right BST sub-tree).
   * 
   * @param data  element held by this binary node
   * @param left  reference to the left child
   * @param right reference to the right child
   * @throws NullPointerException if data is null
   */
  public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
    if(data == null)
      throw new NullPointerException("data cannot be null");
    this.data = data;
    this.left = left;
    this.right = right;
  }

  /**
   * Getter of left child
   * 
   * @return the left
   */
  public BSTNode<T> getLeft() {
    return left;
  }

  /**
   * Setter for left child
   * 
   * @param left the left to set
   */
  public void setLeft(BSTNode<T> left) {
    this.left = left;
  }

  /**
   * Getter of the right child
   * 
   * @return the right child of this binary node
   */
  public BSTNode<T> getRight() {
    return right;
  }

  /**
   * Setter for the right child
   * 
   * @param right the right to set
   */
  public void setRight(BSTNode<T> right) {
    this.right = right;
  }

  /**
   * Getter of data field
   * 
   * @return the data held by this node
   */
  public T getData() {
    return data;
  }

}