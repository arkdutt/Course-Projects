//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: SongPlayer.java
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
 * This class models an iterable collection of songs. 
 * Songs can be played in the forward or reverse order.
 */

import java.util.NoSuchElementException;


public class SongPlayer implements Iterable<Song> {
	private int size; // size of the list
	private LinkedNode<Song> head; // head of this doubly linked list
	private LinkedNode<Song> tail; // tail of this doubly linked list
	private boolean playingBackward; //true if this song player is reading the list backward

	/**
	 * Creates a new instance of song player which contains zero songs and set by
	 * default to play songs in the forward direction. [Implementing this
	 * constructor is optional since it will be added by default by the compiler]
	 */
	public SongPlayer() {
		size = 0;
		head = null;
		tail = null;
	}

	/**
	 * Adds a Song as Last Song
	 * 
	 * @param oneSong - the song that is going to be added to the tail of this
	 *                doubly linked list of songs
	 */
	public void addLast(Song oneSong) {
		LinkedNode<Song> songNxt = new LinkedNode<Song>(tail, oneSong, null);
		if (this.isEmpty()) {
			this.head = songNxt;
			this.tail = songNxt;
			++size;
			return;
		}
		if (tail != null) {
			this.tail.setNext​(songNxt);
		}
		this.tail = songNxt;
		++size;
	}

	/**
	 * Add Song as First Song
	 * 
	 * @param oneSong the song that is going to be added to the head of this
	 *                doubly linked list of songs
	 *
	 * @throws NullPointerException if the passed oneSong is null
	 */
	public void addFirst(Song oneSong) {
		if (oneSong == null) {
			throw new NullPointerException("ERROR! Given oneSong is null!");
		}
		try {
			LinkedNode<Song> songNxt = new LinkedNode<>(null, oneSong, head);
			if (this.isEmpty()) {
				this.head = songNxt;
				this.tail = songNxt;
				++size;
				return;
			}
			if (head != null) {
				this.head.setPrev​(songNxt);
			}
			this.head = songNxt;
			++size;
		} catch (IllegalArgumentException e) {
			throw new NullPointerException(e.getMessage());
		}
	}

