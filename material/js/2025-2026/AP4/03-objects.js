// JS permet de définir des classes
class Student {
  constructor(id, name) {
    this.name = name;
    this.id = id;
  }

  study() {
    console.log("I'm studying");
  }
}

// et d'en instancier des objets
const student1 = new Student(1, "Tanjiro");
const student2 = new Student(1, "Naruto");
console.log(student1, student2);

// Il permet aussi de définir des objets littéraux
const fighter1 = {
  name: "Ryu",
  game: "Street Fighter",
};

const fighter2 = {
  name: "Paul Phoenix",
  game: "Street Tekken",
};

console.log(fighter1, fighter2);

// Ma recommendation est d'utiliser les classes quand on veut modéliser un domaine applicatif
// et les objets littéraux quand pour regrouper plusieurs arguments()

function setupGame(name, options) {
  console.log("Setting up", name);
  console.log("with the options");
  console.log(" FPS", options.fps);
  console.log(" Color filter", options.filter);
  console.log(" Audio enabled", options.isAudioEnabled);
}

setupGame("LoL", { fps: 60, filter: "Black and white", isAudioEnabled: false });
setupGame("CSGo", {
  fps: 120,
  filter: null,
  isAudioEnabled: true,
});
