using System.Reflection.Metadata;
using System.Reflection.PortableExecutable;
using System.Text;

void RunQ1()
{
  void ShowEvenNumbers(List<int> numbers)
  {
    var evenNumbers = from n in numbers where n % 2 == 0 select n;
    Console.WriteLine(string.Join(",", evenNumbers));
  }
  Console.WriteLine("Exercise 1");
  ShowEvenNumbers([1, 2, 3, 4, 5, 6, 7]);
  // Enumerable.Range equivalent of Python range with less features
  ShowEvenNumbers(Enumerable.Range(-10, 20).ToList());
}

void RunQ2()
{
  // Avec la method syntax
  List<int> GetEvenNumbers(List<int> numbers)
  {
    var evenNumbers = numbers.Where(n => n % 2 == 0);
    return evenNumbers.ToList();
  }
  // Avec la query syntax et avec un single statement function
  List<int> GetEvenNumbers2(List<int> numbers) =>
    (from n in numbers where n % 2 == 0 select n).ToList();

  List<int> numbers = Enumerable.Range(1, 10).ToList();
  Console.WriteLine("Exercise 2");
  Console.WriteLine(string.Join(",", GetEvenNumbers(numbers)));
  Console.WriteLine(string.Join(",", GetEvenNumbers2(numbers)));
}

void RunQ3()
{
  string GetConsonants(string input)
  {
    string lowerCased = input.ToLower();
    var consonants = lowerCased.Where(c => !"aeiuyo".Contains(c));
    return string.Join("", consonants);
  }

  string GetConsonants2(string input) =>
    string.Join("", input.ToLower().Where(c => !"aeiuyo".Contains(c)));
  Console.WriteLine("Exercise 3");
  Console.WriteLine(GetConsonants("Hello"));
  Console.WriteLine(GetConsonants("BBBBCCCC"));
  Console.WriteLine(GetConsonants("aeae"));
  Console.WriteLine(GetConsonants2("Hello"));
  Console.WriteLine(GetConsonants2("BBBBCCCC"));
  Console.WriteLine(GetConsonants2("aeae"));
}

void RunQ4()
{
  List<int> GetLengths(List<string> texts) =>
    (from text in texts select text.Length).ToList();
  Console.WriteLine("Exercise 4");
  Console.WriteLine(string.Join(", ", GetLengths(["I", "Love", "C#"])));
  Console.WriteLine(string.Join(", ", GetLengths(["LINQ", "Rocks"])));
}

void RunQ5()
{
  string ToCamelCaseName(string name)
  {
    var transformed = name.Select((c, index) => index == 0 || name[index - 1] == ' ' ? char.ToUpper(c) : c);
    return string.Join("", transformed);
  }
  void PrintResults(List<Person> persons)
  {
    Console.WriteLine($"input list: {string.Join(",", persons)}");
    var olderThan18 = persons.Where(p => p.Age > 18);
    Console.WriteLine($"Older than 18: {string.Join(", ", olderThan18)}");
    var startWithAPersons = from p in persons where p.Name.Length > 1 && p.Name[0] == 'A' select p;
    Console.WriteLine($"Start with A: {string.Join(", ", startWithAPersons)}");
    var camelCased = persons.Select(p => new Person(ToCamelCaseName(p.Name), p.Age));
    Console.WriteLine($"Camel cased: {string.Join(", ", camelCased)}");
  }
  List<Person> persons = [new("Kakashi", 50), new("Arata", 23), new("j bap", 2)];
  PrintResults(persons);
  Random rng = new();
  List<Person> randomPersons = Enumerable.Range(1, 5)
    .Select(
      i => new Person($"person number {i}", rng.Next(10, 30))
    ).ToList();
  PrintResults(randomPersons);
}

RunQ1();
RunQ2();
RunQ3();
RunQ4();
RunQ5();

record Person(string Name, int Age);