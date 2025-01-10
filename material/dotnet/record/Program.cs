Person p1 = new("John", "Doe");
Person p2 = new("John", "Doe");
Console.WriteLine(p1.LastName);
// p1.LastName = "Hello"; -> erreur
Console.WriteLine(p1 == p2); // true
Console.WriteLine(p1); // Person { FirstName = John, LastName = Doe }

public record Person(string FirstName, string LastName);