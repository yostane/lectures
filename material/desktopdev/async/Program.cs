// See https://aka.ms/new-console-template for more information
int add(int x, int y)
{
    return x + y;
}

var f = () =>
    {
        for (int i = 0; i < 10000; i++)
        {
            add(4, 7);
            Thread.Sleep(100);
            add(4, 17);
        }
    };

void showOsThreads()
{
    for (int i = 0; i < 100; i++)
    {
        Thread thread = new Thread(() => f());
        thread.Start();
    }
}

void SayHello()
{
    Console.WriteLine("I'm saying hello");
}

async void showAsyncTask()
{
    var t1 = Task<int>.Run(() => add(2, 4));
    int resultat = await t1;
    // for (int i = 0; i < 100; i++)
    // {
    //     Task.Run(() =>
    //     {
    //         f();
    //     });
    // };

}

SayHello();
Console.WriteLine("Hello, World!");

//showOsThreads();
showAsyncTask();

while (true)
{
    Thread.Sleep(100);
}