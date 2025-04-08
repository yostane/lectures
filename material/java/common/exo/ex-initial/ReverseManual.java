///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class ReverseManual {

  public static void main(String... args) {
    if (args.length == 0) {
      System.err.println("Usage: ReverseManual inputString");
      exit(1);
    }

    // Récupération de l'argument passé en ligne de commande
    String input = args[0];
    String output = "";
    // StringBuffer propose la méthode setCharAt non disponible dans String
    StringBuffer reversedStringBuffer = new StringBuffer();
    reversedStringBuffer.setLength(input.length());

    for (int i = 0; i < input.length(); i++) {
      output = input.charAt(i) + output;
      reversedStringBuffer.setCharAt(input.length() - i - 1, input.charAt(i));
    }

    System.out.println("solution 1: " + output);
    System.out.println("solution 2: " + reversedStringBuffer);
  }
}
