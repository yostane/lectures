///usr/bin/env jbang "$0" "$@" ; exit $?

//https://navin-moorthy.github.io/blog/map-filter-reduce-animated/

import static java.lang.System.*;
import java.util.*;
import java.util.stream.*;

public class StreamDemo {

  public static void main(String... args) {
    out.println("Hello World");
    Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 100);
    // Imperative programming style: describe how to do
    List<Integer> r = new ArrayList<>();
    for (Integer number : numbers.toList()) {
      if (number % 2 == 0) {
        r.add(number);
      }
    }
    numbers = Stream.of(1, 2, 3, 4, 100);
    // Style déclaratif: describe what we want to do
    var filteredNumbers = numbers.filter((n) -> n % 2 == 0);
    var doubleNumbers = filteredNumbers.map((n) -> n * 2);
    var sum = doubleNumbers.reduce(Integer::sum);
    System.out.println(sum);

    var otherNumbers = Stream.of(1, 2, 3, 4, 100);
    var result = otherNumbers
        .filter((n) -> n % 2 == 0)
        .map((n) -> n * 2)
        .reduce((acc, value) -> acc + value);

    System.out.println(result);

    List<Integer> evenNumbers = Stream.of(1, 2, 3, 4, 100)
        .filter((n) -> n % 2 == 0).toList();

    List<Integer> doubledEvens = evenNumbers.stream().map((n) -> n * 2).toList();
    var stringDoubles = doubledEvens.stream().map((n) -> n.toString()).toList();
    System.out.println(String.join(", ", stringDoubles));
  }
}
