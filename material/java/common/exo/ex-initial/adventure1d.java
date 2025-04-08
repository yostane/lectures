///usr/bin/env jbang "$0" "$@" ; exit $?

// Un record est une class plus concise (syntaxe plus courte et simple)
record LevelResult(int hp, int magolon) {
  @Override
  public final String toString() {
    return "";
  }
}

public class adventure1d {
  public static LevelResult playLevel(String level) {
    return new LevelResult(0, 0);
  }

  public static void main(String... args) {
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
  }
}
