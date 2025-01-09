///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class Serie2Ex1 {

  public static void main(String... args) {
    int numbers[] = new int[10];
    RandomGenerator rng = RandomGenerator.getDefault();
    int sum = 0;
    int oddCount = 0; // odd : impair
    int evenCount = 0; // even : pair
    // génération et calcul de la somme
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rng.nextInt(-10, 10);
      System.out.print(numbers[i] + ", ");
      sum += numbers[i];
      if (numbers[i] % 2 == 0) {
        evenCount += 1;
      } else {
        oddCount += 1;
      }
    }
    // min, max, écrat type
    int min = numbers[0];
    int max = numbers[0];
    double standardDeviation = 0; // ecart type
    double average = (double) sum / (double) numbers.length;
    for (int i = 0; i < numbers.length; i++) {
      standardDeviation += Math.pow(numbers[i] - average, 2);
      if (min > numbers[i]) {
        min = numbers[i];
      } else if (max < numbers[i]) {
        max = numbers[i];
      }
    }
    standardDeviation = Math.sqrt(standardDeviation / (double) numbers.length);
    System.out.println("\nResults ->");
    System.out.println("min: " + min + ", max:" + max);
    System.out.println("Even count: " + evenCount + ", Odd count:" + oddCount);
    System.out.println("sum: " + sum + ", Standard deviation:" + standardDeviation);
  }
}
