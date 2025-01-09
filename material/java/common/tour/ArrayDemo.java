///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class ArrayDemo {

  public static void main(String... args) {
    System.out.println("Hello World");

    int[] numbers = new int[] { 5, 10, -100, 52 };
    numbers[2] = -50;
    for (int i = 0; i < numbers.length; i++) {
      System.out.print(i);
      System.out.println(" -> " + numbers[i]);
    }
    // marche pas: numbers[-2], numbers[1:5]

    // Tableau qui permet de stocker 5 éléments et qui est initialement vide
    int[] otherNumbers = new int[5];
    otherNumbers[0] = 20;
    RandomGenerator rng = RandomGenerator.getDefault();
    System.out.println("otherNumbers ->");
    for (int i = 0; i < otherNumbers.length; i++) {
      otherNumbers[i] = rng.nextInt(-5, 5);
      System.out.print(i);
      System.out.println(" -> " + otherNumbers[i]);
    }

    // Somme des éléments de numbers
    int sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];
    }

    int alternativeSum = 0;
    // Décomposition d'un for en while
    int j = 0;
    while (j < numbers.length) {
      alternativeSum += numbers[j];
      j++;
    }

    System.out.println("sum: " + sum + ", alternative sum: " + alternativeSum);

    // valeur max dans otherNumbers
    int max = otherNumbers[0]; // attention ne pas initialiser avec 0
    for (int i = 0; i < otherNumbers.length; i++) {
      if (max < otherNumbers[i]) {
        max = otherNumbers[i];
      }
    }
    System.out.println("max: " + max);
  }
}
