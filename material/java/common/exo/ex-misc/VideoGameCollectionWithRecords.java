///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.google.guava:guava:33.1.0-jre

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;

interface EntertainmentDevice {

  int getReleaseYear();

  // propriété calculée
  default public boolean isAfter2000() {
    return this.getReleaseYear() >= 2000;
  }

  default public boolean isAfter1990() {
    return this.getReleaseYear() >= 1990;
  }
}

record VideoGameConsole(String name, int releaseYear, String companyName) implements EntertainmentDevice {
  @Override
  public int getReleaseYear() {
    return this.releaseYear();
  }
}

record VideoGame(String name, int releaseYear, String publisher) implements EntertainmentDevice {
  @Override
  public int getReleaseYear() {
    return this.releaseYear();
  }
}

public class VideoGameCollectionWithRecords {

  public static void main(String... args) {
    System.out.println("Retro game collection exercise");

    var consoles = List.of(
        new VideoGameConsole("My first 16 bits Console", 1987, "SEGA"),
        new VideoGameConsole("Another 16 bits console", 1991, "Nintendo"),
        new VideoGameConsole("Awesome 3D console", 1996, "Sony"),
        new VideoGameConsole("3D console with weird joystick", 1997, "Nintendo"));

    var games = List.of(
        new VideoGame("Alex Kidd", 1988, "SEGA"),
        new VideoGame("Starcraft 2", 1988, "BLIZZARD"),
        new VideoGame("Sonic", 1990, "SEGA"),
        new VideoGame("Mario RPG", 1996, "Nintendo"),
        new VideoGame("Final Fantasy 6", 1994, "Square"));

    var gamesAfter1990 = games.stream()
        .filter((game) -> game.releaseYear() >= 1990)
        .sorted(Comparator.comparingInt((game) -> game.releaseYear()))
        .toList();

    var gamesAfter1990Bis = games.stream()
        .filter(VideoGame::isAfter1990)
        .sorted((g1, g2) -> Integer.valueOf(g1.releaseYear()).compareTo(g2.releaseYear()))
        .toList();

    var gamesAfter1990Tres = games.stream()
        .filter((game) -> game.releaseYear() >= 1990)
        .sorted((game1, game2) -> {
          if (game1.releaseYear() > game2.releaseYear()) {
            return 1;
          } else if (game1.releaseYear() == game2.releaseYear()) {
            return 0;
          } else {
            return -1;
          }
        })
        .toList();

    System.out.println("\nQ1 - Sort by release year games after 1990");
    gamesAfter1990.stream().forEach((g) -> System.out.println(g));
    System.out.println("Q1 - Bis method" + Joiner.on(",").join(gamesAfter1990Bis));

    var segaConsoleNames = consoles.stream()
        .filter((c) -> c.companyName().equals("SEGA"))
        .map((c) -> c.name())
        .toList();
    System.out.println("\nQ2 - ");
    segaConsoleNames.stream().forEach((g) -> System.out.println(g));

    var sixteenBitsConsoleNames = consoles.stream()
        .filter((c) -> c.name().contains("16 bits"))
        .map((c) -> c.name())
        .toList();

    System.out.println("\nQ3 - 16 bits consoles: ");
    sixteenBitsConsoleNames.stream().forEach((g) -> System.out.println("- " + g));

    System.out.println("\nQ4 - Nom du premier jeu sorti : ");
    Optional<VideoGame> minYearVideoGame = games.stream().min(Comparator.comparingInt((game) -> game.releaseYear()));
    if (!minYearVideoGame.isPresent()) {
      return;
    }
    System.out.println(minYearVideoGame.get().name());

    var minYearVideosGames = games.stream()
        .filter((g) -> g.releaseYear() == minYearVideoGame.get().releaseYear()).toList();
    System.out.println("\nQ4 ++ - Au cas où il y a plusieurs jeux sortis la même année : ");
    System.out.println(Joiner.on(",").join(minYearVideosGames));

    System.out.println("\nQ5 - Nombre de jeux de chaque éditeur : ");
    var groupedGamesByPublishers = games.stream()
        .collect(Collectors.groupingBy((g) -> g.publisher()))
        .entrySet().stream()
        .map((entry) -> new AbstractMap.SimpleEntry<String, Integer>(entry.getKey(), entry.getValue().size())).toList();
    var groupedGamesByPublishers2 = games.stream()
        .collect(Collectors.groupingBy(VideoGame::publisher, Collectors.counting()));
    System.out.println(Joiner.on(",").join(groupedGamesByPublishers));
    System.out.println(Joiner.on(",").join(groupedGamesByPublishers2.entrySet()));
    groupedGamesByPublishers2.forEach((k, v) -> System.out.println(k + " number of games: " + v));

    // Map of first game for each published
    var firstGameByPublishers = games.stream().collect(
        Collectors.groupingBy(VideoGame::publisher,
            Collectors.mapping(VideoGame::releaseYear, Collectors.minBy(Comparator.comparingInt(year -> year)))));
    System.out.println("\nQ5 - Année du premier jeu de chaque éditeur : ");
    System.out.println(Joiner.on(",").join(firstGameByPublishers.entrySet()));
  }
}