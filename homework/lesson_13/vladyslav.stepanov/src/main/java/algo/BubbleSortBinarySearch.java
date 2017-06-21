package algo;

public class BubbleSortBinarySearch extends BinarySearch {

  protected Object[] sort(Object[] unsorted) {
    Object[] sorted = unsorted;

    for (int i = 0; i < sorted.length - 1; i++) {
      Comparable sortValue = (Comparable)sorted[i];
      if (sortValue.compareTo(sorted[i + 1]) > 0) {
        Object temp = unsorted[i];
        sorted[i] = sorted[i + 1];
        sorted[i] = temp;
      }
    }
    return sorted;
  }
}
