package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;

public class TestController6 {

  @Test
  public void testMultipleAdditionsAndQuit() throws IOException {
    // Prepare test input
    String input = "+ 3 4 + 8 9 q";
    Readable in = new StringReader(input);

    // Create output buffer to capture results
    StringBuffer out = new StringBuffer();

    // Create calculator and controller
    Calculator calc = new Calculator();
    Controller6 controller = new Controller6(in, out);

    // Execute the controller
    controller.go(calc);

    // Define expected output
    String expectedOutput = "7\n17\n";

    // Verify output
    assertEquals(expectedOutput, out.toString());
  }
}
