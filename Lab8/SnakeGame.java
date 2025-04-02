import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new MyPanel();
    panel.setPreferredSize(new Dimension(400, 400));
    frame.add(panel);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
