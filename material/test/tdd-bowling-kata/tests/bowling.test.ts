import { describe, expect, it, test, type Test } from "bun:test";
import { BowlingCalcultor } from "../src/bowling";

interface TestCase {
  description: string;
  rolls: number[];
  expectedScore: number;
}

const testCases: TestCase[] = [
  {
    description: "Should get 0 is all frames are 0",
    rolls: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    expectedScore: 0,
  },
  {
    description:
      "Should compute the toal score when there are no spares not strikes",
    rolls: [3, 4, 5, 2, 3, 2, 1, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    expectedScore: 27,
  },
  {
    description:
      "Should compute the toal score when there is one only strike and no spares",
    rolls: [10, 3, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    expectedScore: 24,
  },
  {
    description:
      "Should compute the toal score when there is one only strike and the end and no spares",
    rolls: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 1, 2],
    expectedScore: 13,
  },
  {
    description:
      "Should compute the toal score when there is one only spare at the beginning and no strike",
    rolls: [5, 5, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
    expectedScore: 24,
  },
];

describe("Bowling score calculator", () => {
  for (const testCase of testCases) {
    it(testCase.description, () => {
      const actualScore = BowlingCalcultor.getScore(testCase.rolls);
      expect(actualScore).toBe(testCase.expectedScore);
    });
  }
});
