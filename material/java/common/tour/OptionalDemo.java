///usr/bin/env jbang "$0" "$@" ; exit $?

// Optional<T> permet d'englober une valeur et fournit des méthodes pour la récupérer si elle est présente
// - Attention: l'objet Optionnel en lui-même peut être null
// - En plus, on peut récupérer la valeur contenue même si elle est null et on aura une exception autre que la NPE

import static java.lang.System.*;
import java.util.*;

public class OptionalDemo {

  static String getFromInternet() {
    return "dsfsdfdsf";
  }

  static Optional<String> getFromInternetOpt() {
    return Optional.of("dsfsdfdsf");
  }

  public static void main(String... args) {
    out.println("Hello World");

    Optional<String> myOptionalText = Optional.empty();
    if (myOptionalText.isPresent()) {
      System.out.println(myOptionalText.get());
    }
    var optioanlValue = getFromInternetOpt();
    if (optioanlValue.isPresent()) {
      System.out.println(optioanlValue.get());
    }
  }
}
