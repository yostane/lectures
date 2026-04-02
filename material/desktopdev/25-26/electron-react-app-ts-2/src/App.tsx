import { Link, Outlet } from "react-router-dom";
import "./App.css";

function App() {
  return (
    <>
      <div>
        <Link to="/home">Accueil</Link> -<Link to="/about">A propos</Link> -
        <Link to="/contact">Contact</Link>
      </div>
      <Outlet />
    </>
  );
}

export default App;
