///usr/bin/env jbang "$0" "$@" ; exit $?

import static java.lang.System.*;

class ViennoiserieClass {
  private String name;
  private String texture;
  private int price;

  public ViennoiserieClass(String name, String texture, int price) {
    this.name = name;
    this.texture = texture;
    this.price = price;
  }

  public String getName() {
    return this.name;
  }

  public String getTexture() {
    return texture;
  }

  public int getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return String.format("name: %s, texture %s, price %d", this.getName(), this.getTexture(), this.getPrice());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((texture == null) ? 0 : texture.hashCode());
    result = prime * result + price;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ViennoiserieClass other = (ViennoiserieClass) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (texture == null) {
      if (other.texture != null)
        return false;
    } else if (!texture.equals(other.texture))
      return false;
    if (price != other.price)
      return false;
    return true;
  }

}

// Equivalent of the above class
record Viennoiserie(String name, String texture, int price) {
}

public class RecordDemo {

  public static void main(String... args) {
    Viennoiserie croissant1 = new Viennoiserie("Croissant", "Feuilletée", 100);
    out.println(croissant1);
    Viennoiserie croissant2 = new Viennoiserie("Croissant", "Feuilletée", 100);
    out.println(croissant1);
    Viennoiserie viennoiserie = new Viennoiserie("Pain au chocolat", "Feuilletée", 100);
    Viennoiserie viennoiserie2 = new Viennoiserie("Chocolatine", "Feuilletée", 100);
    Viennoiserie viennoiserie3 = new Viennoiserie("Petit pain", "Feuilletée", 100);
    out.println(croissant1.equals(croissant2));
    out.println(viennoiserie.equals(viennoiserie2));
    out.println(viennoiserie2.equals(viennoiserie3));

    // remove get from getters
    System.out.println("price of croissant 1: " + croissant1.price());
  }
}
