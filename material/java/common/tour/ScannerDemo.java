///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.Scanner;

public class ScannerDemo {

  public static void main(String... args) {
    Scanner scanner = new Scanner(System.in);
    int p1 = scanner.nextInt();
    System.out.println(p1);
    float p2 = scanner.nextFloat();
    System.out.println(p2);
    String input = scanner.next();
    if (input.equals("Java")) {
      System.out.println("I love Java");
    } else {
      System.out.println(String.format("You love %s", input));
    }
    // Fermer le scanner dès qu'on n'en n'a plus besoin
    scanner.close();
  }
}
