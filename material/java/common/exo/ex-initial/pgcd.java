///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class pgcd {

  public static int computePgcd(int a, int b) {
    int min = a <= b ? a : b;
    int pgcd = 1;
    for (int i = 1; i <= min; i++) {
      if (a % i == 0 && b % i == 0) {
        System.out.println(String.format("Trouvé nouveau pgcd %d", i));
        pgcd = i;
      }
    }
    return pgcd;
  }

  public static void main(String... args) {
    System.out.println(String.format("pgcd(3, 6)=%d", computePgcd(3, 6)));
    System.out.println(String.format("pgcd(77, 11)=%d", computePgcd(77, 11)));
    System.out.println(String.format("pgcd(31, 107)=%d", computePgcd(31, 107)));
  }
}
