import "./style.css";

// DOMContentLoaded permet de s'assurer que tout le DOM est bien chargé côté JS
document.addEventListener("DOMContentLoaded", () => {
  const button = document.querySelector<HTMLButtonElement>("#add-item");
  const app = document.querySelector<HTMLDivElement>("#app");
  button?.addEventListener("click", (e) => {
    const p = document.createElement("p");
    const content = document.createTextNode(`- Il est ${new Date()}`);
    p.appendChild(content);
    app?.appendChild(p);
  });
});
