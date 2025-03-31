import { describe, expect, it, test, type Test } from "bun:test";
import { BowlingCalcultor } from "../src/bowling";

interface TestCase {
  description: string;
  rolls: number[][];
  expectedScore: number;
}

const testCases: TestCase[] = [
  {
    description: "Should get 0 is all frames are 0",
    rolls: [
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
    ],
    expectedScore: 0,
  },
  {
    description:
      "Should compute the toal score when there are no spares not strikes",
    rolls: [
      [3, 4],
      [5, 2],
      [3, 2],
      [1, 0],
      [7, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
    ],
    expectedScore: 27,
  },
  {
    description:
      "Should compute the toal score when there is one only strike and no spares",
    rolls: [
      [10, 0],
      [3, 4],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
    ],
    expectedScore: 24,
  },
  {
    description:
      "Should compute the toal score when there is one only strike and the end and no spares",
    rolls: [
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [10, 0],
      [1, 2],
    ],
    expectedScore: 13,
  },
  {
    description:
      "Should compute the toal score when there is one only spare at the beginning and no strike",
    rolls: [
      [5, 5],
      [7, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
    ],
    expectedScore: 24,
  },
  {
    description:
      "Should compute the toal score when there is one only spare at the end and no strike",
    rolls: [
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [6, 4],
      [9, 0],
    ],
    expectedScore: 19,
  },
  {
    description: "Should compte score with two strikes in succession",
    rolls: [
      [10, 0],
      [10, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
    ],
    expectedScore: 30,
  },
  {
    description: "Should compte score with only strikes",
    rolls: [
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 0],
      [10, 10],
    ],
    expectedScore: 300,
  },
  {
    description: "Should compte score with two strikes at the end",
    rolls: [
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [0, 0],
      [10, 0],
      [10, 10],
    ],
    expectedScore: 30,
  },
];

describe("Bowling score calculator", () => {
  for (const testCase of testCases) {
    it(testCase.description, () => {
      const bowlingCalcultor = new BowlingCalcultor(testCase.rolls);
      const actualScore = bowlingCalcultor.getScore();
      expect(actualScore).toBe(testCase.expectedScore);
    });
  }
});
