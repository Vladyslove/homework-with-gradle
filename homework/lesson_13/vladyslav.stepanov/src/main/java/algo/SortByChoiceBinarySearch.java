package algo;

public class SortByChoiceBinarySearch extends BinarySearch {
  protected Object[] sort(Object[] unsorted) {
    Object[] sorted2 = unsorted;
    int indexMin;
    for (int index = 0; index < sorted2.length - 1; index++) {
      indexMin = index;
      Comparable sortValue2 = (Comparable)sorted2[index];
      for (int indexToScan = 0; indexToScan < sorted2.length; indexToScan++ ) {
        if (sortValue2.compareTo(sorted2[indexToScan]) > 0) {
          indexMin = indexToScan;

        }
      }
      Object temp = unsorted[index];
      sorted2[index] = sorted2[indexMin];
      sorted2[indexMin] = temp;
    }
    return sorted2;
  }
}
