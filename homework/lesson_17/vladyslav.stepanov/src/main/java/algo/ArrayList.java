package algo;

public class ArrayList<T> implements List<T> {
  private int size = 0;
  private Object[] elements = new Object[10];

  public void add(T elem) {
    elements[size++] = elem;
  }

  public T get(int index) {
    return (T)elements[index]; // we must cast Object to T
  }

  public void clear() {
    elements = new Object[10];
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void remove(int index) {
    elements[size--] = elements[index];

  }

  public Iterator<T> iterator() {
    return new ArrayListIterator<>();
  }

  public ReverseIterator<T> reverseIterator() {
    return new ArrayListReverseIterator<>();
  }

  public RandomlyIterable<T> randomIterator() {
    return new ArrayListRandomlyIterable<>();
  }

  private class ArrayListRandomlyIterable<X> implements RandomlyIterable<T> {
    private int randomIndex;

    public T randomIterator() {
      return (T) elements[randomIndex];
    }

  }

  private class ArrayListIterable<X> implements Iterable<T> {

    public Iterator <T> iterator() {
      return new Iterator<T>() { // Anonim class
        int currentIndex;
        public boolean hasNext() {
          return currentIndex != size;
        }

        public T next() {
          return (T) elements[currentIndex++];
        }

      };
    }

    public ReverseIterator<T> reverseIterator() {
      return new ReverseIterator<T>() { // Anonim class
        int previousIndex = size - 1;
        public boolean hasPrevious() {
          return previousIndex != - 1;
        }

        public T previous() {
          return (T) elements[previousIndex--];
        }

      };

    }

  }
  public ArrayListRandomlyIterable<T> randomIterator() {
    return new RandomlyIterable<T>() {
      int randomIndex = ((int)(Math.random() * size));
      public boolean hasRandom() {
        return randomIndex != -1;
      }

      public T randomNext() {
          return (T) elements[randomIndex];
        }
    };
  }
}
