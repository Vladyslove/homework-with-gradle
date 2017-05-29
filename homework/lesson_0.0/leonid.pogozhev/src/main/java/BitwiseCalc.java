public class BitwiseCalc {

  //  public static void main(String[]args){
  //    BitwiseCalc and1 = new BitwiseCalc();
  //    BitwiseCalc or1 = new BitwiseCalc();
  //    BitwiseCalc xor1 = new BitwiseCalc();
  //    BitwiseCalc not1 = new BitwiseCalc();
  //    String binary1 = "1110";
  //    String binary2 = "0101";
  //
  //    System.out.println(binary1 + " 'and' " +binary2 + " = " + and1.and(binary1, binary2));
  //    System.out.println(binary1 + " 'or' " +binary2 + " = " + or1.or(binary1, binary2));
  //    System.out.println(binary1 + " 'xor' " +binary2 + " = " + xor1.xor(binary1, binary2));
  //    System.out.println("'not' " +binary1 + " = " + not1.not(binary1));
  //  }

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
