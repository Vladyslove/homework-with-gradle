// import java.util.Arrays;

public class ArraysCopier {
  int[] array;

  //  public static void main(String[] args) {
  //    int[] array = {1, 2, 9, 8, 12, 15, 21, 5, 8, 12};
  //    ArraysCopier a = new ArraysCopier(array);
  //    System.out.println(Arrays.toString(a.copyOf(5)));
  //    System.out.println(Arrays.toString(a.copyOf(15)));
  //    System.out.println(Arrays.toString(a.copyOfRange(5, 9)));
  //    System.out.println(Arrays.toString(a.copyOfRange(10, 15)));
  //    System.out.println(Arrays.toString(a.fill(99)));
  //    System.out.println(Arrays.toString(array));
  //  }

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
    // if (newLength > array.length) {
    //   return null;
    // }

    int[] arr = new int[newLength];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (i < array.length) ? array[i] : 0;
    }
    return arr;
  }

  // возвращает новый массив начиная с элемента from до элемента to
  public int[] copyOfRange(int from, int to) {

    // if (to >= array.length || to < from) {
    //   return null;
    // }
    //
    // int newLength = to - from + 1;
    // int[] arr = new int[newLength];
    //
    // if (newLength == 1) {
    //   return arr = new int[] {};
    // }
    //
    // for (int i = 0; i < arr.length; i++) {
    //   arr[i] = array[from + i];
    // }
    // return arr;

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
