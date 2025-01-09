// compiler avec javac Hello.java -> ça génère un fichier hello.class (du bytecode)
// exécuter avec "java Hello"

import java.util.Scanner;
import java.util.random.RandomGenerator;

class Hello {
  // Point d'entrée
  public static void main(String[] args) {
    System.out.println("Hello world b1 2024");
    // java est statiquement typé
    // Quelques types de base
    byte b = 7;
    short s = 2;
    int i = 10;
    long l = 100;

    double d = 10.34324;
    double d2 = 3;
    float f = 12.334324f;
    boolean bool = true;
    System.out.println(i);
    System.out.println(f);

    // Objet entier (couvre un type de base int dans un objet)
    Integer i2 = 10;

    String message = "Hello";
    System.out.println(message);
    System.out.println(message.length());

    RandomGenerator r = RandomGenerator.getDefault();
    int i3 = r.nextInt(-10, 10);
    System.out.println(i3);
    double d3 = r.nextDouble();
    System.out.println(d3);
    if (i3 > 0) {
      System.out.println("positif");
    } else if (i3 < 0) {
      System.out.println("négatif");
    } else {
      System.out.println("zéro");
    }
    // tableau ou array (on ne peut pas ajouter ou changer d'élémnts une fois qu'il
    // est créé)
    int[] numbers = new int[] { -8, 10, 3, 4 };
    System.out.println(numbers[0]);
    // boucle for
    for (int j = 0; j < numbers.length; j++) {
      System.out.print(numbers[j] + " / ");
    }
    System.out.println();
    // équivalemnt avec un while
    int j = 0;
    while (j < numbers.length) {
      System.out.print(numbers[j] + " / ");
      j++;
    }
    System.out.println();

    // Permet de lire la saisie au clavier
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    switch (input) {
      case "Hello":
        System.out.println("World");
        break;
      case "merci":
        System.out.println("de rien");
        break;
      case "thank you":
        System.out.println("You're welcome");
        break;
      default:
        System.out.println("Pas compris");
        break;
    }
    scanner.close();
  }
}