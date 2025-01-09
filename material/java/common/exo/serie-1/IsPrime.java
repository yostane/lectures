///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.Scanner;

public class IsPrime {

  public static void main(String... args) {
    System.out.println("Veuillez saisir un entier positif et on vous dira s'il est premier.");

    Scanner scanner = new Scanner(System.in);
    long input = scanner.nextLong();
    scanner.close();
    if (input < 0) {
      System.err.println("ce n'est pas un nombre positif");
      exit(1);
    } else if (input < 2) {
      System.out.println("ce n'est pas un nombre premier");
      exit(1);
    } else if (input == 2) {
      System.out.println("c'est un nombre premier");
      exit(0);
    }

    for (long i = 2; i < input / 2; i++) {
      if (input % i == 0) {
        System.out.println("Ce n'est pas un nombre premier");
        exit(1);
      }
    }
    System.out.println("C'est un nombre premier");
  }
}
