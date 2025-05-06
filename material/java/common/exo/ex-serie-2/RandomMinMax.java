///usr/bin/env jbang --enable-preview "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class RandomMinMax {

  public static void printMinMax(int[] numbers) {
    if (numbers.length == 0) {
      return;
    }

    int min = numbers[0];
    int max = numbers[0];

    for (int number : numbers) {
      min = number < min ? number : min;
      max = number > max ? number : max;
    }
    System.out.println(String.format("min: %d, max: %d", min, max));
  }

  public static void main(String... args) {
    RandomGenerator generator = RandomGenerator.getDefault();
    int[] numbers = new int[10];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = generator.nextInt();
      System.out.print(String.format("%d, ", numbers[i]));
    }
    System.out.println();
    printMinMax(numbers);
  }
}
