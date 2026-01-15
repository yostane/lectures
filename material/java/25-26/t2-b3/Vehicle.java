abstract public class Vehicle {
  private int releaseYear;
  private String registrationNumber;

  public Vehicle(int releaseYear, String registrationNumber) {
    this.releaseYear = releaseYear;
    this.registrationNumber = registrationNumber;
  }

  // klaxonner
  abstract public void honk();

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  @Override
  public String toString() {
    return String.format("(Release year %d - Registration: %s)",
        this.getReleaseYear(),
        this.getRegistrationNumber());
  }
}
