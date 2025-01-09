package org.example;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.List;

/**
 * HistoryCalculator
 */
public class HistoryCalculator<Calculator extends AbstractIntCalculator> {
  private final @Nonnull Calculator calculator;
  private final @Nonnull List<String> history = new ArrayList<>();

  public HistoryCalculator(@Nonnull Calculator calculator) {
    this.calculator = calculator;
  }

  public int compute(@Nonnull String line) throws IllegalArgumentException {
    int result = this.calculator.computeFromString(line);
    this.history.add(String.format("%s = %d", line, result));
    return result;
  }

  @Nonnull
  public List<String> getHistory() {
    return this.history;
  }

  @Nonnull
  public List<String> filterHistoryByOperator(char operator) {
    return this.history.stream().filter(
        line -> line.chars().anyMatch(c -> c == operator)).toList();
  }
}