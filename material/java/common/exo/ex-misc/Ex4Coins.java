///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4Coins {

  public int compute1CoinCount(int n) {
    if (n < 3) {
      return n;
    } else if (n < 5) {
      return n - 3;
    } else if (n == 5) {
      return 0;
    } else {
      int n1 = compute1CoinCount(n - 3);
      int n2 = compute1CoinCount(n - 5);
      int result = Math.min(n1, n2);
      return result;
    }
  }

  public static void main(String... args) {
    Ex4Coins ex4Coins = new Ex4Coins();
    Scanner scanner = new Scanner(System.in);
    int testCount = scanner.nextInt();
    List<Integer> inputs = new ArrayList<>();
    for (int i = 0; i < testCount; i++) {
      int n = scanner.nextInt();
      inputs.add(n);
    }
    System.err.println("Output:");
    for (Integer input : inputs) {
      int result = ex4Coins.compute1CoinCount(input);
      System.out.println(result);
    }
  }
}
