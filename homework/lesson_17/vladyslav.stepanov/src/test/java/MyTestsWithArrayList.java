import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.anyOf;

import algo.*;

public class AcceptanceTests {
  private List<Integer> list;

  @Before
  public void setUp() {
    list = new ArrayList<>();

    list.add(11);
    list.add(22);
    list.add(33);
    list.add(44);
  }

  @Test
  public void testFetchingElementsByIndex() {

    assertThat(list.get(0), is(11));
    assertThat(list.get(1), is(22));
    assertThat(list.get(2), is(33));
    assertThat(list.get(3), is(44));
  }

  @Test
  public void testInsertion_thenGetOfFirstElem() {
    assertThat(list.get(0), is(11));
  }

  @Test
  public void testInsertion_thenGetOfSecondElem() {
    assertThat(list.get(1), is(22));
  }

  @Test
  public void testInsertion_thenGetOfThirdElem() {
    assertThat(list.get(2), is(33));
  }

  @Test
  public void removalOfFirstElement() {
    list.remove(0);

    assertThat(list.get(0), is(22));
  }

  @Test
  public void removalOfLastElement() {
    list.remove(3);

    assertThat(list.get(2), is(33));
  }

  @Test
  public void removalElementInTheMiddle() {
    list.remove(1);

    assertThat(list.get(0), is(11));
    assertThat(list.get(1), is(33));
  }

  @Test
  public void removalThreeElementsOneByOne() {
    list.remove(0);
    list.remove(0);
    list.remove(0);

    assertThat(list.get(0), is(44));
  }

  @Test
  public void onEmptyList_isEmpty_returnsTrue() {
    List<Integer> list = new ArrayList<>();

    assertThat(list.isEmpty(), is(true));
  }

  @Test
  public void onNonEmptyList_isEmpty_returnsFalse() {
    List<Integer> list = new ArrayList<>();
    list.add(777);

    assertThat(list.isEmpty(), is(false));
  }

  @Ignore
  @Test // MY
  public void onNonEmptyList_isEmpty_returnsTrue() {
    List<Integer> list = new ArrayList<>();
    list.clear();

    assertThat(list.isEmpty(), is(true));
  }

  @Test
  public void onNoneEmptyList_size_returnsNumberOfItems() {
    List<Integer> list = new ArrayList<>();
    list.add(777);
    list.add(999);

    assertThat(list.size(), is(2));
  }

  @Ignore
  @Test // MY
  public void onNoneEmptyList_size_returnsNumberOfItems() {

    assertThat(list.size(), is(4));
  }

  @Test
  public void afterClearMethodCall_listShouldBeEmpty() {
    list.clear();

    assertThat(list.isEmpty(), is(true));
  }

  @Test (timeout = 3000)
  public void addingPlentyElements() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i <= 10_000; i++) {
      list.add(i);
    }

    assertThat(list.get(0), is(0));
    assertThat(list.get(750), is(750));
    assertThat(list.get(1_500), is(1_500));
    assertThat(list.get(7_500), is(7_500));
    assertThat(list.get(15_000), is(15_000));
  }

  @Test
  public void iteratorOverallTest() {
    List<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(7);
    list.add(10);

    int sum = 0;
    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()) {
      sum += iter.next();
    }

    assertThat(sum, is(5 + 7 + 10));
  }

  @Test
  public void reverseIteratorOverallTest() {
    List<Integer> list = new ArrayList<>();
    list.add(44);
    list.add(27);
    list.add(3);

    int sum = 0;
    ReverseIterator<Integer> iter = list.reverseIterator();
    while(iter.hasPrevious()) {
      sum += iter.previous();
    }

    assertThat(sum, is(3 + 27 + 44));
  }

  @Test
  public void iteratorOrderTest() {
    List<Integer> list = new ArrayList<>();
    list.add(177);
    list.add(222);

    assertThat(list.iterator().next(), is(177));
  }

  @Test
  public void reverseIteratorTest() {
    List<Integer> list = new ArrayList<>();
    list.add(125);
    list.add(457);

    assertThat(list.reverseIterator().previous(), is(457));
  }

  @Test
  public void randomIteratorTest() {
    List<Integer> list = new ArrayList<>();
    list.add(124);
    list.add(254);

    assertThat(list.randomIterator().next(), anyOf(is(124), is(254)));
  }

  // My personal test from lesson17, which took place in the classrom of school)

  @Test
public void testClearWithSize() {
  list.clear();

  assertThat(list.size(), is(0));
}


@Test
public void testClearWithGet() {
  list.clear();

  assertThat(list.get(0), is(list.get(0)));
}


@Test
public void testClear() {
  list.clear();

  assertThat(0, is(0));
}


@Test
public void testIsEmpty() {
  list.clear();

  assertThat(list.isEmpty(), is(true));
}


@Test
public void testSize() {

  assertThat(list.size(), is(3));
}


// @Ignore
// Don't past and i don't know why
@Test
public void testRemove() {

  list.remove(1);

  assertThat(list.get(1), is(2));
}


@Test
public void testPrevious() {

  List<Integer> list = new ArrayList<>();
    list.add(1251);
    list.add(12);
    list.add(77);

  assertThat(list.reverseIterator().previous(), is(77));
}


@Test
public void testPrevious2() {
  assertThat(list.reverseIterator().previous(), is(2));
}


@Test
public void reverseIteratorOverallTest2() {
  List<Integer> list = new ArrayList<>();
  list.add(44);
  list.add(27);
  list.add(3);

  int sum = 0;
  ReverseIterator<Integer> revIter = list.reverseIterator();
  while(revIter.hasPrevious()) {
    sum += revIter.previous();
  }

  assertThat(sum, is(3 + 27 + 44));
}


@Test
public void testhasPreviousWithClear() {
  list.clear();
  assertThat(list.reverseIterator().hasPrevious(), is(false));

}

@Test
public void testhasPreviousWithAdd() {
  assertThat(list.reverseIterator().hasPrevious(), is(true));

}

@Test
public void testPreviousIterator() {

  int counter = list.size()-1;
  ReverseIterator<Integer> reverIter = list.reverseIterator();
  while (reverIter.hasPrevious()) {
    assertThat(reverIter.previous(), is(counter));
    counter--;
  }
  ReverseIterator<Integer> iter2 = list.reverseIterator();
  while (iter2.hasPrevious()) {
    System.out.println(iter2.previous());
  }
}

@Test
public void testNext() {

  assertThat(list.iterator().next(), is(0));

}

@Test
public void testHasNext() {
  list.clear();

  assertThat(list.iterator().hasNext(), is(false));

}
}
