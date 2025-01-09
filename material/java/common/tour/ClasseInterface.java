///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

interface Gamer {
  public void play();
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
    out.println("je joue");
  }
}

class HungryGamerHuman extends Human implements HungryEater, Gamer {

  @Override
  public void eat() {
  }

  @Override
  public void play() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'play'");
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

  }

  static void runGame(Gamer gamer) {

  }

  public static void main(String... args) {
    out.println("Hello World");
  }
}
