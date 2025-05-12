import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { createRoot } from "react-dom/client";
import { StrictMode } from "react";
import "./index.css";
import App from "./App.jsx";
import Portfolio from "./views/Portfolio.jsx";
import About from "./views/About.jsx";
import Home from "./views/Home.jsx";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/home",
        element: <Home />,
      },
      {
        path: "/about",
        element: <About />,
      },
      {
        path: "/cv",
        element: <Portfolio />,
      },
    ],
  },
]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>
);
