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
