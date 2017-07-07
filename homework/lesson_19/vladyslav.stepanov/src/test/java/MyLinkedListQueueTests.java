import org.junit.Before;
import org.junit.Test;

import algo.queue.LinkedListQueue;
import algo.queue.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MyLinkedListQueueTests {

  private LinkedListQueue<Integer> queue;

  @Before
  public void setUp() throws Exception {
    queue = new LinkedListQueue<>();
  }

  @Test
  public void testIsEmptyWithNonZeroElems() {
    queue.enqueue(11);

    assertThat(queue.isEmpty(), is(false));
  }

  @Test
  public void testIsEmptyWithZeroElems() {

    assertThat(queue.isEmpty(), is(true));
  }

  @Test
  public void testClearWithIsEmpty() {
    queue.enqueue(11);
    queue.clear();

    assertThat(queue.isEmpty(), is(true));
  }

  @Test
  public void testClearWithSize() {
    queue.enqueue(11);
    queue.clear();

    assertThat(queue.size(), is(0));
  }

  @Test
  public void testSimpleAddition() {
    queue.enqueue(11);

    assertThat(queue.dequeue(), is(11));
  }

  @Test
  public void testFewAdditionsInRow() {
    queue.enqueue(11);
    queue.enqueue(22);
    queue.enqueue(33);

    assertThat(queue.dequeue(), is(11));
    assertThat(queue.dequeue(), is(22));
    assertThat(queue.dequeue(), is(33));
  }

  @Test
  public void testAdditionAndRemoval() {
    queue.enqueue(11);
    queue.enqueue(22);
    queue.enqueue(33);

    queue.dequeue();
    queue.dequeue();

    queue.enqueue(44);

    assertThat(queue.dequeue(), is(33));
    assertThat(queue.dequeue(), is(44));
  }

  @Test
  public void testMoreAdditions() {
    for (int i = 0; i < 22; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 22; i++) {
      assertThat(queue.dequeue(), is(i));
    }
  }

  @Test
  public void IteratorOrderTest() {
    queue.enqueue(11);
    queue.enqueue(22);
    queue.enqueue(33);

    assertThat(queue.iterator().next(), is (11));
  }

  @Test
  public void IteratorOverallTest() {
    queue.enqueue(11);
    queue.enqueue(22);
    queue.enqueue(33);

    int sum = 0;
    Iterator<Integer> iterator = queue.iterator();
    while(iterator.hasNext()) {
      sum += iterator.next();
    }

    assertThat(sum, is(11+22+33));
  }

  @Test
  public void sizeShouldBeZeroAfterClearMethodCall() {
    queue.clear();

    assertThat(queue.size(), is(0));
  }

  @Test
  public void testInitialSize() {

    assertThat(queue.size(), is(0));
  }


  @Test
  public void testSizeWithThreeElems() {
    queue.enqueue(11);
    queue.enqueue(22);
    queue.enqueue(33);

    assertThat(queue.size(), is(3));
  }

  @Test
  public void testSizeWithOneElems() {
    queue.enqueue(11);

    assertThat(queue.size(), is(1));
  }


}
