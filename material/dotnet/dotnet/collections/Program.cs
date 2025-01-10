// See https://aka.ms/new-console-template for more information
List<string> messages = ["I", "Love", "C#"];
messages.Add("in 2024");
Console.WriteLine(messages[0]);
// ^ -> indexation inversée
Console.WriteLine(messages[^1]);
Console.WriteLine(messages);
// string.Join Pour afficher proprement
Console.WriteLine(string.Join(" $ ", messages));
Console.WriteLine(string.Join(" - ", messages[1..3]));
Console.WriteLine(string.Join(" - ", messages[1..^1]));
// i..j -> extraction de la sous-liste de l'indice i à l'indice j-1
var subMessages = messages[1..3];
Console.WriteLine(subMessages[0]);

foreach (var message in messages)
{
  Console.Write($"{message} ");
}
Console.WriteLine();

foreach (var c in "Hello")
{
  Console.WriteLine($"Current char {c}");
}

// List of ints
List<int> numbers = [5, -9, 2, 3];
Console.WriteLine(string.Join(" - ", numbers));

// Lists can contain any type. Here we use a record
Hero h1 = new("Lapin de Garène", 100);
List<Hero> heroes = [h1, new("Raze", 90)];
Console.WriteLine($"Name of the 1st hero: {heroes[0].Name}");
Console.WriteLine(string.Join(" - ", heroes));

List<Hero2> secondHeroes = [new() { Name = "Siraka", Hp = 50 }, new() { Name = "Malfait", Hp = 80 }];
Console.WriteLine(string.Join(" - ", secondHeroes));

record Hero(string Name, int Hp);

class Hero2
{
  public required string Name { get; set; }
  public required int Hp { get; set; }

  public override string ToString() => $"Name: {Name}, HP: {Hp}";
}