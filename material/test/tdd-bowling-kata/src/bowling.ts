export class Frame {
  constructor(public first: number, public second: number) {}

  isSpare(): boolean {
    return this.first + this.second === 10 && this.second !== 0;
  }

  isStrike(): boolean {
    return this.first === 10;
  }
}
export class BowlingCalcultor {
  constructor(private frames: Frame[]) {}

  getScore(): number {
    let score = 0;
    this.frames.slice(0, 10).forEach((frame, i) => {
      if (frame.isSpare()) {
        const nextFrame = this.frames[i + 1];
        if (nextFrame === undefined) {
          throw new Error("frame error");
        }
        score += nextFrame.first;
      } else if (frame.isStrike()) {
        const nextFrame = this.frames[i + 1];
        if (nextFrame === undefined) {
          throw new Error("frame error");
        }
        score += nextFrame.first + nextFrame.second;
        if (nextFrame.isStrike()) {
          const nextNextFrame = this.frames[i + 2];
          if (nextNextFrame !== undefined) {
            score += nextNextFrame.first;
          }
        }
      }
      score += frame.first + frame.second;
    });
    return score;
  }
}
