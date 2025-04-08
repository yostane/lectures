class EntertainmentDevice {
  constructor(name, releaseYear) {
    this.releaseYear = releaseYear;
  }

  get isAfter2000() {
    return this.releaseYear >= 2000;
  }

  set name(value) {}

  get name() {
    return "Hello";
  }
}

const device1 = new EntertainmentDevice("a", 1990);
console.log(device1.isAfter2000);
device1.name = "dfsdfsg";
console.log(device1.name);
