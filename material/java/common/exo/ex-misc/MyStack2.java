package exo;

import java.util.ArrayList;
import java.util.List;

/*
 * Créer une classe Stack qui permet de faire les opération suivantes:
push: qui permet d’ajouter un élément
pop: qui permet de retirer le dernier élément ajouté à la stack et retourne sa valeur
peek: donne la valeur du dernier élément inséré
isEmpty: retourne true si la Stack ne contient aucun élément
La stack est vide par défaut
 */
class Program2 {
    public static void main(String[] args) {
        MyStack2 s = new MyStack2();
        try {
            System.out.println(s.peek());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

public class MyStack2 {

    private List<Integer> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            // équivalent d'un return
            throw new Exception("Pile vide");
        }
        return items.get(items.size() - 1);
    }

    public void push(int value) {
        items.add(value);
    }

    public int pop() throws Exception {
        int value = peek();
        items.remove(items.size() - 1);
        return value;
    }
}
