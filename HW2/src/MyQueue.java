import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A generic queue implementation using an ArrayList.
 * This queue follows the FIFO (First In, First Out) principle.
 *
 * @param <T> the type of elements in the queue
 */
public class MyQueue<T> {
  private ArrayList<T> data;

  /**
   * Constructs an initially empty queue.
   */
  public MyQueue() {
    data = new ArrayList<>();
  }

  /**
   * Adds an element to the tail of the queue.
   *
   * @param e the element to be added
   */
  public void enqueue(T e) {
    data.add(e);
  }

  /**
   * Removes and returns the head element of the queue.
   *
   * @return the head element
   * @throws NoSuchElementException if the queue is empty
   */
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return data.remove(0);
  }

  /**
   * Returns the head element without removing it.
   *
   * @return the head element
   * @throws NoSuchElementException if the queue is empty
   */
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is empty");
    }
    return data.get(0);
  }

  /**
   * Checks if the queue is empty.
   *
   * @return true if the queue is empty, otherwise false
   */
  public boolean isEmpty() {
    return data.isEmpty();
  }

  /**
   * Returns a string representation of the queue.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return "Queue: " + String.join(" ", data.stream().map(Object::toString).toArray(String[]::new));
  }

  /**
   * Compares this queue with another object for equality.
   *
   * @param obj the object to compare
   * @return true if the objects are equal, otherwise false
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    MyQueue<?> myQueue = (MyQueue<?>) obj;
    return data.equals(myQueue.data);
  }

  /**
   * Returns a hash code for this queue.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(data);
  }
}

/**  QA: Frequent dequeue() operations in an ArrayList-based queue cause O(n) time complexity due to element shifting, leading to performance issues.*?
 *
 */
/** QB: Using LinkedList instead avoids this problem with O(1) dequeues. */
