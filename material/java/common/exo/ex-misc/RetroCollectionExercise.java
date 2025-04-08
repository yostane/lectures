///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS com.google.guava:guava:33.1.0-jre

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.base.Joiner;

abstract class EntertainmentDevice {
  private String name;
  private int releaseYear;

  public EntertainmentDevice(String name, int releaseYear) {
    this.name = name;
    this.releaseYear = releaseYear;
  }

  // propriété calculée
  public boolean isAfter2000() {
    return this.getReleaseYear() >= 2000;
  }

  public boolean isAfter1990() {
    return this.getReleaseYear() >= 1990;
  }

  // proriété avec backieng field (le backing field est name)
  public String getName() {
    return name;
  }

  // proriété avec backieng field (le backing field est name)
  public void setName(String name) {
    this.name = name;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}

class VideoGameConsole extends EntertainmentDevice {
  private String companyName;

  public VideoGameConsole(String name, int releaseYear, String companyName) {
    super(name, releaseYear);
    this.companyName = companyName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
}

class VideoGame extends EntertainmentDevice {
  private String publisher;

  public VideoGame(String name, int releaseYear, String publisher) {
    super(name, releaseYear);
    this.publisher = publisher;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "VideoGame [publisher=" + publisher + ", getName()=" + getName() + ", getReleaseYear()=" + getReleaseYear()
        + "]";
  }

}

public class RetroCollectionExercise {

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
        .filter((game) -> game.getReleaseYear() >= 1990)
        .sorted(Comparator.comparingInt((game) -> game.getReleaseYear()))
        .toList();

    var gamesAfter1990Bis = games.stream()
        .filter(VideoGame::isAfter1990)
        .sorted((g1, g2) -> Integer.valueOf(g1.getReleaseYear()).compareTo(g2.getReleaseYear()))
        .toList();

    System.out.println("\nQ1 - Sort by release year games after 1990");
    gamesAfter1990.stream().forEach((g) -> System.out.println(g));
    System.out.println("Q1 - Bis method" + Joiner.on(",").join(gamesAfter1990Bis));

    var segaConsoleNames = consoles.stream()
        .filter((c) -> c.getCompanyName().equals("SEGA"))
        .map((c) -> c.getName())
        .toList();
    System.out.println("\nQ2 - ");
    segaConsoleNames.stream().forEach((g) -> System.out.println(g));

    var sixteenBitsConsoleNames = consoles.stream()
        .filter((c) -> c.getName().contains("16 bits"))
        .map((c) -> c.getName())
        .toList();

    System.out.println("\nQ3 - 16 bits consoles: ");
    sixteenBitsConsoleNames.stream().forEach((g) -> System.out.println("- " + g));

    System.out.println("\nQ4 - Nom du premier jeu sorti : ");
    Optional<VideoGame> minYearVideoGame = games.stream().min(Comparator.comparingInt((game) -> game.getReleaseYear()));
    if (!minYearVideoGame.isPresent()) {
      return;
    }
    System.out.println(minYearVideoGame.get().getName());

    var minYearVideosGames = games.stream()
        .filter((g) -> g.getReleaseYear() == minYearVideoGame.get().getReleaseYear()).toList();
    System.out.println("\nQ4 ++ - Au cas où il y a plusieurs jeux sortis la même année : ");
    System.out.println(Joiner.on(",").join(minYearVideosGames));

    System.out.println("\nQ5 - Nombre de jeux de chaque éditeur : ");
    var publishers = games.stream().map(g -> g.getPublisher()).distinct().toList();

    var groupedGamesByPublishers = games.stream()
        .collect(Collectors.groupingBy((g) -> g.getPublisher()))
        .entrySet().stream()
        .map((entry) -> new AbstractMap.SimpleEntry<String, Integer>(entry.getKey(), entry.getValue().size())).toList();
    System.out.println(Joiner.on(",").join(groupedGamesByPublishers));

  }
}
