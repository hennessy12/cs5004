import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

/**
 * Unit tests for the MyQueue class.
 */
public class MyQueueTest {

  /**
   * Tests the enqueue method.
   */
  @Test
  public void testEnqueue() {
    MyQueue<String> queue = new MyQueue<>();
    queue.enqueue("A");
    assertFalse(queue.isEmpty());
    assertEquals("A", queue.peek());
  }

  /**
   * Tests the dequeue method.
   */
  @Test
  public void testDequeue() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.enqueue(10);
    queue.enqueue(20);
    assertEquals(10, queue.dequeue());
    assertEquals(20, queue.peek());

    assertThrows(NoSuchElementException.class, queue::dequeue);
  }

  /**
   * Tests the peek method.
   */
  @Test
  public void testPeek() {
    MyQueue<Character> queue = new MyQueue<>();
    queue.enqueue('X');
    assertEquals('X', queue.peek());

    assertThrows(NoSuchElementException.class, () -> {
      MyQueue<Character> emptyQueue = new MyQueue<>();
      emptyQueue.peek();
    });
  }

  /**
   * Tests the isEmpty method.
   */
  @Test
  public void testIsEmpty() {
    MyQueue<Float> queue = new MyQueue<>();
    assertTrue(queue.isEmpty());
    queue.enqueue(3.14f);
    assertFalse(queue.isEmpty());
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    MyQueue<String> queue = new MyQueue<>();
    queue.enqueue("Hello");
    queue.enqueue("World");
    assertEquals("Queue: Hello World", queue.toString());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    MyQueue<String> queue1 = new MyQueue<>();
    queue1.enqueue("A");
    queue1.enqueue("B");

    MyQueue<String> queue2 = new MyQueue<>();
    queue2.enqueue("A");
    queue2.enqueue("B");

    assertEquals(queue1, queue2);
  }

  /**
   * Tests the hashCode method.
   */
  @Test
  public void testHashCode() {
    MyQueue<String> queue1 = new MyQueue<>();
    queue1.enqueue("Test");

    MyQueue<String> queue2 = new MyQueue<>();
    queue2.enqueue("Test");

    assertEquals(queue1.hashCode(), queue2.hashCode());
  }
}
