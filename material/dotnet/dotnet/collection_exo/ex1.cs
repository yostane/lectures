void PrintEvenNumbers(List<int> numbers)
{
  foreach (var number in numbers)
  {
    if (number % 2 == 0)
    {
      Console.WriteLine(number);
    }
  }
}

PrintEvenNumbers([1, 88, 649, -5]);
List<int> numbers = [11, 7, 7179, -1215, 0, 3];
PrintEvenNumbers(numbers);