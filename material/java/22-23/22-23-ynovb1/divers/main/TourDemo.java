package main;

public class TourDemo {
    public TourDemo() {
        System.out.println("Tour demo constructor");
    }

    public void showSomeVariables() {
        System.out.println("some vars");
        byte b = 10;
        short s = 2;
        int i = 10;
        long l = 100_000_000;

        // nombre à virgule flottante. Attention à la précision !
        float x = 10.1f;
        double y = 10.1;
    }

    public String getMessage() {
        return "Hello";
    }
}
