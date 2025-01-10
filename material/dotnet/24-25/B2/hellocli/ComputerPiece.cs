namespace Mylib
{
  class ComputerPiece
  {
    // Constructeur
    public ComputerPiece(int price)
    {
    }
  }
}

namespace DemoOpp
{
  class ComputerPiece
  {
    // prorpiété en lecture et écriture
    public int WattUsage { get; set; }
    // prorpiété en lecture seule
    public int Price { get; }

    // Constructeur
    public ComputerPiece(int price)
    {
      Console.WriteLine("ComputerPiece constructor");
      this.Price = price;
    }
  }

  class PowerGenerator : ComputerPiece, ILightable
  {
    public PowerGenerator(int price) : base(price)
    {
    }

    public void TurnLightsOff()
    {
      Console.WriteLine("Allumage de la lumière de l'alim");
    }

    public void TurnLightsOn()
    {
      Console.WriteLine("Extnction de la lumière de l'alim");
    }
  }

  class UsbPort : ComputerPiece, ILightable
  {
    public UsbPort(int price) : base(price)
    {
    }

    public void TurnLightsOff()
    {
      throw new NotImplementedException();
    }

    public void TurnLightsOn()
    {
      throw new NotImplementedException();
    }
  }

  class CPU : ComputerPiece, IOverclockable
  {
    public CPU(int price) : base(price)
    {
    }
    public int ClockSpeed { get; set; }
    public int CoreCount { get; set; }

    public int MaxPossibleClockSpeed => ClockSpeed + 200;

    public void OverClock(int frequency)
    {
      if (frequency > MaxPossibleClockSpeed)
      {
        Console.WriteLine("Votre CPU a grillé");
      }
      else if (frequency == 0)
      {
        Console.WriteLine("Le CPU fait dodo");
      }
      else
      {
        ClockSpeed = frequency;
      }
    }
  }

  class RAM : ComputerPiece
  {
    public RAM(int price) : base(price)
    {
    }
    public int Capacity { get; set; }
  }
}