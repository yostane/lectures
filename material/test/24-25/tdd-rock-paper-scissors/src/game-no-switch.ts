import type { Move, MoveConfrontationResult } from "./game";

interface Scenario {
  player: Move;
  opponent: Move;
  result: MoveConfrontationResult;
}
export function playGameNoSwitch(
  player: Move,
  opponent: Move
): MoveConfrontationResult {
  const scenarios: Scenario[] = [
    {
      player: "rock",
      opponent: "rock",
      result: "tie",
    },
    // remplir avec les autres cas
  ];

  for (const scenario of scenarios) {
    if (scenario.player === player && scenario.opponent === opponent) {
      return scenario.result;
    }
  }
  throw new Error("Not handled case");
}

export function playGameNoOther(
  player: Move,
  opponent: Move
): MoveConfrontationResult {
  if (player === opponent) {
    return "tie";
  }
  if (player === "rock") {
    return opponent === "scissor" ? "Player wins" : "Player loses";
  } else if (player === "paper") {
    return opponent === "rock" ? "Player wins" : "Player loses";
  } else {
    return opponent === "paper" ? "Player wins" : "Player loses";
  }
}
