import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTuneTest {
  private AbstractTune tune1;
  private AbstractTune tune2;
  private AbstractTune tune3;

  @BeforeEach
  void setUp() {
    // Initialize test objects
    tune1 = new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    tune2 = new Mp3Tune("Song2", new Person("Artist2", 1990), Genre.ROCK, 100, "path2.mp3");
    tune3 = new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
  }

  /**
   * Test the getTitle method.
   */
  @Test
  void getTitle() {
    assertEquals("Song1", tune1.getTitle(), "Title should be 'Song1'.");
    assertEquals("Song2", tune2.getTitle(), "Title should be 'Song2'.");
  }

  /**
   * Test the getArtist method.
   */
  @Test
  void getArtist() {
    assertEquals("Artist1", tune1.getArtist().getName(), "Artist should be 'Artist1'.");
    assertEquals("Artist2", tune2.getArtist().getName(), "Artist should be 'Artist2'.");
  }

  /**
   * Test the getGenre method.
   */
  @Test
  void getGenre() {
    assertEquals(Genre.POP, tune1.getGenre(), "Genre should be POP.");
    assertEquals(Genre.ROCK, tune2.getGenre(), "Genre should be ROCK.");
  }

  /**
   * Test the getTempo method.
   */
  @Test
  void getTempo() {
    assertEquals(120, tune1.getTempo(), "Tempo should be 120.");
    assertEquals(100, tune2.getTempo(), "Tempo should be 100.");
  }

  /**
   * Test the getFilePath method.
   */
  @Test
  void getFilePath() {
    assertEquals("path1.mp3", tune1.getFilePath(), "File path should be 'path1.mp3'.");
    assertEquals("path2.mp3", tune2.getFilePath(), "File path should be 'path2.mp3'.");
  }

  /**
   * Test the compareTo method.
   */
  @Test
  void compareTo() {
    assertTrue(tune1.compareTo(tune2) < 0, "'Song1' should come before 'Song2'.");
    assertTrue(tune2.compareTo(tune1) > 0, "'Song2' should come after 'Song1'.");
    assertEquals(0, tune1.compareTo(tune3), "Titles are the same, so comparison should return 0.");
  }

  /**
   * Test the equals method.
   */
  @Test
  void testEquals() {
    // Test equality with itself
    assertTrue(tune1.equals(tune1), "A tune should be equal to itself.");

    // Test equality with an identical tune
    assertTrue(tune1.equals(tune3), "Tunes with the same attributes should be equal.");

    // Test inequality with a different tune
    assertFalse(tune1.equals(tune2), "Tunes with different attributes should not be equal.");

    // Test equality with null
    assertFalse(tune1.equals(null), "A tune should not be equal to null.");

    // Test equality with an object of a different class
    assertFalse(tune1.equals("Not a Tune"), "A tune should not be equal to an object of a different class.");
  }

  /**
   * Test the hashCode method.
   */
  @Test
  void testHashCode() {
    // Hash codes should be equal for identical tunes
    assertEquals(tune1.hashCode(), tune3.hashCode(), "Hash codes should be equal for identical tunes.");

    // Hash codes should not be equal for different tunes
    assertNotEquals(tune1.hashCode(), tune2.hashCode(), "Hash codes should not be equal for different tunes.");
  }

  /**
   * Test the toString method.
   */
  @Test
  void testToString() {
    String expected = "Tune [Title: Song1, Artist: Artist1, Genre: POP, Tempo: 120, FilePath: path1.mp3]";
    assertEquals(expected, tune1.toString(), "toString output should match the expected format.");
  }

  /**
   * Test the constructor with invalid arguments.
   */
  @Test
  void testConstructorInvalidArguments() {
    // Test null title
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune(null, new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    }, "Constructor should throw IllegalArgumentException for null title.");

    // Test empty title
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    }, "Constructor should throw IllegalArgumentException for empty title.");

    // Test null artist
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("Song1", null, Genre.POP, 120, "path1.mp3");
    }, "Constructor should throw IllegalArgumentException for null artist.");

    // Test null genre
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("Song1", new Person("Artist1", 1980), null, 120, "path1.mp3");
    }, "Constructor should throw IllegalArgumentException for null genre.");

    // Test non-positive tempo
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 0, "path1.mp3");
    }, "Constructor should throw IllegalArgumentException for non-positive tempo.");

    // Test null file path
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, null);
    }, "Constructor should throw IllegalArgumentException for null file path.");

    // Test empty file path
    assertThrows(IllegalArgumentException.class, () -> {
      new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "");
    }, "Constructor should throw IllegalArgumentException for empty file path.");
  }
}

