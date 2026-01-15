public class Car extends Vehicle {
  private int backSeatCount;

  public Car(int releaseYear,
      String registrationNumber,
      int backSeatCount) {
    super(releaseYear, registrationNumber);
    this.backSeatCount = backSeatCount;
  }

  @Override
  public void honk() {
    IO.println("MipMip");
  }

  public int getBackSeatCount() {
    return backSeatCount;
  }

  public void setBackSeatCount(int backSeatCount) {
    this.backSeatCount = backSeatCount;
  }
}