	/**
	 * Adds Song at a given position/order within this collection of songs
	 * 
	 * @param index  the given index where the new song will be added
	 * @param oneSong the song that is going to be added
	 *
	 * @throws NullPointerException if the passed oneSong is null
	 * @throws IndexOutOfBoundsException if index is out of the 0 .. size() range
	 */
	public void add(int index, Song oneSong) 
			throws IndexOutOfBoundsException, NullPointerException {
		if (oneSong == null) {
			throw new NullPointerException("ERROR! Given oneSong is null!");
		}
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException("ERROR! Index is invalid!");
		} else if (size == 0) {
			head = tail = new LinkedNode<Song>(null, oneSong, null);
			++size;
			return;
		} else if (index == 0) {
			addFirst(oneSong);
			return;
		}
		if (index == size) {
			addLast(oneSong);
			return;
		}
		LinkedNode<Song> prvly = head;
		for (int i = 0; i < index - 1; ++i) {
			prvly = prvly.getNext();
		}
		LinkedNode<Song> nxt = prvly.getNext();
		LinkedNode<Song> newS = new LinkedNode<Song>(prvly, oneSong, nxt);
		prvly.setNext​(newS);
		nxt.setPrev​(newS);
		++size;
	}

	/**
	 * Returns the first Song in this list.
	 *
	 * @return the Song at the head of this list
	 *
	 * @throws NoSuchElementException if this list is empty
	 */
	public Song getFirst() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("ERROR! List is empty!");
		}
		return head.getData();
	}

	/**
	 * Returns the last Song in this list.
	 *
	 * @return the Song at the tail of this list
	 *
	 * @throws java.util.NoSuchElementException if this list is empty
	 */
	public Song getLast() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("ERROR! List is empty");
		}
		return tail.getData();
	}

	/**
	 * Returns the song at the specified position in this list.
	 * 
	 * @param index - index of the song to return
	 *
	 * @return the song at the specified position in this list
	 *
	 * @throws IndexOutOfBoundsException if index is out of the 0 .. size()-1 range
	 */
	public Song get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size() - 1) {
			throw new IndexOutOfBoundsException("ERROR! Index is invalid");
		}
		LinkedNode<Song> prvly = head;
		for (int i = 0; i <= index; i++) {
			prvly = prvly.getNext();
		}
		return prvly.getData();
	}

	/**
	 * Removes and returns the first song from this list.
	 *
	 * @return the first song from this list
	 *
	 * @throws NoSuchElementException if this list is empty
	 */
	public Song removeFirst() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("ERROR! List is empty");
		}
		Song track;
		try {
			track = head.getData();
		} catch (NullPointerException e) {
			return null;
		}
		if (size == 1) {
			this.head = this.tail = null;
			size = 0;
			return track;
		}
		head = head.getNext();
		try {
			head.setPrev​(null);
		} catch (NullPointerException e) {
		}
		--size;
		return track;
	}

	/**
	 * Removes and returns the last song from this list.
	 *
	 * @return the last song from this list
	 *
	 * @throws NoSuchElementException if this list is empty
	 */
	public Song removeLast() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException("ERROR! List is empty");
		}
		Song track;
		try {
			track = tail.getData();
		} catch (NullPointerException e) {
			return null;
		}
		if (size == 1) {
			this.tail = null;
			this.head = null;
			size = 0;
			return track;
		}
		tail = tail.getPrev();
		try {
			tail.setNext​(null);
		} catch (NullPointerException e) {
		}
		--size;
		return track;
	}

	/**
	 * Removes the song at the specified position in this list and returns the song
	 * that was removed from the list. The order of precedence of the other songs in
	 * the list should not be modified.
	 * 
	 * @param index the index of the song to be removed
	 *
	 * @return the song previously at the specified position
	 *
	 * @throws IndexOutOfBoundsException if index is out of the 0 .. size()-1 range
	 */
	public Song remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size() - 1) {
			throw new IndexOutOfBoundsException("Index is invalid");
		}
		LinkedNode<Song> now = head;
		for (int i = 0; i < index; ++i) {
			now = now.getNext();
		}
		try {
			now.getPrev().setNext​(now.getNext());
		} catch (NullPointerException e) {
		}
		try {
			now.getNext().setPrev​(now.getPrev());
		} catch (NullPointerException e) {
		}
		--size;
		return now.getData();
	}

	/**
	 * Returns true if this list contains a match with the specified song. More
	 * formally, returns true if and only if this list contains at least one song e
	 * such that Objects.equals(o, e).
	 * 
	 * @param o - song whose presence in this list is to be tested
	 *
	 * @return true if this list contains the specified song
	 */
	public boolean contains(Song o) {
		LinkedNode<Song> now = head;
		for (int i = 0; i < size(); ++i) {
			if (now.getData().equals(o)) {
				return true;
			}
			now = now.getNext();
		}
		return false;
	}

	/**
	 * Removes all of the songs from this list. The list will be empty after this
	 * call returns.
	 */
	public void clear() {
		size = 0;
		head = null;
		tail = null;

	}

	/**
	 * Returns true if this list is empty.
	 *
	 * @return true if this list is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Returns the number of songs in this list.
	 *
	 * @return the number of songs in this list
	 */
	public int size() {
		return (this.size);
	}

	/**
	 * Returns an iterator to iterate through the songs in this list with respect to
	 * current playing direction of this song player (either in the forward or in
	 * the backward direction)
	 *
	 * @return an Iterator to traverse the list of songs in this SongPlayer with
	 * respect to the current playing direction specified by the
	 * playingBackward data field.
	 */
	@Override
	public java.util.Iterator<Song> iterator() {
		if (this.playingBackward) {
			return new BackwardSongIterator(tail);
		} else {
			return new ForwardSongIterator(head);
		}
	}

	/**
	 * Mutator of the playingDirection of this song player. It switches the playing
	 * direction by setting playingBackward to its opposite value.
	 */
	public void switchPlayingDirection() {
		this.playingBackward = !this.playingBackward;
	}

	/**
	 * Plays the songs in this song player in the current playing direction. This
	 * method MUST be implemented using an enhanced for-each loop.
	 *
	 * @return a String representation of the songs in this song player. String
	 * representations of each song are separated by a newline. If this song
	 * player is empty, this method returns an empty string.
	 */
	public String play() {
		String playX = "";
		for (Song song : this) {
			playX += song;
		}
		return playX;
	}

}