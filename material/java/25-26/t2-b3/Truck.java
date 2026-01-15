public class Truck extends Vehicle {
  private int loadCapacityInKg;

  public Truck(int releaseYear, String registrationNumber, int loadCapacityInKg) {
    super(releaseYear, registrationNumber);
    this.loadCapacityInKg = loadCapacityInKg;
  }

  @Override
  public void honk() {
    IO.println("VroomVroom");
  }

  public int getLoadCapacityInKg() {
    return loadCapacityInKg;
  }

  public void setLoadCapacityInKg(int loadCapacityInKg) {
    this.loadCapacityInKg = loadCapacityInKg;
  }
}
