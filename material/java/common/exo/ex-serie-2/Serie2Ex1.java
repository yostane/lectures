///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class Serie2Ex1 {

  public static void main(String... args) {
    int numbers[] = new int[10];
    RandomGenerator rng = RandomGenerator.getDefault();
    int sum = 0;
    int oddCount = 0; // odd : impair
    int evenCount = 0; // even : pair
    // Si on n'a pas encore généré d'éléments, on initialise min et max avec les
    // extrêmes
    int minFirstLoop = Integer.MAX_VALUE;
    int maxFirstLoop = Integer.MIN_VALUE;
    // génération et calcul de la somme, min et max
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rng.nextInt(-10, 10);
      System.out.print(numbers[i] + ", ");
      sum += numbers[i];
      if (numbers[i] % 2 == 0) {
        evenCount += 1;
      } else {
        oddCount += 1;
      }
      if (minFirstLoop > numbers[i]) {
        minFirstLoop = numbers[i];
      } else if (maxFirstLoop < numbers[i]) {
        maxFirstLoop = numbers[i];
      }
    }
    double average = (double) sum / (double) numbers.length;

    System.out.format("First loop data. sum %d, mean %f, evenCount %d, oddCount %d, min %d, max %d\n", sum, average,
        evenCount, oddCount,
        minFirstLoop, maxFirstLoop);

    // On connait déjà les éléments, plus besoin d'initialiser avec les extrêmes
    int min = numbers[0];
    int max = numbers[0];
    // min, max, écrat type
    double standardDeviation = 0; // ecart type
    for (int i = 0; i < numbers.length; i++) {
      standardDeviation += Math.pow(numbers[i] - average, 2);
      if (min > numbers[i]) {
        min = numbers[i];
      } else if (max < numbers[i]) {
        max = numbers[i];
      }
    }
    // SQRT: SQuare RooT -> racine carrée
    standardDeviation = Math.sqrt(standardDeviation / (double) numbers.length);
    System.out.format("Results 2nd loop -> min: %d, max: %d, Standard deviation: %f\n", min, max, standardDeviation);
  }
}
