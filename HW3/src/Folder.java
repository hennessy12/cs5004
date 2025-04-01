import java.util.ArrayList;
import java.util.List;

/**
 * Concrete class representing a folder in the file system.
 * A folder can contain other folders or files.
 */
public class Folder extends FileSys {
  private List<FileSys> children; // List of files and subfolders within the folder

  /**
   * Constructor to initialize a folder with a given name.
   * @param name Name of the folder.
   */
  public Folder(String name) {
    super(name);
    this.children = new ArrayList<>();
  }

  /**
   * Adds a file or folder as a child of this folder.
   * @param node The file or folder to be added.
   */
  public void addNode(FileSys node) {
    children.add(node);
  }

  /**
   * Pretty prints the folder and its contents recursively.
   * @param indent Indentation for formatting the output.
   */
  @Override
  public void prettyPrintName(String indent) {
    System.out.println(indent + "d " + name); // Prefix "d " for directory
    for (FileSys child : children) {
      child.prettyPrintName(indent + "    "); // Indent further for children
    }
  }
}
