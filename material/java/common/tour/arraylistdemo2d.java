///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.List;

public class arraylistdemo2d {

  public static void main(String... args) {
    // 0 vide, 1 ennemi, 2 sortie, 3 obstacle
    int[][] levelMap = {
        { 0, 0, 0 },
        { 0, 1, 2 },
        { 3, 3, 3 }
    };
    for (int i = 0; i < levelMap.length; i++) {
      System.out.format("Content of floor %d\n", i);
      for (int j = 0; j < levelMap[i].length; j++) {
        System.out.format("Cell %d, %d -> %d\n", i, j, levelMap[i][j]);
      }
    }

    List<List<Integer>> levelMapList = List.of(
        List.of(0, 0, 0),
        List.of(0, 1, 2),
        List.of(3, 3, 3));
    for (int i = 0; i < levelMapList.size(); i++) {
      System.out.format("Content of floor %d\n", i);
      for (int j = 0; j < levelMapList.get(i).size(); j++) {
        System.out.format("Cell %d, %d -> %d\n", i, j, levelMapList.get(i).get(j));
      }
    }
  }
}
