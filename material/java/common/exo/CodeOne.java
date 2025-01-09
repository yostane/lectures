package exo;

public class CodeOne {
    public static void main(String argv[]) {
        System.out.println(2 + 4);
        System.out.println(2 + 4 == 7);
    }
}

class CodeTwo {
    int x = 10;

    public CodeTwo() {
        System.out.println(2 + 4 == x);
    }

    public static void main(String argv[]) {
        System.out.println(2 + 4 == 7);
        CodeTwo codeTwo = new CodeTwo();
        System.out.println(codeTwo.x);
    }
}

class CodeThree {
    static int x = 10;

    public CodeThree() {
        x = 4;
    }

    static public void main(String argv[]) {
        System.out.println(x);
        CodeThree codeThree = new CodeThree();
        System.out.println(x);
    }
}
