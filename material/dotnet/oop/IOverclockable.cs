namespace DemoOpp
{
    public interface IOverclockable
    {
        public int MaxPossibleClockSpeed { get; }
        public void OverClock(int frequency);
    }
}
