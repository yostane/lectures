function add(x, y) {
  return x + y;
}

// on peut donner une valeur par défaut aux arguments
function multiply(x = 10, y = 3) {
  return x * y;
}

console.log("multiply()", multiply()); // 30
console.log("multiply(4)", multiply(4)); // 12
console.log("multiply(undefined, 7)", multiply(undefined, 7)); // 70
console.log("multiply(null, 7)", multiply(null, 7)); // 0

// function add(x, y) {} est équivalent à
function add2(x = undefined, y = undefined) {
  return x + y;
}

// Les fonctions sont des éléments de première classe
// -> elles se manipulent comme des variables et des arguments
const f = add;
console.log("f(10, 43)", f(10, 43));

// onRandomGeneration est appelé fonction d'ordre supérieur
// (higher order function)
// C'est toute fonction qui prendre au moins en argument un fonction
function onRandomGeneration(f) {
  const r = Math.random();
  f(r);
}

onRandomGeneration(function (r) {
  if (r > 0.5) {
    console.log("Bigger than 0.5");
  } else {
    console.log("Smaller than 0.5");
  }
});

onRandomGeneration(function (r) {
  console.log("the generated number is ", r);
});

// JS propose une écriture alternative des focntions
// appelées fonctions flèche

const subtract = (a, b) => {
  return a - b;
};
console.log("subtract(10, 5)", subtract(10, 5));

// Si la fonction ne fait que return un calcul, on peut omettre les {} et le return
const divide = (a, b) => a / b;
console.log("divide(10, 5)", divide(10, 5));

// Les fonctions flèches sont particulièrement adaptées pour les
// passer en argument d'une fonction d'ordre supérieur

onRandomGeneration((r) => console.log("r is", r));
onRandomGeneration((r) => {
  console.log("C'est une fonction flèche");
  console.log("r is", r);
});

// Ma recommendation est d'utiliser "function" pour déclarer des fonctions
// et d'utiliser les fonctions flèches pour passer des fonctions en argument
