StreamReader sr = new("hello.txt");

Console.WriteLine(sr.ReadLine());
Console.WriteLine((char)sr.Read());
Console.WriteLine((char)sr.Read());
Console.WriteLine((char)sr.Peek());
// Don't forget to close the stream to free it
sr.Close();

// With using, sr2 will be automatically closed at the end
using (StreamReader sr2 = new("hello.txt"))
{
  string? line = sr2.ReadLine();
  while (line != null)
  {
    Console.WriteLine($"Ligne récuprée: {line}");
    line = sr2.ReadLine();
  }
}

using (StreamWriter sw = new("test.txt"))
{
  sw.WriteLine("Hello");
  sw.Write(" tout le monde");
  sw.WriteLine("J'aime");
  sw.WriteLine("Le C#");
}

// Raccourci pour lire tout le contenu d'un fichier
string fileContent = File.ReadAllText("test.txt");
Console.WriteLine(fileContent);