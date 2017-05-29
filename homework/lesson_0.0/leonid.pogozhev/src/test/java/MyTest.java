import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class MyTest {
  private ArraysCopier copier;

  @Before
  public void setUp() {
    copier = new ArraysCopier(new int[] {1, 2, 9, 8, 12, 15, 21, 5, 8, 12});
  }

  @Test
  public void copyOfTheSameLengthArray() throws Exception {
    assertThat_CopyOf(10, new int[] {1, 2, 9, 8, 12, 15, 21, 5, 8, 12});
  }

  @Test
  public void copyOfEmptyArray() throws Exception {
    assertThat_CopyOf(0, new int[] {});
  }

  @Test
  public void copyOfBiggerArray() throws Exception {
    assertThat_CopyOf(15, new int[] {1, 2, 9, 8, 12, 15, 21, 5, 8, 12, 0, 0, 0, 0, 0});
  }

  @Test
  public void copyOfSmallerArray() throws Exception {
    assertThat_CopyOf(5, new int[] {1, 2, 9, 8, 12});
  }

  private void assertThat_CopyOf(int newLength, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOf(newLength), equalsToArray), is(true));
  }

  @Test
  public void coppyFirstHalfOfArray() throws Exception {
    assertThat_CopyOfRange(0, 5, new int[] {1, 2, 9, 8, 12});
  }

  @Test
  public void coppySecondHalfOfArray() throws Exception {
    assertThat_CopyOfRange(5, 10, new int[] {15, 21, 5, 8, 12});
  }

  @Test
  public void coppyOneElementOfArray_shouldReturnEmptyArray() throws Exception {
    assertThat_CopyOfRange(4, 4, new int[] {});
  }

  @Test
  public void coppyWrongRangeOfArray() throws Exception {
    assertThat(copier.copyOfRange(4, 2), is(nullValue()));
  }

  private void assertThat_CopyOfRange(int from, int to, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.copyOfRange(from, to), equalsToArray), is(true));
  }

  @Test
  public void fillWithZeroValue() {
    assertThat_fillWithValue(0, new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
  }

  @Test
  public void fillWithNegativeValue() {
    assertThat_fillWithValue(-1, new int[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1});
  }

  private void assertThat_fillWithValue(int value, int[] equalsToArray) {
    assertThat(Arrays.equals(copier.fill(value), equalsToArray), is(true));
  }

  @Test
  public void bitwiseAndWithPaddings() throws Exception {
    String left = "11110101";
    String right = "1111";

    assertThat(BitwiseCalc.and(left, right), is("0000" + "0101"));
  }

  @Test
  public void bitwiseAndWithPaddings2() throws Exception {
    String left = "1111";
    String right = "10101010";

    assertThat(BitwiseCalc.and(left, right), is("0000" + "1010"));
  }

  @Test
  public void AndTesting() throws Exception {
    String left =  "1110";
    String right = "0101";

    assertThat(BitwiseCalc.and(left, right), is("0100"));
  }

  @Test
  public void OrTesting() throws Exception {
    String left =  "1110";
    String right = "0101";

    assertThat(BitwiseCalc.or(left, right), is("1111"));
  }

  @Test
  public void XorTesting() throws Exception {
    String left =  "1110";
    String right = "0101";

    assertThat(BitwiseCalc.xor(left, right), is("1011"));
  }

  @Test
  public void NotTesting() throws Exception {
    assertThat(BitwiseCalc.not("1110"), is("0001"));
  }
}
