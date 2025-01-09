///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;
import java.util.*;

class IntegerCalculator {
  private Integer x;

  public IntegerCalculator(Integer x) {
    this.x = x;
  }

  Integer add(Integer b) {
    x += b;
    return x;
  }

  boolean isPositive() {
    return x >= 0;
  }
}

class GenericCalculator<Toto extends Number> {
  private Toto x;

  public GenericCalculator(Toto x) {
    this.x = x;
  }

  boolean isPositive() {
    return x.doubleValue() >= 0;
  }
}

public class GenericsDemo {

  public static void main(String... args) {
    var c1 = new GenericCalculator<Integer>(Integer.valueOf(10));

    List<String> items = new ArrayList<>();
    // Java déduit que le type du générique est "Integer"
    var integers = List.of(Integer.valueOf(19));
    System.out.println(integers);
  }
}
