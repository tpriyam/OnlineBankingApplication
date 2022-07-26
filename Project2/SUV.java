public class SUV extends Car {
    //SUV is inheriting the class Car

    static int counter = 50000;
    SUV() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
