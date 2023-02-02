//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  LinkedQueue.java
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
 *
 * @param <T>
 */

public class LinkedQueue<T> extends Object implements QueueADT<T> {

  private Node<T> back;
  private Node<T> front;
  private int n;

  /**
   * Adds the item to the end of this queue
   *
   * @param data the item to add
   */
  @Override
  public void enqueue(T data) {
	  
    Node basc = new Node<T>(data);
    if (this.isEmpty()) {
      this.front = basc;
      this.back = this.front;

    } else {
      this.back.setNext(basc);
      this.back = this.back.getNext();
    }
    n++;
  }

  /**
   * Removes and returns the first item on the queue
   *
   * @return the first item on the queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  @Override
  public T dequeue() {

    if (isEmpty()) {
      throw new NoSuchElementException("ERROR! Queue is empty!");
    }

    Node<T> nodeX = front;

    if (n == 1) {
      this.front = null;
    } else {
      this.front = front.getNext();
      nodeX.setNext(null);
      this.front.setNext(this.front.getNext());
    }
    n--;
    return nodeX.getData();
  }

  /**
   * Returns the item least recently added to this queue
   *
   * @return the item least recently added to this queue
   * @throws java.util.NoSuchElementException if this queue is empty
   */
  @Override
  public T peek() {

    if (isEmpty())
      throw new NoSuchElementException("ERROR! Queue is empty!");
    return front.getData();
  }

  /**
   * Returns the size of the queue
   *
   * @return size of the queue
   */
  @Override
  public int size() {

    return this.n;
  }
  
  /**
   * Checks whether or not size is 0
   *
   * @return true if empty, false otherwise
   */
  @Override
  public boolean isEmpty() {

    if (size() == 0) {
      return true;
    }
    return false;
  }



  /**
   * Creates a string representation
   *
   * @return string representation of the node
   */
  public String toString() {
    String str = "";
    if (isEmpty()) {
      return str;
    } else {
      Node nde = this.front;
      for (int i = 0; i < size(); i++) {
        str += nde.getData() + " ";
        nde = nde.getNext();
      }
      return str;
    }
  }
}
