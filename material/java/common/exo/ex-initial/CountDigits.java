///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class CountDigits {

  public static void main(String... args) {
    if (args.length == 0) {
      System.err.println("Usage: CountDigits inputNumber");
      exit(1);
    }
    int input = Integer.parseInt(args[0]);
    String detail = " (";
    int sum = 0;
    // Pour ne pas afficher le + dans le détail du calcul du premier nombre
    boolean isFirst = true;
    while (input != 0) {
      int digit = input % 10;
      String prefix = isFirst ? "" : " + ";
      detail += prefix + digit;
      isFirst = false;
      input = input / 10;
      sum += digit;
    }
    detail += ")";

    System.out.println(sum + detail);
  }
}
