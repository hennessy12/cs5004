/**
 * Abstract Tune class helps implement the Tune interface.
 * <p></p>
 * This class provides a base implementation for Tune attributes and methods.
 */
public abstract class AbstractTune implements Tune, Comparable<Tune> {
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
    return title;
  }

  /**
   * Returns the artist of the tune.
   *
   * @return the artist of the tune.
   */
  @Override
  public Person getArtist() {
    return artist;
  }

  /**
   * Returns the genre of the tune.
   *
   * @return the genre of the tune.
   */
  @Override
  public Genre getGenre() {
    return genre;
  }

  /**
   * Returns the tempo of the tune in BPM.
   *
   * @return the tempo of the tune.
   */
  @Override
  public int getTempo() {
    return tempo;
  }

  /**
   * Returns the file path of the tune.
   *
   * @return the file path of the tune.
   */
  @Override
  public String getFilePath() {
    return filePath;
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
    // BUG 3: Inconsistent hashCode implementation
    return title.toLowerCase().hashCode() +
        artist.hashCode() +
        genre.hashCode() +
        tempo +
        filePath.toLowerCase().hashCode();
  }

  /**
   * Returns a string representation of the tune.
   *
   * @return a string containing all attributes of the tune.
   */
  @Override
  public String toString() {
    return String.format("Tune [Title: %s, Artist: %s, Genre: %s, Tempo: %d, FilePath: %s]",
        title, artist.getName(), genre, tempo, filePath);
  }
}

/** public string toDtring (){ return String.format ("tune title :% genere }*//