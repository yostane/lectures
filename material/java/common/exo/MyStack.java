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
class Program {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
        s.push(10);
        s.push(-1);
        s.push(1_000);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }
}

public class MyStack {

    private List<Integer> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.size() == 0;
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return items.get(items.size() - 1);
    }

    public void push(int value) {
        items.add(value);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer value = peek();
        items.remove(items.size() - 1);
        return value;
    }
}
