import { useState } from "react";
import PropTypes from "prop-types";

export default function Counter({ initialValue }) {
  // count c'est l'état
  // setCount met à jour sa valeur (ne pas faire 'count = nouvelle_valeur')
  const [count, setCount] = useState(initialValue);

  function incrementCount() {
    // si on fait count += 1, on ne verra pas le compteur changer
    setCount(count + 1);
  }

  return (
    <div>
      <button onClick={incrementCount}>Increment</button>
      <p>{count}</p>
    </div>
  );
}

Counter.propTypes = {
  initialValue: PropTypes.number.isRequired,
};
