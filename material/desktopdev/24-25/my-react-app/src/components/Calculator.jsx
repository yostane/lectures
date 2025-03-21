import { useState } from "react";
import PropTypes from "prop-types";

export default function Calculator({ op1InitialValue, op2InitialValue }) {
  const [op1, setOp1] = useState(op1InitialValue);
  const [op2, setOp2] = useState(op2InitialValue);
  const [operand, setOperand] = useState("+");

  function computeResult() {
    switch (operand) {
      case "+":
        return op1 + op2;
      case "*":
        return op1 * op2;
      case "-":
        return op1 - op2;
      case "/":
        return op1 / op2;
      case "%":
        return op1 % op2;
      default:
        return NaN;
    }
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

Calculator.propTypes = {
  op1InitialValue: PropTypes.number.isRequired,
  op2InitialValue: PropTypes.number.isRequired,
};
