import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

  private static final int PANEL_SIZE = 400; // Define panel boundary
  private static final int DOT_SIZE = 10; // Size of each segment

  private Coordinate apple_loc;
  private Image apple_image;
  private Image snake_head_image;
  private Image snake_body_image;
  private Direction direction; // Use Enum
  private Random rnd;
  private List<Coordinate> snake_loc;

  public MyPanel() {
    this.setFocusable(true);

    try {
      apple_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/10addac51ca9ba16a3cc46fcb64ca250e5fb15c58c78530c2096bf2e4b503b7b/apple.png"));
      snake_head_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/32956f1c46253cf2ebb9a9c6519df3116fe8c4ca7167444c1312168fbb96873c/head.png"));
      snake_body_image = ImageIO.read(new URL(
          "https://cdn-uploads.piazza.com/paste/k53ka6172ie4ll/08b035cfbd798f6bb0e0f7eb680979285a2df1d51f9066d53707a4a0f79f88ac/dot.png"));
    } catch (Exception e) {
      System.out.println("URL doesn't work");
    }

    rnd = new Random();
    apple_loc = new Coordinate(200, 200);
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(50, 50));
    snake_loc.add(new Coordinate(50 + DOT_SIZE, 50));
    snake_loc.add(new Coordinate(50 + 2 * DOT_SIZE, 50));

    direction = Direction.UP; // Start moving up

    new Timer(200, this).start();
    this.addKeyListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);
    g.drawImage(snake_head_image, snake_loc.get(0).x, snake_loc.get(0).y, this);
    for (int i = 1; i < snake_loc.size(); i++) {
      g.drawImage(snake_body_image, snake_loc.get(i).x, snake_loc.get(i).y, this);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    moveSnake();
    checkAppleCollision();
    repaint();
  }

  private void moveSnake() {
    Coordinate old_tail = snake_loc.remove(snake_loc.size() - 1);
    int old_head_x = snake_loc.get(0).x;
    int old_head_y = snake_loc.get(0).y;
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;

    switch (direction) {
      case UP:
        new_head_y -= DOT_SIZE;
        break;
      case DOWN:
        new_head_y += DOT_SIZE;
        break;
      case LEFT:
        new_head_x -= DOT_SIZE;
        break;
      case RIGHT:
        new_head_x += DOT_SIZE;
        break;
    }

    // Wrap-around logic
    if (new_head_x < 0) new_head_x = PANEL_SIZE - DOT_SIZE; // Left to right
    else if (new_head_x >= PANEL_SIZE) new_head_x = 0; // Right to left
    if (new_head_y < 0) new_head_y = PANEL_SIZE - DOT_SIZE; // Top to bottom
    else if (new_head_y >= PANEL_SIZE) new_head_y = 0; // Bottom to top

    snake_loc.add(0, new Coordinate(new_head_x, new_head_y));
  }

  private void checkAppleCollision() {
    if (snake_loc.get(0).equals(apple_loc)) {
      snake_loc.add(new Coordinate(apple_loc.x, apple_loc.y)); // Grow snake
      regenApple();
    }
  }

  private void regenApple() {
    int new_x = rnd.nextInt(PANEL_SIZE / DOT_SIZE) * DOT_SIZE;
    int new_y = rnd.nextInt(PANEL_SIZE / DOT_SIZE) * DOT_SIZE;
    apple_loc = new Coordinate(new_x, new_y);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        if (direction != Direction.DOWN) direction = Direction.UP;
        break;
      case KeyEvent.VK_DOWN:
        if (direction != Direction.UP) direction = Direction.DOWN;
        break;
      case KeyEvent.VK_LEFT:
        if (direction != Direction.RIGHT) direction = Direction.LEFT;
        break;
      case KeyEvent.VK_RIGHT:
        if (direction != Direction.LEFT) direction = Direction.RIGHT;
        break;
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}
}
