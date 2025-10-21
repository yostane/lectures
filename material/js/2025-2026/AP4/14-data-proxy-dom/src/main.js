const state = {
  planets: [],
};

const stateProxyHandler = {
  set(obj, prop, value) {
    obj[prop] = value;
    localStorage.setItem("planets", JSON.stringify(value));
    if (prop == "planets") {
      renderPlanets(value);
    }
    return true;
  },
};

const stateProxy = new Proxy(state, stateProxyHandler);

function Planet(planet, onDeletePlanet) {
  const node = document.createElement("div");
  node.setAttribute("id", `planet-${planet.name.toLowerCase()}`);
  const textnode = document.createTextNode(`🪐 ${planet.name}`);
  const buttonNode = document.createElement("button");
  const buttonTextNode = document.createTextNode("🗑️");
  buttonNode.appendChild(buttonTextNode);
  buttonNode.addEventListener("click", () => {
    onDeletePlanet(planet);
  });
  node.appendChild(textnode);
  node.appendChild(buttonNode);
  return node;
}

function renderPlanets(planets) {
  const planetsNodes = planets.map((planet) =>
    Planet(planet, (planetToDelete) => {
      const updatedPlanets = planets.filter(
        (p) => p.name !== planetToDelete.name
      );
      stateProxy.planets = updatedPlanets;
    })
  );
  const planetsParentEl = document.querySelector("#planets");
  planetsParentEl.innerHTML = "";
  for (const planetNode of planetsNodes) {
    planetsParentEl.appendChild(planetNode);
  }
}

async function fetchPlanets() {
  const request = await fetch("https://swapi.dev/api/planets");
  const planetsBody = await request.json();
  return planetsBody.results;
}

let currentPlanet = 1;
window.addEventListener("DOMContentLoaded", async () => {
  const planets =
    JSON.parse(localStorage.getItem("planets")) ?? (await fetchPlanets());
  stateProxy.planets = planets;

  document.querySelector("#add-planet").addEventListener("click", () => {
    const planet = {
      name: `Amazing planet ${currentPlanet}`,
    };
    currentPlanet += 1;
    // Créer une nouvelle liste qui reprend la liste d'origine + une nouvelle planète
    // ...tableau => va littéralement remplacer par tableau[0], tableau[1], ...
    stateProxy.planets = [...stateProxy.planets, planet];
  });
});
