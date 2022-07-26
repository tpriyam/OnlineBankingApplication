public class Wagon extends Car {
    //Wagon is inheriting the class Car

    static int counter = 0;
    Wagon() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
