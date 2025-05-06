///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class Schtroumph2Arrays {

  public static int computeSchtroumph(int[] leftItems, int[] rightItems) {
    int restult = 0;
    for (int i = 0; i < rightItems.length; i++) {
      for (int j = 0; j < leftItems.length; j++) {
        int mulitplication = rightItems[i] * leftItems[j];
        restult += mulitplication;
        System.out.format("%d x %d = %d", rightItems[i], leftItems[j], mulitplication);
        if (j < leftItems.length - 1) {
          // Ajouter un ", " à l'affichage pour tous les éléments sauf le dernier
          System.out.print(", ");
        }
      }
      System.out.println();
    }
    return restult;
  }

  public static int[] generateRandomArray() {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    // Nombre d'éléments aléatoires
    int length = randomGenerator.nextInt(2, 5);
    int[] numbers = new int[length];
    System.out.print("[");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = randomGenerator.nextInt(-10, 10);
      System.out.print(numbers[i]);
      if (i != length - 1) {
        // Ajouter un ", " à l'affichage pour tous les éléments sauf le dernier
        System.out.print(", ");
      }
    }
    System.out.println("]");
    return numbers;
  }

  public static void main(String... args) {
    System.out.println("Tableaux donnés en exemple");
    int[] exampleLeftItems = new int[] { 4, 8, 7, 12 };
    int[] exampleRightItems = new int[] { 3, 6 };
    int exampleResult = computeSchtroumph(exampleLeftItems, exampleRightItems);
    System.out.println(exampleResult);

    System.out.println("Tableaux aléatoires");
    int[] rightItems = generateRandomArray();
    int[] leftItems = generateRandomArray();
    int result = computeSchtroumph(leftItems, rightItems);
    System.out.println(result);
  }
}
