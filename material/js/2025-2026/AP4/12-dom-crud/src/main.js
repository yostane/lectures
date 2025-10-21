function Planet() {
  const rnd = Math.random();
  const node = document.createElement("div");
  node.setAttribute("id", `planet-${rnd}`);
  const textnode = document.createTextNode(`Une planète ${rnd}`);
  const buttonNode = document.createElement("button");
  const buttonTextNode = document.createTextNode("🗑️");
  buttonNode.appendChild(buttonTextNode);
  buttonNode.addEventListener("click", () => {
    document.querySelector("#planets").removeChild(node);
  });
  node.appendChild(textnode);
  node.appendChild(buttonNode);
  return node;
}

window.addEventListener("DOMContentLoaded", () => {
  document.querySelector("#add-planet").addEventListener("click", () => {
    const planetsElement = document.querySelector("#planets");
    planetsElement.innerHTML += "<div>Une planète</div>";
  });

  document.querySelector("#add-planet-2").addEventListener("click", () => {
    const planetsElement = document.querySelector("#planets");
    const node = Planet();
    planetsElement.appendChild(node);
  });
});
