///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;

public class randnumcount {

  public static List<Integer> generateRandomeIntegers() {
    List<Integer> integers = new ArrayList<>();
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    int lastGeneratedInt = 10;
    int repeatCount = 0;
    while (repeatCount < 3) {
      int randomInt = randomGenerator.nextInt(-2, 3);
      integers.add(randomInt);
      if (lastGeneratedInt == randomInt) {
        repeatCount += 1;
      } else {
        repeatCount = 1;
        lastGeneratedInt = randomInt;
      }
    }
    return integers;
  }

  public static Map<Integer, Integer> countOccurences(List<Integer> integers) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (Integer i : integers) {
      if (counts.containsKey(i)) {
        // Add 1 to number of occurences (appearances)
        counts.put(i, counts.get(i) + 1);
      } else {
        // First time an int is found
        counts.put(i, 1);
      }
    }
    return counts;
  }

  public static void main(String... args) {
    List<Integer> randomIntegers = generateRandomeIntegers();
    Map<Integer, Integer> counts = countOccurences(randomIntegers);
    for (Integer integer : randomIntegers) {
      System.out.format("%d, ", integer);
    }
    System.out.println();
    for (var entry : counts.entrySet()) {
      System.out.format("Key: %d, value %d \n", entry.getKey(), entry.getValue());
    }
  }
}
