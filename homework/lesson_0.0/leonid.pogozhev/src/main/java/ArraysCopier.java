public class ArraysCopier {
  int[] array;

  //конструктор, который принимает массив
  //целых чисел в качестве параметра
  public ArraysCopier(int[] array) {
    this.array = array;
  }

  // возвращает новый массив указанной длины.
  public int[] copyOf(int newLength) {
    if (newLength == 0) {
      return new int[0];
    }
    if (newLength == array.length) {
      return array;
    }

    int[] arr = new int[newLength];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (i < array.length) ? array[i] : 0;
    }
    return arr;
  }

  // возвращает новый массив начиная с элемента from до элемента to
  public int[] copyOfRange(int from, int to) {

    int newLength = to - from;

    if (newLength < 0) {
      return null;
    }

    int[] newArray = new int[newLength];
    for (int i = from, newIndex = 0; i < to; i++, newIndex++) {
      newArray[newIndex] = array[i];
    }
    return newArray;
  }

  // возвращает новый массив заполненный значением параметра value
  public int[] fill(int value) {
    int[] arr = new int[array.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = value;
    }
    return arr;
  }

}
