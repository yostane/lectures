// window est proposée par les navigateur en variable globale
console.log("window", window);
// il permet d'accéder aux apis du runtime
// Pour un navigateur, ce sera par exemple, AudioContext, le DOM,
// les APIs de window.navigator, etc.
// window est implicite pour les objets qui font partie de window
console.log("window.navigator", window.navigator, "navigator", navigator);
window.sayHello = function () {};
sayHello();

// appelé quand le navigateur a chargé le DOM (les balises)
// C'est le premier moment pour manipuler le DOM
window.addEventListener("DOMContentLoaded", () => {
  // DOM représente la page sous forme d'un objet
  // La racine de la page est accessible avec window.document
  console.log(document);
  document.getElementById("grid-button").addEventListener("click", () => {
    const classList = document.querySelector("main").classList;
    classList.add("grid");
    classList.remove("list");
  });
  document.getElementById("list-button").addEventListener("click", () => {
    const classList = document.querySelector("main").classList;
    classList.remove("grid");
    classList.add("list");
  });
  document.querySelector("#dark-mode").addEventListener("change", (event) => {
    console.log("event object", event);
    console.log("checked", event.target.checked);
    console.log(
      getComputedStyle(document.body).getPropertyValue("--main-bg-color")
    );
  });
});
