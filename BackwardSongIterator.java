//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Backward.java
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

/*
 * 
 * This class models an iterator to play songs in the 
 * reverse backward direction from a doubly linked list of songs
 * 
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardSongIterator implements Iterator<Song> {
	private LinkedNode<Song> next;

	/**
	 * Creates a new iterator which iterates through songs in back/tail to
	 * front/head order
	 * 
	 * @param last reference to the tail of a doubly linked list of songs
	 */
	public BackwardSongIterator(LinkedNode<Song> last) {
		this.next = last;
	}

	/**
	 * Checks whether there are more songs to return in the reverse order
	 *
	 * @return true if there are more songs to return in the reverse order
	 */
	@Override
	public boolean hasNext() {
		return (next != null);
	}

	/**
	 * Returns the next song in the iteration
	 *
	 * @throws java.util.NoSuchElementException with a descriptive error message
	 * if there are no more songs to return in the reverse order (meaning if
	 * this.hasNext() returns false)
	 * 
	 */
	@Override
	public Song next() {
		if (!(hasNext())) {
			throw new NoSuchElementException("ERROR! No more songs to return in the reverse order!");
		}
		LinkedNode<Song> track = next;
		next = next.getPrev();
		return track.getData();
	}

}
