// let permet de définir des variables (ne pas utiliser var)
let x = "Hello";
// JS est dynamiquement typé
x = 10;
// const permet de définir des variables non réassignables
// Utiliser const par défaut, sinon mettre let si besoin
const y = true;
const z = ["I", "Love", "JS"];
// Le code ci-dessous montre quatre types standards:
// String, number, booléen et Array (tableau ou liste)

// Pour afficher, on utilise console.log
console.log(x, y, "Ceci est un log", z);

// On peut considérer JS comme étant faiblement typé
// -> on peut mélanger différents types dans un opération
console.log("Hello" + 10.3);
console.log("100" + 1);
console.log(10 / 0);
console.log("B" + "a" + +"a" + "a");
console.log(+"a");
// le préfixe + convertit en nombre
console.log(+"100" + 1);

// undefined et null signifient l'absence de valeur
// undefined c'est mis pas défaut côté langage
// null est explicitement affecté par le dev
let a;
console.log("a", a);

function add(x, y) {
  console.log("x", x, "y", y);
  return x + y;
}
// Les arguments ont la valeur undefined par défaut
add();
add(undefined, undefined);
add(undefined, 10);
add(10);
add(10, 4);
// null est forcément mis explicitement
a = null;
console.log("a", a);
