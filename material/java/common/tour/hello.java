///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.google.guava:guava:32.1.3-jre

import static java.lang.System.*;

class Calculator {
  public int a;
  public int b;
  static double PI = 3.14;

  public double add() {
    return a + b + Calculator.PI;
  }

  static double multiply(int x, int y) {
    return x * y * PI;
  }
}

class Calculator2 {
  public int a;
  public int b;

  public int add() {
    return a + b;
  }
}

public class hello {

  public static void main(String... args) {
    out.println("Hello World");
    int i = 10;
    long j = 1_000_000;
    var message = "hello";
    message = "world";

    var c = new Calculator();
    c.add();

    Calculator.multiply(10, 1);
  }
}
