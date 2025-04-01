/**
 * Abstract class representing a file system component (either a file or a folder).
 */
public abstract class FileSys {
  protected String name; // Name of the file or folder

  /**
   * Constructor to initialize the name of the file system entity.
   * @param name Name of the file or folder.
   */
  public FileSys(String name) {
    this.name = name;
  }

  /**
   * Getter for the name of the file system entity.
   * @return The name of the file or folder.
   */
  public String getName() {
    return name;
  }

  /**
   * Abstract method to pretty print the file system structure.
   * @param indent Indentation for formatting the output.
   */
  public abstract void prettyPrintName(String indent);
}

