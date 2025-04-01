///usr/bin/env jbang "$0" "$@" ; exit $?

public class BaseTypesDemo {
  public BaseTypesDemo() {
    System.out.println("Tour demo constructor");
  }

  public void showSomeVariables() {
    System.out.println("some vars");
    byte b = 10; // de -127 à 128. 1 octet
    short s = 2; // -32,768 à 32,767. 2 octets
    int i = 10; // -2^(31) à 2^(31)-1. 4 Octets (32 bits)
    long l = 100_000_000; // -2^(63) à 2^(63) - 1. 8 octets (64 bits)
    System.out.println(b);
    String message = "I love Java";
    String text = String.format("s = %d, i = %d, l = %d, message = %s", s, i, l, message);
    System.out.println(text);

    // nombre à virgule flottante. Attention à la précision !
    float x = 10.1f;
    double y = 10.1;
    System.out.println(String.format("x: %.2f, y: %f", x, y));
    System.out.println("x: " + x + ", y: " + y);
  }

  public String getMessage() {
    return "Hello";
  }

  public static void main(String[] args) {
    System.out.println("Base types demo");
    BaseTypesDemo baseTypesDemo = new BaseTypesDemo();
    baseTypesDemo.showSomeVariables();
  }
}
