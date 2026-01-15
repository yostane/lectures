void main() {
  IO.println("Hello World!");
  Car car = new Car(2026,
      "LOVE-JAVA",
      3);
  IO.println(car.getReleaseYear());
  car.setRegistrationNumber("JAVA-ROCKS");
  IO.println(car.getRegistrationNumber());

  Truck truck = new Truck(2000,
      "MAIN",
      100);
  IO.println(truck.getLoadCapacityInKg());
  car.honk();
  truck.honk();

  Vehicle v1 = car;
  Vehicle v2 = truck;
  v1.honk(); // Appelle le honk de car
  v2.honk(); // Appelle le honk de truck

  List<Vehicle> vehicles = List.of(v1, v2,
      new Car(1997, "ANOTHER-CAR", 3),
      new Truck(1990, "ANOTHER-TRUCK", 1995));
  IO.println(vehicles.getFirst().getRegistrationNumber());
  IO.println(vehicles.get(0).getRegistrationNumber());

  // List des véhicules sortis à partir de l'année 2000
  List<Vehicle> year2000Vehicles = vehicles.stream()
      .filter(v -> v.getReleaseYear() >= 2000).toList();
  IO.println(year2000Vehicles);

  // véhicules dont l'année de sortie est pair et le matricule contient le terme
  // JAVA
  var result1 = vehicles.stream()
      .filter(v -> v.getReleaseYear() % 2 == 0
          && v.getRegistrationNumber().contains("JAVA"))
      .toList();
  IO.println(result1);
}