///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.random.RandomGenerator;

public class ContinuousRandomStats {

  public static void main(String... args) {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    int foundCount = 0;
    int sum = 0;
    int generatedIntCount = 0;
    while (foundCount < 5) {
      int generatedInt = randomGenerator.nextInt(1, 6);
      if (generatedInt == 3) {
        foundCount += 1;
        System.out.println(String.format("Found 3 %d times", foundCount));
      }
      sum += generatedInt;
      generatedIntCount += 1;
    }
    int mean = sum / generatedIntCount;
    System.out.println(String.format("Sum: %d, count: %d, mean: %d", sum, generatedIntCount, mean));
  }
}
