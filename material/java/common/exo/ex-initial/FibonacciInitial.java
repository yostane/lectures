///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.logging.Logger;

public class FibonacciInitial {

  public static void main(String... args) {
    Logger.getGlobal().info(String.format("F(0): %d", 0));
    Logger.getGlobal().info(String.format("F(1): %d", 1));
    int secondToLast = 0;
    int last = 1;
    for (int i = 2; i < 10; i++) {
      int current = secondToLast + last;
      Logger.getGlobal().info(String.format("F(%d): %d", i, current));
      secondToLast = last;
      last = current;
    }
  }
}
