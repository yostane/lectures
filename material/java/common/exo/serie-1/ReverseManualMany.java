///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class ReverseManualMany {

  public static void main(String... args) {
    if (args.length == 0) {
      System.err.println("Usage: ReverseManual inputString");
      exit(1);
    }

    for (String input : args) {
      String output = "";
      for (int i = 0; i < input.length(); i++) {
        output = input.charAt(i) + output;
      }

      System.out.println(output);
    }
  }
}
