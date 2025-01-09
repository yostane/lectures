///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

import java.util.Scanner;
import java.util.random.RandomGenerator;

public class HeadsOrTails {

  public static void main(String... args) {

    var randomGenerator = RandomGenerator.getDefault();
    boolean isHeads = randomGenerator.nextBoolean();
    // Opérateur ternaire ? : (ternainre: trois opérandes)
    String side = isHeads ? "pile" : "face";
    // équivalent à ça
    if (isHeads) {
      side = "pile";
    } else {
      side = "face";
    }

    var s = new Scanner(System.in);
    var answer = s.nextLine();
    s.close();

    System.out.println(side);

    if (side.equals(answer)) {
      System.out.println("Gagné");
    } else {
      System.out.println("perdu");
    }
  }
}
