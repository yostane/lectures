import { useState } from "react";

export default function Counter() {
  // count c'est l'état
  // setCount met à jour sa valeur (ne pas faire 'count = nouvelle_valeur')
  const [count, setCount] = useState(-9);

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
