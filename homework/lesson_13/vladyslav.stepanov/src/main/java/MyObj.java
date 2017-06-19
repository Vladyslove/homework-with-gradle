public class MyObj implements Comparable {
  int value;

  public int compareTo(Object obj) {
    MyObj another = (MyObj) obj;
    return Integer.compare(value, another.value);
  }
}
