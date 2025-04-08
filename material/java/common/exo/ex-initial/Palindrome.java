///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class Palindrome {

  public static boolean isPalindromeWithEquals(String input) {
    String reversed = "";
    for (int i = 0; i < input.length(); i++) {
      reversed = input.charAt(i) + reversed;
    }
    return input.equalsIgnoreCase(reversed);
  }

  public static boolean isPalindromeWithoutEquals(String input) {
    for (int i = 0; i < input.length() / 2; i++) {
      if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String... args) {
    if (args.length == 0) {
      System.err.println("Usage: Palindrome inputString");
      exit(1);
    }
    System.out.println("Is palindrome with equals");
    System.out.println(isPalindromeWithEquals(args[0]) ? "Palindrome" : "Pas un Palindrome");
    System.out.println("Is palindrome without equals: ");
    System.out.println(isPalindromeWithoutEquals(args[0]) ? "Palindrome" : "Pas un Palindrome");
  }
}
