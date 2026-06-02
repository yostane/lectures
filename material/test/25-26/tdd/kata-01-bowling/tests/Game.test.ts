import { describe, expect, test } from "bun:test";
import { Game } from "../src/Game";

describe("Can get score of single rolls", () => {
  test("The game should compute the score after 0 rolls", () => {
    const game = new Game();
    expect(game.score()).toBe(0);
  });

  test("The game should compute the score after 1 roll", () => {
    const game = new Game();
    game.roll(5);
    const score = game.score();
    expect(score).toBe(5);
  });
});

describe("Can compute score after 2 rolls", () => {
  test("The game should compute the score after 2 rolls", () => {
    const game = new Game();
    game.roll(5);
    game.roll(4);
    const score = game.score();
    expect(score).toBe(9);
  });

  test("Should get score after 2 rolls with a strike on first roll", () => {
    const game = new Game();
    game.roll(10);
    game.roll(4);
    const score = game.score();
    expect(score).toBe(18);
  });
});

test("I can run 2 separate games (encapsulation)", () => {
  const game1 = new Game();
  game1.roll(5);
  game1.roll(4);
  const score1 = game1.score();
  expect(score1).toBe(9);
  const game2 = new Game();
  game2.roll(6);
  game2.roll(2);
  const score2 = game2.score();
  expect(score2).toBe(8);
});
