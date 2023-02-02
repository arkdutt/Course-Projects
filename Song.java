//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Song.java
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

/**
 * This class models a song. It contains accessor methods and also overrides
 * like toString() and equals() methods.
 * 
 * 
 */
public class Song {
	private String songName; // name or title of the song
	private String artist; // artist of the song
	private String duration; // duration of the song

	/**
	 * Creates a new Song given the song name, the name of the artist, and the
	 * duration of the song
	 * 
	 * @param songName title of the song
	 * @param artist   name of the artist who performed this song
	 * @param duration duration of the song in the format mm:ss
	 * @throws IllegalArgumentException if either of songName, or artist, or
	 *                                  duration is null or is blank, or if the
	 *                                  duration is not formatted as mm:ss where
	 *                                  both mm and ss are in the 0 .. 59 range.
	 */
	public Song(String songName, String artist, String duration) throws IllegalArgumentException {
		if (songName == null || songName.isBlank()) {
			throw new IllegalArgumentException("ERROR! Given songName is blank!");
		}
		if (artist == null || artist.isBlank()) {
			throw new IllegalArgumentException("ERROR! Given artist is blank!");
		}
		if (duration == null || duration.isBlank()) {
			throw new IllegalArgumentException("ERROR! Given duration is null!");
		}
		if (!duration.contains(":")) {
			throw new IllegalArgumentException("ERROR! Duration is not properly formatted! " + "':' is required! ");
		}
		if (Integer.parseInt(duration.split(":")[0]) > 59 || Integer.parseInt(duration.split(":")[0]) < 0) {
			throw new IllegalArgumentException("ERROR! Duration is not entered appropriately! "
					+ "Minutes should be in the range between 0 and 59 inclusively!");
		}
		if (Integer.parseInt(duration.split(":")[1]) > 59 || Integer.parseInt(duration.split(":")[1]) < 0) {
			throw new IllegalArgumentException("ERROR! Duration is not entered appropriately! "
					+ "Seconds should be in the range between 0 and 59 inclusively!");
		}

		this.songName = songName;
		this.artist = artist;
		this.duration = duration;
	}

	/**
	 * Gets the title or name of this song
	 * 
	 * 
	 * @return the title or name of this song
	 * 
	 */
	public String getSongName() {
		return this.songName;
	}

	/**
	 * Gets the name of the artist who performed this song
	 * 
	 * 
	 * @return the artist who performed this song
	 * 
	 */
	public String getArtist() {
		return this.artist;
	}

	/**
	 * Gets the duration of this song
	 * 
	 * 
	 * @return the duration
	 * 
	 */
	public String getDuration() {
		return this.duration;
	}

	/**
	 * Returns a string representation of this song. This string should be formatted
	 * as follows. "songName---artist---duration" where songName is the title of the
	 * song, artist is the name of the artist, and duration is the duration of the
	 * song.
	 * 
	 * 
	 * @return a string representation of this song.
	 * 
	 */
	@Override
	public String toString() {
		return (this.getSongName() + "---" + this.getArtist() + "---" + this.getDuration());
	}

	/**
	 * Returns true when this song's name and artist strings equals to the other
	 * song's name and artist strings, and false otherwise. Note that this method
	 * takes an Object rather than a Song argument, so that it Overrides
	 * Object.equals(Object).
	 * 
	 * If an object that is not an instance of Song is ever passed to this method,
	 * it should return false.
	 * 
	 * 
	 * @return true when the this song has matching name and artist with respect to
	 *         another song (case insensitive comparison)
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Song) || (obj == null)) {
			return false;
		}
		if (this.getArtist().toLowerCase().equals(((Song) obj).getArtist().toLowerCase())
				&& this.getSongName().toLowerCase().equals(((Song) obj).getSongName().toLowerCase())) {
			return true;
		}
		return false;
	}

}