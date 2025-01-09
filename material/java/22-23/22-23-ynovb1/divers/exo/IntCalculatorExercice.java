package exo;

import java.util.Scanner;

public class IntCalculatorExercice {
    public static void main(String[] args) {
        IntCalculator intCalculator = new IntCalculator();
        System.out.println(intCalculator.add(10, -9));
        System.out.println(intCalculator.computeFromString("5 * -10"));
        System.out.println(intCalculator.computeFromString("-5 + +10"));
        System.out.println(intCalculator.computeFromString("-50 / -10"));
        System.out.println(intCalculator.computeFromString("-5 - 10"));
        // System.out.println(intCalculator.computeFromStandardInput());
    }
}

/**
 * IntCalculator
 */
class IntCalculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int multiply(int x, int y) {
        return x * y;
    }

    public int divide(int x, int y) {
        return x / y;
    }

    public int subsctract(int x, int y) {
        return x - y;
    }

    public int computeFromString(String input) {
        String[] tokens = split(input);
        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[2]);
        switch (tokens[1]) {
            case "+":
                return add(a, b);
            case "-":
                return subsctract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                return 0;
        }
    }

    private String[] split(String input) {
        String operand1 = "", operand2 = "";
        String operation = "";
        int currentToken = 0;
        for (int i = 0; i < input.length(); i++) {
            // "3 + -10"
            if (currentToken == 0) {
                operand1 += input.charAt(i);
                if (input.charAt(i + 1) == ' ') {
                    currentToken = 1;
                }
            } else if (currentToken == 1 && input.charAt(i) != ' ') {
                operation += input.charAt(i);
                currentToken = 2;
            } else if (currentToken == 2 && input.charAt(i) != ' ') {
                operand2 += input.charAt(i);
            }
        }
        return new String[] { operand1, operation, operand2 };
    }

    public int computeFromStandardInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        return this.computeFromString(line);
    }
}
