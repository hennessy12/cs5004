/**
 * Concrete class representing a file in the file system.
 * A file does not contain other files or folders.
 */
public class File extends FileSys {

  /**
   * Constructor to initialize a file with a given name.
   * @param name Name of the file.
   */
  public File(String name) {
    super(name);
  }

  /**
   * Pretty prints the file with appropriate indentation.
   * @param indent Indentation for formatting the output.
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + name);
  }
}
