// JS permet de créer des tableaux littéraux
// La convention est de mettre le nom au pluriel
const items = ["I", "Love", "JavaScript"];
console.log("First item", items[0]);
items.push("in");
items.push(2025);
console.log("after adding two items", items);
//pop permet de récupérer la valeur du dernier élément tout en le retirant de la liste
console.log("pop", items.pop());
console.log("pop", items.pop());
// Devrait afficher la liste originale car on a retiré avec pop les éléments qui ont été append
console.log(items);
// join permet d'assembler les élément dans une string
items.push("in");
items.push("2025");
console.log(items.join(" "));

// La sous-liste les éléments qui 3 caractères ou plus -> filtrage
// for of (pas le for in qui fait autre chose)
const result1Items = [];
for (const item of items) {
  if (item.length > 2) {
    result1Items.push(item);
  }
}
console.log("3 chars or more, method 1", result1Items);

const result2Items = items.filter((item) => item.length > 2);
console.log("3 chars or more, method 2", result2Items);

// La sous-liste des éléments qui ont 3 caractères ou plus. Renvoyer les résultat en majuscules
// style impératif
const result3Items = [];
for (const item of items) {
  if (item.length > 2) {
    result3Items.push(item.toLocaleUpperCase());
  }
}
// Style déclaratif
const result4Items = items
  .filter((item) => item.length > 2)
  .map((item) => item.toLocaleUpperCase());
console.log("3+ upper", result3Items, result4Items);
