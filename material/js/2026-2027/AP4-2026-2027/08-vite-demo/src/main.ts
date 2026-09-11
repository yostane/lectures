import "./style.css";

type State = {
  dates: Date[];
};

const state: State = {
  dates: [],
};

const handler: ProxyHandler<State> = {
  set(obj, prop, value) {
    const app = document.querySelector<HTMLDivElement>("#app");
    if (!app) {
      return true;
    }
    app.innerHTML = "";
    for (const date of value) {
      const p = document.createElement("p") as HTMLParagraphElement;
      p.innerText = `- Il est ${date.toISOString()}`;
      app?.appendChild(p);
    }
    obj.dates = value;
    return true;
  },
};
const proxy = new Proxy(state, handler);

// DOMContentLoaded permet de s'assurer que tout le DOM est bien chargé côté JS
document.addEventListener("DOMContentLoaded", () => {
  const button = document.querySelector<HTMLButtonElement>("#add-item");
  const app = document.querySelector<HTMLDivElement>("#app");
  button?.addEventListener("click", (e) => {
    const newDates = [...state.dates, new Date()];
    proxy.dates = newDates;
  });
});
