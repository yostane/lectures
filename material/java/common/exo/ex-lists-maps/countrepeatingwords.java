///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.HashMap;
import java.util.Map;

public class countrepeatingwords {
  public static Map<String, Integer> countWords(String sentence) {
    Map<String, Integer> counts = new HashMap<>();
    // On supprime les points et les virgules
    String[] words = sentence
        .replaceAll("[\\.\\,]", "")
        .toLowerCase()
        .split(" ");
    for (String word : words) {
      if (counts.containsKey(word)) {
        // Add 1 to number of occurences (appearances)
        counts.put(word, counts.get(word) + 1);
      } else {
        // First time an int is found
        counts.put(word, 1);
      }
    }
    return counts;
  }

  public static void main(String... args) {
    String sentence = "Il y a un chat et un chien. Le chat est noir et le chien est blanc";
    Map<String, Integer> counts = countWords(sentence);
    System.out.format("Count repeating words of sentence: %s \n", sentence);
    for (var entry : counts.entrySet()) {
      System.out.format("Key: %s, value %d \n", entry.getKey(), entry.getValue());
    }
  }
}
