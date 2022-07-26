public class SUV extends Car {
    //SUV is inheriting the class Car

    static int counter = 50000;
    SUV(UnlockStrategy unlockStrategy) {
        super(unlockStrategy);
        super.setLicensePlate(super.initLicensePlate(counter++));
    }
}
