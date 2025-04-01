/**
 * Main class to test the implementation of a pretend file system using the Composite Design Pattern.
 */
public class Main {
    public static void main(String[] args) {
        // Creating the root directory
        Folder root = new Folder("root");

        // Creating a home directory inside root
        Folder home = new Folder("home");
        root.addNode(home);

        // Creating another folder inside home
        Folder mlmiller = new Folder("mlmiller");
        home.addNode(mlmiller);

        // Adding files inside mlmiller folder
        File markFileA = new File("markFileA.txt");
        File markFileB = new File("markFileB.txt");

        mlmiller.addNode(markFileA);
        mlmiller.addNode(markFileB);

        // Printing the structure
        root.prettyPrintName("");
    }
}
