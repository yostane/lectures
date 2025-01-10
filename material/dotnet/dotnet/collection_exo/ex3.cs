List<char> GetConsonants(string text)
{
  List<char> consonants = [];
  foreach (var c in text.ToLower())
  {
    if (c != 'a' && c != 'u' && c != 'i' && c != 'o' && c != 'e' && c != 'y')
    {
      consonants.Add(c);
    }
  }
  return consonants;
}

List<char> consontants1 = GetConsonants("Hello");
Console.WriteLine(string.Join(" - ", consontants1));