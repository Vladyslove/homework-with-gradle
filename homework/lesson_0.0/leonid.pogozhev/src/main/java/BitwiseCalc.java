public class BitwiseCalc {

  private static String addPaddingsTo(String input, int expectedLength) {
    return String.format("%" + expectedLength + "s", input);
  }

  public static String and(String binaryLeft, String binaryRight) {
    if (binaryLeft.length() > binaryRight.length()) {
      binaryRight = addPaddingsTo(binaryRight, binaryLeft.length());
    } else {
      binaryLeft = addPaddingsTo(binaryLeft, binaryRight.length());
    }

    String res = "";
    for (int i = 0; i < binaryLeft.length(); i++) {
      if (binaryLeft.charAt(i) == '1' && binaryRight.charAt(i) == '1') {
        res += "1";
      } else {
        res += "0";
      }
    }
    return res;
  }

  public static String or(String binaryLeft, String binaryRight) {
    String res = "";
    for (int i = 0; i < binaryLeft.length(); i++) {
      if (binaryLeft.charAt(i) == '1' || binaryRight.charAt(i) == '1') {
        res += "1";
      } else {
        res += "0";
      }
    }
    return res;
  }

  public static String xor(String binaryLeft, String binaryRight) {
    String res = "";
    for (int i = 0; i < binaryLeft.length(); i++) {
      if (binaryLeft.charAt(i) == '1' ^ binaryRight.charAt(i) == '1') {
        res += "1";
      } else {
        res += "0";
      }
    }
    return res;
  }

  public static String not(String binary) {
    String res = "";
    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1') {
        res += "0";
      } else {
        res += "1";
      }
    }
    return res;
  }
}
