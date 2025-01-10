using DemoOpp;

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
