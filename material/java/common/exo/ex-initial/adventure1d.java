///usr/bin/env jbang "$0" "$@" ; exit $?

// Un record est une class plus concise (syntaxe plus courte et simple)
record LevelResult(int hp, int magolon, int turnCount) {
  @Override
  public final String toString() {
    return String.format("Hero has %d hp, %d magolon. He %s the level after %d turns",
        this.hp, this.magolon, this.hp <= 0 ? "failed" : "succeeded", this.turnCount);
  }
}

public class adventure1d {
  // throw est une sorte de return alternatif pour les cas d'erreur (object
  // Exception)
  public static LevelResult playLevel(String level) throws Exception {
    int hp = 3;
    int turnCount = 0;
    int magolon = 0;
    // D'abord trouver l'indice du joueur dans la carte
    int playerInitialPosition = 0;
    for (; level.charAt(playerInitialPosition) != 'J'
        && playerInitialPosition < level.length(); playerInitialPosition++) {
    }
    // Vérifier que la position du joueur est au moins l'avant dernière case
    if (playerInitialPosition >= level.length() - 1) {
      Exception exception = new Exception("Position intiale du joueur invalide");
      throw exception;
    }
    System.out.format("Initiall player position %d\n", playerInitialPosition);
    // Dérouler le niveau
    for (int i = playerInitialPosition + 1; i < level.length(); i++) {
      turnCount += 1;
      char currentTile = level.charAt(i);
      if (currentTile == 'S') {
        break;
      } else if (currentTile == 'E') {
        turnCount += 1;
        hp -= 1;
        if (hp == 0) {
          break;
        }
        magolon += 1;
      } else if (currentTile == 'P') {
        turnCount += 1;
        hp += 1;
      } else if (currentTile != '.') {
        throw new Exception(String.format("Incorrect tile %c", currentTile));
      }
    }
    return new LevelResult(hp, magolon, turnCount);
  }

  public static void main(String... args) throws Exception {
    String[] firstLevels = {
        "J..S", "J..E..P..S", "J..EE.E..S", "J..E..P..E..P..S", "J..E..PP..EEE..P..E..S"
    };
    for (String level : firstLevels) {
      LevelResult levelResult = playLevel(level);
      System.out.format("Playing level '%s'. Result: %s\n", level, levelResult);
    }
    for (String level : new String[] {
        "..J..S...EP", "E.PSJ..EPPP...S.EP", "SE.SPE.J..EPEE.EPEE.PEPE..S.PSP"
    }) {
      LevelResult levelResult = playLevel(level);
      System.out.format("Playing level '%s'. Result: %s\n", level, levelResult);
    }

    for (String level : new String[] {
        "..J.J.S..", "JN", "..."
    }) {
      try {
        LevelResult levelResult = playLevel(level);
        System.out.format("Playing level '%s'. Result: %s\n", level, levelResult);
      } catch (Exception e) {
        System.out.format("Skipping incorrect level. Cause: %s\n", e.getMessage());
      }
    }
  }
}
