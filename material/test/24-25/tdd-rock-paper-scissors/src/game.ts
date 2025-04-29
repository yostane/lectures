export type Move = "rock" | "paper" | "scissor";
export type MoveConfrontationResult = "Player wins" | "Player loses" | "tie";

export function playGame(
  player: Move,
  opponent: Move
): MoveConfrontationResult {
  switch (player) {
    case "paper":
      switch (opponent) {
        case "rock":
          return "Player wins";
        case "scissor":
          return "Player loses";
        case "paper":
          return "tie";
      }
    case "rock":
      switch (opponent) {
        case "scissor":
          return "Player wins";
        case "paper":
          return "Player loses";
        case "rock":
          return "tie";
      }
    case "scissor":
      switch (opponent) {
        case "rock":
          return "Player loses";
        case "paper":
          return "Player wins";
        case "scissor":
          return "tie";
      }
  }
}
