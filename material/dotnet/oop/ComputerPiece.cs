namespace DemoOpp
{
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

    class PowerGenerator : ComputerPiece, ILightable
    {
        public PowerGenerator(int price) : base(price)
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
}
