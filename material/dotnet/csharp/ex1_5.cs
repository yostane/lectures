void RunExercice1()
{
  Console.WriteLine("Exercise 1");
  var r = new Random();
  Console.WriteLine(r.Next());
}

void RunExercice2()
{
  Console.WriteLine("Exercise 2");
  var r = new Random(50);
  int x = r.Next();
  int y = r.Next();
  if (x < y)
  {
    Console.WriteLine($"{x}, {y}");
  }
  else
  {
    Console.WriteLine($"{y}, {x}");
  }
}

void RunExercice3()
{
  var r = new Random();
  int x = r.Next(50);
  int y = r.Next(50);
  int z = r.Next(50);
  Console.WriteLine($"Exercise 3: tri de {x}, {y} et {z}");
  if (x < y)
  {
    if (z < x)
    {
      Console.WriteLine($"{z}, {x}, {y}");
    }
    else if (z < y)
    {
      Console.WriteLine($"{x}, {z}, {y}");
    }
    else
    {
      Console.WriteLine($"{x}, {y}, {z}");
    }
  }
  else // y <= x
  {
    if (z < y)
    {
      Console.WriteLine($"{z}, {y}, {x}");
    }
    else if (z < x)
    {
      Console.WriteLine($"{y}, {z}, {x}");
    }
    else
    {
      Console.WriteLine($"{y}, {x}, {z}");
    }
  }
}

void RunExercice4()
{
  var r = new Random();
  int x = r.Next(50);
  Console.WriteLine($"Exercise 4: le premier nombre généré est {x}");
  int nbIter = 1;
  for (; x != r.Next(50); nbIter++)
  { }
  Console.WriteLine($"Exercise 4: Nb itération avant de trouver {x} est de {nbIter}");
}

void RunExercice5()
{
  var r3 = new Random();
  var nb = r3.Next(10);
  Console.WriteLine($"Exercise 5: table de multiplication de {nb}:");
  for (int i = 0; i <= 10; i++)
  {
    Console.WriteLine($"{nb} x {i} = {nb * i}");
  }
}


void RunExercices()
{
  RunExercice1();
  RunExercice2();
  for (int i = 0; i < 20; i++)
  {
    RunExercice3();
  }

  RunExercice4();
  RunExercice5();

}
