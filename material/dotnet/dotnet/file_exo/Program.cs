static void PrintCountPerLine(string filePath)
{
  using StreamReader sr = new(filePath);
  string? line = sr.ReadLine();
  while (line != null)
  {
    Console.WriteLine(line.Length);
    line = sr.ReadLine();
  }
}

static void AddDotIfNotPresent(string filePath)
{
  using StreamReader sr = new(filePath);
  using StreamWriter sw = new("dotted_file.txt");
  string? line = sr.ReadLine();
  while (line != null)
  {
    if (!line.EndsWith('.'))
    {
      line += '.'; // autre façon: line = $"{line}.";
    }
    sw.WriteLine(line);
    line = sr.ReadLine();
  }
}

static void WriteLongestLine(string filePath)
{
  using StreamReader sr = new(filePath);
  string? line = sr.ReadLine();
  string? longestLine = line;
  while (line != null)
  {
    line = sr.ReadLine();
    if (longestLine?.Length < line?.Length)
    {
      longestLine = line;
    }
  }
  if (longestLine != null)
  {
    using StreamWriter sw = new("longest_line.txt");
    sw.WriteLine(longestLine);
  }
}

string filePath = "input_file.txt";
PrintCountPerLine(filePath);
AddDotIfNotPresent(filePath);
WriteLongestLine(filePath);