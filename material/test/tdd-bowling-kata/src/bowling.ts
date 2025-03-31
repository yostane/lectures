export class BowlingCalcultor {
  static getScore(frames: number[]): number {
    let sum = 0;
    for (let index = 0; index < frames.length; index++) {
      const frame = frames[index];
      const nextFrame = frames[index + 1];
      if (frame === 10) {
        sum += 10 + nextFrame + frames[index + 2];
      } else if (index < 19) {
        sum += frame;
      } else if (frame + nextFrame === 10) {
        sum += frame + nextFrame + frames[index + 2] * 2;
      }
    }
    return sum;
  }
}
