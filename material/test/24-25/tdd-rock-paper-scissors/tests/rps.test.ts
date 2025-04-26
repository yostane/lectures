import { describe, expect, it, test, type Test } from "bun:test";
import { playGame, type Move, type MoveConfrontationResult } from "../src/game";

interface TestCase {
  description: string;
  player1: Move;
  player2: Move;
  expectedResult: MoveConfrontationResult;
}

const testCases: TestCase[] = [
  {
    description: "Paper paper should give tie",
    expectedResult: "tie",
    player1: "paper",
    player2: "paper",
  },
  {
    description: "paper scissor shoud give player2",
    expectedResult: "Player loses",
    player1: "paper",
    player2: "scissor",
  },
  {
    description: "paper rock shoud give player1",
    expectedResult: "Player wins",
    player1: "paper",
    player2: "rock",
  },
  {
    description: "rock scissor shoud give player1",
    expectedResult: "Player wins",
    player1: "rock",
    player2: "scissor",
  },
  {
    description: "rock rock shoud give tie",
    expectedResult: "tie",
    player1: "rock",
    player2: "rock",
  },
  {
    description: "rock paper shoud give lose",
    expectedResult: "Player loses",
    player1: "rock",
    player2: "paper",
  },
  {
    description: "scissor scissor shoud give tie",
    expectedResult: "tie",
    player1: "scissor",
    player2: "scissor",
  },
  {
    description: "scissor rock shoud give lose",
    expectedResult: "Player loses",
    player1: "scissor",
    player2: "rock",
  },
  {
    description: "scissor paper shoud give win",
    expectedResult: "Player wins",
    player1: "scissor",
    player2: "paper",
  },
];

describe("rpc game engine", () => {
  testCases.forEach((testCase) => {
    it(testCase.description, () => {
      const actualResult = playGame(testCase.player1, testCase.player2);
      expect(testCase.expectedResult).toEqual(actualResult);
    });
  });
});
