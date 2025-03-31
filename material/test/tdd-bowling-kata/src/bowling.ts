export class BowlingCalcultor {
  private frames: number[][];
  constructor(frames: number[][]) {
    this.frames = frames;
  }

  getScore(): number {
    let sum = 0;
    let frameBonus = 0;
    const framesLength = this.frames.length;

    if (this.isStrikeAtTheEnd() || this.isSpareAtThenEnd()) {
      sum = 10 + this.getFrameTotal(this.frames[framesLength - 1]);
      frameBonus = 2;
    }

    for (let index = 0; index < framesLength - frameBonus; index++) {
      const frame = this.frames[index];
      const nextFrame = this.frames[index + 1];
      if (this.isStrike(frame)) {
        if (this.isStrike(nextFrame) && index <= framesLength - 2) {
          const nextNextFrame = this.frames[index + 2];
          sum += this.getFrameTotal(nextNextFrame);
        }
        sum += this.getFrameTotal(nextFrame);
      }
      if (this.isSpare(frame)) {
        sum += nextFrame[0];
      }
      sum += this.getFrameTotal(frame);
    }

    return sum;
  }

  private getFrameTotal(frame: number[]): number {
    return frame[0] + frame[1];
  }

  private isStrike(frameNumbers: number[]): Boolean {
    return frameNumbers[0] === 10;
  }

  private isSpare(frameNumbers: number[]): Boolean {
    if (this.isStrike(frameNumbers)) {
      return false;
    }
    return this.getFrameTotal(frameNumbers) === 10;
  }

  private isStrikeAtTheEnd(): Boolean {
    return this.isStrike(this.frames[this.frames.length - 2]);
  }

  private isSpareAtThenEnd(): Boolean {
    return this.isSpare(this.frames[this.frames.length - 2]);
  }
}
