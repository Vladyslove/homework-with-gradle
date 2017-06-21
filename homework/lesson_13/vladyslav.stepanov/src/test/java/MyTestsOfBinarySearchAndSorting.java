import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import algo.BinarySearch;
import algo.BubbleSortBinarySearch;

import java.util.Arrays;

public class MyTestsOfBinarySearchAndSorting {
  @Test
  public void testExample() {
    BinarySearch bin = new BinarySearch() {
      protected Object[] sort(Object[] input) {
        Arrays.sort(input);
        return input;
      }
    };

    MyObj objectToFind = new MyObj();
    MyObj[] objects = {new MyObj(), objectToFind, new MyObj()};
    int index = bin.perform(objects, objectToFind);

    assertThat(index, is(1));
  }

  @Test
  public void test_BubbleSortBinarySearch_WithSortedArray() {
    BinarySearch bin = new BubbleSortBinarySearch();

    MyObj obj1 = new MyObj();
    MyObj obj2 = new MyObj();
    MyObj obj3 = new MyObj();

    obj1.value = 1000;
    obj2.value = 1111;
    obj3.value = 2222;

    MyObj[] objects = {obj1, obj2, obj3};
    int index = bin.perform(objects, obj2);

    assertThat(index, is(1));
  }

  @Test
  public void test_BubbleSortBinarySearch_WithUnSortedArray() {
    BinarySearch bin = new BubbleSortBinarySearch();

    MyObj obj1 = new MyObj();
    MyObj obj2 = new MyObj();
    MyObj obj3 = new MyObj();

    obj1.value = 222;
    obj2.value = 111;
    obj3.value = 333;

    MyObj[] objects = {obj1, obj2, obj3};
    int index = bin.perform(objects, obj2);

    //assertThat(index, is(1)); // here we don't have what we would expect.
    // The position is 0, not 1, which is a result of sort function inside BinarySearch.perform() method.
    // Therefore, we implement technically incorrect implementation. It works correctly only for sorted arrays ¯\_(ツ)_/¯
    // Even though the behaviour is incorrect for unsorted arrays case, for educational purposes it's fine :)
    assertThat(index, is(1));
  }
}
