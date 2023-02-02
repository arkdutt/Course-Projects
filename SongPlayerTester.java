
/**
 * This class implements unit test methods to check the correctness of Song,
 * LinkedNode, SongPlayer ForwardSongIterator and BackwardSongIterator classes.
 *
 */
public class SongPlayerTester {

	/**
	 * This method test and make use of the Song constructor, an accessor (getter)
	 * method, overridden method toString() and equal() method defined in the Song
	 * class.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSong() {
		// Tests whether the Song constructor is functional
		Song track;
		try {
			track = new Song("Rap God", "Eminem", null);
			return false;
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("Rap God", "Eminem", "");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("Rap God", null, "6:03");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("Rap God", "", "6:03");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song(null, "Eminem", "6:03");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("", "Eminem", "603");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("Rap God", "Eminem", "6:88");
		} catch (IllegalArgumentException e) {
		}
		try {
			track = new Song("Rap God", "Eminem", "79:69");
		} catch (IllegalArgumentException e) {
		}

		track = new Song("Rap God", "Eminem", "6:03");
		// Tests whether getSongName() method is functional
		if (!track.getSongName().equals("Rap God")) {
			System.out.println("ERROR! getSongName() method failed.");
			return false;
		}

		// Tests whether the getArtist() method is functional
		if (!track.getArtist().equals("Eminem")) {
			System.out.println("ERROR! getArtist() method failed!");
			return false;
		}

		// Tests whether the getDuration() method is functional
		if (!track.getDuration().equals("6:03")) {
			System.out.println("ERROR! getDuration() method failed!");
			return false;
		}

		// Tests whether the toString() method is functional from Song.java
		if (!track.toString().equals("Rap God---Eminem---6:03")) {
			System.out.println("ERROR! toString() method failed!");
			return false;
		}

		// Tests whether the equals() method is functional from Song.java
		Song trackX = new Song("Rap God", "Eminem", "6:03");
		if (!track.equals(trackX)) {
			System.out.println("ERROR! equals() method failed!");
			return false;
		}
		trackX = new Song("Julia", "The Weeknd", "6:03");
		if (track.equals(trackX)) {
			System.out.println("ERROR! equals() method failed!");
			return false;
		}
		trackX = new Song("Rap God", "Rihanna", "6:03");
		if (track.equals(trackX)) {
			System.out.println("ERROR! equals() method failed!");
			return false;
		}
		trackX = new Song("Rap God", "Eminem", "3:39");
		if (!track.equals(trackX)) {
			System.out.println("ERROR! equals() method failed!");
			return false;
		}
		trackX = new Song("Rap God", "Eminem", "6:03");
		if (!track.equals(trackX)) {
			System.out.println("ERROR! equals() method failed!");
			return false;
		}
		return true;
	}

	/**
	 * This method test and make use of the LinkedNode constructor, an accessor
	 * (getter) method, and a mutator (setter) method defined in the LinkedCart
	 * class.
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testLinkedNode() {
		LinkedNode<Song> track = null;
		return true;
	}

	/**
	 * This method checks for the correctness of addFirst(), addLast() and add(int
	 * index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerAdd() {
		// Tests constructor by creating a new SongPlayer object
		SongPlayer newTrack = null;
		try {
			newTrack = new SongPlayer();
		} catch (Exception e) {
			System.out.println("ERROR! songPlayer contructor failed!");
			return false;
		}

		// Tests the functionality of the addFirst() method when adding to an empty list
		Song newTrackX = new Song("Rockstar", "Post Malone", "3:38");
		try {
			newTrack.addFirst(newTrackX);
		} catch (Exception e) {
			System.out.println("ERROR! addFirst() method failed!");
			return false;
		}

		if (newTrack.size() != 1) {
			System.out.println("ERROR! The list has incorrect size when addFirst() is being used!");
			return false;
		}

		// Tests the functionality of addFirst() when adding to a list that is non-empty
		Song newTrackY = new Song("Rap God", "Eminem", "6:03");
		try {
			newTrack.addFirst(newTrackY);
		} catch (Exception e) {
			System.out.println("ERROR! addFirst() method failed!");
			return false;
		}

		// Tests the functionality of add(index, Song) method
		Song newTrackZ = new Song("November Rain", "Guns N' Roses", "8:56");
		try {
			newTrack.add(1, newTrackZ);
		} catch (Exception e) {
			System.out.println("ERROR! add() method failed!");
			return false;
		}

		// test whether the play() method is functional
		String musicQ = null;
		try {
			musicQ = newTrack.play();
		} catch (Exception e) {
		}
		System.out.println(musicQ);
		newTrack.switchPlayingDirection();
		String musicQY = null;
		try {
			musicQY = newTrack.play();
		} catch (Exception e) {
		}
		System.out.println(musicQY);
		return true;
	}

	/**
	 * This method checks for the correctness of getFirst(), getLast() and get(int
	 * index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerGet() {
		return true;
	}

	/**
	 * This method checks for the correctness of removeFirst(), removeLast() and
	 * remove(int index) method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerRemove() {
		// Tests constructor by creating a new SongPlayer object
		SongPlayer curPayer = null;
		try {
			curPayer = new SongPlayer();
		} catch (Exception e) {
			System.out.println("ERROR! songPlayer constructor failed when creating a new songPlayer object!");
			return false;
		}

		// Tests the functionality of the addFirst() method when adding to an empty list
		Song tracklisX = new Song("Rockstar", "Post Malone", "3:38");
		curPayer.addFirst(tracklisX);

		// Tests the functionality of addFirst() when adding to a list that is non-empty
		Song newTempSong1 = new Song("Rap God", "Eminem", "6:03");
		try {
			curPayer.addFirst(newTempSong1);
		} catch (Exception e) {
			System.out.println("ERROR! the addFirst() method failed!");
			return false;
		}

		// Tests the functionality of add(index, Song) method
		Song addTrackY = new Song("November Rain", "Guns N' Roses", "8:56");
		try {
			curPayer.add(1, addTrackY);
		} catch (Exception e) {
			System.out.println("ERROR! the add() method failed!");
			return false;
		}

		System.out.println(curPayer.play());
		curPayer.switchPlayingDirection();
		System.out.println(curPayer.play());
		return true;
	}

	/**
	 * This method checks for the correctness of iterator(),
	 * switchPlayingDirection() and String play() method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerIterator() {
		return true;
	}

	/**
	 * This method checks for the correctness of contains(Object song), clear(),
	 * isEmpty()and size() method in SongPlayer class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testSongPlayerCommonMethod() {
		return true;
	}

	/**
	 * This method checks for the correctness of ForwardSongIterator class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testForwardSongIterator() {
		// Create a LinkedList with 3 Nodes which will be used to test other methods
		LinkedNode<Song> tempNode1 = null;
		Song song1 = new Song("Starboy", "The Weeknd", "3:50");
		try {
			tempNode1 = new LinkedNode<>(null, song1, null);
		} catch (Exception e) {
			System.out.println("Constructor failed when creating the first node");
			return false;
		}

		LinkedNode<Song> tempNode2 = null;
		Song song2 = new Song("Streets", "Doja Cat", "3:47");
		try {
			tempNode2 = new LinkedNode<>(tempNode1, song2, null);
		} catch (Exception e) {
			System.out.println("Constructor failed when creating the second node");
			return false;
		}

		LinkedNode<Song> tempNode3 = null;
		Song song3 = new Song("Die Young", "Kesha", "3:32");
		try {
			tempNode3 = new LinkedNode<>(tempNode2, song3, null);
		} catch (Exception e) {
			System.out.println("Constructor failed when creating the second node");
			return false;
		}

		// 2. Tests constructor
		SongPlayer songPlayer = null;
		try {
			songPlayer = new SongPlayer();
		} catch (Exception e) {
			System.out.println("songPlayer constructor failed when creating a new songPlayer object");
			return false;
		}
		return true;
	}

	/**
	 * This method checks for the correctness of BackwardSongIterator class
	 * 
	 * @return true when this test verifies a correct functionality, and false
	 *         otherwise
	 */
	public static boolean testBackwardSongIterator() {
		return true;
	}

	/**
	 * This method calls all the test methods defined and implemented in your
	 * SongPlayerTester class.
	 * 
	 * @return true if all the test methods defined in this class pass, and false
	 *         otherwise.
	 */
	public static boolean runAllTests() {
		return (testSong() && testLinkedNode() && testSongPlayerAdd() && testSongPlayerGet() && testSongPlayerRemove()
				&& testSongPlayerIterator() && testSongPlayerCommonMethod() && testForwardSongIterator()
				&& testBackwardSongIterator());
	}

	/**
	 * Driver method defined in this SongPlayerTester class
	 * 
	 * @param args input arguments if any.
	 */
	public static void main(String[] args) {
		// System.out.print(testSong());
		if (runAllTests()) {
			System.out.print("All tests passed.");
		} else {
			System.out.print("Test(s) failed.");
		}
	}
}