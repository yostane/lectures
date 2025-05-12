import "./App.css";
import { Link } from "react-router-dom";

export default function App() {
  return (
    <>
      <div>
        <Link to="/home">Accueil</Link>
        <Link to="/about">A propos</Link>
        <Link to="/portfolio">CV</Link>
      </div>
    </>
  );
}
