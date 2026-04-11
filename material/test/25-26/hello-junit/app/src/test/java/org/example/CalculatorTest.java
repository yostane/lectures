package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
  @Test
  void canAdd() {
    Calculator calculator = new Calculator();
    assertEquals(10.0, calculator.add(-77, 87));
    assertNotEquals(4, calculator.add(5.1, 8));
  }

  @Test
  void canAddOtherTest() {
    Calculator calculator = new Calculator();
    assertEquals(7.0, calculator.add(-77, 87));
  }
}
