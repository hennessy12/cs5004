/**
 * Abstract Tune class helps implement the Tune interface.
 * <p></p>
 * This class provides a base implementation for Tune attributes and methods.
 */
public abstract class AbstractTune implements Tune, Comparable<Tune> { .// BUG 1 : Should be implement and not extend
  private String title;
  private Person artist;
  private Genre genre;
  private int tempo;
  private String filePath;

  /**
   * Constructs a new AbstractTune with the specified attributes.
   *
   * @param title    the title of the tune (must not be null or empty).
   * @param artist   the artist of the tune (must not be null).
   * @param genre    the genre of the tune (must not be null).
   * @param tempo    the tempo of the tune in BPM (must be positive).
   * @param filePath the file path of the tune (must not be null or empty).
   * @throws IllegalArgumentException if any argument is invalid.
   */
  public AbstractTune(String title, Person artist, Genre genre, int tempo, String filePath) throws IllegalArgumentException {
    // BUG 1: Missing argument validation
    if (title == null || title.isEmpty()) {
      throw new IllegalArgumentException("Title must not be null or empty.");
    }
    if (artist == null) {
      throw new IllegalArgumentException("Artist must not be null.");
    }
    if (genre == null) {
      throw new IllegalArgumentException("Genre must not be null.");
    }
    if (tempo <= 0) {
      throw new IllegalArgumentException("Tempo must be positive.");
    }
    if (filePath == null || filePath.isEmpty()) {
      throw new IllegalArgumentException("File path must not be null or empty.");
    }

    this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.tempo = tempo;
    this.filePath = filePath; // BUG 2: Missing assignment of filePath
  }

  /**
   * Returns the title of the tune.
   *
   * @return the title of the tune.
   */
  @Override
  public String getTitle() {
    // BUG 3: Incorrect implementation (returns empty string)
    // return ""; // BUG
    return title; // Fixed
  }

  /**
   * Returns the artist of the tune.
   *
   * @return the artist of the tune.
   */
  @Override
  public Person getArtist() {
    // BUG 4: Incorrect implementation (returns null)
    // return null; // BUG
    return artist; // Fixed
  }

  /**
   * Returns the genre of the tune.
   *
   * @return the genre of the tune.
   */
  @Override
  public Genre getGenre() {
    // BUG 5: Incorrect implementation (returns null)
    // return null; // BUG
    return genre; // Fixed
  }

  /**
   * Returns the tempo of the tune in BPM.
   *
   * @return the tempo of the tune.
   */
  @Override
  public int getTempo() {
    // BUG 6: Incorrect implementation (returns 0)
    // return 0; // BUG
    return tempo; // Fixed
  }

  /**
   * Returns the file path of the tune.
   *
   * @return the file path of the tune.
   */
  @Override
  public String getFilePath() {
    // BUG 7: Incorrect implementation (returns null)
    // return null; // BUG
    return filePath; // Fixed
  }

  /**
   * Compares this tune to another tune based on their titles, ignoring case.
   *
   * @param other the other tune to compare to.
   * @return a negative integer, zero, or a positive integer if this tune's title
   *         is less than, equal to, or greater than the other tune's title.
   */
  @Override
  public int compareTo(Tune other) {
    // BUG 8: Missing null check
    if (other == null) {
      throw new IllegalArgumentException("Cannot compare to null.");
    }
    return this.title.compareToIgnoreCase(other.getTitle());
  }

  /**
   * Checks if this tune is equal to another object.
   *
   * @param obj the object to compare to.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    AbstractTune other = (AbstractTune) obj;
    return title.equalsIgnoreCase(other.title) &&
        artist.equals(other.artist) &&
        genre == other.genre &&
        tempo == other.tempo &&
        filePath.equalsIgnoreCase(other.filePath);
  }

  /**
   * Returns a hash code for this tune.
   *
   * @return the hash code.
   */
  @Override
  public int hashCode() {
    // BUG 9: Inconsistent hashCode implementation
    // Use a consistent formula to calculate the hash code
    int result = title.toLowerCase().hashCode();
    result = 31 * result + artist.hashCode();
    result = 31 * result + genre.hashCode();
    result = 31 * result + tempo;
    result = 31 * result + filePath.toLowerCase().hashCode();
    return result;
  }

  /**
   * Returns a string representation of the tune.
   *
   * @return a string containing all attributes of the tune.
   */
  @Override
  public String toString() {
    // BUG 10: Missing artist name in toString
    // return String.format("Tune [Title: %s, Genre: %s, Tempo: %d, FilePath: %s]",
    //         title, genre, tempo, filePath); // BUG
    return String.format("Tune [Title: %s, Artist: %s, Genre: %s, Tempo: %d, FilePath: %s]",
        title, artist.getName(), genre, tempo, filePath); // Fixed
  }
}