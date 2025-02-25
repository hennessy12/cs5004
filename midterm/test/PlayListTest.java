
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayListTest {
  private PlayList playList;

  @BeforeEach
  void setUp() {
    playList = new PlayList();
    playList.addTune(new Mp3Tune("Song1", new Person("Artist1", 1980), Genre.POP, 120, "path1.mp3"));
    playList.addTune(new Mp3Tune("Song2", new Person("Artist2", 1990), Genre.ROCK, 100, "path2.mp3"));
  }

  @Test
  void sortByTitle() {
    playList.sortByTitle();
    assertEquals("Song1", playList.getTune(0).getTitle());
    assertEquals("Song2", playList.getTune(1).getTitle());
  }

  @Test
  void sortByTempo() {
    playList.sortByTempo();
    assertEquals(100, playList.getTune(0).getTempo());
    assertEquals(120, playList.getTune(1).getTempo());
  }
}




