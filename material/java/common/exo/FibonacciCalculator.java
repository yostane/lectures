package exo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciCalculator {
    public static void main(String... argv) {
        long start1 = System.nanoTime();
        System.out.println("fib(10) = " + computeFiboMethod1(10));
        System.out.println("fib(100) = " + computeFiboMethod1(100));
        System.out.println("Elapsed Time in nano seconds: " + (System.nanoTime() - start1));

        // start1 = System.nanoTime();
        // System.out.println("fib(10) = " + computeFiboMethod2(10));
        // System.out.println("fib(20) = " + computeFiboMethod2(20));
        // System.out.println("Elapsed Time in nano seconds: " + (System.nanoTime() -
        // start1));

        start1 = System.nanoTime();
        System.out.println("fib(10) = " + computeFiboMethod3(BigInteger.valueOf(10)));
        System.out.println("fib(100) = " + computeFiboMethod3(BigInteger.valueOf(100)));
        System.out.println("Elapsed Time in nano seconds: " + (System.nanoTime() - start1));
    }

    static BigInteger computeFiboMethod1(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        if (n == 1 || n == 2) {
            return BigInteger.ONE;
        }
        BigInteger fibMinus1 = BigInteger.ONE;
        BigInteger fibMinus2 = BigInteger.ONE;
        BigInteger fib = BigInteger.ZERO;
        for (int i = 3; i <= n; i++) {
            fib = fibMinus1.add(fibMinus2);
            fibMinus2 = fibMinus1.add(BigInteger.ZERO);
            fibMinus1 = fib.add(BigInteger.ZERO);
        }
        return fib;
    }

    static int computeFiboMethod2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return computeFiboMethod2(n - 1) + computeFiboMethod2(n - 2);
    }

    // Integer est une classe qui couvre (wrapper) le type de base int
    // Clé: numéro du fib (le n dans fib(n))
    // valeur: valeur du fib(n)
    // Cette technique fonctionne avec les fonctions pures (toujours le même
    // résultat pour les mêmes entrées)
    // La technique s'appelle "Memoïsation"
    static Map<BigInteger, BigInteger> computedFibonaccis = new HashMap<>();

    static BigInteger computeFiboMethod3(BigInteger n) {
        if (computedFibonaccis.containsKey(n)) {
            // System.out.println("Using cache for item " + n + ", value:" +
            // computedFibonaccis.get(n));
            return computedFibonaccis.get(n);
        }
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        BigInteger fibMinus1 = computeFiboMethod3(n.add(BigInteger.valueOf(-1)));
        BigInteger fibMinus2 = computeFiboMethod3(n.add(BigInteger.valueOf(-2)));
        BigInteger fib = fibMinus1.add(fibMinus2);
        computedFibonaccis.put(n, fib);
        return fib;
    }
}