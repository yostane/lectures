package org.example;

import javax.annotation.Nonnull;
import java.util.Scanner;

public abstract class AbstractIntCalculator {
  public int add(int x, int y) {
    return x + y;
  }

  public int multiply(int x, int y) {
    return x * y;
  }

  public int divide(int x, int y) {
    return x / y;
  }

  public int subtract(int x, int y) {
    return x - y;
  }

  abstract public int computeFromString(@Nonnull String input) throws IllegalArgumentException;

  public int computeFromStandardInput() {
    try (Scanner scanner = new Scanner(System.in)) {
      String line = scanner.next();
      return this.computeFromString(line);
    }
  }
}
