export class Game {
  #isPreviousRollStrike = false;
  #score = 0;
  roll(pinCount: number): void {
    if (this.#isPreviousRollStrike) {
      this.#isPreviousRollStrike = false;
      this.#score += pinCount * 2;
    } else {
      this.#score += pinCount;
    }

    if (pinCount === 10) {
      this.#isPreviousRollStrike = true;
    }
  }

  score(): number {
    return this.#score;
  }
}
