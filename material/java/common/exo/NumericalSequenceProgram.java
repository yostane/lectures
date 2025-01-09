package exo;

public class NumericalSequenceProgram {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(NumericalSequenceCalculator.computeSequence1(i));
            System.out.print(" - ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(NumericalSequenceCalculator.computeSequence2(i));
            System.out.print(" - ");
        }
        System.out.println();
    }
}

class NumericalSequenceCalculator {
    static int computeSequence1(int n) {
        return n / 2;
    }

    /*
     * Ecrire une fonction qui calcule le terme n de cette suite
     * U(n) = n / 2 si n est pair
     * U(n) = 2n - 1 sinon
     */
    static int computeSequence2(int n) {
        if (n % 2 == 0) {
            return n / 2;
        }
        return 2 * n - 1;
    }

    // U(n) = U(n-1) + 1 et U(0) = 1
    static int computeSequence3WithLoop(int n) {
        int u = 1;
        for (int i = 1; i <= n; i++) {
            u = u + 1;
        }
        return u;
    }

    static int computeSequence3Recursive(int n) {
        if (n == 1) {
            return 1;
        }
        return computeSequence3Recursive(n - 1) + 1;
    }

    static int computeFibonacci(int n) {
        return 0;
    }
}