///usr/bin/env jbang "$0" "$@" ; exit $?

public class First10Prime {

  public static void main(String... args) {
    System.out.println("Hello World");

    int[] firstTenPrimes = new int[10];
    firstTenPrimes[2] = 2;
    int i = 1;
    for (int currentInt = 3; i < firstTenPrimes.length; currentInt++) {

      // check if currentInt is prime
      int j = 2;
      for (; j < currentInt; j++) {
        if (currentInt % j == 0) {
          break;
        }
      }
      if (j == currentInt) {
        firstTenPrimes[i] = currentInt;
        i++;
      }
    }

    System.out.println("Résutat ->");
    for (int j = 0; j < firstTenPrimes.length; j++) {
      System.out.print(firstTenPrimes[j] + ", ");
    }
  }
}
