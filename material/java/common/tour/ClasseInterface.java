///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

interface Gamer {
  public void play();

  public void takeABreak();
}

interface HungryEater {
  public void eat();
}

class Human {
  private String name;

  public Human() {
    this("anonymous");
  }

  public Human(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class HumanGamer extends Human implements Gamer {
  @Override
  public void play() {
    System.out.println("Je joue");
  }

  @Override
  public void takeABreak() {
    System.out.println("Pause");
  }
}

class HungryGamerHuman extends Human implements HungryEater, Gamer {

  @Override
  public void eat() {
    System.out.println("Je mange en étant affamé");
  }

  @Override
  public void play() {
    System.out.println("Je joue mais j'ai faim");
  }

  @Override
  public void takeABreak() {
    System.out.println("Je fais dodo");
  }
}

class Lion implements HungryEater {
  @Override
  public void eat() {
  }
}

class Student extends Human {
  private String idNumbeString;

  public Student(String name, String idNumbeString) {
    super(name);
    this.idNumbeString = idNumbeString;
  }

  public String getIdNumberString() {
    return idNumbeString;
  }

  public void setIdNumberString(String idNumbeString) {
    this.idNumbeString = idNumbeString;
  }
}

public class ClasseInterface {

  static void giveFood(HungryEater eater) {
    System.out.println("miam mia pour un HungryEater");
    eater.eat();
  }

  static void runGame(Gamer gamer) {
    System.out.println("Lancement d'un jeu");
    gamer.play();
  }

  public static void main(String... args) {
    out.println("Hello World");
    HungryGamerHuman hungryGamerHuman = new HungryGamerHuman();
    Lion lion = new Lion();

    giveFood(hungryGamerHuman);
    giveFood(lion);

    runGame(hungryGamerHuman);
  }
}
