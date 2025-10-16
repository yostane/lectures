const baseUrl = "https://swapi.dev/api";
// JS permet d'interpoler des expressions dans des string définis avec ``
const peopleEndpoint = `${baseUrl}/people`;
// await permet d'attendre la récupération de la réponse car elle peut prendre du temps
const response = await fetch(peopleEndpoint);
const peopleBody = await response.json();
console.log("next", peopleBody.next);
console.log("results count", peopleBody.results.length);
/**
 * {
	"count": 82,
	"next": "https://swapi.dev/api/people/?page=2",
	"previous": null,
	"results": [ ...],
}
 */
