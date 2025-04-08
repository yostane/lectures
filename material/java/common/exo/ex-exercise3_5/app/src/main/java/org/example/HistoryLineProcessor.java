package org.example;

import javax.annotation.Nonnull;
import java.io.PrintStream;
import java.util.stream.Collectors;

public class HistoryLineProcessor<Calculator extends AbstractIntCalculator> {

  public HistoryLineProcessor(@Nonnull Calculator calculator,
                              @Nonnull PrintStream outputStream) {
    this.historyCalculator = new HistoryCalculator<>(calculator);
    this.outputStream = outputStream;
  }

  @Nonnull
  HistoryCalculator<Calculator> historyCalculator;
  @Nonnull
  PrintStream outputStream;
  boolean isExited = false;

  public void processLine(@Nonnull String line) {
    switch (line) {
      case "h": {
        @Nonnull var history = this.historyCalculator.getHistory();
        @Nonnull String output = history.stream().collect(Collectors.joining("\n"));
        //String output = String.join("\n", history);
        this.outputStream.println(output);
      }
      break;
      case "+":
      case "-":
      case "*":
      case "/": {
        @Nonnull var history = this.historyCalculator.filterHistoryByOperator(line.charAt(0));
        @Nonnull String output = history.stream().collect(Collectors.joining("\n"));
        //String output = String.join("\n", history);
        outputStream.println(output);
      }
      break;
      case "exit":
        this.isExited = true;
        break;
      default:
        try {
          int result = this.historyCalculator.compute(line);
          outputStream.println(result);
        } catch (IllegalArgumentException iae) {
          outputStream.println(iae.getMessage());
        }
        break;
    }
  }
}
