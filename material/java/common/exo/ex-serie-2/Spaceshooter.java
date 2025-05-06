///usr/bin/env jbang "$0" "$@" ; exit $?

import java.util.random.RandomGenerator;

public class Spaceshooter {

  public static void printLevelMap(char[][] levelMap) {
    System.out.println("Current Level map");
    for (int i = 0; i < levelMap.length; i++) {
      for (int j = 0; j < levelMap[i].length; j++) {
        System.out.format("%c ", levelMap[i][j]);
      }
      System.out.println();
    }
    System.out.println("End of current Level map\n");
  }

  public static void main(String... args) {
    char[][] levelMap = new char[10][10];
    // Boucle for imbriquée qui remplit le niveau de vide
    for (int i = 0; i < levelMap.length; i++) {
      for (int j = 0; j < levelMap[i].length; j++) {
        levelMap[i][j] = '.';
        // printLevelMap(levelMap);
      }
    }
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    // Permet de placer le vaisseau à peu près au milieu
    int shipColumn = randomGenerator.nextInt(levelMap[0].length / 2, levelMap[0].length / 2 + 2);
    int shipRow = levelMap.length - 1;
    levelMap[shipRow][shipColumn] = 'V';
    printLevelMap(levelMap);

    System.out.println("Adding enemies");
    putEnemiesWithExerciseConstraint(levelMap);
    // Commenter au dessus et décommenter en dessous pour avoir une variante
    // putEnemiesNoTwoAdjacentOnRow(levelMap);

    boolean hasShipFailed = false;
    while (!hasShipFailed) {
      levelMap[shipRow][shipColumn] = '.';
      if (shipRow == 0) {
        break;
      }
      int columnMovement = +1;
      // Vérifier que le vaisseau peut se déplacer
      while (levelMap[shipRow - 1][shipColumn] == 'E') {
        if (columnMovement > 0) {
          if (shipColumn + columnMovement < levelMap[shipRow].length
              && levelMap[shipRow][shipColumn + columnMovement] != 'E') {
            shipColumn += columnMovement;
            System.out.println("➡️ Movement");
          } else {
            System.out.println("Start to move left ⬅️");
            columnMovement = -1;
          }
        } else {
          if (shipColumn + columnMovement > 0
              && levelMap[shipRow][shipColumn + columnMovement] != 'E') {
            shipColumn += columnMovement;
            System.out.println("⬅️ Movement");
          } else {
            System.out.println("Oops, impossible to move ⬅️");
            levelMap[shipRow][shipColumn] = '*';
            hasShipFailed = true;
            break;
          }
        }
      }
      if (hasShipFailed) {
        System.out.println("BOOM 💥");
        break;
      }
      shipRow -= 1;
      levelMap[shipRow][shipColumn] = 'V';
      printLevelMap(levelMap);
    }
    System.out.println("Final level map");
    printLevelMap(levelMap);
    System.out.format("Ship has failed ? %s\n", hasShipFailed ? "yes" : "no");
  }

  public static void putEnemiesWithExerciseConstraint(char[][] levelMap) {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    int enemyShipCount = 0;
    while (enemyShipCount < 40) {
      // Les ennemis ne sont pas dans les deux dernières lignes
      int randomLine = randomGenerator.nextInt(0, levelMap.length - 2);
      int randomColumn = randomGenerator.nextInt(0, levelMap[0].length);
      if (levelMap[randomLine][randomColumn] != 'E') {
        levelMap[randomLine][randomColumn] = 'E';
        enemyShipCount += 1;
      } else {
        System.out.format("Skip enemy because constraints not satisified at position (%d, %d)\n", randomLine,
            randomColumn);
      }
      printLevelMap(levelMap);
    }
  }

  /**
   * Exemple de placement d'ennemeis avec la containte supplémentaire qu'il ne
   * faut en avoir deux d'adjacents sur la même ligne
   */
  public static void putEnemiesNoTwoAdjacentOnRow(char[][] levelMap) {
    RandomGenerator randomGenerator = RandomGenerator.getDefault();
    int enemyShipCount = 0;
    while (enemyShipCount < 7) {
      // Les ennemus sont entre les lignes 0 et 7
      int randomLine = randomGenerator.nextInt(0, levelMap.length - 2);
      int randomColumn = randomGenerator.nextInt(0, levelMap[0].length);

      boolean isAlreadyEnemy = levelMap[randomLine][randomColumn] == 'E';
      // Opérateur ternaire correspond à une "if ? then : else" en une seule ligne
      // valeur = condition ? résultat si vrai : résultat si faux
      boolean hasEnemyOnLeft = randomColumn == 0 ? false : levelMap[randomLine][randomColumn - 1] == 'E';
      boolean hasEnemyOnRight = randomColumn == levelMap[randomLine].length - 1 ? false
          : levelMap[randomLine][randomColumn + 1] == 'E';
      if (!isAlreadyEnemy && !hasEnemyOnLeft && !hasEnemyOnRight) {
        levelMap[randomLine][randomColumn] = 'E';
        enemyShipCount += 1;
      } else {
        System.out.format("Skip enemy because constraints not satisified at position (%d, %d)\n", randomLine,
            randomColumn);
      }
      printLevelMap(levelMap);
    }
  }
}
