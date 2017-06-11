import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class SimpleStringCalculatorTest {
  private  SimpleStringCalculator str = new SimpleStringCalculator();

  @Test
  public void nuberSummationTest() {
      assertThat(str.add("1+2+3+4+5+6+7"), is(28));
  }

  @Test
  public void nuberSummationWithExceptionTest() throws Exception {
    assertThat(str.add("1+2+3+4+5+6+7"), is(28));
  }

  @Test
  public void emptyStringTest() {
    assertThat(str.add(""), is(0));
  }

  @Test
  public void AnyNumbersWhatYouWantTest() {
    assertThat(str.add("1+2+3+4+5+6+7+8+9+10"), is(55));
  }

  @Test
  public void AnyNumbersWhatYouWantTest1() {
    assertThat(str.add("1+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19+20"), is(210));
  }

  @Test
  public void anySepartorInsteadPlusTest() {
    assertThat(str.add("1@2#3$4%5"), is(15));
  }

  @Test
  public void anySepartorInsteadPlusAndWithPlusTest() {
    assertThat(str.add("1@2#3$4%5+6"), is(21));
  }

  @Test
  public void anySymbolAtTheStartOfLineTest() {
    assertThat(str.add("!1@2#3$4%5+6"), is(21));
  }

  @Test
  public void negativeNumberTest() {
    assertThat(str.add("1+2+3+4-5+6+7"), is(-1));
  }

  @Test
  public void negativeNumbersTest() {
    assertThat(str.add("-1-2-3-4-5-6-7"), is(-1));
  }

  @Test
  public void largeNumberTest() {
    assertThat(str.add("1+10+1001"), is(11));
  }

  @Test
  public void largeNumberTest1() {
    assertThat(str.add("1+99999"), is(1));
  }

  @Test
  public void notLargeNumberTest() {
    assertThat(str.add("9+90+900+1000"), is(1999));
  }
}
