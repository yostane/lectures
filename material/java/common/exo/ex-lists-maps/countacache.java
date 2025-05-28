///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countacache {

  public static Map<String, Integer> cache = new HashMap<>();

  public static int countAs(String word) {
    int count = 0;
    word = word.toLowerCase();
    if (cache.containsKey(word)) {
      count = cache.get(word);
      System.out.format("('%s', %d) already in cache \n", word, count);
      return count;
    }
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) == 'a') {
        count += 1;
      }
    }
    System.out.format("Adding ('%s', %d) to cache\n", word, count);
    cache.put(word, count);
    return count;
  }

  public static int countAs(List<String> words) {
    int result = 0;
    for (String word : words) {
      result += countAs(word);
    }
    return result;
  }

  public static void main(String... args) {
    List<String> words = List.of("I", "love", "Java", "and", "the", "JVM", "which", "is", "the", "Java", "Virtual",
        "Machine");
    int count = countAs(words);
    System.out.format("The numbers of a in the list is %d\n", count);
  }
}
