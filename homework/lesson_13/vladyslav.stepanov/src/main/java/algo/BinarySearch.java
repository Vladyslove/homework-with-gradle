package algo;

public abstract class BinarySearch {
  public final int perform(Object[] unsorted, Object toFind) {
    // your code here
    int index = 0;
    Object[] sorted = sort(unsorted);
    index = binarySearch(sorted, toFind);
    return index;
  }

  protected abstract Object[] sort(Object[] unsorted);

  private int binarySearch(Object[] sorted, Object toFind) {
     return binarySearch0(sorted, 0, sorted.length, toFind);
}

  private int binarySearch0(Object[] sorted, int fromIndex, int toIndex,
                                       Object key) {
   int low = fromIndex;
   int high = toIndex - 1;

      while (low <= high) {
          int mid = (low + high) >>> 1;
          // @SuppressWarnings("rawtypes")
          Comparable midVal = (Comparable)sorted[mid];
          // @SuppressWarnings("unchecked")
          int cmp = midVal.compareTo(key);

          if (cmp < 0)
              low = mid + 1;
          else if (cmp > 0)
              high = mid - 1;
          else
              return mid; // key found
      }
      return -(low + 1);  // key not found.
  }
}
