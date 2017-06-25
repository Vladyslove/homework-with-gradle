package algo;

public interface Iterable<T> { // was <Item>
  Iterator<T> iterator();
  ReverseIterator<T> reverseIterator();
}
