///usr/bin/env jbang "$0" "$@" ; exit $?

public class CountVowels {

  static int countVowels(String[] words) {
    int vowelCount = 0;
    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        char c = word.toLowerCase().charAt(i);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
          vowelCount += 1;
        }
      }
    }
    return vowelCount;
  }

  public static void main(String... args) {
    String[] firstWords = new String[] { "Bonjour", "le", "monde" };
    System.out.format("%d\n", countVowels(firstWords));

    String[] secondWords = new String[] { "Bonjour", "le", "monde", "Java", "est", "un", "langage", "de",
        "programmation", "orienté", "objet" };
    System.out.format("%d\n", countVowels(secondWords));
  }
}
