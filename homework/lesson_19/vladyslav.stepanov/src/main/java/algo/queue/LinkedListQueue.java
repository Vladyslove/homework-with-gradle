package algo.queue;

import java.util.NoSuchElementException;

public class LinkedListQueue<T> implements Queue<T> {
  private int size;
  private Node first;
  private Node last;

  private class Node {
    private T elem;
    private Node next;
  }

  public void enqueue(T elem) {
    Node temp = new Node();
    temp.elem = elem;
    if (isEmpty()) {
      first = temp;
    } else {
      last.next = temp;
    }
    last = temp;
    size++;

    // temp = first; || first = temp
    // first = last;
    // last = temp;
    //
    // a = 1
    // b = 2
    // temp = a = 1
    // a = b = 2
    // b = temp = 1
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Nothig to dequeue, queue is empty.");
    } else if (first.next == null) {
      last = null;
    }
    T temp = first.elem;
    first = first.next;
    size--;
    return temp;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    first = null;
    size = 0;
  }

  public Iterator<T> iterator() {
    return new QueueIterator<>();
  }

  // В данном итераторе очередь будте работать по принципу FIFO - first in first out
  private class QueueIterator<X> implements Iterator<T> {
    private Node current = first;

    public boolean hasNext() {
      return (current != null);
    }

    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      T elem = current.elem;
      current = current.next;
      return elem;
    }
  }
}
