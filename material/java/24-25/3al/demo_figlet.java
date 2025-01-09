///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.github.lalyos:jfiglet:0.0.9

import com.github.lalyos.jfiglet.FigletFont;
import static java.lang.System.*;

public class demo_figlet {

  public static void main(String... args) {
    out.println("Hello World");
    try {
      String asciiArt1 = FigletFont.convertOneLine("I love Java");
      out.println(asciiArt1);
    } catch (Exception e) {
      out.println("erreur");
    }
  }
}
