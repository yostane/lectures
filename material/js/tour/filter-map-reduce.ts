const numbers = [2, 5, 8, -7];

// garder uniquement les nombres pairs et les doubler
const resultNumbers: number[] = []; // en TS et JS, il n'y a que des numbers (pas de distinction int et float)

for (const number of numbers) {
  if (number % 2 === 0) {
    resultNumbers.push(number * 2);
  }
}
console.log(numbers, resultNumbers);

// un prédicat: une fonction qui retourne un booléen
// filter appelle le prédicat sur chaque élément, et garde ceux dont le résultat est true
const evenNumbers = numbers.filter((number) => number % 2 === 0);
console.log("even numbers", evenNumbers);
const resultNumbers2 = evenNumbers.map((number) => number * 2);
console.log("result 2", resultNumbers2);
// Style déclaratif: qui exprime l'intention
const resultNumbers3 = numbers
  .filter((number) => number % 2 === 0)
  .map((number) => number * 2);
console.log("result 3", resultNumbers2);

const texts = ["I", "love", "JavaScript", "and", "TypeScript"];
// map peut retourner un autre type que la source
console.log(
  "texts lengths",
  texts.map((text) => text.length)
);
