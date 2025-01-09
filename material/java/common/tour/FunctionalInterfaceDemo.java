///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// L'inteface semble optionnelle
@FunctionalInterface
interface MyCustomBiPredicate {
  boolean doSomething(int a, int b);
}
// equivalent en Kotlin typealias MyCustomPredicate = (Int, Int) -> Boolean ou
// (Int, Int) -> Boolean

public class FunctionalInterfaceDemo {
  static boolean returnFalse(int a, int b) {
    return false;
  }

  // Higher order function: a function that takes as argument another function
  static void callPredicate(MyCustomBiPredicate p) {
    System.out.println(p.doSomething(10, 0));
    System.out.println(p.doSomething(0, 0));
  }

  static List<String> filter(List<String> items, Predicate<String> predicate) {
    List<String> results = new ArrayList<>();
    for (String item : items) {
      if (predicate.test(item)) {
        results.add(item);
      }
    }
    return results;
  }

  public static void main(String... args) {
    MyCustomBiPredicate p = (a, b) -> a > b;
    System.out.println(p.doSomething(10, 20));
    p = FunctionalInterfaceDemo::returnFalse;
    System.out.println(p.doSomething(111, 0));

    callPredicate(p);
    callPredicate(FunctionalInterfaceDemo::returnFalse);
    callPredicate((a, b) -> a > b);

    Predicate<Integer> multipleOfThreePredicate = (a) -> a % 3 == 0;
    Predicate<String> isEmptyPredicate = (s) -> s.length() == 0;
    System.out.println(multipleOfThreePredicate.test(21));
    System.out.println(multipleOfThreePredicate.test(65));
    System.out.println(isEmptyPredicate.test("Hello"));
    System.out.println(isEmptyPredicate.test(""));

    List<String> words = List.of("I", "Love", "Java", "2024");
    List<String> items1 = filter(words, (word) -> word.length() == 4);
    System.out.println(String.join(" - ", items1));
    List<String> items2 = filter(words, (w) -> w.charAt(0) == 'J');
    System.out.println(String.join(" - ", items2));
  }
}
