///usr/bin/env jbang --enable-preview "$0" "$@" ; exit $?

import java.util.*;
import java.util.Map.Entry;

public class CollectionDemo {

  public static void main(String... args) {
    // Tableau crée avec [] a une taille fixe
    int[] numbers = { 1, 20, 30 };
    System.out.format("premier élément %d, nombre d'éléments %d\n", numbers[0], numbers.length);
    numbers[1] = -4;
    System.out.format("Deuxième élément après modification %d\n", numbers[1]);
    // boucle for classique
    for (int i = 0; i < numbers.length; i++) {
      System.out.format("%d, ", numbers[i]);
    }
    System.out.println();
    // boucle for each
    for (int number : numbers) {
      System.out.format("%d, ", number);
    }
    System.out.println();

    List<Integer> items = new ArrayList<>();
    items.add(-3);
    items.add(11);
    items.add(22);
    for (int k = 0; k < items.size(); k++) {
      System.out.format("%d, ", items.get(k));
    }
    System.out.println();
    var otherItems = List.of(-2, 11, 22);
    for (Integer otherItem : otherItems) {
      System.out.format("%d, ", otherItem);
    }
    System.out.println();
    // Conversion d'une liste en tableau (array)
    // (Integer[]) ... s'appelle du casting -> forcer le type d'une expression
    Integer[] arrayOfItems = items.toArray(new Integer[items.size()]);
    System.out.println(arrayOfItems[0]);
    // Conversion d'un array d'un type objet en list
    List<Integer> listOfNumbers1 = Arrays.asList(arrayOfItems);
    List<Integer> listOfNumbers2 = Arrays.stream(arrayOfItems).toList();
    System.out.format("listOfNumbers1 size %d\n", listOfNumbers1.size());
    System.out.format("listOfNumbers2 size %d\n", listOfNumbers2.size());

    Iterator<Integer> iter = items.iterator();
    System.out.format("next: %d, has next ? %b\n", iter.next(), iter.hasNext());
    System.out.format("next: %d, has next ? %b\n", iter.next(), iter.hasNext());
    System.out.format("next: %d, has next ? %b\n", iter.next(), iter.hasNext());
    System.out.println();
    System.out.println("Iter for loop");
    for (var iter2 = items.iterator(); iter2.hasNext();) {
      Integer value = iter2.next();
      System.out.print(value + ", ");
    }
    System.out.println();
    System.out.println("for each utilise un itérateur derrière les rideaux");
    for (Integer item : items) {
      System.out.print(item + ", ");
    }
    System.out.println();

    System.out.println("Map");
    // 6786L => Litéral de type long (type de base)
    Map<String, Long> userIds = Map.of("Hugo", 6786L, "Rémy", 343L);
    System.out.println(userIds.get("Rémy"));
    for (var userIdEntry : userIds.entrySet()) {
      System.out.print(userIdEntry.getKey() + "->" + userIdEntry.getValue());
      System.out.print(", ");
    }
    System.out.println();

    Map<String, Long> mutableUserIds = new HashMap<>(userIds);
    mutableUserIds.put("toto", 3L);
    for (var userIdEntry : mutableUserIds.entrySet()) {
      System.out.print(userIdEntry.getKey() + "->" + userIdEntry.getValue());
      System.out.print(", ");
    }
    System.out.println();

    Iterator<Entry<String, Long>> iterUserIds = userIds.entrySet().iterator();
    System.out.println(iterUserIds.next() + ", " + iterUserIds.hasNext());
    var entry = iterUserIds.next();
    System.out.println(entry.getKey() + "->" + entry.getValue() + ", " + iterUserIds.hasNext());
  }
}
