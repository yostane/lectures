///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class pgcd {

  public static int computePgcd(int a, int b) {
    int min = a <= b ? a : b;
    int pgcd = 1;
    // On trouve le diviseur commun de 1 jusqu'a plus petit des deux arguments
    for (int i = 1; i <= min; i++) {
      // Si on trouve un nouveau diviseur plus grand (car i s'incrémente), on écrase
      // la variable pgcd
      if (a % i == 0 && b % i == 0) {
        System.out.println(String.format("Trouvé nouveau pgcd %d", i));
        pgcd = i;
      }
    }
    return pgcd;
  }

  public static int computePgcdFaster(int a, int b) {
    int min = a <= b ? a : b;
    // On démarre directement du min et on s'arrête dès qu'on trouve un diviseur
    // commun
    for (int i = min; i >= 1; i--) {
      if (a % i == 0 && b % i == 0) {
        System.out.println(String.format("pgcd trouvé %d", i));
        return i;
      }
    }
    return 1;
  }

  public static void main(String... args) {
    System.out.println(String.format("pgcd(3, 6)=%d", computePgcd(3, 6)));
    System.out.println(String.format("pgcd(77, 11)=%d", computePgcd(77, 11)));
    System.out.println(String.format("pgcd(31, 107)=%d", computePgcd(31, 107)));

    System.out.println("Faster");
    System.out.println(String.format("pgcd(3, 6)=%d", computePgcdFaster(3, 6)));
    System.out.println(String.format("pgcd(77, 11)=%d", computePgcdFaster(77, 11)));
    System.out.println(String.format("pgcd(31, 107)=%d", computePgcdFaster(31, 107)));
  }
}
