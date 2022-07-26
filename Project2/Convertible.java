public class Convertible extends Car {
    //Convertible is inheriting the class Car

    static int counter = 0;
    Convertible() {
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
