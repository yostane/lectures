package exo;

import java.util.random.RandomGenerator;

public class RandomeDemo {
    public static void main(String[] args) {
        RandomGenerator generator = RandomGenerator.getDefault();
        int x = generator.nextInt(10, 20);
        int y = generator.nextInt(-100, 100);
        System.out.println(x + y);

        System.out.println(generator.nextInt(10, 20) + generator.nextInt(-100, 100));
    }
}
