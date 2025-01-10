void RunTour(){
  
}
// Premier tour du langage
Console.WriteLine("Hello, World!");

int intValue = 10;
bool b = false;
string s = "hello";

Console.WriteLine(intValue);
Console.WriteLine(s);

// Ne pas utliser la concaténation
Console.WriteLine("La valeur de s est : " + s + " et la valeur de est " + intValue);
// Car il y a mieux à la place avec $"" -> interpolation de string
Console.WriteLine($"La valeur de s est : {s} et la valeur de l'entier est {intValue}");

// intValue = "Hello"; // erreur car statiquement typé et intValue est un int

// typage implicite: message sera de type string
var message = $"La valeur de s est : {s} et la valeur de l'entier est {intValue}";
Console.WriteLine(message);

Random r = new Random();
int randomVal = r.Next(10, 20);

if (randomVal > 15)
{
  Console.WriteLine("gagné");
}
else
{
  Console.WriteLine("perdu");
}

for (int i = 3; i < 8; i++)
{
  Console.WriteLine($"La valeur de i est : {i}");
}

// Mettre un identifiant au pluriel pour les tableaux
int[] items = { 1, 2, 4 };

for (int i = 0; i < items.Length; i++)
{
  Console.WriteLine($"La valeur de l'élement d'indice {i} du tableau est : {items[i]}");
}

foreach (var item in items)
{
  Console.WriteLine($"La valeur de l'élement courant est : {item}");
}
