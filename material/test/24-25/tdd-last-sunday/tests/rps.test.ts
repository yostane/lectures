import { describe, expect, it, test, type Test } from "bun:test";

interface TestCase {
  description: string;
  year: number;
  expectedResult: Date[];
}

const testCases: TestCase[] = [];

describe("Last sunday of each month for a given year", () => {
  testCases.forEach((testCase) => {
    it(testCase.description, () => {
      const actualResult = playGame(testCase.player1, testCase.player2);
      expect(testCase.expectedResult).toEqual(actualResult);
    });
  });
});
