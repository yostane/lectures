import "./App.css";
import { Link, Outlet } from "react-router-dom";

export default function App() {
  return (
    <>
      <div>
        <Link to="/home">Accueil</Link> - <Link to="/about">A propos</Link> -{" "}
        <Link to="/cv">Protfolio</Link>
      </div>
      <Outlet />
      <footer>Copyright 2025</footer>
    </>
  );
}
