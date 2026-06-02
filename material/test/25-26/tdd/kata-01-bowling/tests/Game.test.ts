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

describe("Shouold compute score after 3 rolls", () => {
  test("Should compute score with 3 rolls without strike nor spare", () => {
    const game = new Game();
    game.roll(3);
    game.roll(4);
    game.roll(8);
    const score = game.score();
    expect(score).toBe(15);
  });

  test("Should compute score with 3 rolls with a first strike and no spares", () => {
    const game = new Game();
    game.roll(10); // 22
    game.roll(4); // 4
    game.roll(8); // 8
    const score = game.score();
    expect(score).toBe(34);
  });

  test("Should compute score with 3 rolls with two first strikes", () => {
    const game = new Game();
    game.roll(10); // 28
    game.roll(10); // 18
    game.roll(8); // 8
    const score = game.score();
    expect(score).toBe(54);
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
