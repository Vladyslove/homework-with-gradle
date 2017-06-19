public class SimpleStringCalculator {
  public int add(String expression) {
    int sum = 0;
    if (expression == null || expression.equals(" ") || expression.equals("") ) {
      return 0;
    }
    for (int i = 0; i < expression.length(); i++) {
      char ch = expression.charAt(i);
      String chTemp = Character.toString(ch);
      // String allow us for working with numbers > 9
      String str = "";
      if (Character.isDigit(ch)) {
        // While current element of line is less than length of line and
        // current element is number, than compose line of number fo charachers
        while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
          str += expression.charAt(i++);
        }
        --i;
        int numstr = Integer.parseInt(str);
        // if number less or equal 1000, than we sum if more than 1000 we miss
        if (numstr <= 1000) {
          sum += numstr;
        }
      } else if ((chTemp.equals("-")) && Character.isDigit(expression.charAt(i + 1))) {
        return -1;
      }
    }
    return sum;
  }
}
