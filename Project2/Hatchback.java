public class Hatchback extends Car {
    //Hatchback is inheriting the class Car

    static int counter = 0;
    Hatchback() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
