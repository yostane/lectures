///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class RandomDemo {

  public static void main(String... args) {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    // i++ -> i = i + 1 -> i += 1
    for (int i = 0; i < 10; i++) {
      int randomInt = randomGenerator.nextInt(1, 21);
      System.out.println(randomInt);
    }

  }
}
