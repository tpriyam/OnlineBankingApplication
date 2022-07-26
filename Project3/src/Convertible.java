public class Convertible extends Car {
    //Convertible is inheriting the class Car

    static int counter = 0;
    Convertible(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
