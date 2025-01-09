package org.example;

import javax.annotation.Nonnull;
import java.util.Scanner;

public class Ex3Main {

  public static void main(String... args) {
    @Nonnull IntCalculator intCalculator = new IntCalculator();
    @Nonnull HistoryLineProcessor<IntCalculator> lineProcessor = new HistoryLineProcessor<>(intCalculator, System.out);

    @Nonnull var scanner = new Scanner(System.in);
    while(!lineProcessor.isExited){
      @Nonnull var line = scanner.nextLine();
      lineProcessor.processLine(line);
    }
    scanner.close();
  }
}