// See https://aka.ms/new-console-template for more information
using System.Data;
using DemoOpp;

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

Random r = new();
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
int[] items = [1, 2, 4];

for (int i = 0; i < items.Length; i++)
{
  Console.WriteLine($"La valeur de l'élement d'indice {i} du tableau est : {items[i]}");
}

foreach (var item in items)
{
  Console.WriteLine($"La valeur de l'élement courant est : {item}");
}

CPU cpu1 = new(200);
cpu1.WattUsage = 100;
Console.WriteLine(cpu1.WattUsage);

CPU cpu2 = new(500);
cpu2.WattUsage = 100;
Console.WriteLine(cpu2.WattUsage);

CPU cpu3 = new(200)
{
  ClockSpeed = 100,
  CoreCount = 8,
  WattUsage = 10
};

Console.WriteLine(cpu3);


RAM ram1 = new(200)
{
  Capacity = 8000,
  WattUsage = 10
};
Console.WriteLine(ram1);