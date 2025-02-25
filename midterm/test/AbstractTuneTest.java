import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTuneTest {
  private AbstractTune tune1;
  private AbstractTune tune2;

  @BeforeEach
  void setUp() {
    tune1 = new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    tune2 = new Mp3Tune("Song2", new Person("Artist2", 1990), Genre.ROCK, 100, "path2.mp3");
  }

  @Test
  void testToString() {
    String expected = "Tune [Title: Song1, Artist: Artist1, Genre: POP, Tempo: 120, FilePath: path1.mp3]";
    assertEquals(expected, tune1.toString());
  }

  @Test
  void getTitle() {
    assertEquals("Song1", tune1.getTitle());
  }

  @Test
  void compareTo() {
    assertTrue(tune1.compareTo(tune2) < 0);
  }

  @Test
  void testEquals() {
    AbstractTune tune3 = new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    assertTrue(tune1.equals(tune3));
  }

  @Test
  void testHashCode() {
    AbstractTune tune3 = new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3");
    assertEquals(tune1.hashCode(), tune3.hashCode());
  }
}

