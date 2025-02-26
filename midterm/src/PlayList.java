import java.util.function.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * Concrete Class to implement a Simple Playlist.
 */
public class PlayList {
  private List<Tune> myPlayList;

  /**
   * Constructor, creates a new, empty PlayList.
   */
  public PlayList() {
    myPlayList = new LinkedList<>();
  }

  /**
   * Adds a new Tune to the end of the PlayList.
   *
   * @param tune the tune to add.
   */
  public void addTune(Tune tune) {
    myPlayList.add(tune);
  }

  /**
   * Gets the Tune from index position i.
   *
   * @param i the index of the tune to retrieve.
   * @return the tune at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  Tune getTune(int i) throws IndexOutOfBoundsException {
    return myPlayList.get(i);
  }

  /**
   * Removes all occurrences of a Tune from the PlayList.
   *
   * @param tune the tune to remove.
   * @return true if the tune was found and removed, false otherwise.
   */
  boolean remove(Tune tune) {
    return myPlayList.remove(tune);
  }

  /**
   * Returns the size of the PlayList.
   *
   * @return the number of tunes in the PlayList.
   */
  int size() {
    return myPlayList.size();
  }

  /**
   * Sorts the PlayList by title, ignoring case.
   * <p></p>
   * This method uses the natural ordering of Tunes, which is defined by the
   * `compareTo` method in the `AbstractTune` class.
   */
  void sortByTitle() {
    // Use Collections.sort with the natural ordering of Tunes (based on title)
    Collections.sort(myPlayList);
  }

  /**
   * Sorts the PlayList by tempo.
   * <p></p>
   * This method uses a custom `TempoComparator` to sort tunes by their tempo.
   */
  void sortByTempo() {
    // Use Collections.sort with a custom TempoComparator
    Collections.sort(myPlayList, new TempoComparator());
  }

  /**
   * Returns the PlayList as a string suitable for printing.
   *
   * @return a string representation of the PlayList.
   */
  @Override
  public String toString() {
    StringBuilder soFar = new StringBuilder("{\n");
    for (Tune aTune : myPlayList) {
      soFar.append(aTune.toString()).append("\n");
    }
    return soFar + "}";
  }
}

