///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

public class operators {

  public static void main(String... args) {
    // unary operator: takes one operand and return a value
    System.out.println(+3);
    int x = 55;
    System.out.println(-x);
    // Binary operator: takes two operands and returns a value
    System.out.println(5 * 4);
    System.out.println(-x / 4);
    // % is the remainder of the division
    System.out.println(9 % 2);
    // Binary operators for comparison: >, ==, !=, <, >=, <= takes two comparable
    // values (numbers and booleans in Java)
    System.out.println(x > 10);
    // Unary operator for boolean algebra: !
    boolean comparison = x % 5 == 0;
    System.out.println(!comparison);
  }
}
