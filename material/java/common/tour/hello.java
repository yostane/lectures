///usr/bin/env jbang "$0" "$@" ; exit $?

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
    // typage explicite (on donne le nom du type)
    int i = 10;
    long j = 1_000_000;
    // var permet de faire du typage implicite (le type est déduit par Java)
    var message = "hello";
    message = "world";

    // Instruction illégale car java fait du typage statique
    // -> i est un entier et ne peut pas changer en String
    // L'opposé de typage statique est typage dynamique
    // i = "Hello";
    // message = 10;

    var c = new Calculator();
    c.add();

    Calculator.multiply(10, 1);
  }
}
