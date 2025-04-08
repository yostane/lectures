package exo;

class PrimeNumberEx {
    // Tous les modulos seront calculés de 2 à n-1
    public boolean isPrimeA(int n) {
        boolean isPrime = true;
        for (int i = 2; i < n; i += 1) {
            System.out.println(
                    String.format("i: %d, n: %d. n modulo i: %d", i, n, n % i));
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    // idem que isPrimeA avec un optimisation: si le nombre n'est pas premier, on
    // s'arrête dès
    // qu'on trouve le premier modulo égal à 0
    public boolean isPrimeB(int n) {
        for (int i = 2; i < n; i += 1) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // idem que isPrimeB avec une optimisation: on va de 2 à n/2 au lieu de 2 à n-1
    public boolean isPrimeC(long n) {
        for (long i = 2; i <= n / 2; i += 1) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Attention c'est pas du https
    // http://compoasso.free.fr/primelistweb/page/prime/liste_online_en.php
    public static void main(String[] args) {
        PrimeNumberEx primeNumberEx = new PrimeNumberEx();
        System.out.println(primeNumberEx.isPrimeA(10));
        System.out.println(primeNumberEx.isPrimeB(17));
        System.out.println(primeNumberEx.isPrimeC(97));
        System.out.println(primeNumberEx.isPrimeC(1000000005721L));
    }
}