List<int> GetEvenNumbers(List<int> numbers)
{
  List<int> evenNumbers = [];
  foreach (var number in numbers)
  {
    if (number % 2 == 0)
    {
      evenNumbers.Add(number);
    }
  }
  return evenNumbers;
}

List<int> even1Numbers = GetEvenNumbers([1, 4, 88, 649, -5]);
List<int> numbers = [11, 7, 7179, -1214, 0, 3];
List<int> even2Numbers = GetEvenNumbers(numbers);
Console.WriteLine(string.Join(" - ", even1Numbers));
Console.WriteLine(string.Join(" - ", even2Numbers));