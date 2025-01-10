class ComputerPiece
{
  // prorpiété en lecture et écriture
  public int WattUsage { get; set; }
  // prorpiété en lecture seule
  public int Price { get; }

  public ComputerPiece(int price)
  {
    Console.WriteLine("ComputerPiece constructor");
    this.Price = price;
  }
}

class PowerGenerator : ComputerPiece
{
  public PowerGenerator(int price) : base(price)
  {
  }
}

class UsbPort : ComputerPiece
{
  public UsbPort(int price) : base(price)
  {
  }
}

class CPU : ComputerPiece
{
  public CPU(int price) : base(price)
  {
  }
  public int ClockSpeed { get; set; }
  public int CoreCount { get; set; }
}

class RAM : ComputerPiece
{
  public RAM(int price) : base(price)
  {
  }
  public int Capacity { get; set; }
}

CPU cpu1 = new CPU(200);
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

ComputerBox computerBox = new(10, 10, 5);
Console.WriteLine(computerBox);
