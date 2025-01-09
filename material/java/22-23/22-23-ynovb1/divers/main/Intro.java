package main;
// public: l'élément est visible ou utilisable depuis n'importe quel autre classe et 

// de n'importe quel autre fichier

// En java le nom du fichier doit avoir le même nom que la classe (avec la même casse)
public class Intro {
    // point d'entrée: selon le langage, c'est la première ligne du fichier ou la
    // fonction main
    // C'est la première ligne de code qui est exécutée
    public static void main(String[] args) {
        System.out.println("Hello");
        TourDemo tourDemo = new TourDemo();
        tourDemo.showSomeVariables();
        String message = tourDemo.getMessage();
    }
}

// Une classe non publique n'est pas visible partout selon l'arbosecnce des des
// dossiers
class Demo {

}

// javac Intro.java
// -> génère le bytecode dans Intro.class (javac c'est le compilateur)
// java Intro
// java lance une JRE