///usr/bin/env jbang --enable-preview "$0" "$@" ; exit $?

import static java.lang.System.*;
import java.util.*;
import java.util.Map.Entry;

public class CollectionDemo {

  public static void main(String... args) {
    // Type de base int
    int i = 99;
    // Objet Integer
    Integer j = 10;
    System.out.println(i);
    System.out.println("Integer: " + j.compareTo(i) + ", " + j.floatValue());
    int[] numbers = { 1, 20, 30 };
    List<Integer> items = new ArrayList<>();
    items.add(-3);
    items.add(11);
    items.add(22);
    var otherItems = List.of(-2, 11, 22);
    for (int k = 0; k < items.size(); k++) {
      System.out.print(items.get(k) + ", ");
    }
    System.out.println();
    Iterator<Integer> iter = items.iterator();
    System.out.println(iter.next() + ", " + iter.hasNext());
    System.out.println(iter.next() + ", " + iter.hasNext());
    System.out.println(iter.next() + ", " + iter.hasNext());
    System.out.println();
    System.out.println("Iter for loop");
    for (var iter2 = items.iterator(); iter2.hasNext();) {
      Integer value = iter2.next();
      System.out.print(value + ", ");
    }
    System.out.println();
    System.out.println("Iter for each");
    for (Integer item : items) {
      System.out.print(item + ", ");
    }
    System.out.println();

    System.out.println("Map");
    // 6786L => Litéral de type long (type de base)
    Map<String, Long> userIds = Map.of("Hugo", 6786L, "Rémy", 343L);
    System.out.println(userIds.get("Rémy"));
    Iterator<Entry<String, Long>> iterUserIds = userIds.entrySet().iterator();
    System.out.println(iterUserIds.next() + ", " + iterUserIds.hasNext());
    var entry = iterUserIds.next();
    System.out.println(entry.getKey() + "->" + entry.getValue() + ", " + iterUserIds.hasNext());
    for (var userIdEntry : userIds.entrySet()) {
      System.out.print(userIdEntry.getKey() + "->" + userIdEntry.getValue());
      System.out.print(", ");
    }
    System.out.println();
  }
}
