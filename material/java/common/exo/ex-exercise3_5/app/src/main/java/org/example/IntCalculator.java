package org.example;

import javax.annotation.Nonnull;

/**
 * IntCalculator
 */
class IntCalculator extends AbstractIntCalculator {

  @Override
  public int computeFromString(@Nonnull String input) throws IllegalArgumentException {
    String[] tokens = input.split(" ");
    if (tokens.length != 3) {
      throw new IllegalArgumentException("Incorrect number of arguments");
    }
    try {
      int a = Integer.parseInt(tokens[0]);
      int b = Integer.parseInt(tokens[2]);
      return switch (tokens[1]) {
        case "+" -> add(a, b);
        case "-" -> subtract(a, b);
        case "*" -> multiply(a, b);
        case "/" -> divide(a, b);
        default -> throw new IllegalArgumentException("Operator not found");
      };
    } catch (NumberFormatException nfe) {
      throw new IllegalArgumentException("Incorrect operand(s)");
    }
  }

  private String[] manualSplit(String input) {
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
    return new String[]{operand1, operation, operand2};
  }
}
