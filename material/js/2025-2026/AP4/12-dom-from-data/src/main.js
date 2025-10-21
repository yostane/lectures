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
      localStorage.setItem("planets", JSON.stringify(updatedPlanets));
      renderPlanets(updatedPlanets);
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
  localStorage.setItem("planets", JSON.stringify(planetsBody.results));
  return planetsBody.results;
}

window.addEventListener("DOMContentLoaded", async () => {
  const planets =
    JSON.parse(localStorage.getItem("planets")) ?? (await fetchPlanets());
  console.log(planets);
  renderPlanets(planets);
});
