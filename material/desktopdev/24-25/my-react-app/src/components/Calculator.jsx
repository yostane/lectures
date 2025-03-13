import { useState } from "react";

export default function Calculator() {
  const [op1, setOp1] = useState(0);
  const [op2, setOp2] = useState(0);
  const [operand, setOperand] = useState("+");

  function computeResult() {
    return op1 + op2;
  }

  const result = computeResult();

  // input nécessitent une liaison bi-directionnelle
  // value = {} permet de mettre à jour l'input quand le state change
  // onchage=... permet de mettre à jour le state quand l'utilisateur change l'input
  return (
    <div>
      <p>Result: {result}</p>
      <div>
        <label htmlFor="op1">op1</label>
        <input
          type="number"
          name="op1"
          value={op1}
          onChange={(event) => setOp1(+event.target.value)}
        />
      </div>
      <div>
        <label htmlFor="operand">operand</label>
        <input
          type="text"
          name="operand"
          placeholder="*, /, %, +, -"
          maxLength={1}
          value={operand}
          onChange={(event) => setOperand(event.target.value)}
        />
      </div>
      <div>
        <label htmlFor="op2">op2</label>
        <input
          type="number"
          name="op2"
          value={op2}
          onChange={(event) => setOp2(+event.target.value)}
        />
      </div>
    </div>
  );
}
