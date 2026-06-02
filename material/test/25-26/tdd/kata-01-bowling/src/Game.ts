export class Game {
  #isSecondToLastRollStrike = false;
  #isLastRollStrike = false;
  #score = 0;
  roll(pinCount: number): void {
    this.#score += pinCount;
    if (this.#isSecondToLastRollStrike) {
      this.#score += pinCount;
      this.#isSecondToLastRollStrike = false;
    }
    if (this.#isLastRollStrike) {
      this.#score += pinCount;
      this.#isSecondToLastRollStrike = true;
      this.#isLastRollStrike = false;
    }
    if (pinCount === 10) {
      this.#isLastRollStrike = true;
    }
  }

  score(): number {
    return this.#score;
  }
}
