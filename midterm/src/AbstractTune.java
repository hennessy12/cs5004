/**
 * Abstract Tune class helps implement the Tune interface
 * <p></p>
 * STUDENT TO COMPLETE -- INCLUDING JAVADOCS, STUBBED/MISSING METHODS
 * See AbstractTuneTest as well
 */
public abstract class AbstractTune extends Tune, Comparable<Tune> {
  private String title;
  private Person artist;
  private Genre genre;
  private int tempo;
  private String filePath;

  /**
   * STUDENT TO COMPLETE JAVADOCS and ARG-CHECKING of CONSTRUCTOR
   */
  public AbstractTune(String title, Person artist, Genre genre, int tempo, String filePath) throws IllegalArgumentException {
      this.title = title;
      this.artist = artist;
      this.genre = genre;
      this.tempo = tempo;
  }

  /**
   * STUDENT TO COMPLETE REMAINING METHODS, except playTune, here.
   * INCLUDE ACTUAL JAVADOCS and ARG CHECKS. THIS SHOULD INCLUDE
   * equals METHOD, hashCode METHOD, and toString METHODS. See the
   * parent Interface for a full list of methods required. What
   * you see here has been partly "stubbed out" to get started.
   */
  public String getTitle () {
      return "";
    }

  @Override
  public Person getArtist() {
    return null;
  }

  @Override
  public Genre getGenre() {
    return null;
  }

  @Override
  public int getTempo() {
    return 0;
  }

  @Override
  public String getFilePath() {
    return null;
  }

  /*
   There is one required method that is NOT to be implemented here:
   the method for playing a tune from a file. That is left to each concrete
   class that extends AbstractTune, based on the type of file that
   contains the music. See the two concrete classes for details.
  */

  /** Overriding equals for Tunes to examine all attributes */
  @Override
  public boolean equals (Tune other) {
    // Student to complete
    return false;
  }

  /** Overriding hashCode for Tunes to match equals */
  @Override
  public int hashCode () {
    // Student to complete
    return 0;
  }

  /** Overriding toString for Tunes to include all attributes */
  @Override
  public String toString () {
    // Student to complete
    return "";
  }

  /**
   * Comparable Interface for comparing based on Title
   * <p></p>
   * 
   * @param other -- a Tune
   * @return negative, 0, or positive int based on Title
   *         Comparison should ignore case (so A equals a)
   */
  @Override
  public int compareTo(Tune other) {
    // STUDENT TO IMPLEMENT
    return 0;
    }
}
 // anbsit ajshye @ overide wthdn akjndnno uageb sjniun  bvasedh in tttile s njk Comapratsion

